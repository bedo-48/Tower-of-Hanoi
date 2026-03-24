package towerofhanoi;

import student.TestCase;

public class TowerTest extends TestCase {

    private Tower tower;

    public void setUp() {
        tower = new Tower(Position.LEFT);
    }


    public void testPosition() {
        assertEquals(Position.LEFT, tower.position());
    }


    public void testPushValid() {
        Disk big = new Disk(30);
        Disk small = new Disk(10);

        tower.push(big);
        tower.push(small);

        assertEquals(2, tower.size());
        assertEquals(small, tower.peek());
    }


    public void testPushNull() {
        Exception e = null;
        try {
            tower.push(null);
        }
        catch (IllegalArgumentException ex) {
            e = ex;
        }
        assertNotNull(e);
    }


    public void testPushLargerOntoSmaller() {
        Disk small = new Disk(10);
        Disk big = new Disk(30);

        tower.push(small);

        Exception e = null;
        try {
            tower.push(big);
        }
        catch (IllegalStateException ex) {
            e = ex;
        }
        assertNotNull(e);
    }


    public void testPushSmallerOntoLarger() {
        Disk big = new Disk(30);
        Disk small = new Disk(10);

        tower.push(big);
        tower.push(small);

        assertEquals(small, tower.peek());
    }


    public void testPopInherited() {
        Disk disk = new Disk(10);
        tower.push(disk);

        assertEquals(disk, tower.pop());
        assertTrue(tower.isEmpty());
    }
}
