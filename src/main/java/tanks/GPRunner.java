package tanks;

import node_functions.FireGP;
import node_functions.RobotRep;
import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.GPProblem;
import org.jgap.gp.impl.DeltaGPFitnessEvaluator;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.GPGenotype;

public class GPRunner extends GPProblem {
    private static int NUM_OF_GENERATIONS = 1;
    private static int MAX_TREE_DEPTH = 5;
    private static int MIN_TREE_DEPTH = 1;
    private static float MUTATION_PROB = 0.0075f;
    private static int POP_SIZE = 5;

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

        config.setGPFitnessEvaluator(new DeltaGPFitnessEvaluator());
        config.setMinInitDepth(MIN_TREE_DEPTH);
        config.setMaxInitDepth(MAX_TREE_DEPTH);
        config.setPopulationSize(POP_SIZE);
        config.setMutationProb(MUTATION_PROB);

        Class[] types = { CommandGene.CharacterClass };
        Class[][] argTypes = { {} };

        //TODO create our own fitness function utilizing robocode scoring
        config.setFitnessFunction(new OurFitnessFunction());
        config.setInitStrategy(new GPInitStrategy(RobotRep.class));

        //TODO define functions and terminals for this node set
        CommandGene[][] nodeSets = {{
            new RobotRep(config, 0, Object.class),
            new FireGP(config, 0, Integer.class),
        }};
        //return null;
        return GPGenotype.randomInitialGenotype(config, types, argTypes, nodeSets, 10, true);
    }

}
