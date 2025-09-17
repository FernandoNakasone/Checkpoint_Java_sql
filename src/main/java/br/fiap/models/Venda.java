package br.fiap.models;

public class Venda {
    private long id;
    private String vendedor;
    private double valor;

    @Override
    public String toString() {
        return String.format("ID: %d | Vendedor: %s | Valor: R$%.2f",id,vendedor,valor);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
}
