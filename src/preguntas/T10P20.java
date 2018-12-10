package preguntas;

class T10P20 {
	public static void main (String... args){
		//Según la solución, no compila porque no se puede imprimir void.
		//Como no es trivial establecer una conexión a una BBDD, vamos a probarlo con un atajo.
		
		System.out.println(noDevuelveNada());
		
	}
	
	public static boolean noDevuelveNada() {
		return false;
	}
}
