package br.com.arquetipo.model.u;

import br.com.arquetipo.model.servicos.Leitura;
import br.com.arquetipo.model.u.Usuario;

import java.util.ArrayList;

public class Leitor extends Usuario{
    private  int id_leitor;
    private  String generoPreferido;
    private   String escritorPreferido;
    private  int numeroObrasLidas;

    private static String nome;

    private  ArrayList <Leitura> listaLeituras= new ArrayList <Leitura>();
    public Leitor() {
    }
    public Leitor(int id_leitor,String login, String senha, String nome) {
        super(login,senha,nome);
    }

    public int getId_leitor() {
        return id_leitor;
    }

    public void setId_leitor(int id_leitor) {
        this.id_leitor = id_leitor;
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




    public String getGeneroPreferido() {
        return generoPreferido;
    }

    public void setGeneroPreferido(String generoPreferido) {
        this.generoPreferido = generoPreferido;
    }

    public String getEscritorPreferido() {
        return escritorPreferido;
    }

    public void setEscritorPreferido(String escritorPreferido) {
        this.escritorPreferido = escritorPreferido;
    }

    public int getNumeroObrasLidas() {
        return numeroObrasLidas;
    }

    public void setNumeroObrasLidas(int numeroObrasLidas) {
        this.numeroObrasLidas = numeroObrasLidas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
