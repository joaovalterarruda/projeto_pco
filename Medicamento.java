/**
 * The type Medicamento.
 */
public class Medicamento {
    private String name;
    private String form;
    private String dosage;
    private String laboratory;
    private String substances;

    /**
     * Instantiates a new Medicamento.
     *
     * @param name       the name
     * @param form       the form
     * @param dosage     the dosage
     * @param laboratory the laboratory
     * @param substances the substances
     */
    public Medicamento(String name, String form, String dosage, String laboratory, String substances) {
        this.name = name;
        this.form = form;
        this.dosage = dosage;
        this.laboratory = laboratory;
        this.substances = substances;
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
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets form.
     *
     * @return the form
     */
    public String getForm() {
        return form;
    }

    /**
     * Sets form.
     *
     * @param form the form
     */
    public void setForm(String form) {
        this.form = form;
    }

    /**
     * Gets dosage.
     *
     * @return the dosage
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * Sets dosage.
     *
     * @param dosage the dosage
     */
    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    /**
     * Gets laboratory.
     *
     * @return the laboratory
     */
    public String getLaboratory() {
        return laboratory;
    }

    /**
     * Sets laboratory.
     *
     * @param laboratory the laboratory
     */
    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    /**
     * Gets substances.
     *
     * @return the substances
     */
    public String getSubstances() {
        return substances;
    }

    /**
     * Sets substances.
     *
     * @param substances the substances
     */
    public void setSubstances(String substances) {
        this.substances = substances;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "name='" + name + '\'' +
                ", form='" + form + '\'' +
                ", dosage='" + dosage + '\'' +
                ", laboratory='" + laboratory + '\'' +
                ", substances='" + substances + '\'' +
                '}';
    }
}


