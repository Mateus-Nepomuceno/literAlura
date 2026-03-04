package br.com.alura.literalura.model;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;
    private List<Livro> livros = new ArrayList<>();

    public Autor() {
    }

    public Autor(DadosAutor autor) {
        this.nome = autor.nome();
        try {
            this.anoNascimento = Integer.valueOf(autor.anoNascimento());
        } catch (NumberFormatException e) {
            this.anoNascimento = 0;
        }
        try {
            this.anoFalecimento = Integer.valueOf(autor.anoFalecimento());
        } catch (NumberFormatException e) {
            this.anoNascimento = 0;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(Livro livro) {
        this.livros.add(livro);
        livro.setAutor(this);
    }

    @Override
    public String toString() {
        return "============== Autor =============" +
                "\nNome: " + nome +
                "\nAno de nascimento: " + anoNascimento +
                "\nAno de falecimento: " + anoFalecimento;
    }
}
