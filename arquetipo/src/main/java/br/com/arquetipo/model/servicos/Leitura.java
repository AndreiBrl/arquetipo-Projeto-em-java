package br.com.arquetipo.model.servicos;

import br.com.arquetipo.model.historia.Historia;
import br.com.arquetipo.model.u.Leitor;

public class Leitura {
    private int id_leitura;
    private Historia historia;
    private int idHistoria;
    private int paginasLidas;
    private boolean leituraFinalizada;
    private int nota;
    private Leitor leitor;

    public Leitura() {
    }

    public Leitura(int id_leitura  ) {
        this.id_leitura = id_leitura;
       
    }

    public int getId_leitura() {
        return id_leitura;
    }

    public void setId_leitura(int id_leitura) {
        this.id_leitura = id_leitura;
    }

    public int getPaginasLidas() {
        return paginasLidas;
    }

    public void setPaginasLidas(int paginasLidas) {
        this.paginasLidas = paginasLidas;
    }

    public boolean isLeituraFinalizada() {
        return leituraFinalizada;
    }

    public void setLeituraFinalizada(boolean leituraFinalizada) {
        this.leituraFinalizada = leituraFinalizada;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(int idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void daNotaLeitor(){

    }
    
    public Historia getHistoria(){
        
        return this.historia;
    }
    public void setHistoria(Historia historia){
        this.historia=historia;
    }
}
