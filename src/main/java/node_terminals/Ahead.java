package node_terminals;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

//TODO define values for this terminal (and many others)
//TODO not sure if those terminals will be even necessary or if the whole robot behaviour can be defined in functions
public class Ahead extends CommandGene {

    int value;

    public Ahead(GPConfiguration a_conf, int value) throws InvalidConfigurationException {
        this(a_conf, CommandGene.CharacterClass, value, 0);
    }

    public Ahead(GPConfiguration a_conf, Class a_returnType, int value, int a_subReturnType) throws InvalidConfigurationException {
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
        return "\t\t\t\tahead(" + value + ");\n";
    }
}
