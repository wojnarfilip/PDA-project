package node_terminals;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

import java.util.Random;

public class TurnLeft extends CommandGene {
    private double mean;
    private double deviation;

    public TurnLeft(GPConfiguration a_conf, double mean, double deviation) throws InvalidConfigurationException {
        this(a_conf, CommandGene.CharacterClass, mean, deviation, 0);
    }

    public TurnLeft(GPConfiguration a_conf, Class a_returnType, double mean, double deviation, int a_subReturnType) throws InvalidConfigurationException {
        super(a_conf, 0, a_returnType, a_subReturnType, null);
        this.mean = mean;
        this.deviation = deviation;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        String randValue = String.valueOf(rand.nextGaussian()*deviation+mean);

        if (n == 0) {
            return "";
        }
        return "\t\t\t\tturnLeft(" + randValue + ");\n";
    }

    @Override
    public String toString() {
        return "\t\t\t\tturnLeft();\n";
    }
}
