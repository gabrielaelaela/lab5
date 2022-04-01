package itmo.constructors;

/**
 * Constructors for complex objects
 * @author Gabriela Ticu
 */
public interface Constructor {
    /**
     * @return complex object as Object
     * @throws Exception
     */
    public Object askConstruct() throws Exception;

    /**
     * @return complex object as Object
     * @throws Exception
     */
    public Object scanConstruct() throws Exception;
}
