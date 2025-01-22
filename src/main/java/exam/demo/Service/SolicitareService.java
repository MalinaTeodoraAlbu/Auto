package exam.demo.Service;

import exam.demo.Model.Client;
import exam.demo.Model.Solicitare;
import exam.demo.Repository.ServiciuRepository;
import exam.demo.Repository.SolicitareRepository;
import exam.demo.State.StareSolicitare;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitareService {

    @Autowired
    private SolicitareRepository solicitareRepository;
    @Autowired
    private ServiciuRepository serviciuRepository;


    public List<Solicitare> findAll() {
        return solicitareRepository.findAll();
    }

    public Solicitare findById(int id) {
        return solicitareRepository.findById(id).orElseThrow(() -> new RuntimeException("Solicitare not found"));
    }

    public void updateStare(int id, String stare) {
        Solicitare solicitare = findById(id);
        solicitare.setStare(StareSolicitare.valueOf(stare));
        solicitareRepository.save(solicitare);
    }

    public List<Solicitare> findByStare(StareSolicitare stare) {
        return solicitareRepository.findByStare(stare); // Aceasta va trebui să fie implementată în repository
    }

    @Transactional
    public void delete(int id) {
        serviciuRepository.deleteBySolicitareId(id);
        solicitareRepository.deleteById(id);
    }
}

