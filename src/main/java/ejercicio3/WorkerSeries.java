package ejercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.SwingWorker;

public class WorkerSeries extends SwingWorker<Void, Double> {
	/*
	 * Medidas del círculo y del cuadrado inscrito. r = 30
	 */
	
	private int iteraciones; // numero de iteraciones del método
	private Panel panel;
	public WorkerSeries(int iteraciones, Panel panel)
	{
		this.iteraciones = iteraciones;
		this.panel=panel;
	}
	/*
	 * Método para calcular pi 
	 */

	@Override
	protected Void doInBackground() {
		double pi = 0;
		double i = 0;
		while(i < 2*iteraciones && !this.isCancelled()) {
			pi += (4/((i*2)+1)) - (4/((i*2)+3));
			publish(pi);
			this.setProgress((int) (100*(1.0*i*2/iteraciones)));
			i+=2;
			}
		return null;
			
		}

	
	
	public void process(List<Double> lista)
	{
		try {
			panel.limpia2();
			panel.escribePI2(lista.get(lista.size()-1));

		} catch (Exception e) {
			panel.limpia2();
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}
}
