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


    @Override
    public String toString() {
        return left.toString() + center.toString() + right.toString();
    }


    public void move(Tower source, Tower destination) {
        Disk movedDisk = source.pop();
        destination.push(movedDisk);

        setChanged();
        notifyObservers(destination.position());
    }


    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {

        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);

            move(startPole, endPole);

            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    public void solve() {
        solveTowers(numDisks, left, center, right);
    }
}
