package exam.demo.State;

import exam.demo.Model.Solicitare;

public class StareTrimisa implements SolicitareStare{
    @Override
    public void setStare(Solicitare solicitare) {
        solicitare.setStare(StareSolicitare.SOLICITARE_TRIMISA);
    }
}
