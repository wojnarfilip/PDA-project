package tanks;

import robocode.BattleResults;
import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class RobocodeRunner {
	private static double score;
	public static void main(String[] args) throws IOException {

		String individual_tank = "Mental";
		String enemy_list = "Crazy, Corners, Fire";

		runRobocode(individual_tank, enemy_list);
	}

	public static double runRobocode(String individual_tank, String enemy_list) throws IOException {

		// create src and dest path for compiling
		String src = "src/main/java/sample/" + individual_tank + ".java";
		String dst = "robots/sample/" + individual_tank + ".java";
		// compile our created robot and store it to robots/samples
		File source = new File(src);
		File dest = new File(dst);
		Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, System.out, System.out, dst);
		// remove all whitespaces
		enemy_list = enemy_list.replaceAll("\\s", "");
		// create list of tanks to fight

		String tanks[] = enemy_list.split(",");
		String finalListOfTanks = "";
		for (String string : tanks) {
			string = "sample." + string + ",";
			finalListOfTanks += string;
		}

		finalListOfTanks += "sample." + individual_tank;

		// ("sample.Corners, sample.MujRobot"

		// Battle listener used for receiving battle events
		BattleObserver battleListener = new BattleObserver();

		// Create the RobocodeEngine
		RobocodeEngine engine = new RobocodeEngine(); // Run from current
														// working directory

		// Add battle listener to our RobocodeEngine
		engine.addBattleListener(battleListener);

		// Show the battles
		engine.setVisible(true);

		// Set up the battle specification

		int numberOfRounds = 5;
		//NECHAT NA 800x600. Potreba pri tvorbe tanku
		BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600
		// RobotSpecification[] selectedRobots =
		// engine.getLocalRepository("sample.Corners, sample.MujRobot");
		RobotSpecification[] selectedRobots = engine.getLocalRepository(finalListOfTanks);

		BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);
		// Run our specified battle and let it run till it's over
		engine.runBattle(battleSpec, true/* wait till the battle is over */);

		for (BattleResults result : battleListener.getResults()) {
			System.out.println(result.getTeamLeaderName() + " - " + result.getScore());

			if(result.getTeamLeaderName() == "Mental") {
				score = result.getScore();
			}
		}

		// Cleanup our RobocodeEngine
		engine.close();

		// Make sure that the Java VM is shut down properly
		System.exit(0);
		return score;
	}
}