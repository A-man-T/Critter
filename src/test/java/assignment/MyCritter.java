package assignment;

import java.util.ArrayList;
import java.util.List;

public class MyCritter implements Critter{
    public ArrayList<String> instructions = new ArrayList<>();
    public List code;
    public ArrayList<Integer> registers = new ArrayList<>();
    public int i=1;

    public MyCritter(List i){
        this.code = i;

    }

    @Override
    public List getCode() {
        return code;
    }

    @Override
    public int getNextCodeLine() {

        return i;
    }

    @Override
    public void setNextCodeLine(int i) {
        this.i++;

    }

    @Override
    public int getReg(int i) {
        instructions.add("getReg" + i);
        registers.add(i);
        return 0;
    }

    @Override
    public void setReg(int i, int i1) {
        instructions.add("setReg"+i+i1);
        registers.add(i);


    }

    @Override
    public HungerLevel getHungerLevel() {
        instructions.add("getHungerLevel");
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
        instructions.add("infect"+i);
        registers.add(i);

    }

    @Override
    public int getCellContent(int i) {
        instructions.add("getCellContent"+i);
        registers.add(i);
        return 0;
    }

    @Override
    public int getOffAngle(int i) {
        instructions.add("getOffAngle"+i);
        registers.add(i);
        return 0;
    }

    @Override
    public boolean ifRandom() {
        instructions.add("ifrandom");
        return false;
    }
}
