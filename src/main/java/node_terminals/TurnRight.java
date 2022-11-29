package node_terminals;

import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

import java.util.Random;

public class TurnRight extends CommandGene {

    private int maxDegree = 360;

    public TurnRight(GPConfiguration config) throws Exception {
        super(config, 0, CommandGene.CharacterClass);
    }

    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        String power = String.valueOf(rand.nextInt(maxDegree));

        return "turnRight(" + power + ");\n";
    }

    @Override
    public String toString() {
        return "turnRight";
    }
}
