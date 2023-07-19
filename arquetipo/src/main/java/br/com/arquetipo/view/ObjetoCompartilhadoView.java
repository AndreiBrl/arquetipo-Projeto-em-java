/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.arquetipo.view;

/**
 *
 * @author barbu
 */

//Esta classe foi criada com objetivo de guardar as informações da Sessão do usuário(Nome,Id,Tipo)
// Também é utilizada para fazer a conexão do ID da Tabela Usuário nas Tabelas Escritor/Editora/Leitor.
// Desempenha um papel semelhante a instanciar um objeto generico do Usuário nas views

public class ObjetoCompartilhadoView {
    
    
    private static int id;//ID da tabela USUARIO
    private static String nome;
    private static String tipoUsuario;

    public ObjetoCompartilhadoView() {
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
