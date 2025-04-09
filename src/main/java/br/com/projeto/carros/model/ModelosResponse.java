package br.com.projeto.carros.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ModelosResponse {
    private List<DadosVeiculos> modelos;

    public List<DadosVeiculos> getModelos() {
        return modelos;
    }

    public void setModelos(List<DadosVeiculos> modelos) {
        this.modelos = modelos;
    }
}
