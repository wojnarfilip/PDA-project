package node_terminals;

import node_functions.DeclareRoboClass;
import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.IMutateable;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;
import org.jgap.util.ICloneable;

import java.util.Map;
import java.util.Random;

public class IfDistanceFire extends CommandGene implements ICloneable, IMutateable {
    private double mean;
    private double deviation;
    private int distanceStep;

    private int numOfIfs = -1;
    private double randValue = -1.0d;
    private static int min = 1;
    private static int max = 5;

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

        if(randValue < 0.0d || numOfIfs < 0){
            this.randValue = rand.nextGaussian()*deviation+mean;
            this.numOfIfs = rand.nextInt((max - min) + 1 + min);
        }

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

    @Override
    public Object clone() {
        try {
            IfDistanceFire dstFire = new IfDistanceFire(
                    super.getGPConfiguration(),
                    super.getReturnType(),
                    this.mean,
                    this.deviation,
                    this.distanceStep,
                    super.getSubReturnType()
            );
            dstFire.randValue = this.randValue;
            dstFire.numOfIfs = this.numOfIfs;

            return dstFire;
        } catch (InvalidConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CommandGene applyMutation(int i, double v) throws InvalidConfigurationException {
        Random rand = new Random();
        this.randValue = rand.nextGaussian()*(deviation/2) + randValue;
        this.numOfIfs = rand.nextInt((max - min) + 1 + min);
        return this;
    }
}
