package application;

import modules.cinema.Filme;
import modules.cinema.Sala;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner l;
    private boolean execute;


    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        l = new Scanner(System.in);
        execute = true;
        List<Filme> filmes = new ArrayList<>();
        Filme filme1 = new Filme("1", "As Branquelas", 2019, "Ronaldo Fenomeno", "Michael Jackson");
        Filme filme2 = new Filme("2", "A volta dos que não foram", 2017, "Ronaldinho Gaúcho", "Jackson Michael");
        Filme filme3 = new Filme("3", "Harry Potter", 2016, "Pelé", "Silvestre Stalone");
        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);

        List<Sala> salas = new ArrayList<>();
        Sala sala1 = new Sala("1001", "Sala 1", 100, "VARIADOS", "SIM", "9999-9999");
        salas.add(sala1);

        System.out.println("BEM VINDO AO CADASTRO DE USUÁRIOS");

        while (execute) {
            String opcao = menu();

            if (opcao.equalsIgnoreCase("1")) {
                String opcao2 = subMenuFilmes();
                if(opcao2.equalsIgnoreCase("1")){
                    cadastrarFilme(filmes);
                }else if(opcao2.equalsIgnoreCase("2")){
                    System.out.println("Informe o código do filme que será alterado: ");
                    Filme f = findOneFilme(filmes, l.nextLine());
                    if(f == null){
                        System.out.println("Filme não encontrado");
                    }else{
                        alterarFilme(f);
                        System.out.printf("Filme Alterado com sucesso ! ");
                    }

                }else if(opcao2.equalsIgnoreCase("3")){
                    System.out.println("Informe o código do filme que será excluído: ");
                    Filme f = findOneFilme(filmes, l.nextLine());
                    if(f == null){
                        System.out.println("Filme não encontrado");
                    }else{
                        deletarFilme(filmes, f);
                        System.out.println("Filme deletado com sucesso");
                    }

                }else if(opcao2.equalsIgnoreCase("4")){
                    System.out.println("Informe o código do filme que será exibido: ");
                    Filme f = findOneFilme(filmes, l.nextLine());
                    if(f == null){
                        System.out.println("Filme não encontrado");
                    }else{
                        System.out.println(f.toString());
                    }

                }else if(opcao2.equalsIgnoreCase("5")){
                    listarCadastros(filmes);
                }
            } else if (opcao.equalsIgnoreCase("2")) {
                String opcao3 = subMenuSalas();
                if(opcao3.equalsIgnoreCase("1")){
                    cadastrarSala(salas);
                }else if(opcao3.equalsIgnoreCase("2")){
                    System.out.println("Informe o código do filme que adicionado na sala: ");
                    Filme f = findOneFilme(filmes, l.nextLine());
                    if(f == null){
                        System.out.println("Filme não encontrado\n");

                    }
                    System.out.println("Informe a código da sala ");
                    Sala sala = findOneSala(salas, l.nextLine());
                    if(sala == null){
                        System.out.printf("Sala não encontrada\n");

                    }else{
                        sala.adicionarFilme(f);
                    }

//                    cadastrarFilmeNaSala()
                }
                else if(opcao3.equalsIgnoreCase("3")){
                    System.out.println("Informe a código da sala ");
                    Sala sala = findOneSala(salas, l.nextLine());
                    if(sala == null){
                        System.out.printf("Sala não encontrada\n");
                    }else{
                        alterarSala(sala);
                    }
//                    alterarSala()
                }else if(opcao3.equalsIgnoreCase("4")){
//                    alterarFilmeNaSala()
                }
                else if(opcao3.equalsIgnoreCase("5")){
                    System.out.println("Informe a código da sala ");
                    Sala sala = findOneSala(salas, l.nextLine());
                    if(sala == null){
                        System.out.printf("Sala não encontrada\n");
                    }else{
                        deletarSala(salas,sala);
                    }

//                    Exclui sala
                }
                else if(opcao3.equalsIgnoreCase("6")){
//                    Exclui filme na sala
                }
                else if(opcao3.equalsIgnoreCase("7")){
                    System.out.println("Informe a código da sala ");
                    Sala sala = findOneSala(salas, l.nextLine());
                    if(sala == null){
                        System.out.printf("Sala não encontrada\n");
                    }else{
                        System.out.println(sala.toString());
                    }
//                    Listar uma sala e seus filmes
                }
                else if(opcao3.equalsIgnoreCase("8")){
                    listarSalasCadastradas(salas);
//                    LISTAR TODOS AS SALAS E SEUS FILMES
                }
                else if(opcao3.equalsIgnoreCase("9")){
//                    Cadastrar todos os filmes na sala
                }
            } else if (opcao.equalsIgnoreCase("3")) {
                execute = false;
            } else {
                System.out.println("\nOpção Inválida seu noob !!! \n");
            }
        }
    }

    private Sala findOneSala(List<Sala> salas, String codigo) {
        return salas.stream().filter((s)-> s.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    private void cadastrarSala(List<Sala> salas) {
        Sala sala = new Sala();
        System.out.println("Código: ");
        sala.setCodigo(l.nextLine());
        System.out.println("Nome: ");
        sala.setNome(l.nextLine());
        System.out.println("Capacidade: ");
        sala.setCapacidade(Integer.valueOf(l.nextLine()));
        System.out.println("Tipo de Exibicao:");
        sala.setTipoDeExibicao(l.nextLine());
        System.out.println("Acessível");
        sala.setAcessivel(l.nextLine());
        System.out.println("Telefone:");
        sala.setTelefoneSala(l.nextLine());
        salas.add(sala);

    }

    private void deletarFilme(List<Filme> filmes , Filme f) {
        filmes.remove(f);
    }
    private void deletarSala(List<Sala> salas , Sala sala) {
        salas.remove(sala);
    }

    private String menu() {
        System.out.println("Selecione a opção:");
        System.out.println("1 - Submenu de Filmes  ");
        System.out.println("2 - Submenu de Salas" );
        System.out.println("3 - Sair");
        return l.nextLine();
    }

    private String subMenuFilmes(){
        System.out.println("1 - CADASTRAR UM FILME ");
        System.out.println("2 - ALTERAR UM FILME ");
        System.out.println("3 - EXCLUIR FILME ");
        System.out.println("4 - LISTAR UM FILME ");
        System.out.println("5 - LISTAR TODOS OS FILMES ");
        System.out.println("6 - Sair");
        return l.nextLine();

    }
    private String subMenuSalas(){
        System.out.println("1 - CADASTRAR UMA SALA ");
        System.out.println("2 - CADASTRAR UM FILME NA SALA: ");
        System.out.println("3 - ALTERAR UMA SALA ");
        System.out.println("4 - ALTERAR UM FILME DA SALA ");
        System.out.println("5 - EXCLUIR UMA SALA ");
        System.out.println("6 - EXCLUIR UM FILME DA SALA ");
        System.out.println("7 - LISTAR UMA SALA E SEUS FILMES");
        System.out.println("8 - LISTAR TODOS AS SALAS E SEUS FILMES");
        System.out.println("9 - SAIR");
        return l.nextLine();

    }

    private void cadastrarFilme(List<Filme> filmes) {
        Filme filme = new Filme();
        System.out.println("Código: ");
        filme.setCodigo(l.nextLine());
        System.out.println("Nome: ");
        filme.setNome(l.nextLine());
        System.out.println("Ano Lançamento: ");
        filme.setAnoLancamento(Integer.valueOf(l.nextLine()));
        System.out.println("Diretor");
        filme.setDiretor(l.nextLine());
        System.out.println("Ator");
        filme.setAtor(l.nextLine());
        System.out.println(filme.toString());
        filmes.add(filme);

    }

    private Filme findOneFilme(List<Filme> filmes, String codigo){
        return filmes.stream().filter((f)-> f.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    private void alterarFilme(Filme filme) {
        System.out.println("Nome: ");
        filme.setNome(l.nextLine());
        System.out.println("Ano Lançamento: ");
        filme.setAnoLancamento(Integer.valueOf(l.nextLine()));
        System.out.println("Diretor");
        filme.setDiretor(l.nextLine());
        System.out.println("Ator");
        filme.setAtor(l.nextLine());


    }

    private void alterarSala(Sala sala) {
        System.out.println("Nome: ");
        sala.setNome(l.nextLine());
        System.out.println("Capacidade: ");
        sala.setCapacidade(Integer.valueOf(l.nextLine()));
        System.out.println("Tipo de Exibicao");
        sala.setTipoDeExibicao(l.nextLine());
        System.out.println("Acessível");
        sala.setAcessivel(l.nextLine());
        System.out.println("Telefone Sala");
        sala.setTelefoneSala(l.nextLine());


    }


    private void listarCadastros(List<Filme> filmeList) {
        if(filmeList.size() != 0 && !filmeList.isEmpty()){
            filmeList.forEach(f-> System.out.println(f.toString()));
        }else{
            System.out.println("Não existe filmes cadastrados !");
        }

    }

    private void listarSalasCadastradas(List<Sala> salasList) {
        if(salasList.size() != 0 && !salasList.isEmpty()){
            salasList.forEach(s-> System.out.println(s.toString()));
        }else{
            System.out.println("Não existe salas cadastrados !");
        }

    }

    private String textInput(String label) {
        return l.nextLine();
    }
}