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
		String[] current = ((String)c.getCode().get(0)).split(" ");

		executeInstruction(c);

		return;
	}

	public CritterSpecies loadSpecies(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String name;
		ArrayList<String> instructions = new ArrayList<>();
		name = reader.readLine();
		String temp = reader.readLine();
		while (!Objects.equals(temp, "")) {
			instructions.add(temp);
			temp = reader.readLine();
		}
		return new CritterSpecies(name, instructions);
	}

	public void executeInstruction(Critter c) {
		int i = c.getNextCodeLine();
		String[] current = ((String) c.getCode().get(i - 1)).split(" ");
		System.out.println(current[0]);
		switch (current[0]) {
			case "hop":
				if (c.getCellContent(Critter.FRONT) == Critter.EMPTY) {
					c.hop();
				}
				i++;
				c.setNextCodeLine(i);
				break;
			case "go":
				c.setNextCodeLine(Integer.parseInt(current[1]));
				executeInstruction(c);
				break;
			case "right":
				c.right();
				i++;
				c.setNextCodeLine(i);
				break;
			case "left":
				c.left();
				i++;
				c.setNextCodeLine(i);
				break;
			case "infect":
				if (c.getCellContent(Critter.FRONT) == Critter.ENEMY) {
					if (current.length == 1) {
						c.infect();
					} else {
						c.infect(Integer.parseInt(current[1]));
					}
					i++;
					c.setNextCodeLine(i);
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				break;
			case "ifenemy":
				if (c.getCellContent(Integer.parseInt(current[1])) == Critter.ENEMY) {
					c.setNextCodeLine(Integer.parseInt(current[2]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "ifempty":
				if (c.getCellContent(Integer.parseInt(current[1])) == Critter.EMPTY) {
					c.setNextCodeLine(Integer.parseInt(current[2]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "ifrandom":
				if (c.ifRandom()) {
					c.setNextCodeLine(Integer.parseInt(current[1]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "ifhungry":
				if (c.getHungerLevel() == Critter.HungerLevel.HUNGRY || c.getHungerLevel() == Critter.HungerLevel.STARVING) {
					c.setNextCodeLine(Integer.parseInt(current[1]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "ifstarving":
				if (c.getHungerLevel() == Critter.HungerLevel.STARVING) {
					c.setNextCodeLine(Integer.parseInt(current[1]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "eat":
				if (c.getCellContent(Critter.FRONT) == Critter.ENEMY) {
					c.eat();
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				break;
			case "ifally":
				if (c.getCellContent(Integer.parseInt(current[1])) == Critter.ALLY) {
					c.setNextCodeLine(Integer.parseInt(current[2]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "ifwall":
				if (c.getCellContent(Integer.parseInt(current[1])) == Critter.WALL) {
					c.setNextCodeLine(Integer.parseInt(current[2]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "ifangle":
				if (c.getOffAngle(Integer.parseInt(current[1])) == Integer.parseInt(current[2])) {
					c.setNextCodeLine(Integer.parseInt(current[3]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "write":
				c.setReg(Integer.parseInt(current[1]), Integer.parseInt(current[2]));
				i++;
				c.setNextCodeLine(i);
				executeInstruction(c);
				break;
			case "add":
				c.setReg(Integer.parseInt(current[1]), c.getReg(Integer.parseInt(current[1])) + c.getReg(Integer.parseInt(current[2])));
				i++;
				c.setNextCodeLine(i);
				executeInstruction(c);
				break;
			case "sub":
				c.setReg(Integer.parseInt(current[1]), c.getReg(Integer.parseInt(current[1])) - c.getReg(Integer.parseInt(current[2])));
				i++;
				c.setNextCodeLine(i);
				executeInstruction(c);
				break;
			case "inc":
				c.setReg(Integer.parseInt(current[1]), c.getReg(Integer.parseInt(current[1])) + 1);
				i++;
				c.setNextCodeLine(i);
				executeInstruction(c);
				break;
			case "dec":
				c.setReg(Integer.parseInt(current[1]), c.getReg(Integer.parseInt(current[1])) - 1);
				i++;
				c.setNextCodeLine(i);
				executeInstruction(c);
				break;
			case "iflt":
				if (c.getReg(Integer.parseInt(current[1])) < c.getReg(Integer.parseInt(current[2]))) {
					c.setNextCodeLine(Integer.parseInt(current[3]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "ifleq":
				if (c.getReg(Integer.parseInt(current[1])) == c.getReg(Integer.parseInt(current[2]))) {
					c.setNextCodeLine(Integer.parseInt(current[3]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
			case "ifgt":
				if (c.getReg(Integer.parseInt(current[1])) > c.getReg(Integer.parseInt(current[2]))) {
					c.setNextCodeLine(Integer.parseInt(current[3]));
				} else {
					i++;
					c.setNextCodeLine(i);
				}
				executeInstruction(c);
				break;
		}
	}
}
