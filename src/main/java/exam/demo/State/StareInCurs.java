package exam.demo.State;

import exam.demo.Model.Solicitare;

public class StareInCurs implements SolicitareStare{
    @Override
    public void setStare(Solicitare solicitare) {
        solicitare.setStare(StareSolicitare.ECHIPA_PLECATA);
    }
}
