package projeto.ufpb.dcx;

import java.io.Serializable;

public class Carro implements Serializable {

    private String marca;
    private String numeroCrv;
    private String modelo;
    private float precoFixo;

    public Carro(){

    }

    public Carro(String marca, String numeroCrv, String modelo, float precoFixo){
        this.marca = marca;
        this.numeroCrv = numeroCrv;
        this.modelo = modelo;
        this.precoFixo = precoFixo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroCrv() {
        return numeroCrv;
    }

    public void setNumeroCrv(String numeroCrv) {
        this.numeroCrv = numeroCrv;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecoFixo() {
        return precoFixo;
    }

    public void setPrecoFixo(float precoFixo) {
        this.precoFixo = precoFixo;
    }

    public String toString() {
        return "Marca Carro: " + this.marca + "\nNúmero do CRV: " + this.numeroCrv +
                "\nModelo do Carro: " + this.modelo + "\nPreço do Carro: " + this.precoFixo;
    }
}
