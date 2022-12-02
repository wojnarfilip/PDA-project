package node_functions;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

import java.util.Random;

public class PostionCheck extends CommandGene implements IfType {

    private int a_arity;
    private int maxWidth;
    private int maxHeight;
    private String[] randPosition = {"", ""};
    private String[] randSign = {"", ""};
    private String randLogic;

    public PostionCheck(final GPConfiguration a_conf, int a_arity, int width, int height) throws InvalidConfigurationException {
        super(a_conf, a_arity, CommandGene.CharacterClass);
        this.a_arity = a_arity;
        this.maxWidth = width;
        this.maxHeight = height;

        Random rand = new Random();

        randPosition[0] = String.valueOf(rand.nextInt(maxWidth));
        randPosition[1] = String.valueOf(rand.nextInt(maxHeight));
        randSign[0] = rand.nextInt(2) > 0 ? "<=" : ">=";
        randSign[1] = rand.nextInt(2) > 0 ? "<=" : ">=";

        randLogic = rand.nextInt(2) > 0 ? "||" : "&&";

    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        String result = "";

        result += "\n\t\tif(getX() " + randSign[0] + " " + randPosition[0] + " " + randLogic + " getY() " + randSign[1] + " " + randPosition[1] + "){\n\t\t\t\n\n";
        for (int i = 0; i < a_arity; i++) {
            result += c.execute_object(n, i, args);
        }
        result += "\n\t\t}\n\n";

        return result;
    }

    @Override
    public String toString() {
        return "\n\t\tif(getX() " + randSign[0] + " " + randPosition[0] + " " + randLogic + " getY() " + randSign[1] + " " + randPosition[1] + "){\n\t&1 &2 &3 &4 &5}";
    }
}
