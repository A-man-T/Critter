package assignment;

public class InstructionSwitch {
    public static void executeInstruction(Critter c) {
        if (c.getCode() == null) {
            return;
        }
        int i = c.getNextCodeLine();
        if (i > c.getCode().size() || i < 1) {
            return;
        }
        String[] current = ((String) c.getCode().get(i - 1)).split(" ");
        switch (current[0]) {
            case "hop":
                c.hop();
                i++;
                c.setNextCodeLine(i);
                break;
            case "go":
                c.setNextCodeLine(jumpType(current[1], i, c));
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
                if (current.length == 1) {
                    c.infect();
                } else {
                    c.infect(Integer.parseInt(current[1]));
                }
                i++;
                c.setNextCodeLine(i);
            case "ifenemy":
                if (c.getCellContent(Integer.parseInt(current[1])) == Critter.ENEMY) {
                    c.setNextCodeLine(jumpType(current[2], i, c));
                } else {
                    i++;
                    c.setNextCodeLine(i);
                }
                executeInstruction(c);
                break;
            case "ifempty":
                if (c.getCellContent(Integer.parseInt(current[1])) == Critter.EMPTY) {
                    c.setNextCodeLine(jumpType(current[2], i, c));
                } else {
                    i++;
                    c.setNextCodeLine(i);
                }
                executeInstruction(c);
                break;
            case "ifrandom":
                if (c.ifRandom()) {
                    c.setNextCodeLine(jumpType(current[1], i, c));
                } else {
                    i++;
                    c.setNextCodeLine(i);
                }
                executeInstruction(c);
                break;
            case "ifhungry":
                if (c.getHungerLevel() == Critter.HungerLevel.HUNGRY || c.getHungerLevel() == Critter.HungerLevel.STARVING) {
                    c.setNextCodeLine(jumpType(current[1], i, c));
                } else {
                    i++;
                    c.setNextCodeLine(i);
                }
                executeInstruction(c);
                break;
            case "ifstarving":
                if (c.getHungerLevel() == Critter.HungerLevel.STARVING) {
                c.setNextCodeLine(jumpType(current[1], i, c));
                } else {
                    i++;
                    c.setNextCodeLine(i);
                }
                executeInstruction(c);
                break;
            case "eat":
                i++;
                c.setNextCodeLine(i);
                break;
            case "ifally":
                if (c.getCellContent(Integer.parseInt(current[1])) == Critter.ALLY) {
                    c.setNextCodeLine(jumpType(current[2], i, c));
                } else {
                    i++;
                    c.setNextCodeLine(i);
                }
                executeInstruction(c);
                break;
            case "ifwall":
                if (c.getCellContent(Integer.parseInt(current[1])) == Critter.WALL) {
                    c.setNextCodeLine(jumpType(current[2], i, c));
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

    private static int jumpType(String s, int i, Critter c) {
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return i + Integer.parseInt(s);
        }
        else if (s.charAt(0) == 'r') {
            return c.getReg(Integer.parseInt(s.substring(1)));
        }
        else {
            return Integer.parseInt(s);
        }
    }
}
