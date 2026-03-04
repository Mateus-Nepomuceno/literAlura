package br.com.alura.literalura.model;

public class Livro {
    private String titulo;
    private Autor autor;
    private String idioma;
    private Integer downloads;

    public Livro() {
    }

    public Livro(DadosLivro livro) {
        this.titulo = livro.titulo();
        this.idioma = livro.idiomas().get(0);
        this.downloads = livro.downloads();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return  "============== Livro =============" +
                "\nTítulo: " + titulo +
                "\nAutor: " + autor.getNome() +
                "\nIdioma: " + idioma +
                "\nDownloads: " + downloads;
    }
}