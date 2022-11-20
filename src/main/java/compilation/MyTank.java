package compilation;


import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/*
    Sample class used as a template for the result of genetic programming.
 */
public class MyTank extends Robot {

    public void run(){
        while(true){
            ${NORMAL_CODE}
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        ${ON_SCANNED_CODE}
    }

    public void onHitRobot(HitRobotEvent e) {
        ${ON_HIT_CODE}
    }


}
