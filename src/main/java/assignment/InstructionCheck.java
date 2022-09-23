package assignment;

public class InstructionCheck {
    public static boolean CompileInstructionCheck(String s) {
        String[] command = (s.split(" "));
        if (command[0].equals("hop")) {
            return true;
        }
        if (command[0].equals("left")) {
            return true;
        }
        if (command[0].equals("right")) {
            return true;
        }
        if (command[0].equals("infect")) {
            return true;
        }
        if (command[0].equals("eat")) {
            return true;
        }
        if (command[0].equals("ifally")) {
            return true;
        }
        if (command[0].equals("ifenemy")) {
            return true;
        }
        if (command[0].equals("ifrandom")) {
            return true;
        }
        if (command[0].equals("go")) {
            return true;
        }
        if (command[0].equals("ifstarving")) {
            return true;
        }
        if (command[0].equals("ifangle")) {
            return true;
        }
        if (command[0].equals("ifempty")) {
            return true;
        }
        if (command[0].equals("ifwall")) {
            return true;
        }
        if (command[0].equals("write")) {
            return true;
        }
        if (command[0].equals("add")) {
            return true;
        }
        if (command[0].equals("sub")) {
            return true;
        }
        if (command[0].equals("inc")) {
            return true;
        }
        if (command[0].equals("dec")) {
            return true;
        }
        if (command[0].equals("iflt")) {
            return true;
        }
        if (command[0].equals("ifeq")) {
            return true;
        }
        if (command[0].equals("ifgt")) {
            return true;
        }
        if (command[0].equals("ifhungry")) {
            return true;
        }
        return false;
    }

    public static boolean NumChecks(String s) {
        String[] command = (s.split(" "));
        if (command[0].equals("hop")) {
            if (command.length != 1) {
                return false;
            }
        }

        if (command[0].equals("infect")) {
            if (command.length == 2) {
                try {
                    Integer.parseInt(noWhitespace(command[1]));
                } catch (NumberFormatException e) {
                    return false;
                }
                if (!validRegister(command[1])) {
                    return false;
                }
            }
            if (command.length > 2) {
                return false;
            }
        }
        if (command[0].equals("ifally")) {
            if (3 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (Integer.parseInt(command[1]) % 45 != 0) {
                return false;
            }
            if (!validRegister(command[2])) {
                return false;
            }
        }
        if (command[0].equals("ifenemy")) {
            if (3 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (Integer.parseInt(command[1]) % 45 != 0) {
                return false;
            }
            if (!validRegister(command[2])) {
                return false;
            }
        }
        if (command[0].equals("ifrandom")) {
            if (2 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (!validRegister(command[1])) {
                return false;
            }
        }
        if (command[0].equals("go")) {
            if (2 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (!validRegister(command[1])) {
                return false;
            }
        }
        if (command[0].equals("ifstarving")) {
            if (2 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (!validRegister(command[1])) {
                return false;
            }
        }
        if (command[0].equals("ifangle")) {
            if (4 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
                Integer.parseInt(noWhitespace(command[3]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (Integer.parseInt(command[1]) % 45 != 0 || Integer.parseInt(command[2]) % 45 != 0) {
                return false;
            }
            if (!validRegister(command[3])) {
                return false;
            }
        }
        if (command[0].equals("ifempty")) {
            if (3 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (Integer.parseInt(command[1]) % 45 != 0) {
                return false;
            }
            if (!validRegister(command[2])) {
                return false;
            }
        }
        if (command[0].equals("ifwall")) {
            if (3 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (Integer.parseInt(command[1]) % 45 != 0) {
                return false;
            }
            if (!validRegister(command[2])) {
                return false;
            }
        }
        if (command[0].equals("write")) {
            if (3 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (command[0].equals("add")) {
            if (3 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (command[0].equals("sub")) {
            if (3 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (command[0].equals("inc")) {
            if (2 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (command[0].equals("dec")) {
            if (2 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
            } catch (NumberFormatException e) {
                return false;
            }
        }
        if (command[0].equals("iflt")) {
            if (4 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
                Integer.parseInt(noWhitespace(command[3]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (!validRegister(command[2])) {
                return false;
            }
        }
        if (command[0].equals("ifeq")) {
            if (4 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
                Integer.parseInt(noWhitespace(command[3]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (!validRegister(command[2])) {
                return false;
            }
        }
        if (command[0].equals("ifgt")) {
            if (4 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
                Integer.parseInt(noWhitespace(command[2]));
                Integer.parseInt(noWhitespace(command[3]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (!validRegister(command[2])) {
                return false;
            }
        }
        if (command[0].equals("ifhungry")) {
            if (2 != command.length) {
                return false;
            }
            try {
                Integer.parseInt(noWhitespace(command[1]));
            } catch (NumberFormatException e) {
                return false;
            }
            if (!validRegister(command[1])) {
                return false;
            }
        }
        return true;
    }

    private static String noWhitespace(String s) {
        if (!Character.isDigit(s.charAt(0))) {
            return s.substring(1);
        }
        return s;
    }

    private static boolean isRegister(String s) {
        return s.charAt(0) == 'r';
    }
    private static boolean validRegister(String s) {
        if (isRegister(s)) {
            if (Integer.parseInt(noWhitespace(s)) > 10 || Integer.parseInt(noWhitespace(s)) < 1) {
                return false;
            }
        }
        return true;
    }

}
