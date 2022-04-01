package itmo.organization;

import itmo.iowork.Printable;
import itmo.iowork.Scannable;
import itmo.constructors.Constructor;

import java.io.IOException;

/**
 * Factory for organizations {@link Organization}
 * @author Gabriela Ticu
 */
public class OrganizationFactory implements Constructor {
    Printable printable;
    Scannable scannable;

    /**
     * @param printable
     * @param scannable
     */
    public OrganizationFactory(Printable printable, Scannable scannable) {
        this.printable = printable;
        this.scannable = scannable;
    }

    /**
     * @return Object using console
     * @throws Exception
     */
    public Object askConstruct() throws Exception {
        String name = setName();
        Coordinates coordinates = setCoordinates();
        long annualTurnover = setAnnualTurnover();
        Organization.OrganizationType organizationType = setOrganizationType();
        Address address = setAddress();
        return new Organization(name, coordinates, annualTurnover, organizationType, address);
    }

    /**
     * @return Object read from the file
     * @throws Exception
     */
    public Object scanConstruct() throws Exception {
        String name = scannable.scanLine();
        float x = scannable.scanFloat();
        int y = scannable.scanInt();
        Coordinates coordinates = new Coordinates(x, y);
        long annualTurnover = scannable.scanLong();
        Organization.OrganizationType organizationType = scanOrganizationType();
        Address address = new Address(scannable.scanLine());
        return new Organization(name, coordinates, annualTurnover, organizationType, address);
    }

    /**
     * @return name of Organization
     * @throws IOException
     */
    private String setName() throws IOException {
        String name = null;
        while(name == null) {
            printable.print("Enter the name of itmo.organization: ");
            name = scannable.scanLine();
        }
        return name;
    }

    /**
     * @return coordinates {@link Coordinates}
     * @throws IOException
     */
    private Coordinates setCoordinates() throws IOException {
        float xCoordinate = -893;
        while (xCoordinate <= -893) {
            printable.print("Enter the x coordinate: ");
            xCoordinate = scannable.scanFloat();
        }
        printable.print("Enter the y coordinate: ");
        int yCoordinate = scannable.scanInt();
        return new Coordinates(xCoordinate, yCoordinate);
    }

    /**
     * @return annual turnover
     * @throws IOException
     */
    private long setAnnualTurnover() throws IOException {
        long annualTurnover = 0;
        while (annualTurnover <= 0) {
            printable.print("Enter the annual turnover: ");
            annualTurnover = scannable.scanLong();
        }
        return annualTurnover;
    }

    /**
     * @return itmo.organization type from the console
     * @throws IOException
     */
    private Organization.OrganizationType setOrganizationType() throws IOException {
        printable.print("Enter the itmo.organization type (PUBLIC/PRIVATE LIMITED COMPANY/OPEN JOINT STOCK COMPANY): ");
        String inputType = scannable.scanLine().toUpperCase();
        while (inputType.equals(""))
            inputType = scannable.scanLine().toUpperCase();

        switch (inputType) {
            case "PUBLIC":
                return Organization.OrganizationType.PUBLIC;
            case "PRIVATE LIMITED COMPANY" :
                return Organization.OrganizationType.PRIVATE_LIMITED_COMPANY;
            case "OPEN JOINT STOCK COMPANY":
                return Organization.OrganizationType.OPEN_JOINT_STOCK_COMPANY;
            default:
                return setOrganizationType();
        }
    }

    /**
     * @return itmo.organization type from the file
     * @throws IOException
     */
    private Organization.OrganizationType scanOrganizationType() throws IOException {
        String inputType = scannable.scanLine().toUpperCase();
        while (inputType.equals(""))
            inputType = scannable.scanLine().toUpperCase();

        switch (inputType) {
            case "PUBLIC":
                return Organization.OrganizationType.PUBLIC;
            case "PRIVATE LIMITED COMPANY" :
                return Organization.OrganizationType.PRIVATE_LIMITED_COMPANY;
            case "OPEN JOINT STOCK COMPANY":
                return Organization.OrganizationType.OPEN_JOINT_STOCK_COMPANY;
            default:
                return scanOrganizationType();
        }
    }

    /**
     * @return address {@link Address}
     * @throws IOException
     */
    private Address setAddress() throws IOException {
        String zipcode = null;
        while (zipcode == null || zipcode.length() < 4) {
            printable.print("Enter the zipcode: ");
            zipcode = scannable.scanLine();
        }
        return new Address(zipcode);
    }
}
