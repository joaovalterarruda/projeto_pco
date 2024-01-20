/**
 * The type Medicamento.
 */
public class Medicamento {
    private String name;
    private String form;
    private String dosage;
    private String laboratory;
    private String substances;

    public Medicamento(String name, String form, String dosage, String laboratory, String substances) {
        this.name = name;
        this.form = form;
        this.dosage = dosage;
        this.laboratory = laboratory;
        this.substances = substances;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(String laboratory) {
        this.laboratory = laboratory;
    }

    public String getSubstances() {
        return substances;
    }

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


