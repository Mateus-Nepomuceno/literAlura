package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;
    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "\n============== Autor =============" +
                "\nNome: " + nome +
                "\nAno de nascimento: " + anoNascimento +
                "\nAno de falecimento: " + anoFalecimento+"\n";
    }
}
