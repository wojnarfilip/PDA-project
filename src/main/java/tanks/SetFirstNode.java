package tanks;

import node_functions.DeclareRoboClass;
import org.jgap.gp.CommandGene;
import org.jgap.gp.IGPChromosome;
import org.jgap.gp.IGPInitStrategy;

public class SetFirstNode implements IGPInitStrategy {

    @Override
    public CommandGene init(IGPChromosome chrom, int chrom_Number) {

        for (CommandGene gen : chrom.getFunctionSet()) {
            if (gen.getClass().getName().equals(DeclareRoboClass.class.getName())) {
                return gen;
            }
        }
        return null;
    }
}
