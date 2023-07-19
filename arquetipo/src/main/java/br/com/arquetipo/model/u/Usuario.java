package br.com.arquetipo.model.u;

public abstract class Usuario {

    protected String login;
    protected String senha;
    protected  String nome;

    public Usuario() {
    }

    public Usuario(String login, String senha,String nome) {
        this.login = login;
        this.senha = senha;
        this.nome=nome;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
     public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
