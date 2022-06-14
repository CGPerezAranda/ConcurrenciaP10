package practica.evaluable;

import java.awt.event.*;

public class Controlador implements ActionListener{
    
    private Panel panel;
    private WorkerMontecarlo workerMontecarlo=null;
    public Controlador (Panel panel){
        this.panel=panel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(Panel.COMENZAR)){
        	workerMontecarlo = new WorkerMontecarlo(panel.getIteraciones(), this.panel);
            workerMontecarlo.execute();
        }
    }
}
