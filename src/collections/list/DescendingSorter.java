package collections.list;

import java.util.Comparator;

public class DescendingSorter implements Comparator<Cricketer> {

    // compareTo returns -1 if cricketer1 < cricketer2
    // 1 if cricketer1 > cricketer2
    // 0 if cricketer1 = cricketer2

    // Since we want to sort in descending order,
    // we should return -1 when runs are more

    @Override
    public int compare(Cricketer o1, Cricketer o2) {
        if(o1.runs > o2.runs) {
            return -1;
        } if(o1.runs < o2.runs) {
            return 1;
        }
        return 0;
    }
}
