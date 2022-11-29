package tanks;

import org.jgap.gp.GPFitnessFunction;
import org.jgap.gp.IGPProgram;
import parser.GPParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OurFitnessFunction extends GPFitnessFunction {
    private static double tank_score = Double.MIN_VALUE;
    String individual_tank = "Genesis";
    String enemy_list = "Crazy, Corners, Fire";
    private static String Header="package sample;\r\n" +  "\r\n" +  "import robocode.*;" + "\r\n" + "public class Genesis extends Robot {";

    private static Object[] NO_ARGS = new Object[0];

    @Override
    protected double evaluate(IGPProgram igpProgram) {
        String robot = (String) igpProgram.execute_object(0, NO_ARGS);

        try {
            GPParser.createFile(individual_tank, "src/main/java/sample/");
            GPParser.writeToFile(robot, individual_tank, "src/main/java/sample/");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            evolve(robot, RobocodeRunner.runRobocode(individual_tank ,enemy_list, false));
            return tank_score;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //TODO once everything works fine it might be good to do more sophisticated evolve function and choose more individuals at the same time (Not sure if this is correct way of thinking)
    public void evolve(String robot, double current_tank_score) throws IOException {
        //Update best solution value
        if(tank_score < current_tank_score) {
            tank_score = current_tank_score;

            //Save best current robot into a file, overwrite every time better solution is found
            GPParser.createFile("EnderTank", "src/main/java/sample/");
            GPParser.writeToFile(robot, "EnderTank", "src/main/java/sample/");
        }
    }
}
