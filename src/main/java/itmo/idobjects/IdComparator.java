package itmo.idobjects;

import java.util.Comparator;

/**
 * Comparator by id
 * @author Gabriela Ticu
 */
public class IdComparator implements Comparator<IdObject> {

    /**
     * @param o1
     * @param o2
     * @return 0 if equals; negative number if o1 is smaller; positive if o1 is bigger
     */
    @Override
    public int compare(IdObject o1, IdObject o2) {
        if (o1 == o2) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.getId()-o2.getId();
    }
}
