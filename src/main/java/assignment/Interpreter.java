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

		// calls helper method containing switch
		InstructionSwitch.executeInstruction(c);

	}

	public CritterSpecies loadSpecies(String filename) throws IOException {
		// read in .cri file.
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		String name;
		ArrayList<String> instructions = new ArrayList<>();

		// read name
		name = reader.readLine();
		if (name == null || name.length() == 0) {
			return null;
		}

		// while blank line or end of file not encountered, read in instructions
		// temp stores every read line
		String temp = reader.readLine();
		while ((temp != null)&&(!Objects.equals(temp, ""))) {
			if (InstructionCheck.CompileInstructionCheck(temp) && InstructionCheck.NumChecks(temp)) {
				instructions.add(temp);
				temp = reader.readLine();
			} else {
				return null;
			}
		}
		return new CritterSpecies(name, instructions);
	}
}