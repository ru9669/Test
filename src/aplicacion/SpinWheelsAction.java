package aplicacion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class SpinWheelsAction extends RecursiveAction {
	private int a;
	private int c;
	
	public SpinWheelsAction(int a, int c) {
		this.a = a;
		this.c = c;
	}
	
	protected void compute() {
		if(a<=0){
			System.out.println(a);
		} else {
			int b = a + ((c - a)/2);
			
			invokeAll(new SpinWheelsAction(0, b), new SpinWheelsAction(0, c));
		}
	}
	
	public static void main (String [] args) {
		ForkJoinTask<?> task = new SpinWheelsAction(1, 100);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
	}
}
