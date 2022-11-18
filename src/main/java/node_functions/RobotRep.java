package node_functions;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

public class RobotRep extends CommandGene {

    public RobotRep(GPConfiguration a_conf, int a_arity, Class a_returnType) throws InvalidConfigurationException {
        super(a_conf, a_arity, a_returnType);
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        return c.execute_object(n, 0, args);
    }

    @Override
    public String toString() {
        return "public class RobotRep(){&1 &2 &3 &4 &5 &6 &7 &8}";
    }
}
