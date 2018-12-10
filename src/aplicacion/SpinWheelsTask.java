package aplicacion;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SpinWheelsTask extends RecursiveTask {
	private int a;
	private int c;
	
	public SpinWheelsTask(int a, int c) {
		this.a = a;
		this.c = c;
	}
	
	protected Object compute() {
		if(a<=0){
			return 10;
		} else {
			int b = a + ((c - a)/2);
			
			invokeAll(new SpinWheelsTask(a, b), new SpinWheelsTask(b, c));
			return "";
		}
	}
	
	public static void main (String [] args) {
		ForkJoinTask task = new SpinWheelsTask(1, 100);
		ForkJoinPool pool = new ForkJoinPool();
		int x = (Integer) pool.invoke(task);
		
		System.out.println(x);
	}

}
