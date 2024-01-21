/**
 * The type Laboratory.
 */
public class Laboratory {
    private String name;
    private String surveillance;

    /**
     * Instantiates a new Laboratory.
     *
     * @param name         the name
     * @param surveillance the surveillance
     */
    public Laboratory(String name, String surveillance) {
        this.name = name;
        this.surveillance = surveillance;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets surveillance.
     *
     * @return the surveillance
     */
    public String getSurveillance() {
        return surveillance;
    }

    @Override
    public String toString() {
        return "Laboratory{" +
                "name='" + name + '\'' +
                ", surveillance='" + surveillance + '\'' +
                '}';
    }
}
