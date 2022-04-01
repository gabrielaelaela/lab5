package itmo.upgradedcollections;

import itmo.exceptions.WrongClassException;
import itmo.idobjects.IdObject;

import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Priority queue with creation date
 * @param <T>
 * @author Gabriela Ticu
 */
public class UpgradedPriorityQueue<T> extends PriorityQueue<T> implements Queue<T> {
    /**
     * Date
     */
    private java.time.LocalDate creationDate;

    /**
     * Default constructor
     */
    public UpgradedPriorityQueue() {
        super();
        creationDate = LocalDate.now();
    }

    /**
     * @return date
     */
    public java.time.LocalDate getCreationDate() {
        return this.creationDate;
    }

    /**
     * @param id
     * @return id object
     * @throws WrongClassException
     */
    public IdObject getElementById(int id) throws WrongClassException {
        if (!(element() instanceof IdObject)) throw new WrongClassException("You do not have the id in the objects in this collection");
        for (T priorityQueueObject: this) {
            IdObject idObject = (IdObject) priorityQueueObject;
            if (idObject.getId() == id) return idObject;
        }
        return null;
    }
}
