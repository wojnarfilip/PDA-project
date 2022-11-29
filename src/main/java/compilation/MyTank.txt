package compilation;


import robocode.*;

/*
    Sample class used as a template for the result of genetic programming.
 */
public class MyTank extends Robot {

    private int score = 0;
    public void run(){
        while(true){
            ${RUN}
        }
    }

    public void onScannedRobot(ScannedRobotEvent e) {
        ${ON_SCANNED_ROBOT}
    }

    public void onHitWall(HitWallEvent e) {
        ${ON_HIT_WALL}
    }

    public void onBulletHit(BulletHitEvent e){
        ${ON_BULLET_HIT}
    }

    public void onHitByBullet(HitByBulletEvent e){
        ${ON_HIT_BY_BULLET}
    }

    public int getScore(){
       return this.score;
    }

    public void setScore(int score){
        this.score = score;
    }

}
