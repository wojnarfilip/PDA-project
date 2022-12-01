package node_terminals;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

import java.util.Random;

public class ScanSurroundigs extends CommandGene {
    int value;

    public ScanSurroundigs(GPConfiguration a_conf) throws InvalidConfigurationException {
        this(a_conf, CommandGene.CharacterClass, 0);
    }

    public ScanSurroundigs(GPConfiguration a_conf, Class a_returnType, int a_subReturnType) throws InvalidConfigurationException {
        super(a_conf, 0, a_returnType, a_subReturnType, null);
        this.value = 360;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {

        if (n == 0) {
            return "";
        }
        return "\t\t\t\tturnGunLeft(" + value + ");\n";
    }

    @Override
    public String toString() {
        return "\t\t\t\tturnGunLeft(360);\n";
    }
}
