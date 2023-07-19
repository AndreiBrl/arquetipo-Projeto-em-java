package br.com.arquetipo.dao.impl;

import br.com.arquetipo.dao.IGenericDAO;
import br.com.arquetipo.model.u.Leitor;
import br.com.arquetipo.util.connection.ConnectionFactory;
import br.com.arquetipo.view.ObjetoCompartilhadoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class LeitorDAO implements IGenericDAO<Leitor,Integer> {
    ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();

    @Override
    public void inserir(Leitor obj) throws SQLException, ClassNotFoundException {
        // 4 PASSOS
        // 1 - CONECTAR
        UsuarioDAO usu = new UsuarioDAO();
        
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            // 2 - PREPARAR SQL
            String sql = "INSERT INTO bdarquetipo.leitor " +
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
    public void alterar(Leitor obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "UPDATE `bdarquetipo`.`leitor`\n" +
                    "SET\n" +
                    "`generoPreferido` = ?,\n" +
                    "`escritorPreferido` = ?,\n" +
                    "`nome` = ?,\n" +
                    "`numeroObrasLidas` = ?\n" +
                    "WHERE `id_Leitor` = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, obj.getGeneroPreferido());
            pst.setString(2, obj.getEscritorPreferido());
            pst.setString(3, obj.getNome());
            pst.setInt(4, obj.getNumeroObrasLidas() );
            pst.setInt(5,4);


            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public void apagar(Leitor obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "DELETE FROM `bdarquetipo`.`leitor`\n" +
                    "WHERE `id_Leitor` = ?; ";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,3);


            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public Leitor Buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        
          
        try {
            // 2 - PREPARAR SQL
            String sql = "SELECT * FROM bdarquetipo.leitor where id_usuario=?";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, key);
             
            ResultSet rs = pst.executeQuery();
             if (rs.next()) {
                 Leitor leitor = new Leitor();
                 objCompartilhado.setNome(rs.getString(5));
                 objCompartilhado.setId(rs.getInt(1));
                 leitor.setNome(rs.getString(5));
                 leitor.setGeneroPreferido(rs.getNString(2));
                 leitor.setEscritorPreferido(rs.getString(3));
                 leitor.setId_leitor(rs.getInt(1));
                 leitor.setNumeroObrasLidas(rs.getInt(4));
                 
                 
                 
                 
            return leitor;
        } 


            // 4 - EXECUTAR
             
            
            
        
    }
        
        finally {
            c.close();
        }

        return null;
    }

    @Override
    public ArrayList<Leitor> BuscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        Leitor leitor = new Leitor();

        leitor.setLogin("usuario");
        leitor.setSenha("senha");
        leitor.setNome("Flavia");
        leitor.setEscritorPreferido("rr");
        leitor.setGeneroPreferido("Drama");
        leitor.setNumeroObrasLidas(7);

        // Criar uma instância do LeitorDAO
        LeitorDAO leitorDAO = new LeitorDAO();

        try {
            // Chamar o método inserir para inserir o objeto no banco
//            leitorDAO.inserir(leitor);
//            leitorDAO.alterar(leitor);
            leitorDAO.apagar(leitor);
            System.out.println("Leitor apagado com sucesso!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro ao inserir o leitor: " + e.getMessage());
        }
    }
}


