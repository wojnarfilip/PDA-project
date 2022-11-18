package node_functions;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;

public class FireGP extends CommandGene {

    public FireGP(GPConfiguration a_conf, int a_arity, Class a_returnType) throws InvalidConfigurationException {
        super(a_conf, a_arity, a_returnType);
    }

    @Override
    public String toString() {
        return "fire(1);\n";
    }
}
