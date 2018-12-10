package clases;

import java.util.function.Predicate;

public class FunctionalProgramming {
	public static void main (String[] args) {
		
		Predicate<String> p1 = String::isEmpty;
		System.out.println(p1.test("HOLA"));
	}
}
