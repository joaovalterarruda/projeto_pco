public class Laboratory {
    private String name;
    private String surveillance;

    public Laboratory(String name, String surveillance) {
        this.name = name;
        this.surveillance = surveillance;
    }

    public String getName() {
        return name;
    }

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