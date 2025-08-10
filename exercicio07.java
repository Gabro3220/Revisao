public class Veiculo {
    protected String marca;
    protected String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Veículo - Marca: " + marca + ", Modelo: " + modelo;
    }
}

public class Carro extends Veiculo {
    private int numeroDePortas;

    public Carro(String marca, String modelo, int numeroDePortas) {
        super(marca, modelo);
        this.numeroDePortas = numeroDePortas;
    }

    @Override
    public String toString() {
        return "Carro - Marca: " + marca + ", Modelo: " + modelo + ", Portas: " + numeroDePortas;
    }
}

public class Moto extends Veiculo {
    private int cilindradas;

    public Moto(String marca, String modelo, int cilindradas) {
        super(marca, modelo);
        this.cilindradas = cilindradas;
    }

    @Override
    public String toString() {
        return "Moto - Marca: " + marca + ", Modelo: " + modelo + ", Cilindradas: " + cilindradas;
    }
} 