package exam.demo.State;

import exam.demo.Model.Solicitare;

public class StareAcceptata implements SolicitareStare{
    @Override
    public void setStare(Solicitare solicitare) {
        solicitare.setStare(StareSolicitare.SOLICITARE_ACCEPTATA);
    }
}
