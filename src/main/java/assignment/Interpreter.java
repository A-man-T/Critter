package assignment;

import java.io.BufferedReader;
import java.io.File;
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
		File file = new File(filename);

		// check for empty file
		if (file.length() == 0) {
			return null;
		}

		// read name
		name = reader.readLine();

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
		// blank line after name, instructions array is empty
		if (instructions.size() == 0) {
			return null;
		}
		return new CritterSpecies(name, instructions);
	}
}