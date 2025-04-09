package br.com.projeto.carros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;


public class Veiculo {
    private Integer codigo;
    private String nome;
    private String marca;
    private Double preco;
    private LocalDate ano;


    public Veiculo(Integer codigo, String nome, String marca, Double preco, LocalDate ano ){
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.preco = preco;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return
                "nome: " + nome +
                        "codigo: " + codigo;
    }
}
