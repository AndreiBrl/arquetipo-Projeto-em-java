package br.com.arquetipo.dao.impl;

import br.com.arquetipo.dao.IGenericDAO;
import br.com.arquetipo.model.historia.Historia;
import br.com.arquetipo.model.servicos.Leitura;
import br.com.arquetipo.model.u.Escritor;
import br.com.arquetipo.util.connection.ConnectionFactory;
import br.com.arquetipo.view.ObjetoCompartilhadoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LeituraDAO implements IGenericDAO<Leitura, Integer> {

    ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();

    @Override
    public void inserir(Leitura obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            // 2 - PREPARAR SQL
            String sql = "INSERT INTO bdarquetipo.leitura "
                    + "(id_historia,id_leitor) "
                    + "VALUES(?,?);";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, obj.getIdHistoria());
            pst.setInt(2, objCompartilhado.getId());

            // 4 - EXECUTAR
            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Leitura obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "UPDATE leitura \n"
                    + "SET \n"
                    + "    leitura.paginasLidas = ?,\n"
                    + "    leitura.nota = ?\n"
                    + "WHERE\n"
                    + "    id_leitura = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, obj.getPaginasLidas());
            pst.setInt(2, obj.getNota());
            pst.setInt(3, obj.getId_leitura());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Leitura obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "DELETE FROM `bdarquetipo`.`leitura`\n"
                    + "WHERE `id_leitura` = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId_leitura());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Leitura Buscar(Integer key) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Leitura> BuscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }

    public ArrayList<Leitura> BuscarLeitorPorID() throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "SELECT \n"
                    + "    l.id_leitura, es.nome, h.titulo, l.paginasLidas, l.nota\n"
                    + "FROM\n"
                    + "    leitura AS l\n"
                    + "        INNER JOIN\n"
                    + "    historia AS h ON l.id_historia = h.id_historia\n"
                    + "        INNER JOIN\n"
                    + "    escritor AS es ON h.id_escritor = es.id_escritor\n"
                    + "        INNER JOIN\n"
                    + "    leitor ON leitor.id_Leitor = l.id_leitor\n"
                    + "where l.id_leitor=?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, objCompartilhado.getId());

            ResultSet rs = pst.executeQuery();

            // 5 - Preparar Objeto
            return getRegistro(rs);
        } finally {
            c.close();
        }

    }

    private ArrayList<Leitura> getRegistro(ResultSet rs) throws SQLException {
        ArrayList<Leitura> lista = new ArrayList<>();

        while (rs.next()) {

            Leitura lt = new Leitura();
            Escritor es = new Escritor();
            Historia h = new Historia();
            lt.setHistoria(h);
            h.setEscritor(es);
            lt.setId_leitura(rs.getInt(1));
            es.setNome(rs.getString(2));
            h.setTitulo(rs.getString(3));
            lt.setPaginasLidas(rs.getInt(4));
            lt.setNota(rs.getInt(5));

            lista.add(lt);
        }

        return lista;
    }
}
