package exam.demo.Controller;

import exam.demo.Model.Serviciu;
import exam.demo.Model.Solicitare;
import exam.demo.Service.ServiciuService;
import exam.demo.Service.SolicitareService;
import exam.demo.State.StareAcceptata;
import exam.demo.State.StareInCurs;
import exam.demo.State.StareSolicitare;
import exam.demo.State.StareTrimisa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/solicitari")
public class SolicitareController {

    @Autowired
    private SolicitareService solicitareService;

    @Autowired
    private ServiciuService serviciuService;

    @GetMapping("/{id}/addServiciu")
    public String showAddServiciuForm(@PathVariable int id, Model model) {
        Solicitare solicitare = solicitareService.findById(id);
        model.addAttribute("solicitare", solicitare);
        return "addServiciu"; // Afișează formularul pentru adăugarea unui serviciu
    }

    @PostMapping("/{id}/addServiciu")
    public String addServiciu(@PathVariable int id, @RequestParam("descriere") String descriere,
                              @RequestParam("tarif") double tarif, Model model) {
        Solicitare solicitare = solicitareService.findById(id);

        // Creăm și salvăm serviciul
        Serviciu serviciu = new Serviciu();
        serviciu.setDescriere(descriere);
        serviciu.setTarif(tarif);
        serviciu.setSolicitare(solicitare); // Asociem serviciul cu solicitarea

        serviciuService.save(serviciu); // Salvăm serviciul în bază de date

        return "redirect:/solicitari/" + id; // Redirectăm către pagina de detalii a solicitării
    }
    @GetMapping
    public String getSolicitari(@RequestParam(value = "stare", required = false) String stare, Model model) {
        List<Solicitare> solicitari;

        // Filtrare pe baza stării, dacă este furnizată
        if (stare != null && !stare.isEmpty()) {
            try {
                StareSolicitare stareEnum = StareSolicitare.valueOf(stare);
                solicitari = solicitareService.findByStare(stareEnum); // Metodă în serviciu pentru a filtra solicitările
            } catch (IllegalArgumentException e) {
                solicitari = solicitareService.findAll(); // Dacă starea nu e validă, afișăm toate solicitările
            }
        } else {
            solicitari = solicitareService.findAll(); // Returnează toate solicitările dacă nu se aplică niciun filtru
        }

        model.addAttribute("solicitari", solicitari);
        model.addAttribute("stare", stare); // Pentru a păstra starea selectată în formular
        return "solicitari"; // Returnează pagina cu tabelul de solicitări
    }

    @GetMapping("/{id}")
    public String viewSolicitare(@PathVariable int id, Model model) {
        Solicitare solicitare = solicitareService.findById(id);
        model.addAttribute("solicitare", solicitare);
        return "solicitareDetalii";
    }

    @PostMapping("/{id}/update")
    public String updateStare(@PathVariable("id") int id, @RequestParam("stare") String stare, Model model) {
        Solicitare solicitare = solicitareService.findById(id);

        try {
            // Convertim stare din string în enum
            StareSolicitare stareEnum = StareSolicitare.valueOf(stare.toUpperCase().replace(" ", "_"));
            solicitare.setStare(stareEnum);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Stare invalidă");
            return "errorPage"; // Afișează pagina de eroare dacă starea nu este validă
        }

        // Actualizăm starea în baza de date
        solicitareService.updateStare(id, solicitare.getStare().name());

        // Redirecționăm utilizatorul către pagina detaliilor solicitării actualizate
        return "redirect:/solicitari/" + id;  // Redirecționează către detaliile solicitării
    }


    @PostMapping("/{id}/delete")
    public String deleteSolicitare(@PathVariable("id") int id) {
        solicitareService.delete(id); // Șterge solicitarea din baza de date
        return "redirect:/solicitari"; // Redirecționează înapoi la lista solicitărilor
    }

    @PostMapping("/{id}/deleteServiciu")
    public String deleteServiciu(@PathVariable("id") int id) {
        serviciuService.delete(id);
        return "redirect:/solicitari"; // Redirecționează înapoi la lista solicitărilor
    }

}
