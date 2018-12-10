package enthuware;

import java.nio.file.Paths;

public class T5P08 {
	public class A{	}

	public static class B{	}
	
	public void useClasses(){
		//1
		T5P08.B b = new T5P08.B();
		B b2 = new B();
		
		A a = new T5P08.A();
		A a2 = new A();
		A a3 = new T5P08().new A();
	}
}

class unaVueltaMas{
	public void prueba() {
		T5P08.B b = new T5P08.B();
		
		T5P08.A a = new T5P08().new A();
	}
}