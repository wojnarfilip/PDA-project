package sample;

import robocode.*;


public class EnderTank extends Robot {

		public void onHitWall(ScannedRobotEvent e){
			double distance = e.getDistance();

				turnGunLeft(360);
				ahead(112.51855216087199);
				turnRight(45.485140174409786);

		}


		public void run(){
			while(true){
				back(34.223054193128874);
				turnGunLeft(360);
				ahead(46.04312302019392);
				turnRight(54.069600984243145);
			}
		}


		public void onScannedRobot(ScannedRobotEvent e){
			double distance = e.getDistance();

				fire(2.941601214838462);
				ahead(88.12108666117452);
				ahead(72.18009794999344);
				back(74.6217756300941);

		}

}
