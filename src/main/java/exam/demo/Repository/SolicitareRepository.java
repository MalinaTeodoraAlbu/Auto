package exam.demo.Repository;

import exam.demo.Model.Solicitare;
import exam.demo.State.StareSolicitare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SolicitareRepository extends JpaRepository<Solicitare, Integer> {
    List<Solicitare> findByStare(StareSolicitare stare);
}
