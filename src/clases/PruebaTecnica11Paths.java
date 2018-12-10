package clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PruebaTecnica11Paths {
	/*No se si llegarás a leer esto pero, independientemente de ello, ayer me quedé con un mal sabor de boca y al llegar hoy del trabajo he intentado darle sentido a todas las propuestas que me rondaban la cabeza de la manera más elegante posible. Saludos!*/
	
	public static void main (String ... args) {
		//Datos de trabajo
		int [] arrayOne = {1, 2, 4, 5, 6, 7, 9, 9, 10};
		int [] arrayTwo = {2, 2, 4, 7, 8, 8};
		
		//Inicializacion de variables
		List<Integer> listaOne = new ArrayList<Integer>();
		List<Integer> listaTwo = new ArrayList<Integer>();
		List<Integer> listaThree = new ArrayList<Integer>();
		
		for(int i = 0; i < arrayOne.length; i++) {
			listaOne.add(arrayOne[i]);
		}
		
		for(int j = 0; j < arrayTwo.length; j++) {
			listaTwo.add(arrayTwo[j]);
		}
		
		System.out.println(listaOne);
		System.out.println(listaTwo);
		
		//Soluciones propuestas
		long start= System.currentTimeMillis();
		solucionTradicional(listaOne, listaTwo, listaThree);
		listaThree = solucionStreams(listaOne, listaTwo);
		long end = System.currentTimeMillis();
		
		//Comprobacion
		System.out.println(listaThree);
				
		// Report results
		double time = end-start;
		System.out.println("\nTasks start in: "+start+" miliseconds");
		System.out.println("\nTasks end in: "+end+" miliseconds");
		System.out.println("\nTasks completed in: "+time+" miliseconds");
		
	}
	
	private static void solucionTradicional(List<Integer> listaOne, List<Integer> listaTwo, List<Integer> listaThree) {
		int contador = 0;
		
		while(!listaOne.isEmpty() && !listaOne.isEmpty()) {
			System.out.println("Iteracion: " + contador);
			contador++;
			
			if(!listaOne.isEmpty() && !listaTwo.isEmpty() && esMenorYNoEstaContenido(listaOne.get(0), listaTwo.get(0), listaThree)) {
//				System.out.println("Iteracion tipo: esMenorYNoEstaContenido");
				listaThree.add(listaOne.get(0));
				listaOne.remove(0);
			} else if(!listaOne.isEmpty() && !listaTwo.isEmpty() && esMenorYEstaContenido(listaOne.get(0), listaTwo.get(0), listaThree)) {
//				System.out.println("Iteracion tipo: esMenorYEstaContenido");
				listaOne.remove(0);
			} else if(!listaOne.isEmpty() && !listaTwo.isEmpty() && esMayorYNoEstaContenido(listaOne.get(0), listaTwo.get(0), listaThree)) {
//				System.out.println("Iteracion tipo: esMayorYNoEstaContenido");
				listaThree.add(listaTwo.get(0));
				listaTwo.remove(0);
			} else if(!listaOne.isEmpty() && !listaTwo.isEmpty() && esMayorYEstaContenido(listaOne.get(0), listaTwo.get(0), listaThree)) {
//				System.out.println("Iteracion tipo: esMayorYEstaContenido");
				listaTwo.remove(0);
			} else if(!listaOne.isEmpty() && !listaTwo.isEmpty() && esIgualYNoEstaContenido(listaOne.get(0), listaTwo.get(0), listaThree)) {
//				System.out.println("Iteracion tipo: esIgualYNoEstaContenido");
				listaThree.add(listaOne.get(0));
				listaOne.remove(0);
				listaTwo.remove(0);
			} else if(!listaOne.isEmpty() && !listaTwo.isEmpty() && esIgualYEstaContenido(listaOne.get(0), listaTwo.get(0), listaThree)) {
//				System.out.println("Iteracion tipo: esIgualYEstaContenido");
				listaOne.remove(0);
				listaTwo.remove(0);
			} else if(listaOne.isEmpty()) {
//				System.out.println("Iteracion tipo: soloListaTwoTieneElementos");
				if(listaThree.isEmpty() || listaThree.get(listaThree.size()-1).compareTo(listaTwo.get(0)) != 0) {
					listaThree.add(listaTwo.get(0));
				}
				listaTwo.remove(0);
			} else if(listaTwo.isEmpty()) {
//				System.out.println("Iteracion tipo: soloListaOneTieneElementos");
				if(listaThree.isEmpty() || listaThree.get(listaThree.size()-1).compareTo(listaOne.get(0)) != 0) {
					listaThree.add(listaOne.get(0));
				}
				listaOne.remove(0);
			}
		}
	}
	
	private static boolean esMenorYNoEstaContenido(Integer intOne, Integer intTwo, List<Integer> listaThree) {
		return (intOne.compareTo(intTwo) < 0 && (listaThree.isEmpty() || listaThree.get(listaThree.size()-1).compareTo(intOne) != 0));
	}
	
	private static boolean esMenorYEstaContenido(Integer intOne, Integer intTwo, List<Integer> listaThree) {
		return (intOne.compareTo(intTwo) < 0 && !listaThree.isEmpty() && listaThree.get(listaThree.size()-1).compareTo(intOne) == 0);
	}
	
	private static boolean esMayorYNoEstaContenido(Integer intOne, Integer intTwo, List<Integer> listaThree) {
		return (intOne.compareTo(intTwo) > 0 && (listaThree.isEmpty() || listaThree.get(listaThree.size()-1).compareTo(intTwo) != 0));
	}
	
	private static boolean esMayorYEstaContenido(Integer intOne, Integer intTwo, List<Integer> listaThree) {
		return (intOne.compareTo(intTwo) > 0 && !listaThree.isEmpty() && listaThree.get(listaThree.size()-1).compareTo(intTwo) == 0);
	}
	
	private static boolean esIgualYNoEstaContenido(Integer intOne, Integer intTwo, List<Integer> listaThree) {
		return (intOne.compareTo(intTwo) == 0 && (listaThree.isEmpty() || listaThree.get(listaThree.size()-1).compareTo(intTwo) != 0));
	}
	
	private static boolean esIgualYEstaContenido(Integer intOne, Integer intTwo, List<Integer> listaThree) {
		return (intOne.compareTo(intTwo) == 0 && !listaThree.isEmpty() && listaThree.get(listaThree.size()-1).compareTo(intTwo) == 0);
	}
	
	private static List<Integer> solucionStreams(List<Integer> listaOne, List<Integer> listaTwo) {
		listaOne.addAll(listaTwo);
		return listaOne.stream().sorted().distinct().collect(Collectors.toList());
	}
}
