package sample;

import robocode.*;


public class EnderTank extends Robot {

		public void onScannedRobot(ScannedRobotEvent e){
			double distance = e.getDistance();

				fire(3.8929977776615887);
				turnGunLeft(360);
				fire(0.7901935008241814);
				turnLeft(37.64527097208878);

		}


		public void onHitByBullet(ScannedRobotEvent e){
			double distance = e.getDistance();

				fire(1.9576984005721605);
				turnGunLeft(360);
				turnRight(68.22537895613428);

		}


		public void onHitWall(ScannedRobotEvent e){
			double distance = e.getDistance();

				if(distance > 800) {
					fire(4.231786986982396);
				}
				else if(distance > 400 && distance <= 600){
					fire(2.8211913246549303);
				}
				else if(distance > 200 && distance <= 400){
					fire(2.8211913246549303);
				}
				else if(distance < 200) {
					fire(1.4105956623274651);
				}
				back(33.67048828673467);
				back(37.48275838170508);

		}


		public void run(){
			while(true){
				ahead(40.33797304734814);
				ahead(96.88019979715756);
				turnGunLeft(360);
				turnRight(58.71455158172644);
				turnLeft(22.991647602813824);
			}
		}

}
