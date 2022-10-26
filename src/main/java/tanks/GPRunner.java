package tanks;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.GPProblem;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.GPGenotype;

public class GPRunner extends GPProblem {
    private static int NUM_OF_GENERATIONS = 1;
    private static int MAX_TREE_DEPTH = 5;

    public GPRunner() throws InvalidConfigurationException {
        super(new GPConfiguration());
    }

    public static void main(String[] args) throws InvalidConfigurationException {
        GPProblem problem = new GPRunner();

        GPGenotype gp = problem.create();
        gp.setVerboseOutput(true);
        gp.evolve(NUM_OF_GENERATIONS);
        System.out.println("Test run");
    }

    @Override
    public GPGenotype create() throws InvalidConfigurationException {
        GPConfiguration config = getGPConfiguration();

        //TODO create our own fitness function utilizing robocode scoring
        config.setFitnessFunction(new FitnessFunction() {
            @Override
            protected double evaluate(IChromosome iChromosome) {
                return 0;
            }
        });

        CommandGene[][] nodeSets = {{
            //TODO define functions and terminals for this node set
        }};
        return null;
    }

}
