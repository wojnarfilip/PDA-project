package node_functions;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

public class DeclareRoboClass extends CommandGene {

    private int a_arity;

    public DeclareRoboClass(final GPConfiguration a_conf, int a_arity) throws InvalidConfigurationException {
        super(a_conf, a_arity, CommandGene.CharacterClass);
        this.a_arity = a_arity;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        String result = "";

        if (n != 0) {
            return result;
        }

        result += "\npublic class Genesis extends Robot {\n";
        for (int i = 0; i < a_arity; i++) {
            result += c.execute_object(n, i, args);
        }
        result += "}\n";

        return result;
    }

    @Override
    public String toString() {
        return "public class Genesis extends Robot (){\n&1 &2\n}";
    }

}
