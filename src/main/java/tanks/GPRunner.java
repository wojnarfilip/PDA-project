package tanks;


import node_functions.DeclareRoboClass;
import node_functions.OnScannedRobot;
import node_functions.Run;
import node_terminals.*;
import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.GPProblem;
import org.jgap.gp.IGPProgram;
import org.jgap.gp.impl.DeltaGPFitnessEvaluator;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.GPGenotype;

public class GPRunner extends GPProblem {
    private static int numOfTerminals = 5;
    private static int NUM_OF_GENERATIONS = 1;
    private static int MAX_TREE_DEPTH = 3;
    private static int MIN_TREE_DEPTH = 1;
    private static float MUTATION_PROB = 0.0075f;
    private static int POP_SIZE = 250;

    public GPRunner() throws InvalidConfigurationException {
        super(new GPConfiguration());
    }

    public static void main(String[] args) throws InvalidConfigurationException {
        GPProblem problem = new GPRunner();

        GPGenotype gp = problem.create();
        gp.setVerboseOutput(true);
        gp.evolve(NUM_OF_GENERATIONS);
        //gp.outputSolution(gp.getAllTimeBest());
        //System.out.println(gp.getAllTimeBest().toStringNorm(0));;
        System.out.println("Nejlepší tank generace získal score: " + OurFitnessFunction.tank_score);
    }

    @Override
    public GPGenotype create() throws InvalidConfigurationException {
        GPConfiguration config = getGPConfiguration();

        config.setGPFitnessEvaluator(new DeltaGPFitnessEvaluator());
        config.setMinInitDepth(MIN_TREE_DEPTH);
        config.setMaxInitDepth(MAX_TREE_DEPTH);
        config.setPopulationSize(POP_SIZE);
        //config.setMutationProb(MUTATION_PROB);
        //config.setStrictProgramCreation(true);

        Class[] types = { CommandGene.CharacterClass };
        Class[][] argTypes = { {} };

        //TODO work on RobotClassValidator
        config.setFitnessFunction(new OurFitnessFunction());
        config.setNodeValidator(new RobotClassValidator());
        config.setInitStrategy(new SetFirstNode());

        //TODO define functions and terminals for this node set
        CommandGene[][] nodeSets = {{
            //Set of functions
                new DeclareRoboClass(config, 2),
                new Run(config, numOfTerminals),
                new OnScannedRobot(config, numOfTerminals),
            //Set of terminals
                new Ahead(config, 100),
                new Back(config, 75),
                new Fire(config, 3),
                new TurnLeft(config, 15),
                new TurnRight(config, 15),
                new TurnGunLeft(config, 360),
        }};

        GPGenotype result = GPGenotype.randomInitialGenotype(
                config,
                types,
                argTypes,
                nodeSets,
                20,
                true
        );
        for (int i = 0; i < POP_SIZE; i++) {
            IGPProgram randomProgram = result.getGPPopulation().getGPProgram(i);
            System.out.println("RESULTS HEEERE");
            System.out.println(randomProgram.toStringNorm(0));
        }

        return GPGenotype.randomInitialGenotype(config, types, argTypes, nodeSets, 25, true);
    }

}
