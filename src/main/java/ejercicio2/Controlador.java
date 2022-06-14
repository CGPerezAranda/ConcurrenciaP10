package ejercicio2;

import java.awt.event.*;

public class Controlador implements ActionListener{
    
    private Panel panel;
    private WorkerMontecarlo workerMontecarlo=null;
    private WorkerSeries workerSeries=null;
    public Controlador (Panel panel){
        this.panel=panel;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(Panel.COMENZAR)){
        	workerMontecarlo = new WorkerMontecarlo(panel.getIteraciones(), this.panel);
            workerMontecarlo.execute();
        	
        	workerSeries = new WorkerSeries(panel.getIteraciones(), this.panel);
            workerSeries.execute();
        }
    }
}
