package preguntas;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class T4P14 {
	public static void main(String [] args) {
		Stream<Integer> s = Stream.of(1);
		IntStream is = s.mapToInt(x -> x);
		DoubleStream ds = s.mapToDouble(x -> x);
		IntStream s2 = ds.mapToInt(x -> (int) x); //Viendo la respuesta esto es lo que buscaba.
	}
}
