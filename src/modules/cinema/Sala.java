package modules.cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Sala {
    private String codigo;
    private String nome;
    private Integer capacidade;
    private String tipoDeExibicao;
    private String acessivel;
    private String telefoneSala;
    private List<Filme> filmes = new ArrayList<>();

    public Sala() {
    }

    public Sala(String codigo, String nome, Integer capacidade, String tipoDeExibicao, String acessivel, String telefoneSala) {
        this.codigo = codigo;
        this.nome = nome;
        this.capacidade = capacidade;
        this.tipoDeExibicao = tipoDeExibicao;
        this.acessivel = acessivel;
        this.telefoneSala = telefoneSala;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipoDeExibicao() {
        return tipoDeExibicao;
    }

    public void setTipoDeExibicao(String tipoDeExibicao) {
        this.tipoDeExibicao = tipoDeExibicao;
    }

    public String getAcessivel() {
        return acessivel;
    }

    public void setAcessivel(String acessivel) {
        this.acessivel = acessivel;
    }

    public String getTelefoneSala() {
        return telefoneSala;
    }

    public void setTelefoneSala(String telefoneSala) {
        this.telefoneSala = telefoneSala;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }


    private Filme findFilmeByCod(String codigo){
        return filmes.stream().filter((f)-> f.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public void adicionarFilme(Filme filme){
        try{
            if(findFilmeByCod(filme.getCodigo()) == null){
                this.filmes.add(filme);
                System.out.println("Adicionado com Sucesso! ");
            }else{
                System.out.println("Filme já existente");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void updateFilme(Filme filme){
        try{
            Filme newFilme = findFilmeByCod(filme.getCodigo());
            if(newFilme != null){
                newFilme.setNome(filme.getNome());
                newFilme.setAtor(filme.getAtor());
                newFilme.setAnoLancamento(filme.getAnoLancamento());
                newFilme.setDiretor(filme.getDiretor());
                System.out.println("Filme alterado com sucesso !");
            }else{
                System.out.println("Filme não encontrado");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void removeFilme(String cod){
        try{
            if(findFilmeByCod(cod) == null){
                System.out.println("Filme não encontrado");
            }else{
                this.filmes.remove(cod);
                System.out.println("Filme removido com sucesso ! ");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void listarTodosFilmes(){
        if(filmes.isEmpty() || filmes.size() == 0){
            System.out.println("Não existe filmes !");
        }else{
            filmes.forEach(filme -> System.out.println(filme.toString()));
        }
    }

    public void listarUm(String cod){
        try{
            validateCod(cod);
            if(findFilmeByCod(cod) != null){
                System.out.println(findFilmeByCod(cod).toString());
            }else{
                System.out.println("Filme não encontrado");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void validateCod(String cod){
        if(cod == null || cod.isEmpty()){
            throw new IllegalArgumentException("Código nulo ou vazio !");
        }
    }
}
