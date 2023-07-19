package br.com.arquetipo.model.servicos;

import br.com.arquetipo.model.historia.Historia;
import br.com.arquetipo.model.u.Editora;

public class Avaliacao {
    private int id_avaliacao;
    private Editora editora;
    private int nota;
    private Historia historia;


    public Avaliacao() {
    }

    public Avaliacao(int id_avaliacao, int nota, Historia historia) {
        this.id_avaliacao = id_avaliacao;
        this.nota = nota;
        this.historia = historia;
    }

    public int getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(int id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Historia getHistoria() {
        return historia;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void daNotaEditora(){

    }
}
