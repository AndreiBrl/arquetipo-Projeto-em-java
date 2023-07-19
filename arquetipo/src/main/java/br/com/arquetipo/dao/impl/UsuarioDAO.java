package br.com.arquetipo.dao.impl;

import br.com.arquetipo.dao.IGenericDAO;
import br.com.arquetipo.model.u.Leitor;
import br.com.arquetipo.model.u.Usuario;
import br.com.arquetipo.util.connection.ConnectionFactory;
import br.com.arquetipo.view.ObjetoCompartilhadoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO  implements IGenericDAO<Usuario,Integer> {


    @Override
    public void inserir(Usuario obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();
        try {
            // 2 - PREPARAR SQL
            String sql = "INSERT INTO bdarquetipo.usuario " +
                    "(login,senha,tipo) " +
                    "VALUES(?,?,?);";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, obj.getLogin());
            pst.setString(2, obj.getSenha());
            pst.setString(3, objCompartilhado.getTipoUsuario());
            

            // 4 - EXECUTAR
            pst.execute();
            ResultSet generatedKeys = pst.getGeneratedKeys();
        if (generatedKeys.next()) {
            int id = generatedKeys.getInt(1);
            
            objCompartilhado.setId(id);
        } else {
            
            throw new SQLException("Falha ao obter o ID gerado.");
        }
            
            
        } finally {
            c.close();
        }
    }
    
    //Metodo que pega o ultimo ID da tabela Usuario. -- Deixou de ser necessário
//    public int getUltimoIDAdicionado()throws SQLException, ClassNotFoundException {
//          Connection c = ConnectionFactory.getConnectionMysql();
//          
//          int ultimoId=0;
//        try {
//            // 2 - PREPARAR SQL
//            String sql = "SELECT MAX(id_usuario) FROM bdarquetipo.usuario";
//            // 3 - PREPARAR EXECUÇÃO
//            PreparedStatement pst = c.prepareStatement(sql);
//            ResultSet resultSet = pst.executeQuery();
//             if (resultSet.next()) {
//            ultimoId = resultSet.getInt(1);
//            }
//
//
//            // 4 - EXECUTAR
//           // pst.execute();
//            
//            
//        } finally {
//            c.close();
//        }
//        return ultimoId;
//    }
    public boolean verificaUsuario(String login,String senha) throws SQLException, ClassNotFoundException{
        Connection c = ConnectionFactory.getConnectionMysql();
        ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();
          
        try {
            // 2 - PREPARAR SQL
            String sql = "SELECT * FROM bdarquetipo.usuario where login= ? and senha=?";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1, login);
             pst.setString(2, senha);
             
            ResultSet rs = pst.executeQuery();

             if (rs.next()) {
                 
                 
                 objCompartilhado.setId(rs.getInt(1));
                 objCompartilhado.setTipoUsuario(rs.getString(4));
                 
                 
            return true;
        } else {
               System.out.println("O banco de dados não possui registros.");
            
            return false;
        }
   
    }
        
        
        finally {
            c.close();
        }
        
    }
    

    @Override
    public void alterar(Usuario obj) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void apagar(Usuario obj) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Usuario Buscar(Integer key) throws SQLException, ClassNotFoundException {
        
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            // 2 - PREPARAR SQL
            String sql = "SELECT * FROM bdarquetipo.usuario where id_usuario=?";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, key);

            ResultSet rs = pst.executeQuery();
             if (rs.next()) {
                 Leitor leitor = new Leitor();

                 leitor.setLogin(rs.getString(2));





            return leitor;
        }

            // 4 - EXECUTAR;

    }

        finally {
            c.close();
        }

        return null;
    }
    

    @Override
    public ArrayList<Usuario> BuscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }

    public static void main(String [] args){
        System.out.println("AQUI");
        UsuarioDAO usu = new UsuarioDAO();
        ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();

        System.out.println(objCompartilhado.getId());
        try {
            usu.verificaUsuario("user123", "password123");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


