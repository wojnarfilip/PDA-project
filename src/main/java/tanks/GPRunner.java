package tanks;

import node_functions.*;
import node_terminals.*;
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
    private static int MAX_LENGTH = 10;

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
        CommandGene[][] nodeSets = new CommandGene[0][];
        try {
            nodeSets = new CommandGene[][]{{
                //Functions
                new GetEnergy(config, MAX_LENGTH, 3),
                new OnHitByBullet(config, MAX_LENGTH),
                new OnHitWall(config, MAX_LENGTH),
                new OnScannedRobot(config, MAX_LENGTH),
                new PositionCheck(config, MAX_LENGTH, 800, 600),
                //Terminals
                new Ahead(config, 600),
                new Back(config, 600),
                new Fire(config, 10),
                new TurnLeft(config),
                new TurnRight(config)
            }};
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //return null;
        return GPGenotype.randomInitialGenotype(config, types, argTypes, nodeSets, 10, true);
    }

}
