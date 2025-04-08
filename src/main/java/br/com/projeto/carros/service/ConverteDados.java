package br.com.projeto.carros.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public class ConverteDados implements IConverteDados{
        private ObjectMapper mapper = new ObjectMapper();

        public <T> List<T> obterLista(String json, Class<T> classe) {
            try {
                return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, classe));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public <T> T obterDados(String json, Class<T> classe) {
            try {
                return mapper.readValue(json, classe);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }

