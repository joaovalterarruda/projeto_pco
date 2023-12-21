public class Medicamento {
    public String nome;
    public String formula;
    public int dosagem;

    public Medicamento(String nome, String formula, int dosagem) {
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

    public int getDosagem() {
        return dosagem;
    }

    public void setDosagem(int dosagem) {
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
