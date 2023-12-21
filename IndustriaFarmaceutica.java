public interface IndustriaFarmaceutica {
    String nome = "";

    public default String getNome() {
        return nome;
    }

    public default void setNome(String nome) {

    }

    public default void criarMedicamento(){

    }
    public default void indicarNomeMedicamento(){

    }
    public default void confirmarCriacao(){

    }
    public default void cancelarCriacao(){

    }
    public default void consultarMedicamento(){

    }

    @Override
    public String toString();
}
