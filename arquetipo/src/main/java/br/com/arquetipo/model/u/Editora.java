package br.com.arquetipo.model.u;

import br.com.arquetipo.model.servicos.Avaliacao;

import java.util.ArrayList;

public class Editora extends Usuario {

    private  int id_editora;
    private  static ArrayList <Avaliacao> listaAvaliacoes= new ArrayList <Avaliacao>();
    private  int numeroAutoresPublicados;
    

    public Editora() {
    }

    public Editora(int id_editora,String login, String senha, String nome) {
        super(login,senha,nome);
    }

    public void novaHistoria(){

    }

    public int getId_editora() {
        return id_editora;
    }

    public void setId_editora(int id_editora) {
        this.id_editora = id_editora;
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

    public int getNumeroAutoresPublicados() {
        return numeroAutoresPublicados;
    }

    public void setNumeroAutoresPublicados(int numeroAutoresPublicados) {
        this.numeroAutoresPublicados = numeroAutoresPublicados;
    }

}
