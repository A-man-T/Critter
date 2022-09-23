package assignment;

public class InstructionSwitch {
    // switch to choose actions based on command string
    public static void executeInstruction(Critter c) {
        // iterative processor for action and non-action based turns
        // returns used for action commands and break used for non-action commands.
        while (true) {
            int i = c.getNextCodeLine();
            if (i > c.getCode().size() || i < 1) {
                return;
            }
            // current is the current line in the instruction code
            String[] current = ((String) c.getCode().get(i - 1)).trim().split("\\s+");

            // current[0] is the command name, remaining indices are the other parameters
            switch (current[0]) {
                case "hop" -> {

                    c.hop();
                    i++;
                    c.setNextCodeLine(i);
                    return;
                }
                case "go" -> {

                    c.setNextCodeLine(jumpType(current[1], i, c));
                }
                case "right" -> {

                    c.right();
                    i++;
                    c.setNextCodeLine(i);
                    return;
                }
                case "left" -> {

                    c.left();
                    i++;
                    c.setNextCodeLine(i);
                    return;
                }
                case "infect" -> {

                    if (current.length == 1) {
                        c.infect();
                    } else {
                        c.infect(jumpType(current[1], i, c));
                    }
                    i++;
                    c.setNextCodeLine(i);
                    return;
                }
                case "ifenemy" -> {
                    if (c.getCellContent(Integer.parseInt(current[1])) == Critter.ENEMY) {
                        c.setNextCodeLine(jumpType(current[2], i, c));
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                    }
                }
                case "ifempty" -> {
                    if (c.getCellContent(Integer.parseInt(current[1])) == Critter.EMPTY) {
                        c.setNextCodeLine(jumpType(current[2], i, c));
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                    }
                }
                case "ifrandom" -> {
                    if (c.ifRandom()) {
                        c.setNextCodeLine(jumpType(current[1], i, c));
                        ;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        ;
                    }
                }
                case "ifhungry" -> {
                    if (c.getHungerLevel() == Critter.HungerLevel.HUNGRY || c.getHungerLevel() == Critter.HungerLevel.STARVING) {
                        c.setNextCodeLine(jumpType(current[1], i, c));
                        ;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        ;
                    }
                }
                case "ifstarving" -> {
                    if (c.getHungerLevel() == Critter.HungerLevel.STARVING) {
                        c.setNextCodeLine(jumpType(current[1], i, c));
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                    }
                }
                case "eat" -> {

                    c.eat();
                    i++;
                    c.setNextCodeLine(i);
                    return;
                }
                case "ifally" -> {

                    if (c.getCellContent(Integer.parseInt(current[1])) == Critter.ALLY) {
                        c.setNextCodeLine(jumpType(current[2], i, c));
                        ;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        ;
                    }
                }
                case "ifwall" -> {

                    if (c.getCellContent(Integer.parseInt(current[1])) == Critter.WALL) {
                        c.setNextCodeLine(jumpType(current[2], i, c));
                        ;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        ;
                    }
                }
                case "ifangle" -> {

                    if (c.getOffAngle(Integer.parseInt(current[1])) == Integer.parseInt(current[2])) {
                        c.setNextCodeLine(jumpType(current[3], i, c));
                        ;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        ;
                    }
                }
                case "write" -> {

                    c.setReg(Integer.parseInt(onlyDigits(current[1])), Integer.parseInt(current[2]));
                    i++;
                    c.setNextCodeLine(i);
                }
                case "add" -> {

                    c.setReg(Integer.parseInt(onlyDigits(current[1])), c.getReg(Integer.parseInt(onlyDigits(current[1]))) + c.getReg(Integer.parseInt(onlyDigits(current[2]))));
                    i++;
                    c.setNextCodeLine(i);
                }
                case "sub" -> {

                    c.setReg(Integer.parseInt(onlyDigits(current[1])), c.getReg(Integer.parseInt(onlyDigits(current[1]))) - c.getReg(Integer.parseInt(onlyDigits(current[2]))));
                    i++;
                    c.setNextCodeLine(i);
                }
                case "inc" -> {

                    c.setReg(Integer.parseInt(onlyDigits(current[1])), c.getReg(Integer.parseInt(onlyDigits(current[1]))) + 1);
                    i++;
                    c.setNextCodeLine(i);
                }
                case "dec" -> {

                    c.setReg(Integer.parseInt(onlyDigits(current[1])), c.getReg(Integer.parseInt(onlyDigits(current[1]))) - 1);
                    i++;
                    c.setNextCodeLine(i);
                }
                case "iflt" -> {

                    if (c.getReg(Integer.parseInt(onlyDigits(current[1]))) < c.getReg(Integer.parseInt(onlyDigits(current[2])))) {
                        c.setNextCodeLine(jumpType(current[3], i, c));
                        ;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        ;
                    }
                }
                case "ifeq" -> {

                    if (c.getReg(Integer.parseInt(onlyDigits(current[1]))) == c.getReg(Integer.parseInt(onlyDigits(current[2])))) {
                        c.setNextCodeLine(jumpType(current[3], i, c));
                        ;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        ;
                    }
                }
                case "ifgt" -> {

                    if (c.getReg(Integer.parseInt(onlyDigits(current[1]))) > c.getReg(Integer.parseInt(onlyDigits(current[2])))) {
                        c.setNextCodeLine(jumpType(current[3], i, c));
                        ;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        ;
                    }
                }
                // by input validation, this case is never reached.
                default -> {
                }
            }
        }
    }

    // method to check the 'n' value after a command to see what type of jump it is.
    private static int jumpType(String s, int i, Critter c) {
        // relative jump
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            return i + Integer.parseInt(s);
        }
        // register value
        else if (s.charAt(0) == 'r') {
            return c.getReg(Integer.parseInt(s.substring(1)));
        }
        // absolute jump
        else {
            return Integer.parseInt(s);
        }
    }

    // returns the digits of a parameter if the parameter is not already an integer (starts w/ r,+,-).
    private static String onlyDigits(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            return s.substring(1);
        }
        return s;
    }
}
