package br.com.projeto.carros.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculos (@JsonAlias("nome")String nome,
                             @JsonAlias("codigo")Integer codigo){

}



