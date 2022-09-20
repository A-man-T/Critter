package assignment;

import java.util.ArrayList;
import java.util.List;

public class MyCritter implements Critter{
    private ArrayList<String> instructions = new ArrayList<>();
    @Override
    public List getCode() {
        return null;
    }

    @Override
    public int getNextCodeLine() {
        return 0;
    }

    @Override
    public void setNextCodeLine(int i) {

    }

    @Override
    public int getReg(int i) {
        return 0;
    }

    @Override
    public void setReg(int i, int i1) {

    }

    @Override
    public HungerLevel getHungerLevel() {
        return null;
    }

    @Override
    public void hop() {
        instructions.add("hop");

    }

    @Override
    public void left() {
        instructions.add("left");

    }

    @Override
    public void right() {
        instructions.add("right");
    }

    @Override
    public void eat() {
        instructions.add("eat");

    }

    @Override
    public void infect() {
        instructions.add("infect");

    }

    @Override
    public void infect(int i) {
        instructions.add("infect " + i);

    }

    @Override
    public int getCellContent(int i) {
        return 0;
    }

    @Override
    public int getOffAngle(int i) {
        return 0;
    }

    @Override
    public boolean ifRandom() {
        return false;
    }
}
