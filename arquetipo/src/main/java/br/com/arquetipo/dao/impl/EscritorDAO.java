package br.com.arquetipo.dao.impl;

import br.com.arquetipo.dao.IGenericDAO;
import br.com.arquetipo.model.u.Escritor;
import br.com.arquetipo.util.connection.ConnectionFactory;
import br.com.arquetipo.view.ObjetoCompartilhadoView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EscritorDAO implements IGenericDAO<Escritor, Integer> {
    ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();

    @Override
    public void inserir(Escritor obj) throws SQLException, ClassNotFoundException {
// 4 PASSOS
        // 1 - CONECTAR
        ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();
        Connection c = ConnectionFactory.getConnectionMysql();
        
        try {
            // 2 - PREPARAR SQL
            String sql = "INSERT INTO bdarquetipo.escritor " +
                    "(nome,generoEscrita,id_usuario) " +
                    "VALUES(?,?,?);";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getGeneroEscrita());
            pst.setInt(3, objCompartilhado.getId());

            // 4 - EXECUTAR
            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Escritor obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "UPDATE `bdarquetipo`.`escritor`\n" +
                    "SET\n" +
                    "`nome` = ?,\n" +
                    "`generoEscrita` = ?,\n" +
                    "`numeroDeObras` = ?,\n" +
                    "`livrosPublicados` = ?\n" +
                    "WHERE `id_escritor` = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getGeneroEscrita());
            pst.setInt(3,obj.getNumeroObras());
            pst.setInt(4,obj.getLivrosPublicados());


            pst.execute();
        }finally {
            c.close();
        }
    }

    @Override
    public void apagar(Escritor obj) throws SQLException, ClassNotFoundException {

        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "DELETE FROM `bdarquetipo`.`escritor`\n" +
                    "WHERE `id_escritor` = ?; ";


            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1,2);


            pst.execute();
        }finally {
            c.close();
        }

    }

    @Override
    public Escritor Buscar(Integer key) throws SQLException, ClassNotFoundException {
         Connection c = ConnectionFactory.getConnectionMysql();
        
          
        try {
            // 2 - PREPARAR SQL
            String sql = "SELECT * FROM bdarquetipo.escritor where id_usuario=?";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, key);
             
            ResultSet rs = pst.executeQuery();
             if (rs.next()) {
                 objCompartilhado.setNome(rs.getString(5));
                 objCompartilhado.setId(rs.getInt(1));
                 Escritor es = new Escritor();
                 es.setId_escritor(rs.getInt(1));
                 es.setGeneroEscrita(rs.getString(2));
                 es.setNumeroObras(rs.getInt(3));
                 es.setLivrosPublicados(rs.getInt(4));
                 es.setNome(rs.getString(5));
                 
     
            return es;
        } 
            // 4 - EXECUTAR
 
    }
     
        finally {
            c.close();
        }
        return null;
    }

    @Override
    public ArrayList<Escritor> BuscarTodos() throws SQLException, ClassNotFoundException {
          Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "SELECT *\n" +
                    "FROM escritor;\n";

            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet resultado = pst.executeQuery();
            // 5 - Preparar Objeto

            return getRegistro(resultado);
        }finally {
            c.close();
        }
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }
    
   

    public ArrayList<Escritor> buscaPorEscritor(String nomeEscritor,  String genero) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        
        String sqlGenero = "AND generoEscrita =" + "\"" + genero + "\"";
        String sqlNomeEscritor = "AND escritor.nome =" + "\"" + nomeEscritor + "\"";
        
//        Lógica para implementar busca por parâmetros diferentes - Concatena Strins de acordo com a
// a entrada do usuário
        
       
        if ("Todos".equals(genero)) {
            sqlGenero = "";
        }
        if ("Todos".equals(nomeEscritor)) {
            sqlNomeEscritor = "";
        }

        try {
            String sql = "SELECT "
                    + "  escritor.id_escritor , escritor.nome,escritor.generoEscrita,escritor.numeroDeObras,escritor.livrosPublicados "
                    + "FROM "
                    + "    escritor "
                    
                    + "WHERE escritor.id_escritor>0 " + sqlNomeEscritor + sqlGenero ;

            PreparedStatement pst = c.prepareStatement(sql);

//            pst.setDouble(1, Double.parseDouble(media));

           
            ResultSet rs = pst.executeQuery();

            // 5 - Preparar Objeto
            return getRegistroBuscaGeral(rs);
        } finally {
            c.close();
        }

    }
    private ArrayList<Escritor> getRegistroBuscaGeral(ResultSet rs) throws SQLException{
       ArrayList<Escritor> lista = new ArrayList<>();

        while (rs.next()){
           
            Escritor Es = new Escritor();
            Es.setId_escritor(rs.getInt(1));
            Es.setNome(rs.getString(2));
            Es.setGeneroEscrita(rs.getString(3));
            Es.setNumeroObras(rs.getInt(4));
            Es.setLivrosPublicados(rs.getInt(5));
            
            
            lista.add(Es);
        }

        return lista;
    }
      private ArrayList<Escritor> getRegistro(ResultSet rs) throws SQLException{
       ArrayList<Escritor> lista = new ArrayList<>();

        while (rs.next()){
           
            Escritor Es = new Escritor();
            Es.setNome(rs.getString(5));
            
            lista.add(Es);
        }

        return lista;
    }
}
