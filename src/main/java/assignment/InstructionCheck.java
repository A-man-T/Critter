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
        if (command[0].equals("infect")) {
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

}
