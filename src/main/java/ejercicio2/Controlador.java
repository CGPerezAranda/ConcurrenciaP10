package ejercicio2;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controlador implements ActionListener, PropertyChangeListener{
    
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
        	workerMontecarlo.addPropertyChangeListener(this);
        	workerSeries = new WorkerSeries(panel.getIteraciones(), this.panel);
            workerSeries.execute();
            workerSeries.addPropertyChangeListener(this);
        }
    }
    public void propertyChange(PropertyChangeEvent evt) {

    	if (evt.getPropertyName().equals("progress")) {

    		panel.setProgresoMonteCarlo(workerMontecarlo.getProgress());
    		panel.setProgresoLeibniz(workerSeries.getProgress());
    	}		
    }
}
