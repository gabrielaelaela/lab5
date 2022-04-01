package itmo.organization;

import itmo.exceptions.WrongInputException;

/**
 * Coordinate of the Organization {@link Organization}
 * @author Gabriela Ticu
 */
public class Coordinates {
    /**
     * x coordinate
     */
    private Float x; //Значение поля должно быть больше -893, Поле не может быть null
    /**
     * y coordinate
     */
    private double y;

    /**
     * @param x
     * @param y
     */
    public Coordinates(Float x, double y) {
        if (x == null || (x <= -893)) {
            throw new WrongInputException("Wrong x coordinate. The value may not be null and should be bigger then -893");
        }

        this.x = x;
        this.y = y;
    }
}
