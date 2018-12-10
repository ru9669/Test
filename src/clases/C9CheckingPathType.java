package clases;

import java.nio.file.Path;
import java.nio.file.Paths;

public class C9CheckingPathType {
	public static void main (String... args) {
		Path path1 = Paths.get("D:\\Videos\\Peliculas");
		
		System.out.println("Path1 is Absolute? " + path1.isAbsolute());
		Path path2 = path1.toAbsolutePath();

		if(path1==path2) {
			System.out.println("Path1 and path2 are equals");
		} else {
			System.out.println("Path1 and path2 are distincts");	
		}
		
		Path path3 = Paths.get("D:\\Videos\\Peliculas");
		
		if(path1==path3) {
			System.out.println("Path1 and path3 are equals");
		} else {
			System.out.println("Path1 and path3 are distincts");	
		}
	}
}
