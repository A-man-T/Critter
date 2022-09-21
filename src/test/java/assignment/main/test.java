package assignment.main;

import assignment.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class test {
    @Test
    void testCommands() throws IOException {
        Interpreter i = new Interpreter();
       CritterSpecies cs = i.loadSpecies("species/AmanTrap.cri");
       MyCritter mc = new MyCritter(cs.getCode());

       for (int a = 0; a < 100; a++) {
           i.executeCritter(mc);
           //System.out.println((mc).instructions);
       }
    }
    @Test
    void checkCommands() throws IOException {
        String filepath = "species/AmanTrap.cri";
        Interpreter i = new Interpreter();
        CritterSpecies cs = i.loadSpecies(filepath);
        MyCritter mc = new MyCritter(cs.getCode());
        ArrayList<String> parsedinstructions = new ArrayList<>();

        List<String> list = Files.readAllLines(new File(filepath).toPath(), Charset.defaultCharset() );

        for (String str: list)
            parsedinstructions.add(str);
        System.out.println(parsedinstructions);

        //assertEquals()


        for (int a = 0; a < 100; a++) {
            i.executeCritter(mc);
        }
        //assertEquals(mc.instructions,parsedinstructions);

    }



}