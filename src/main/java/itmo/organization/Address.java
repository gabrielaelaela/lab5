package itmo.organization;

import itmo.exceptions.WrongInputException;

/**
 * Addres of Organization {@link Organization}
 * @author Gabriela Ticu
 */
public class Address {
    /**
     * Zip code
     */
    private String zipCode; //Длина строки должна быть не меньше 4, Поле не может быть null

    /**
     * @param zipcode
     */
    public Address(String zipcode) {
        if ((zipcode.equals(null)) || (zipcode.length() < 4)) {
            throw new WrongInputException("Wrong zipcode. Zipcode may not be null or shorter than 4 symbols");
        }
        this.zipCode = zipcode;
    }

    /**
     * @return String
     */
    public String toString() {
        return this.zipCode;
    }
}
