package towerofhanoi;

public class Tower extends LinkedStack<Disk> {

    private Position position;

    public Tower(Position position) {
        super();
        this.position = position;
    }


    public Position position() {
        return position;
    }


    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }

        if (isEmpty() || peek().compareTo(disk) > 0) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
