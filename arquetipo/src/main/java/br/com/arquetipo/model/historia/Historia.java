package br.com.arquetipo.model.historia;

import br.com.arquetipo.model.servicos.Avaliacao;
import br.com.arquetipo.model.u.Escritor;

public class Historia {

    private int id;
    private Escritor escritor;
    private String titulo;
    private Avaliacao avaliacao;
    private double media;
   

    
    private String genero;
    private double preco;

    public Historia() {
    }

    public Historia(int id, String titulo, String genero,double preco) {
        this.id = id;
        this.titulo = titulo;
        this.preco=preco;
        this.genero = genero;
    }

     public int getId() {
        return id;
    }

    public void setId_(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

   

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Escritor getEscritor() {
        return this.escritor;
    }

    public void setEscritor(Escritor escritor) {
        this.escritor = escritor;
    }
     public Avaliacao getAvaliacao() {
        return this.avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }
}
