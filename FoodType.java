public class FoodType {
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public FoodType(String type) {
        this.type = type;
    }
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