package node_functions;

import org.jgap.InvalidConfigurationException;
import org.jgap.gp.CommandGene;
import org.jgap.gp.impl.GPConfiguration;
import org.jgap.gp.impl.ProgramChromosome;

public class OnBulletHit extends CommandGene {
    private int a_arity;

    public OnBulletHit(final GPConfiguration a_conf, int a_arity) throws InvalidConfigurationException {
        super(a_conf, a_arity, CommandGene.CharacterClass);
        this.a_arity = a_arity;
    }

    @Override
    public Object execute_object(ProgramChromosome c, int n, Object[] args) {
        String result = "";

        result += "\n\t\tpublic void onBulletHit(ScannedRobotEvent e){\n\t\t\tdouble distance = e.getDistance();\n\n";
        for (int i = 0; i < a_arity; i++) {
            result += c.execute_object(n, i, args);
        }
        result += "\n\t\t}\n\n";

        return result;
    }

    @Override
    public String toString() {
        return "public void onBulletHit(ScannedRobotEvent e){\n\tdouble distance = e.getDistance();\n&1 &2 &3 &4 &5}";
    }
}
