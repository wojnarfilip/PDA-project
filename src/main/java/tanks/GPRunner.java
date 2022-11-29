package tanks;


import node_functions.Run;
import node_terminals.Ahead;
import node_terminals.Fire;
import node_terminals.TurnLeft;
import node_terminals.TurnRight;
import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.GPProblem;
import org.jgap.gp.impl.DeltaGPFitnessEvaluator;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.GPGenotype;

public class GPRunner extends GPProblem {
    private static int numOfTerminals = 5;
    private static int NUM_OF_GENERATIONS = 1;
    private static int MAX_TREE_DEPTH = 1;
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

        //TODO define functions and terminals for this node set
        CommandGene[][] nodeSets = {{
            //Set of functions
            new Run(config, numOfTerminals),
            //Set of terminals
            new Ahead(config, 100),
                new Fire(config, 1),
                new TurnLeft(config, 15),
                new TurnRight(config, 15),
        }};
        //return null;
        return GPGenotype.randomInitialGenotype(config, types, argTypes, nodeSets, 10, true);
    }

}
