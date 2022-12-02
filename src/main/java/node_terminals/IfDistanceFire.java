package node_terminals;

import node_functions.DeclareRoboClass;
import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

import java.util.Map;
import java.util.Random;

public class IfDistanceFire extends CommandGene {
    private double mean;
    private double deviation;
    private int distanceStep;

    public IfDistanceFire(GPConfiguration a_conf, double mean, double deviation, int distanceStep) throws InvalidConfigurationException {
        this(a_conf, CommandGene.CharacterClass, mean, deviation, distanceStep, 0);
    }

    public IfDistanceFire(GPConfiguration a_conf, Class a_returnType, double mean, double deviation, int distanceStep, int a_subReturnType) throws InvalidConfigurationException {
        super(a_conf, 0, a_returnType, a_subReturnType, null);
        this.mean = mean;
        this.deviation = deviation;
        this.distanceStep = distanceStep;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        Double randValue = rand.nextGaussian()*deviation+mean;
        Random ifNumGen = new Random();
        int min = 1;
        int max = 5;
        int numOfIfs = ifNumGen.nextInt((max - min) + 1 + min);

        String result = "";

        if (n == 0) {
            return "";
        }

        for (int i = 1; i <= numOfIfs; i++) {
            if (i == 1) {
                result += "\t\t\t\tif(distance > " + distanceStep * (numOfIfs - i + 1)+ ") {\n" +
                         "\t\t\t\t\tfire(" + randValue * 1.5 + ");\n\t\t\t\t}\n";
            } else if (i == numOfIfs) {
                result += "\t\t\t\telse if(distance < " + distanceStep + ") {\n" +
                          "\t\t\t\t\tfire("+ randValue * 0.5+");\n\t\t\t\t}\n";
            } else {
                result += "\t\t\t\telse if(distance > "+ distanceStep * (numOfIfs - i) +" && distance <= "+distanceStep * (numOfIfs - i + 1)+"){\n" +
                          "\t\t\t\t\tfire("+ randValue +");\n\t\t\t\t}\n";
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "\t\t\t\tIfDistanceFire();\n";
    }
}
