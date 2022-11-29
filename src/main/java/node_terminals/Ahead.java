package node_terminals;

import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;
import tanks.SubTreeTypes;

import java.util.HashMap;
import java.util.Random;

//TODO define values for this terminal (and many others)
//TODO not sure if those terminals will be even necessary or if the whole robot behaviour can be defined in functions
public class Ahead extends CommandGene {

    private int maxPower;

    public Ahead(GPConfiguration config, int maxPower) throws Exception {
        super(config, 0, CommandGene.CharacterClass);
        this.maxPower = maxPower;
    }


    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        HashMap<SubTreeTypes, String> map = (HashMap<SubTreeTypes, String>) args[0];
        SubTreeTypes type = (SubTreeTypes) args[1];
        String power = String.valueOf(rand.nextInt(maxPower));
        String currentString = map.get(type);
        currentString += "ahead(" + power + ");\n";
        map.put(type, currentString);
        return map;
    }

    @Override
    public String toString() {
        return "ahead";
    }
}
