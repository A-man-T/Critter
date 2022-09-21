package assignment;

public class InstructionSwitch {
    public static void executeInstruction(Critter c) {
        if (c.getCode() == null) {
            return;
        }
        while (true) {
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
                    return;
                case "go":
                    c.setNextCodeLine(jumpType(current[1], i, c));
                    break;
                case "right":
                    c.right();
                    i++;
                    c.setNextCodeLine(i);
                    return;
                case "left":
                    c.left();
                    i++;
                    c.setNextCodeLine(i);
                    return;
                case "infect":
                    if (current.length == 1) {
                        c.infect();
                    } else {
                        c.infect(Integer.parseInt(current[1]));
                    }
                    i++;
                    c.setNextCodeLine(i);
                    return;
                case "ifenemy":
                    if (c.getCellContent(Integer.parseInt(current[1])) == Critter.ENEMY) {
                        c.setNextCodeLine(jumpType(current[2], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "ifempty":
                    if (c.getCellContent(Integer.parseInt(current[1])) == Critter.EMPTY) {
                        c.setNextCodeLine(jumpType(current[2], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "ifrandom":
                    if (c.ifRandom()) {
                        c.setNextCodeLine(jumpType(current[1], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "ifhungry":
                    if (c.getHungerLevel() == Critter.HungerLevel.HUNGRY || c.getHungerLevel() == Critter.HungerLevel.STARVING) {
                        c.setNextCodeLine(jumpType(current[1], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "ifstarving":
                    if (c.getHungerLevel() == Critter.HungerLevel.STARVING) {
                        c.setNextCodeLine(jumpType(current[1], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "eat":
                    i++;
                    c.setNextCodeLine(i);
                    return;
                case "ifally":
                    if (c.getCellContent(Integer.parseInt(current[1])) == Critter.ALLY) {
                        c.setNextCodeLine(jumpType(current[2], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "ifwall":
                    if (c.getCellContent(Integer.parseInt(current[1])) == Critter.WALL) {
                        c.setNextCodeLine(jumpType(current[2], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "ifangle":
                    if (c.getOffAngle(Integer.parseInt(current[1])) == Integer.parseInt(current[2])) {
                        c.setNextCodeLine(Integer.parseInt(current[3]));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "write":
                    c.setReg(Integer.parseInt(current[1]), Integer.parseInt(current[2]));
                    i++;
                    c.setNextCodeLine(i);

                    break;
                case "add":
                    c.setReg(Integer.parseInt(current[1]), c.getReg(Integer.parseInt(current[1])) + c.getReg(Integer.parseInt(current[2])));
                    i++;
                    c.setNextCodeLine(i);

                    break;
                case "sub":
                    c.setReg(Integer.parseInt(current[1]), c.getReg(Integer.parseInt(current[1])) - c.getReg(Integer.parseInt(current[2])));
                    i++;
                    c.setNextCodeLine(i);

                    break;
                case "inc":
                    c.setReg(Integer.parseInt(current[1]), c.getReg(Integer.parseInt(current[1])) + 1);
                    i++;
                    c.setNextCodeLine(i);

                    break;
                case "dec":
                    c.setReg(Integer.parseInt(current[1]), c.getReg(Integer.parseInt(current[1])) - 1);
                    i++;
                    c.setNextCodeLine(i);

                    break;
                case "iflt":
                    if (c.getReg(Integer.parseInt(current[1])) < c.getReg(Integer.parseInt(current[2]))) {
                        c.setNextCodeLine(jumpType(current[3], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "ifleq":
                    if (c.getReg(Integer.parseInt(current[1])) == c.getReg(Integer.parseInt(current[2]))) {
                        c.setNextCodeLine(jumpType(current[3], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                case "ifgt":
                    if (c.getReg(Integer.parseInt(current[1])) > c.getReg(Integer.parseInt(current[2]))) {
                        c.setNextCodeLine(jumpType(current[3], i, c));
                        break;
                    } else {
                        i++;
                        c.setNextCodeLine(i);
                        break;
                    }

                default:
                    System.err.println("Invalid Command");
                    break;
            }
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
