package node_terminals;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.IMutateable;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;
import org.jgap.util.ICloneable;

import java.util.Random;

//TODO define values for this terminal (and many others)
//TODO not sure if those terminals will be even necessary or if the whole robot behaviour can be defined in functions
public class Ahead extends CommandGene implements ICloneable, IMutateable {

    private double mean;
    private double deviation;
    private String randValue = "-1";

    public Ahead(GPConfiguration a_conf, double mean, double deviation) throws InvalidConfigurationException {
        this(a_conf, CommandGene.CharacterClass, mean, deviation, 0);
    }

    public Ahead(GPConfiguration a_conf, Class a_returnType, double mean, double deviation, int a_subReturnType) throws InvalidConfigurationException {
        super(a_conf, 0, a_returnType, a_subReturnType, null);
        this.mean = mean;
        this.deviation = deviation;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        if(Double.parseDouble(randValue) < 0){
            randValue = String.valueOf(rand.nextGaussian()*deviation+mean);
        }

        if (n == 0) {
            return "";
        }
        return "\t\t\t\tahead(" + randValue + ");\n";
    }

    @Override
    public String toString() {
        return "\t\t\t\tahead();\n";
    }

    @Override
    public Object clone() {
        try {
            Ahead ahead = new Ahead(
                    super.getGPConfiguration(),
                    super.getReturnType(),
                    this.mean,
                    this.deviation,
                    super.getSubReturnType()
            );
            ahead.randValue = this.randValue;

            return ahead;
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CommandGene applyMutation(int i, double v) throws InvalidConfigurationException {
        Random rand = new Random();
        this.randValue = String.valueOf(rand.nextGaussian()*(deviation/2) + Double.parseDouble(randValue));
        return this;
    }
}
