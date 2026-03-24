package towerofhanoi;

import student.TestCase;

public class HanoiSolverTest extends TestCase {

    private HanoiSolver solver;

    public void setUp() {
        solver = new HanoiSolver(3);
    }


    public void testDisks() {
        assertTrue(solver.disks() == 3);
    }


    public void testGetTowerLeft() {
        assertNotNull(solver.getTower(Position.LEFT));
        assertEquals(Position.LEFT, solver.getTower(Position.LEFT).position());
    }


    public void testGetTowerCenter() {
        assertNotNull(solver.getTower(Position.CENTER));
        assertEquals(Position.CENTER, solver.getTower(Position.CENTER)
            .position());
    }


    public void testGetTowerRight() {
        assertNotNull(solver.getTower(Position.RIGHT));
        assertEquals(Position.RIGHT, solver.getTower(Position.RIGHT)
            .position());
    }


    public void testGetTowerDefault() {
        assertEquals(solver.getTower(Position.CENTER), solver.getTower(
            Position.DEFAULT));
    }


    public void testToStringInitially() {
        assertEquals("[][][]", solver.toString());
    }


    public void testToStringAfterPush() {
        solver.getTower(Position.LEFT).push(new Disk(30));
        solver.getTower(Position.LEFT).push(new Disk(15));
        solver.getTower(Position.CENTER).push(new Disk(45));

        assertEquals("[15, 30][45][]", solver.toString());
    }


    public void testMove() {
        Tower left = solver.getTower(Position.LEFT);
        Tower right = solver.getTower(Position.RIGHT);

        Disk disk = new Disk(15);
        left.push(disk);

        solver.move(left, right);

        assertTrue(left.isEmpty());
        assertEquals(disk, right.peek());
    }


    public void testSolveOneDisk() {
        HanoiSolver oneDisk = new HanoiSolver(1);
        oneDisk.getTower(Position.LEFT).push(new Disk(15));

        oneDisk.solve();

        assertTrue(oneDisk.getTower(Position.LEFT).isEmpty());
        assertTrue(oneDisk.getTower(Position.RIGHT).size() == 1);
    }


    public void testSolveThreeDisks() {
        HanoiSolver game = new HanoiSolver(3);
        game.getTower(Position.LEFT).push(new Disk(45));
        game.getTower(Position.LEFT).push(new Disk(30));
        game.getTower(Position.LEFT).push(new Disk(15));

        game.solve();

        assertTrue(game.getTower(Position.LEFT).isEmpty());
        assertTrue(game.getTower(Position.CENTER).isEmpty());
        assertTrue(game.getTower(Position.RIGHT).size() == 3);
    }
}
