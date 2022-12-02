package node_terminals;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;
import org.jgap.util.ICloneable;

public class ScanSurroundings extends CommandGene implements ICloneable {
    int value;

    public ScanSurroundings(GPConfiguration a_conf) throws InvalidConfigurationException {
        this(a_conf, CommandGene.CharacterClass, 0);
    }

    public ScanSurroundings(GPConfiguration a_conf, Class a_returnType, int a_subReturnType) throws InvalidConfigurationException {
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

    @Override
    public Object clone() {
        try {
            return new ScanSurroundings(
                    super.getGPConfiguration()
            );
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }

    }
}
