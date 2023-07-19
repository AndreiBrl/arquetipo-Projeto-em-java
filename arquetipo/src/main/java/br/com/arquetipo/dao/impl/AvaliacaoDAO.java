package br.com.arquetipo.dao.impl;

import br.com.arquetipo.dao.IGenericDAO;
import br.com.arquetipo.model.historia.Historia;
import br.com.arquetipo.model.servicos.Avaliacao;
import br.com.arquetipo.model.u.Escritor;
import br.com.arquetipo.util.connection.ConnectionFactory;
import br.com.arquetipo.view.ObjetoCompartilhadoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvaliacaoDAO implements IGenericDAO<Avaliacao, Integer> {

    ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();

    @Override
    public void inserir(Avaliacao obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            // 2 - PREPARAR SQL
            String sql = "INSERT INTO bdarquetipo.avaliacao "
                    + "(id_historia,id_editora,nota) "
                    + "VALUES(?,?,?);";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getHistoria().getId());
            pst.setInt(2, objCompartilhado.getId());
            pst.setInt(3, obj.getNota());

            // 4 - EXECUTAR
            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Avaliacao obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = " UPDATE avaliacao \n"
                    + "SET \n"
                    + "    nota = ?\n"
                    + "WHERE\n"
                    + "    avaliacao.id_avaliacao = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, obj.getNota());

            pst.setInt(2, obj.getId_avaliacao());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Avaliacao obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "DELETE FROM `bdarquetipo`.`avaliacao`\n"
                    + "WHERE `id_avaliacao` = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId_avaliacao());

            pst.execute();
        } finally {
            c.close();
        }
    }

    public ArrayList<Avaliacao> BuscarPeloIdEditora() throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "SELECT \n"
                    + "    a.id_avaliacao, es.nome, h.titulo, a.nota,h.id_historia\n"
                    + "FROM\n"
                    + "    avaliacao AS a\n"
                    + "        INNER JOIN\n"
                    + "    historia AS h ON a.id_historia = h.id_historia\n"
                    + "        INNER JOIN\n"
                    + "    escritor AS es ON es.id_escritor = h.id_escritor\n"
                    + "WHERE\n"
                    + "    a.id_editora = ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, objCompartilhado.getId());

            ResultSet rs = pst.executeQuery();

            // 5 - Preparar Objeto
            return getRegistro(rs);
        } finally {
            c.close();
        }

    }

    private ArrayList<Avaliacao> getRegistro(ResultSet rs) throws SQLException {
        ArrayList<Avaliacao> lista = new ArrayList<>();

        while (rs.next()) {
            Avaliacao a = new Avaliacao();
            Historia h = new Historia();
            Escritor es = new Escritor();
            a.setHistoria(h);
            h.setEscritor(es);

            a.setId_avaliacao(rs.getInt(1));
            es.setNome(rs.getString(2));
            h.setTitulo(rs.getString(3));
            a.setNota(rs.getInt(4));
            h.setId_(rs.getInt(5));
            lista.add(a);
        }

        return lista;
    }

    @Override
    public Avaliacao Buscar(Integer key) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Avaliacao> BuscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }
}
