package node_terminals;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

public class Fire extends CommandGene {

    int fireXTimes;

    public Fire(GPConfiguration a_conf, int fireXTimes) throws InvalidConfigurationException {
        this(a_conf, CommandGene.CharacterClass, fireXTimes, 0);
    }

    public Fire(GPConfiguration a_conf, Class a_returnType, int fireXTimes, int a_subReturnType) throws InvalidConfigurationException {
        super(a_conf, 0, a_returnType, a_subReturnType, null);
        this.fireXTimes = fireXTimes;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        if (n == 0) {
            return "";
        }
        return this.toString();
    }

    @Override
    public String toString() {
        return "\t\t\t\tfire(" + fireXTimes + ");\n";
    }
}
