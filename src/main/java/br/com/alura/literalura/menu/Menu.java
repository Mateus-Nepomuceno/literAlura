package br.com.alura.literalura.menu;

import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.DadosLivro;
import br.com.alura.literalura.model.DadosResultados;
import br.com.alura.literalura.model.Livro;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.service.ConsumoApi;
import br.com.alura.literalura.service.ConverteDados;
import java.util.Optional;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados converte = new ConverteDados();
    private final String URL_BASE = "https://gutendex.com/books/";
    private AutorRepository repositorio;
    private String json;

    public Menu(AutorRepository repositorio) {
        this.repositorio = repositorio;
    }

    private void mostrarMenu(){
        System.out.println("""
                ================================================
                |                 LiterAlura                   |
                ================================================
                | 1 - Buscar livro pelo título                 |
                | 2 - Listar livros registrados                |
                | 3 - Listar autores registrados               |
                | 4 - Listar autores vivos em determinado ano  |
                | 5 - Listar livros em um determinado idioma   |
                ================================================
                | 0 - Sair                                     |
                ================================================""");
        System.out.print("Escolha o número da opção desejada: ");
    }

    public void iniciar() {
        int opcao = -1;
        while (opcao != 0) {
            mostrarMenu();
            try {
                opcao = Integer.parseInt(this.sc.nextLine());
                switch (opcao) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        buscarLivroPorTitulo();
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("Digite apenas números.");
            }
        }
    }

    private void buscarLivroPorTitulo() {
        System.out.print("Digite o título do livro: ");
        String titulo = this.sc.nextLine();
        this.json = consumo.obterDados(URL_BASE+"?search="+titulo.replace(" ","+"));
        Optional<DadosLivro> livroBuscado = pegaDadosLivro(titulo);
        if (livroBuscado.isPresent()){
            DadosLivro livroEncontrado = livroBuscado.get();
            Livro livro = new Livro(livroEncontrado);
            Autor autor = new Autor(livroEncontrado.autores().get(0));
            autor.setLivros(livro);
            System.out.println(livro);
            repositorio.save(autor);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private Optional<DadosLivro> pegaDadosLivro(String titulo) {
        DadosResultados resultados = converte.converteDados(this.json, DadosResultados.class);
        return resultados.livros().stream()
                .filter(l -> l.titulo().toLowerCase().contains(titulo.toLowerCase()))
                .findFirst();
    }
}
