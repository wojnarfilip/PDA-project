package node_terminals;

import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;
import tanks.SubTreeTypes;

import java.util.HashMap;
import java.util.Random;

public class Back extends CommandGene {

    private int maxPower;

    public Back(GPConfiguration config, int maxPower) throws Exception {
        super(config, 0, CommandGene.CharacterClass);
        this.maxPower = maxPower;
    }


    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        HashMap<SubTreeTypes, String> map = (HashMap<SubTreeTypes, String>) args[0];
        SubTreeTypes type = (SubTreeTypes) args[1];
        String power = String.valueOf(rand.nextInt(maxPower));
        String currentString = map.get(type);
        currentString += "back(" + power + ");\n";
        map.put(type, currentString);
        return map;
    }

    @Override
    public String toString() {
        return "back";
    }
}
