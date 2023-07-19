package br.com.arquetipo.dao.impl;

import br.com.arquetipo.dao.IGenericDAO;
import br.com.arquetipo.model.u.Editora;
import br.com.arquetipo.util.connection.ConnectionFactory;
import br.com.arquetipo.view.ObjetoCompartilhadoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditoraDAO implements IGenericDAO<Editora,Integer> {



    @Override
    public void inserir(Editora obj) throws SQLException, ClassNotFoundException {
        // 4 PASSOS
        // 1 - CONECTAR
        ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();
        Connection c = ConnectionFactory.getConnectionMysql();
        
        try {
            // 2 - PREPARAR SQL
            String sql = "INSERT INTO bdarquetipo.editora " +
                    "(nome,id_usuario) " +
                    "VALUES(?,?);";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setInt(2, objCompartilhado.getId());

            // 4 - EXECUTAR
            pst.execute();
        } finally {
            c.close();
        }

    }

    @Override
    public void alterar(Editora obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "UPDATE `bdarquetipo`.`editora`\n" +
                    "SET\n" +
                    "`nome` = ?,\n" +
                    "`numeroAutoresPublicados` = ?\n" +
                    "WHERE `id_editora` = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setInt(2, obj.getNumeroAutoresPublicados());
            pst.setInt(3,3);


            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public void apagar(Editora obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "DELETE FROM `bdarquetipo`.`editora`\n" +
                    "WHERE `id_editora` = ?; ";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,2);


            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public Editora Buscar(Integer key) throws SQLException, ClassNotFoundException {

 Connection c = ConnectionFactory.getConnectionMysql();
         ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();
          
        try {
            // 2 - PREPARAR SQL
            String sql = "SELECT * FROM bdarquetipo.editora where id_usuario=?";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, key);
             
            ResultSet rs = pst.executeQuery();
             if (rs.next()) {
                 objCompartilhado.setNome(rs.getString(3));
                 objCompartilhado.setId(rs.getInt(1));
                 Editora ed = new Editora();
                 ed.setId_editora(rs.getInt(1));
                 ed.setNome(rs.getString(3));
                 ed.setNumeroAutoresPublicados(rs.getInt(2));
     
            return ed;
        } 
            // 4 - EXECUTAR
 
    }
     
        finally {
            c.close();
        }
        return null;
    }

    @Override
    public ArrayList<Editora> BuscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        Editora editora = new Editora();

        editora.setLogin("usuario");
        editora.setSenha("senha");
        editora.setNome("Luzes");
        editora.setNumeroAutoresPublicados(10);

        // Criar uma instância do editoraDAO
        EditoraDAO editoraDAO = new EditoraDAO();

        try {
            // Chamar o método inserir para inserir o objeto no banco
            editoraDAO.inserir(editora);
            editoraDAO.alterar(editora);
            editoraDAO.apagar(editora);
            System.out.println("editora apagado com sucesso!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao inserir o editora: " + e.getMessage());
        }
    }

}
