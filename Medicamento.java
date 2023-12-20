public class Medicamento {
    public String nome;
    public String formula;
    public String dosagem;

    public Medicamento(String nome, String formula, String dosagem) {
        this.nome = nome;
        this.formula = formula;
        this.dosagem = dosagem;
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

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nome='" + nome + '\'' +
                ", formula='" + formula + '\'' +
                ", dosagem='" + dosagem + '\'' +
                '}';
    }
}
