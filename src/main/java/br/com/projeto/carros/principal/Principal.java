package br.com.projeto.carros.principal;

import br.com.projeto.carros.model.DadosVeiculos;
import br.com.projeto.carros.model.VeiculoDetalhado;
import br.com.projeto.carros.service.ConsumoApi;
import br.com.projeto.carros.service.ConverteDados;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        var jsonMarcas = consumo.obterDados(ENDERECO + opcao + "/marcas");
        List<DadosVeiculos> marcas = conversor.obterLista(jsonMarcas, DadosVeiculos.class);
        marcas.forEach(System.out::println);

        System.out.println("Escolha o número da marca");
        int indiceMarca = leitura.nextInt();
        leitura.nextLine();
        var jsonModelos = consumo.obterDados(ENDERECO + opcao + "/marcas/" + indiceMarca + "/modelos");
        br.com.projeto.carros.model.ModelosResponse responseModelos = conversor.obterDados(jsonModelos, br.com.projeto.carros.model.ModelosResponse.class);
        List<DadosVeiculos> modelos = responseModelos.getModelos();
        modelos.forEach(System.out::println);


        System.out.println("Digite o modelo que deseja consultar: ");
        var trechoTitulo = leitura.nextLine();
        List<DadosVeiculos> modeloBuscado =  modelos.stream()
                .filter(e -> e.nome().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .toList();
        if(!modeloBuscado.isEmpty()){
            System.out.println("Modelos encontrados: ");
            modeloBuscado.forEach(System.out::println);
        }else{
            System.out.println("Modelo não encontrado");
            return; // Encerra o método se o modelo não for encontrado
        }

        System.out.println("Digite o código do modelo que deseja consultar os anos: ");
        var codigoModelo = leitura.nextInt();
        leitura.nextLine();

        String urlAnosListagem = ENDERECO + opcao + "/marcas/" + indiceMarca + "/modelos/" + codigoModelo + "/anos";
        var jsonAnosListagem = consumo.obterDados(urlAnosListagem);
        List<DadosVeiculos> anosDisponiveis = conversor.obterLista(jsonAnosListagem, DadosVeiculos.class);

        if (!anosDisponiveis.isEmpty()) {
            System.out.println("\nAnos disponíveis para o modelo com código " + codigoModelo + ":");
            anosDisponiveis.forEach(System.out::println);

            System.out.println("Digite o ANO que deseja consultar os detalhes:");
            var anoDigitado = leitura.nextLine();

            // Construindo a URL para buscar os detalhes usando apenas o ano digitado
            String urlDetalhes = ENDERECO + opcao + "/marcas/" + indiceMarca + "/modelos/" + codigoModelo + "/anos/" + anoDigitado;
            var jsonDetalhes = consumo.obterDados(urlDetalhes);
            VeiculoDetalhado detalhes = conversor.obterDados(jsonDetalhes, VeiculoDetalhado.class);

            if (detalhes != null) {
                System.out.println("\nDetalhes do veículo para o ano " + anoDigitado + ":");
                System.out.println(detalhes);
            } else {
                System.out.println("Não foram encontrados detalhes para o ano: " + anoDigitado);
            }

        } else {
            System.out.println("Nenhum ano encontrado para o código: " + codigoModelo);
        }
    }
}