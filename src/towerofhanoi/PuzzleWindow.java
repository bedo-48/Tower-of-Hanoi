package towerofhanoi;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

public class PuzzleWindow implements Observer {

    private HanoiSolver game;
    private Window window;
    private Shape left;
    private Shape center;
    private Shape right;

    private static final int DISK_GAP = 12;
    private static final int DISK_HEIGHT = 8;
    private static final int WIDTH_FACTOR = 15;

    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);

        window = new Window("Tower of Hanoi");
        window.setSize(600, 500);

        int windowWidth = window.getWidth();
        int windowHeight = window.getHeight();

        // Create the poles
        left = new Shape(windowWidth / 4, windowHeight / 4, 5, windowHeight
            / 2);
        center = new Shape(windowWidth / 2, windowHeight / 4, 5, windowHeight
            / 2);
        right = new Shape(3 * windowWidth / 4, windowHeight / 4, 5, windowHeight
            / 2);

        window.addShape(left);
        window.addShape(center);
        window.addShape(right);

        // Create the disks on LEFT tower
        for (int i = game.disks(); i >= 1; i--) {
            Disk disk = new Disk(i * WIDTH_FACTOR);

            game.getTower(Position.LEFT).push(disk);
            window.addShape(disk);
            window.moveToFront(disk);
            moveDisk(Position.LEFT);

        }

        // Add Solve button
        Button solve = new Button("Solve");
        solve.onClick(this, "clickedSolve");
        window.addButton(solve, WindowSide.SOUTH);
    }


    public void moveDisk(Position position) {

        Tower tower = game.getTower(position);
        Disk currentDisk = tower.peek();
        Shape currentPole;

        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.CENTER) {
            currentPole = center;
        }
        else {
            currentPole = right;
        }

        int x = (int)currentPole.getX() - (currentDisk.getWidth() / 2)
            + (currentPole.getWidth() / 2);

        int y = (int)(currentPole.getY() + currentPole.getHeight() - (tower
            .size() * (DISK_HEIGHT + DISK_GAP)));

        currentDisk.moveTo(x, y);
    }


    public void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
            // ignore
        }
    }


    public void clickedSolve(Button button) {
        new Thread(() -> game.solve()).start();
    }


    @Override
    public void update(Observable o, Object arg) {

        if (arg instanceof Position) {
            moveDisk((Position)arg);
            sleep();
        }
    }
}
