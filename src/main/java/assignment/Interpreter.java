package assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Responsible for loading critter species from text files and interpreting the
 * simple Critter language.
 * 
 * For more information on the purpose of the below two methods, see the
 * included API/ folder and the project description.
 */
public class Interpreter implements CritterInterpreter {

	public void executeCritter(Critter c) {

		InstructionSwitch.executeInstruction(c);

	}

	public CritterSpecies loadSpecies(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String name;
		ArrayList<String> instructions = new ArrayList<>();
		name = reader.readLine();
		String temp = reader.readLine();
		while (!Objects.equals(temp, "")) {
			if (InstructionCheck.CompileInstructionCheck(temp)) {
				instructions.add(temp);
				temp = reader.readLine();
			} else {
				System.err.println("Invalid command detected for " + name + "-type critters.");
				return new CritterSpecies(name, null);
			}
		}
		return new CritterSpecies(name, instructions);
	}
}