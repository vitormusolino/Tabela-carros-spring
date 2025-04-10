package br.com.projeto.carros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VeiculoDetalhado {
    @JsonAlias("CodigoFipe")
    private String codigoFipe;
    @JsonAlias("Marca")
    private String marca;
    @JsonAlias("Modelo")
    private String modelo;
    @JsonAlias("AnoModelo")
    private Integer anoModelo;
    @JsonAlias("Combustivel")
    private String combustivel;
    @JsonAlias("Valor")
    private String preco;


    public VeiculoDetalhado() {
    }

    public VeiculoDetalhado(String codigoFipe, String marca, String modelo, Integer anoModelo, String combustivel, String preco, String key, String mesReferencia, Integer id) {
        this.preco = preco;
        this.codigoFipe = codigoFipe;
        this.marca = marca;
        this.modelo = modelo;
        this.anoModelo = anoModelo;
        this.combustivel = combustivel;

    }


    public String getCodigoFipe() {
        return codigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        this.codigoFipe = codigoFipe;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }


    @Override
    public String toString() {
        return  "Preço: " + preco + "\n" +
                "Código Fipe: " + codigoFipe + "\n" +
                "Marca: " + marca + "\n" +
                "Modelo: " + modelo + "\n" +
                "Ano Modelo: " + anoModelo + "\n" +
                "Combustível: " + combustivel + "\n" +

                "----------------------";
    }
}