package ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.SwingWorker;

public class WorkerSeries extends SwingWorker<Double, Void> {
	/*
	 * Medidas del círculo y del cuadrado inscrito. r = 30
	 */
	
	private static final int RADIO = 30;
	private Random aleatorio;
	
	private int iteraciones; // numero de iteraciones del método
	private Panel panel;
	public WorkerSeries(int iteraciones, Panel panel)
	{
		this.iteraciones = iteraciones;
		aleatorio = new Random();
		this.panel=panel;
	}
	/*
	 * Método para calcular pi 
	 */

	@Override
	protected Double doInBackground() {
		double res = 0;
		for (double i = 0; i<2*iteraciones; i+=2) {
			res += (4/((i*2)+1)) - (4/((i*2)+3));
			}
		return res;
			
		}

	
	
	@Override
	public void done()
	{
		try {
			panel.limpia2();
			panel.escribePI2(get());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}
}
