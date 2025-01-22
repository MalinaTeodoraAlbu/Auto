package exam.demo.Service;

import exam.demo.Model.Serviciu;
import exam.demo.Repository.ServiciuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciuService {
    @Autowired
    private ServiciuRepository serviciuRepository;

    public void save(Serviciu serviciu) {
        serviciuRepository.save(serviciu);
    }

    @Transactional
    public void delete(int id) {
        serviciuRepository.deleteById(id);
    }
}
