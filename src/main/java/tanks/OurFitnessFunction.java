package tanks;

import org.jgap.gp.GPFitnessFunction;
import org.jgap.gp.IGPProgram;

import java.io.IOException;
import java.util.HashMap;

public class OurFitnessFunction extends GPFitnessFunction {
    private static double tank_score = Double.MIN_VALUE;
    String individual_tank = "Mental";
    String enemy_list = "Crazy, Corners, Fire";



    @Override
    protected double evaluate(IGPProgram igpProgram) {

        try {
            tank_score = RobocodeRunner.runRobocode(individual_tank ,enemy_list);
            HashMap<SubTreeTypes, String> subTreeStrings = this.createSubTreeMap();

            //Argument [0]: Substrings for each category
            //Argument[1]: Currently used substring
            Object[] arguments = {(Object) subTreeStrings, (Object) SubTreeTypes.RUN};
            HashMap<SubTreeTypes, String> result = (HashMap<SubTreeTypes, String>) igpProgram.execute_object(0, arguments);

            this.writeIntoJavaFile(result, "superRobot.java");

            return tank_score;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<SubTreeTypes, String> createSubTreeMap(){
        HashMap<SubTreeTypes, String> map = new HashMap<>();
        for(SubTreeTypes subTree: SubTreeTypes.values()){
            map.put(subTree, "");
        }
        return map;
    }

    public void writeIntoJavaFile(HashMap<SubTreeTypes, String> map, String fileName){

        for(SubTreeTypes type : map.keySet()){
            //TODO Tady se bude zapisovat do souboru
        }

    }

    //TODO function which will look on all existing individuals in the generations and choose the fittest one based on highest score from RobocodeRunner
    //TODO once everything works fine it might be good to do more sophisticated evolve function and choose more individuals at the same time
    public void evolve() {

    }
}
