package sample;

import robocode.*;


public class EnderTank extends Robot {

		public void run(){
			while(true){
				ahead(100);
				ahead(100);
				turnGunLeft(360);
				turnRight(15);
				ahead(100);
			}
		}


		public void onScannedRobot(ScannedRobotEvent e){
			double distance = e.getDistance();

				fire(3);
				fire(3);
				fire(3);
				turnLeft(15);
				back(75);

		}

}
