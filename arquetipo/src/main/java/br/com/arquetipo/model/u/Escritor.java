package br.com.arquetipo.model.u;

import br.com.arquetipo.model.historia.Historia;

import java.util.ArrayList;

public class Escritor extends Usuario {

    private int id_escritor;
private  String generoEscrita;
private  int numeroObras;
private  String nome;
private  int livrosPublicados;
ArrayList <Historia> listaHistorias = new ArrayList<Historia>();

    public Escritor() {

    }
    public Escritor(int id_escritor,String login, String senha, String nome) {
        super(login,senha,nome);
    }

    public int getId_escritor() {
        return id_escritor;
    }

    public void setId_escritor(int id_escritor) {
        this.id_escritor = id_escritor;
    }

    public String getGeneroEscrita() {
        return generoEscrita;
    }

    public void setGeneroEscrita(String generoEscrita) {
        this.generoEscrita = generoEscrita;
    }

    public int getNumeroObras() {
        return numeroObras;
    }

    public void setNumeroObras(int numeroObras) {
        this.numeroObras = numeroObras;
    }


    public int getLivrosPublicados() {
        return livrosPublicados;
    }

    public void setLivrosPublicados(int livrosPublicados) {
        this.livrosPublicados = livrosPublicados;
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public void setLogin(String login) {
        super.setLogin(login);
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
