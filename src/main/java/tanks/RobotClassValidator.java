package tanks;

import node_functions.DeclareRoboClass;
import node_functions.OnScannedRobot;
import node_functions.Run;
import node_terminals.*;
import org.jgap.gp.CommandGene;
import org.jgap.gp.INodeValidator;
import org.jgap.gp.impl.ProgramChromosome;

import java.util.LinkedList;

public class RobotClassValidator implements INodeValidator {

    private LinkedList<Class<?>> alreadyUsed = new LinkedList<>();

    @Override
    public boolean validate(ProgramChromosome programChromosome, CommandGene node, CommandGene rootNode,
                            int i, int i1, int i2, Class aClass, CommandGene[] commandGenes, int i3, boolean b, int i4, boolean b1) {

        alreadyUsed.add(DeclareRoboClass.class);
        if (programChromosome != null){
            return true;
        }

        if (node == null){
            return true;
        }

        if (node.getArity(null) == 0 && rootNode.getClass().equals(DeclareRoboClass.class)) {
            return false;
        }

		if (node.getClass().equals(IfDistanceFire.class) && !rootNode.getClass().equals(OnScannedRobot.class)){
			if (alreadyUsed.contains(IfDistanceFire.class)) {
				return false;
			} else {
				alreadyUsed.add(node.getClass());
				return true;
			}
		}

		if (node.getArity(null) != 0) {
			if (alreadyUsed.contains(node.getClass())) {
				return false;
			}
			else {
				alreadyUsed.add(node.getClass());
				return true;
			}
		}
		else {
			if (!rootNode.getClass().equals(DeclareRoboClass.class)) {
				return true;
			}
			else {
				return false;
			}
		}
    }
}
