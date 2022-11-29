package node_functions;

import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;
import tanks.SubTreeTypes;

import java.util.HashMap;
import java.util.Random;

public class GetEnergy extends CommandGene {

    private int max_length;
    private int maxEnergy;
    private HashMap<SubTreeTypes, String> map;
    private String randEnergy;
    private String randSign;

    public GetEnergy(GPConfiguration config, int max_length, int maxEnergy) throws Exception {
        super(config, max_length, CommandGene.CharacterClass);
        this.max_length = max_length;
        this.maxEnergy = maxEnergy;

    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        map = (HashMap<SubTreeTypes, String>) args[0];
        this.setRandEnergy();

        SubTreeTypes treeType = (SubTreeTypes) args[1];
        String currentString = map.get(treeType);
        currentString += "if(getEnergy() " + randSign + " " + randEnergy + "){\n";
        int randLength = rand.nextInt(this.max_length);
        for(int i = 0; i < randLength; i++) {
            map = (HashMap<SubTreeTypes, String>) c.execute_object(n, i, new Object[]{map, treeType});
            currentString += map.get(treeType);
        }
        currentString += "}";
        map.put(treeType, currentString);

        return map;
    }

    public void setRandEnergy(){
        Random rand = new Random();
        this.randEnergy = String.valueOf(rand.nextInt(maxEnergy));
        switch(rand.nextInt(5)){
            case 0:
                this.randSign = ">";
                break;
            case 1:
                this.randSign = "<";
                break;
            case 2:
                this.randSign = "==";
                break;
            case 3:
                this.randSign = "<=";
                break;
            case 4:
                this.randSign = ">=";
                break;
        }
    }

    @Override
    public String toString() {
        return "GetEnergy";
    }
}
