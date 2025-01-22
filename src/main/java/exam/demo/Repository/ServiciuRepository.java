package exam.demo.Repository;

import exam.demo.Model.Client;
import exam.demo.Model.Serviciu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiciuRepository extends JpaRepository<Serviciu, Integer> {
    void deleteBySolicitareId(int solicitare_id);
}
