package trabalho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Conexao() {
    }
    public static Connection getConnection() {
        String URL_DB = "jdbc:mysql://127.0.0.1/Sockets";
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL_DB,"root","");
        }catch(ClassNotFoundException ex){
            System.out.println("Driver Mysql não encontrado!");
        }catch(SQLException ex){
            System.out.println("Erro ao tentar se conectar ao Mysql!");
        }
        return con;
    }
}
