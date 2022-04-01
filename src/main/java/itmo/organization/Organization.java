package itmo.organization;

import itmo.exceptions.WrongInputException;
import itmo.idobjects.IdObject;

import java.time.LocalDate;

/**
 * Organization class
 * @author Gabriela Ticu
 */
public class Organization implements IdObject, Comparable<IdObject> {
    /**
     * id
     */
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    /**
     * name
     */
    private String name; //Поле не может быть null, Строка не может быть пустой
    /**
     * coordinates {@link Coordinates}
     */
    private Coordinates coordinates; //Поле не может быть null
    /**
     * creation date
     */
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    /**
     * annual turnover
     */
    private long annualTurnover; //Значение поля должно быть больше 0
    /**
     * itmo.organization type {@link OrganizationType}
     */
    private OrganizationType type; //Поле может быть null
    /**
     * postal address {@link Address}
     */
    private Address postalAddress; //Поле не может быть null

    /**
     * @param name
     * @param coordinates
     * @param annualTurnover
     * @param type
     * @param postalAddress
     */
    public Organization(String name, Coordinates coordinates, long annualTurnover, OrganizationType type, Address postalAddress) {
        id = (int) (Math.random()*2000000000);
        if (name == null || name.isEmpty()) throw new WrongInputException("Wrong name of itmo.organization");
        this.name = name;
        if (coordinates == null) throw new WrongInputException("Null coordinates");
        this.coordinates = coordinates;
        creationDate = LocalDate.now();
        if (annualTurnover <= 0) throw new WrongInputException("Annual turnover should be bigger than 0");
        this.annualTurnover = annualTurnover;
        if (type == null) throw new WrongInputException("Organization type may not be null");
        this.type = type;
        if (postalAddress == null) throw new WrongInputException("Postal address may not be null");
        this.postalAddress = postalAddress;
    }

    /**
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Organization type enums
     */
    public enum OrganizationType {
        PUBLIC,
        PRIVATE_LIMITED_COMPANY,
        OPEN_JOINT_STOCK_COMPANY;
    }

    /**
     * @param newId
     */
    public void setId(int newId) {
        this.id = newId;
    }

    /**
     * @return string
     */
    public String toString() {
        return this.id + ": " + this.name + ", postal address: " + this.postalAddress;
    }

    /**
     * @param o
     * @return 0 if equals; negative number if smaller than o; positive number if bigger
     */
    @Override
    public int compareTo(IdObject o) {
        if (this == o) {
            return 0;
        }
        if (o == null) {
            return 1;
        }
        return this.getId()-o.getId();
    }

    /**
     * @return annual turnover
     */
    public long getAnnualTurnover() {
        return annualTurnover;
    }
}


