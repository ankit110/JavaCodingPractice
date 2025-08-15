package collections.list;


public class Cricketer implements Comparable<Cricketer> {

    int runs;
    String name;

    public Cricketer(String name, int runs) {
        this.name = name;
        this.runs = runs;
    }

    @Override
    public String toString() {
        return name + " " + runs;
    }

    // compareTo takes an argument of the same type of the class
    // compareTo returns -1 if this < that
    // 1 if this > that
    // 0 if this = that
    @Override
    public int compareTo(Cricketer cricketer) {

        if(this.runs < cricketer.runs) {
            return -1;
        }
        if (this.runs > cricketer.runs) {
            return 1;
        }
        return 0;
    }
}
