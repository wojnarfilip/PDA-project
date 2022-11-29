package sample;

import robocode.Robot;

public class EnderTank extends Robot {

		public void run(){
			while(true){
				ahead(100);
				turnRight(15);
				turnRight(15);
				turnRight(15);
				turnLeft(15);
			}
		}

}