package tanks;

import org.jgap.gp.CommandGene;
import org.jgap.gp.IGPChromosome;
import org.jgap.gp.IGPInitStrategy;

public class GPInitStrategy implements IGPInitStrategy {

    private Class<?> class_name;

    public GPInitStrategy(Class<?> name) {
        this.class_name = name;
    }

    @Override
    public CommandGene init(IGPChromosome a_chrom, int i) {
        CommandGene root = null;

        for (CommandGene gen : a_chrom.getFunctionSet()) {
            if (gen.getClass().getName().equals(class_name.getName())) {
                root = gen;
                break;
            }
        }
        return root;
    }
}
