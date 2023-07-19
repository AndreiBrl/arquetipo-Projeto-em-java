package br.com.arquetipo.util.connection;



import br.com.arquetipo.model.u.Leitor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnectionMysql() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/bdarquetipo";
        String login = "aluno";
        String senha = "aluno";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, login, senha);
    }

    public static void main(String[] args) {
        try {
            Connection c = ConnectionFactory.getConnectionMysql();

            Leitor obj = new Leitor(2, "123", "345", "Andrei");

            //DAO - inserir, editar, apagar, buscar, .....
//            new AviaoDAO().inserir(av);

            System.out.println("Conectou no Banco");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!!!");
        } catch (SQLException e) {
            System.out.println("Não conectou no banco " + e.getMessage());
        } catch (Exception e) {
            System.out.println("erro Interno");
        }

    }
}
