public class Medicamento {
    public String nome;
    public String formula;
    public int dosagem;
    public String laboratorio;
    public String substancias;

    public Medicamento(String nome, String formula, int dosagem, String laboratorio, String substancias) {
        this.nome = nome;
        this.formula = formula;
        this.dosagem = dosagem;
        this.laboratorio = laboratorio;
        this.substancias = substancias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
        this.dosagem = dosagem;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getSubstancias() {
        return substancias;
    }

    public void setSubstancias(String substancias) {
        this.substancias = substancias;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nome='" + nome + '\'' +
                ", formula='" + formula + '\'' +
                ", dosagem=" + dosagem +
                ", laboratorio='" + laboratorio + '\'' +
                ", substancias='" + substancias + '\'' +
                '}';
    }
}
