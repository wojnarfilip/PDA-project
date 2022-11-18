package tanks;

import org.jgap.gp.GPFitnessFunction;
import org.jgap.gp.IGPProgram;

import java.io.IOException;

public class OurFitnessFunction extends GPFitnessFunction {
    private static double tank_score = Double.MIN_VALUE;
    String individual_tank = "Mental";
    String enemy_list = "Crazy, Corners, Fire";

    private static Object[] NO_ARGS = new Object[0];

    @Override
    protected double evaluate(IGPProgram igpProgram) {

        try {
            tank_score = RobocodeRunner.runRobocode(individual_tank ,enemy_list);
            return tank_score;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO function which will look on all existing individuals in the generations and choose the fittest one based on highest score from RobocodeRunner
    //TODO once everything works fine it might be good to do more sophisticated evolve function and choose more individuals at the same time
    public void evolve() {

    }
}
