package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a")
    List<Autor> buscarAutores();

    @Query("SELECT l FROM Autor a JOIN a.livros l")
    List<Livro> buscarLivros();

    @Query("SELECT a FROM Autor a WHERE (a.anoFalecimento > :ano OR a.anoFalecimento = 0) AND a.anoNascimento <= :ano")
    List<Autor> buscarAutoresVivosPorAno(int ano);

    @Query("SELECT l FROM Autor a JOIN a.livros l WHERE l.idioma ILIKE :idioma")
    List<Livro> buscarLivrosPorIdioma(String idioma);
}
