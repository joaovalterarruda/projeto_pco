/**
 * The type Food type.
 */
public class FoodType {
    private String type;

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Instantiates a new Food type.
     *
     * @param type the type
     */
    public FoodType(String type) {
        this.type = type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return "FoodType{" +
                "type='" + type + '\'' +
                '}';
    }

}
