package towerofhanoi;

import student.TestCase;

public class DiskTest extends TestCase {

    private Disk small;
    private Disk medium;
    private Disk sameAsSmall;

    public void setUp() {
        small = new Disk(10);
        medium = new Disk(20);
        sameAsSmall = new Disk(10);
    }


    public void testCompareToSmaller() {
        assertTrue(small.compareTo(medium) < 0);
    }


    public void testCompareToLarger() {
        assertTrue(medium.compareTo(small) > 0);
    }


    public void testCompareToEqual() {
        assertTrue(small.compareTo(sameAsSmall) == 0);
    }


    public void testCompareToNull() {
        Exception e = null;
        try {
            small.compareTo(null);
        }
        catch (IllegalArgumentException ex) {
            e = ex;
        }
        assertNotNull(e);
    }


    public void testToString() {
        assertEquals("10", small.toString());
    }


    public void testEqualsSameWidth() {
        assertTrue(small.equals(sameAsSmall));
    }


    public void testEqualsDifferentWidth() {
        assertFalse(small.equals(medium));
    }


    public void testEqualsNull() {
        assertFalse(small.equals(null));
    }


    public void testEqualsDifferentType() {
        assertFalse(small.equals("hello"));
    }
}
