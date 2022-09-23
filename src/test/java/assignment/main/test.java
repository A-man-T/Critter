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
    void testCritterCreation() throws IOException {
        Interpreter i = new Interpreter();
        CritterSpecies cs = i.loadSpecies("species/my2.cri");
        MyCritter mc = new MyCritter(cs.getCode());

        for (int a = 0; a < 100; a++) {
           i.executeCritter(mc);
           //System.out.println((mc).instructions);
       }
    }
    @Test
    //This method no longer tests loadspecies
    void checkInterpreter() throws IOException {
        //set up MyCritter
        String filepath = "species/my2.cri";
        Interpreter i = new Interpreter();
        CritterSpecies cs = i.loadSpecies(filepath);
        if(cs==null) {
            System.err.println("Error in input");
            return;
        }
        MyCritter mc = new MyCritter(cs.getCode());
        //create cut Instructions
        ArrayList<String> parsedinstructions = (ArrayList<String>) mc.code;
        /*
        ArrayList<String> parsedinstructions = new ArrayList<>();
        List<String> list = Files.readAllLines(new File(filepath).toPath(), Charset.defaultCharset() );
        for (String str: list)
            parsedinstructions.add(str);
        parsedinstructions.remove(0);
        int cut = parsedinstructions.size();
        for(int index =0; index<parsedinstructions.size();index++) {
            if (parsedinstructions.get(index).equals("")) {
                cut = index;
                break;
            }
        }
         go to cut below
         */
        ArrayList<String> cutInstructions = new ArrayList<>();
        //ArrayList<Integer> nums = new ArrayList<>();
        String[] current;
        for(int index =0; index<parsedinstructions.size();index++) {
            current = ((parsedinstructions.get(index).split(" ")));
            if((current[0].equals("go"))) {
                if (current[1].charAt(0) == 'r')
                    cutInstructions.add("getReg"+current[1].substring(1));
                continue;
            }
            //else if
            else if(current[0].equals("ifhungry")||current[0].equals("ifstarving")) {
                cutInstructions.add("getHungerLevel");
                if (current[1].charAt(0) == 'r')
                    cutInstructions.add("getReg"+current[1].substring(1));
                if(current[0].equals("ifhungry")) {
                    cutInstructions.add("getHungerLevel");
                    if (current[1].charAt(0) == 'r')
                        cutInstructions.add("getReg"+current[1].substring(1));
                }

                continue;
            }
            else if(current[0].equals("ifenemy")||current[0].equals("ifempty")||current[0].equals("ifally")||current[0].equals("ifwall")) {
                cutInstructions.add("getCellContent"+current[1]);
                if (current[2].charAt(0) == 'r')
                    cutInstructions.add("getReg"+current[1].substring(1));
                continue;
            }
            else if(current[0].equals("ifangle")){
                cutInstructions.add("getOffAngle"+current[1]);
                if (current[3].charAt(0) == 'r')
                    cutInstructions.add("getReg"+current[1].substring(1));
                continue;
            }
            else if(current[0].equals("write")){
                cutInstructions.add("setReg"+current[1].substring(1)+current[2]);
                continue;
            }
            else if(current[0].equals("add")||current[0].equals("sub")){
                cutInstructions.add("getReg"+current[1].substring(1));
                cutInstructions.add("getReg"+current[2].substring(1));
                cutInstructions.add("setReg"+current[1].substring(1)+0);
                continue;
            }
            else if(current[0].equals("inc")||current[0].equals("dec")){
                cutInstructions.add("getReg"+current[1].substring(1));
                if(current[0].equals("inc"))
                    cutInstructions.add("setReg"+current[1].substring(1)+1);
                else
                    cutInstructions.add("setReg"+current[1].substring(1)+"-1");
                continue;
            }
            else if(current[0].equals("iflt")||current[0].equals("ifeq")||current[0].equals("ifgt")){
                cutInstructions.add("getReg"+current[1].substring(1));
                cutInstructions.add("getReg"+current[2].substring(1));
                if (current[3].charAt(0) == 'r')
                    cutInstructions.add("getReg"+current[3].substring(1));
                continue;
            }
            else if(current[0].equals("infect")&&current.length!=1) {
                if (current[1].charAt(0) == 'r')
                    cutInstructions.add("getReg"+current[1].substring(1));
                else {
                    cutInstructions.add("infect"+current[1]);
                    continue;
                }
            }
            else if(current[0].equals("ifrandom")&&current.length!=1) {
                if (current[1].charAt(0) == 'r')
                    cutInstructions.add("getReg" + current[1].substring(1));

            }

            cutInstructions.add(current[0]);
        }


        for (int a = 0; a < 1000; a++) {
            i.executeCritter(mc);
        }

        //System.out.println(mc.instructions);
        //System.out.println(cutInstructions);
        assertEquals(mc.instructions,cutInstructions);

    }

    @Test
    void testLoadSpecies() throws IOException {
        //set up MyCritter
        String filepath = "species/AmanTrap.cri";
        Interpreter i = new Interpreter();
        CritterSpecies cs = i.loadSpecies(filepath);
        if(cs==null) {
            System.err.println("Error in input");
            return;
        }
        MyCritter mc = new MyCritter(cs.getCode());
        ArrayList<String> parsedinstructions = new ArrayList<>();
        List<String> list = Files.readAllLines(new File(filepath).toPath(), Charset.defaultCharset() );
        for (String str: list)
            parsedinstructions.add(str);
        parsedinstructions.remove(0);
        int cut = parsedinstructions.size();
        for(int index =0; index<parsedinstructions.size();index++) {
            if (parsedinstructions.get(index).equals("")) {
                cut = index;
                break;
            }
        }
        ArrayList<String> cutInstructions = new ArrayList<>();
        for(int i1=0;i1<cut;i1++)
            cutInstructions.add(parsedinstructions.get(i1));

        //System.out.println(mc.code);
        //System.out.println(cutInstructions);

        assertEquals(mc.code,cutInstructions);


    }

    @Test
    void inputValidation() throws IOException {
        Interpreter i = new Interpreter();
        CritterSpecies cs = i.loadSpecies("species/AmanTrap.cri");
        //MyCritter mc = new MyCritter(cs.getCode());
        //assertEquals(cs,null);


    }
}