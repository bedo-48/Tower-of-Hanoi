package towerofhanoi;

import java.awt.Color;
import student.TestableRandom;

import cs2.Shape;

public class Disk extends Shape implements Comparable<Disk> {

    public Disk(int width) {

        super(0, 0, width, 20);
        TestableRandom rand = new TestableRandom();

        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);

        setBackgroundColor(new Color(r, g, b));

    }


    @Override
    public int compareTo(Disk otherDisk) {

        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }

        return this.getWidth() - otherDisk.getWidth();
    }


    @Override
    public String toString() {
        return "" + this.getWidth();

    }


    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Disk)) {
            return false;
        }

        Disk other = (Disk)obj;

        return this.getWidth() == other.getWidth();
    }

}
