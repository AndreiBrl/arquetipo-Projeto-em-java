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

public class HistoriaDAO implements IGenericDAO<Historia, Integer> {

    ObjetoCompartilhadoView objCompartilhado = new ObjetoCompartilhadoView();

    @Override
    public void inserir(Historia obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            // 2 - PREPARAR SQL
            String sql = "INSERT INTO bdarquetipo.historia "
                    + "(titulo,genero,preco,id_escritor) "
                    + "VALUES(?,?,?,?);";
            // 3 - PREPARAR EXECUÇÃO
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, obj.getTitulo());
            pst.setString(2, obj.getGenero());
            pst.setDouble(3, obj.getPreco());
            pst.setInt(4, objCompartilhado.getId());

            // 4 - EXECUTAR
            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void alterar(Historia obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "UPDATE `bdarquetipo`.`historia`\n"
                    + "SET\n"
                    + "`titulo` = ?,\n"
                    + "`genero` = ?,\n"
                    + "`preco` = ?,\n"
                    + "`id_escritor` = ?\n"
                    + "WHERE `id_historia` = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, obj.getTitulo());
            pst.setString(2, obj.getGenero());
            pst.setDouble(3, obj.getPreco());
            pst.setInt(4, objCompartilhado.getId());
            pst.setInt(5, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public void apagar(Historia obj) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "DELETE FROM `bdarquetipo`.`historia`\n"
                    + "WHERE `id_historia` = ?; ";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setInt(1, obj.getId());

            pst.execute();
        } finally {
            c.close();
        }
    }

    @Override
    public Historia Buscar(Integer key) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        Historia h = new Historia();
        Avaliacao a = new Avaliacao();
        Escritor es = new Escritor();
         h.setAvaliacao(a);
         h.setEscritor(es);
        try {
            String sql = "SELECT \n"
                    + "    a.id_avaliacao, es.nome, h.titulo, a.nota\n"
                    + "FROM\n"
                    + "    avaliacao AS a\n"
                    + "        INNER JOIN\n"
                    + "    historia AS h ON a.id_historia = h.id_historia\n"
                    + "        INNER JOIN\n"
                    + "    escritor AS es ON es.id_escritor = h.id_escritor\n"
                    + "WHERE\n"
                    + "    h.id_historia = ?;";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, key);

            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                 h.getAvaliacao().setId_avaliacao(rs.getInt(1));
                h.getEscritor().setNome(rs.getString(2));
                h.setTitulo(rs.getString(3));
                h.getAvaliacao().setNota(rs.getInt(4));
                return h;
            }
          
            
            

            // 5 - Preparar Objeto
            
        } finally {
            c.close();
        }
        return null;
    }

    @Override
    public ArrayList<Historia> BuscarTodos() throws SQLException, ClassNotFoundException {
        return null;
    }

    public ArrayList<Historia> buscaPorObra(String nomeEscritor, String titulo, String genero, String media) throws SQLException, ClassNotFoundException {
        Connection c = ConnectionFactory.getConnectionMysql();
        String sqlTitulo = "";
        String sqlGenero = "AND genero =" + "\"" + genero + "\"";
        String sqlNomeEscritor = "AND escritor.nome =" + "\"" + nomeEscritor + "\"";

//        Lógica para implementar busca por parâmetros diferentes - Concatena Strins de acordo com a
// a entrada do usuário
        if (titulo != null) {
            titulo = "\"%" + titulo + "%\"";
            sqlTitulo = "AND titulo LIKE " + titulo + " ";

        }
        if ("Todos".equals(genero)) {
            sqlGenero = "";
        }
        if ("Todos".equals(nomeEscritor)) {
            sqlNomeEscritor = "";
        }

        try {
            String sql = "SELECT "
                    + "  historia.id_historia,  historia.titulo, historia.genero, historia.preco, AVG(leitura.nota + avaliacao.nota) as media "
                    + "FROM "
                    + "    historia "
                    + "    LEFT JOIN escritor ON escritor.id_escritor = historia.id_escritor "
                    + "    LEFT JOIN leitura ON historia.id_historia = leitura.id_historia "
                    + "    LEFT JOIN avaliacao ON historia.id_historia = avaliacao.id_historia "
                    + "WHERE historia.id_historia>0 " + sqlNomeEscritor + sqlGenero + sqlTitulo
                    + "GROUP BY historia.id_historia "
                    + "HAVING AVG(COALESCE(leitura.nota, 0) + COALESCE(avaliacao.nota, 0)) >= ?";

            PreparedStatement pst = c.prepareStatement(sql);

            pst.setDouble(1, Double.parseDouble(media));

            ResultSet rs = pst.executeQuery();

            // 5 - Preparar Objeto
            return getRegistro(rs);
        } finally {
            c.close();
        }

    }

    public ArrayList<Historia> BuscarPeloIdEscritor() throws SQLException, ClassNotFoundException {

        //Metodo utiliza o ID do usuário previamente guardado na classe ObjetoCompartilhado para encontrar o
        //ID do escritor e então buscar as obras do mesmo.
        Connection c = ConnectionFactory.getConnectionMysql();
        try {
            String sql = "SELECT \n"
                    + "    *\n"
                    + "FROM\n"
                    + "    historia\n"
                    + "        where id_escritor=?";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, objCompartilhado.getId());

            ResultSet rs = pst.executeQuery();

            // 5 - Preparar Objeto
            return getRegistro(rs);
        } finally {
            c.close();
        }

    }

    private ArrayList<Historia> getRegistro(ResultSet rs) throws SQLException {
        ArrayList<Historia> lista = new ArrayList<>();

        while (rs.next()) {

            Historia Ht = new Historia(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getDouble(4));

            Ht.setMedia(rs.getDouble(5));

            lista.add(Ht);
        }

        return lista;
    }

    @Override
    public int quantidade() throws SQLException, ClassNotFoundException {
        return 0;
    }

}
