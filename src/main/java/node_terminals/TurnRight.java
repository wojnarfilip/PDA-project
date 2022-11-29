package node_terminals;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

public class TurnRight extends CommandGene {
    int value;

    public TurnRight(GPConfiguration a_conf, int value) throws InvalidConfigurationException {
        this(a_conf, CommandGene.CharacterClass, value, 0);
    }

    public TurnRight(GPConfiguration a_conf, Class a_returnType, int value, int a_subReturnType) throws InvalidConfigurationException {
        super(a_conf, 0, a_returnType, a_subReturnType, null);
        this.value = value;
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
        return "\t\t\t\tturnRight(" + value + ");\n";
    }
}