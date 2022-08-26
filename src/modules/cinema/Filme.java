package modules.cinema;

public class Filme {
    private String codigo;
    private String nome;
    private Integer anoLancamento;
    private String diretor;
    private String ator;

    public Filme() {
    }

    public Filme(String codigo, String nome, Integer anoLancamento, String diretor, String ator) {
        this.codigo = codigo;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.diretor = diretor;
        this.ator = ator;
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

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getAtor() {
        return ator;
    }

    public void setAtor(String ator) {
        this.ator = ator;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", diretor='" + diretor + '\'' +
                ", ator='" + ator + '\'' +
                '}';
    }
}
