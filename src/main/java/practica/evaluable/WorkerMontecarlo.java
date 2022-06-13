package practica.evaluable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.SwingWorker;

public class WorkerMontecarlo extends SwingWorker<Double, Void> {
	/*
	 * Medidas del círculo y del cuadrado inscrito. r = 30
	 */
	
	private static final int RADIO = 30;
	private static final int LADO = 60;
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
	protected Double doInBackground() {

		double pdentro = 0;

		Double x, y;
		for (int i = 0; i<iteraciones; i++) {
			x = (double) aleatorio.nextInt(LADO);
			y = (double) aleatorio.nextInt(LADO);
			System.out.println("("+x+","+y+")");
			if(Math.pow(x, 2)+Math.pow(y,2) < Math.pow(RADIO, 2)) {
				pdentro++;
			}
			
		}
		double res  = (4 * (pdentro/((double) iteraciones)));
		System.out.println(res);
		
		
		return res;
	}
	
	
	@Override
	public void done()
	{
		try {
			panel.limpia1();
			panel.escribePI1(get());

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
		}
	}
}
