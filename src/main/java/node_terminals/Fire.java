package node_terminals;

import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

import java.util.Random;

public class Fire extends CommandGene {
    private int maxPower;

    public Fire(GPConfiguration config, int maxPower) throws Exception {
        super(config, 0, CommandGene.CharacterClass);
        this.maxPower = maxPower;
    }

    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        String power = String.valueOf(rand.nextInt(maxPower));

        return "fire(" + power + ");\n";
    }

    @Override
    public String toString() {
        return "fire";
    }
}
