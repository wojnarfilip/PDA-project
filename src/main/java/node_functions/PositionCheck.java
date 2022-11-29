package node_functions;

import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;
import tanks.SubTreeTypes;

import java.util.HashMap;
import java.util.Random;

public class PositionCheck extends CommandGene {

    private int max_length;
    private int maxWidth;
    private int maxLength;
    private HashMap<SubTreeTypes, String> map;
    private String[] randPositon = {"", ""};
    private String[] randSigns = {"", ""};

    private String randLogic;

    public PositionCheck(GPConfiguration config, int max_length, int maxWidth, int maxHeigth) throws Exception {
        super(config, max_length, CommandGene.CharacterClass);
        Random rand = new Random();
        this.max_length = max_length;
        this.maxLength = maxHeigth;
        this.maxWidth = maxWidth;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        setRandValues();
        map = (HashMap<SubTreeTypes, String>) args[0];

        SubTreeTypes treeType = (SubTreeTypes) args[1];
        String currentString = map.get(treeType);
        currentString += "if(getX() " + randSigns[0] + " " + randPositon[0] + " " + randLogic + " getY() " + randSigns[1] + " " + randPositon[1] + "){\n";
        int randLength = rand.nextInt(this.max_length);
        for(int i = 0; i < randLength; i++) {
            map = (HashMap<SubTreeTypes, String>) c.execute_object(n, i, new Object[]{map, treeType});
            currentString += map.get(treeType);
        }
        currentString += "}";
        map.put(treeType, currentString);

        return map;
    }

    public void setRandValues(){
        Random rand = new Random();
        this.randPositon[0] = String.valueOf(rand.nextInt(maxWidth));
        this.randPositon[1] = String.valueOf(rand.nextInt(maxLength));

        this.randSigns[0] = rand.nextInt(2) == 1 ? ">" : "<";
        this.randSigns[1] = rand.nextInt(2) == 1 ? ">" : "<";
        this.randLogic = rand.nextInt(2) == 1 ? "||" : "&&";
    }

    @Override
    public String toString() {
        return "PostionCheck";
    }

}
