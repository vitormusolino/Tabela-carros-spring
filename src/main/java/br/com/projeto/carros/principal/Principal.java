package br.com.projeto.carros.principal;

import br.com.projeto.carros.model.AnosVeiculos;
import br.com.projeto.carros.model.DadosVeiculos;
import br.com.projeto.carros.model.ModelosResponse;
import br.com.projeto.carros.model.Veiculo;
import br.com.projeto.carros.service.ConsumoApi;
import br.com.projeto.carros.service.ConverteDados;

import java.util.List;
import java.util.Optional;
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
        json = consumo.obterDados(ENDERECO + opcao + "/marcas/" + indiceMarca + "/modelos");
        ModelosResponse response = conversor.obterDados(json, ModelosResponse.class);
        List<DadosVeiculos> dadosMarcas = response.getModelos();
        dadosMarcas.forEach(System.out::println);


        System.out.println("Digite carro que deseja consultar: ");
        var trechoTitulo = leitura.nextLine();
        List<DadosVeiculos> carroBuscado =  dadosMarcas.stream()
                .filter(e -> e.nome().toUpperCase().contains(trechoTitulo.toUpperCase()))
                .toList();
        if(!carroBuscado.isEmpty()){
            System.out.println("Carros encontrados: ");
            carroBuscado.forEach(System.out::println);
        }else{
            System.out.println("Carro não encontrado");
        }

        System.out.println("Código do carro que deseja consultar opções: ");
        var codigoCarro = leitura.nextInt();
        leitura.nextLine();

        json = consumo.obterDados(ENDERECO + opcao + "/marcas/" + indiceMarca + "/modelos/" + codigoCarro + "/anos");
        System.out.println(json);
//        AnosVeiculos anos = conversor.obterDados(json, AnosVeiculos.class);
//        List<DadosVeiculos> anosCarros = anos.getAnosCarros();
//        anosCarros.forEach(System.out::println);

    }
}
