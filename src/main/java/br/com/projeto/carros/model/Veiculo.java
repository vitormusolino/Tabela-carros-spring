package br.com.projeto.carros.model;

public class Veiculo {
    private Integer codigo;
    private String nome;

    public Veiculo(Integer codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
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
