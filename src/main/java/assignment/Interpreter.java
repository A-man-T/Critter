package assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Responsible for loading critter species from text files and interpreting the
 * simple Critter language.
 * 
 * For more information on the purpose of the below two methods, see the
 * included API/ folder and the project description.
 */
public class Interpreter implements CritterInterpreter {

	public void executeCritter(Critter c) {
		// obviously, your code should do something
		return;
	}

	public CritterSpecies loadSpecies(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String name;
		ArrayList<String> instructions = new ArrayList<>();
		name = reader.readLine();
		while (reader.readLine() != null) {
			instructions.add(reader.readLine());
		}
		return new CritterSpecies(name, instructions);
	}
}
