package towerofhanoi;

import java.util.Observable;

public class HanoiSolver extends Observable {

    private Tower left;
    private Tower center;
    private Tower right;
    private int numDisks;

    public HanoiSolver(int numDisks) {

        this.numDisks = numDisks;

        left = new Tower(Position.LEFT);
        center = new Tower(Position.CENTER);
        right = new Tower(Position.RIGHT);
    }


    public int disks() {
        return numDisks;
    }


    public Tower getTower(Position pos) {

        switch (pos) {

            case LEFT:
                return left;

            case CENTER:
                return center;

            case RIGHT:
                return right;

            default:
                return center;
        }
    }
}
