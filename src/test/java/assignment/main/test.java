package assignment.main;

import assignment.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class test {
    @Test
    void testMyCritter() throws IOException {
        //Critter hello = new MyCritter();
        Interpreter i = new Interpreter();
        //Interpreter.loadSpecies();

       CritterSpecies cs = i.loadSpecies("species/FlyTrap.cri");
       MyCritter hello = new MyCritter(cs.getCode());

       for (int a = 0; a < 100; a++) {
           i.executeCritter(hello);
           System.out.println(( hello).instructions);
       }


    }


}