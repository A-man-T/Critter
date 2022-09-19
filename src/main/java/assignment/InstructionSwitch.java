package assignment;

public class InstructionSwitch {
    public static void executeInstruction(Critter c) {
        if (c.getCode() == null) {
            return;
        }
        int i = c.getNextCodeLine();
        if (i > c.getCode().size()) {
            return;
        }
        String[] current = ((String) c.getCode().get(i - 1)).split(" ");
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
            default:
                System.err.println("Invalid Command");
                break;
        }
    }
}
