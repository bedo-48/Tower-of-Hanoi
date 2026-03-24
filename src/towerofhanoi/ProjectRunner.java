package towerofhanoi;

public class ProjectRunner {

    public static void main(String[] args) {

        int disks = 5;

        if (args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }

        HanoiSolver game = new HanoiSolver(disks);
        new PuzzleWindow(game);
    }

}
