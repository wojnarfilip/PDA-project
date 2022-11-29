package node_functions;

import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;
import tanks.SubTreeTypes;

import java.util.HashMap;
import java.util.Random;

public class OnHitBullet extends CommandGene {
    private int max_length;
    private HashMap<SubTreeTypes, String> map;

    public OnHitBullet(GPConfiguration config, int max_length) throws Exception {
        super(config, max_length, CommandGene.CharacterClass);
        this.max_length = max_length;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        Random rand = new Random();
        map = (HashMap<SubTreeTypes, String>) args[0];

        SubTreeTypes newType = SubTreeTypes.ON_BULLET_HIT;
        String currentString = map.get(newType);
        int randLength = rand.nextInt(this.max_length);
        for(int i = 0; i < randLength; i++) {
            map = (HashMap<SubTreeTypes, String>) c.execute_object(n, i, new Object[]{map, newType});
            currentString += map.get(newType);
        }
        map.put(newType, currentString);

        return map;
    }

    @Override
    public String toString() {
        return "OnBulletHit";
    }

}
