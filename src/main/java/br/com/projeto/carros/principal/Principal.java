package br.com.projeto.carros.principal;

import br.com.projeto.carros.model.DadosVeiculos;
import br.com.projeto.carros.service.ConsumoApi;
import br.com.projeto.carros.service.ConverteDados;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";


    public void exibeMenu(){
        System.out.println("De qual veículo você deseja ver tabela? \n" +
                "-Carros\n" +
                "-Caminhoes\n" +
                "-Motos");
        var opcao = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + opcao + "/marcas");
        List<DadosVeiculos> dados = conversor.obterLista(json, DadosVeiculos.class);
        dados.forEach(System.out::println);

        System.out.println("Escolha o número da marca");
        int indiceMarca = leitura.nextInt();
        leitura.nextLine();
        json = consumo.obterDados(ENDERECO + opcao + "/marcas" + indiceMarca + "/modelos");
        DadosVeiculos dadosMarca = conversor.obterDados(json, DadosVeiculos.class);
        System.out.println(dadosMarca);
    }
}
