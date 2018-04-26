package fr.kacetal.staticGenerators;

public class GeneratorASCIIChar {
	
	public static char generateRandomASCIIChar(boolean char09, boolean charAZ, boolean charaz) {
		
		while(true) {
			
			if (IntGenerator.generateInt(2) == 1 && char09) {
				return (char) IntGenerator.generateInt(48, 58);
			}
			
			if (IntGenerator.generateInt(2) == 1 && charAZ) {
				return (char) IntGenerator.generateInt(65, 91);
			}
			
			if (IntGenerator.generateInt(2) == 1 && charaz) {
				return (char) IntGenerator.generateInt(97, 123);
			}
			
		}
	}
}