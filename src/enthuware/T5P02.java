package enthuware;

interface Boiler{
	public void boil();
	
	public static void shutdown(){
		System.out.println("shutting down");
	}
}

interface Vaporizer extends Boiler{
	public default void vaporize(){
		boil();
		System.out.println("Vaporized!");
	} 
}

class Prueba{
	public static void prueba() {
		
	}
}


public class T5P02 implements Vaporizer{
	public void boil() {
		System.out.println("Boiling...");
	}
	
	public void vaporize(){
		System.out.println("T5P02 Vaporized!");
	}
	
	public static void main(String[] args) {
		T5P02 t5 = new T5P02();
		t5.vaporize();
		
		Vaporizer v = new T5P02();
		v.vaporize();
		//v.shutdown();
		Boiler.shutdown();
	}
}

