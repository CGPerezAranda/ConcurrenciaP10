package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.SwingWorker;

public class WorkerMontecarlo extends SwingWorker<Void, Double> {
	/*
	 * Medidas del círculo y del cuadrado inscrito. r = 30
	 */
	
	private static final int RADIO = 30;
	private Random aleatorio;
	
	private int iteraciones; // numero de iteraciones del método
	private Panel panel;
	public WorkerMontecarlo(int iteraciones, Panel panel)
	{
		this.iteraciones = iteraciones;
		aleatorio = new Random();
		this.panel=panel;
	}
	/*
	 * Método para calcular pi 
	 */

	@Override
	protected Void doInBackground() {
		double limInf = -RADIO;
		double limSup = RADIO;

		double pdentro = 0;

		Double x, y, pi;
		for (int i = 0; i<iteraciones; i++) {
			x = limInf + (limSup - limInf)*aleatorio.nextDouble();
			y = limInf + (limSup - limInf)*aleatorio.nextDouble();
			if(Math.pow(x, 2)+Math.pow(y,2) < Math.pow(RADIO, 2)) {
				pdentro++;
			}
			pi  = (4 * pdentro/((double) iteraciones));
			publish (pi);
			this.setProgress((int) (100*((double)(1+i)/(double)iteraciones)));
			//System.out.println((int) (100*((double)(1+i)/(double)iteraciones)));
			
		}
		return null;

	}
	
	
	public void process(List<Double> lista)
	{
		try {
			panel.limpia1();
			panel.escribePI1(lista.get(lista.size()-1));

		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}
}
