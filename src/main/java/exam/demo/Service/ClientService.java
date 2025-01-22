package exam.demo.Service;

import exam.demo.Model.Client;
import exam.demo.Model.Solicitare;
import exam.demo.Repository.ClientRepository;
import exam.demo.Repository.SolicitareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository, SolicitareRepository solicitareRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }


}
