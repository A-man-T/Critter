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

       CritterSpecies cs = i.loadSpecies("species/AmanTrap.cri");
       Critter hello = new MyCritter(cs.getCode());
       i.executeCritter(hello);
       System.out.print(((MyCritter) hello).instructions);


    }


}