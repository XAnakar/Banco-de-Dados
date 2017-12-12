package trabalho.pooii.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String [] args){
        new Conexao();
    }
    public Conexao() {
       Connection con = Conexao.getConnection();
    }
    
    public static Connection getConnection() {
        String URL_DB = "jdbc:mysql://127.0.0.1/poo";
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL_DB,"root","");
        }catch(ClassNotFoundException ex){
            System.out.println("Driver Mysql não encontrado!");
        }catch(SQLException ex){
            System.out.println("Erro ao tentar se conectar ao Mysql!");
        }
        System.out.println("Conectado!");
        return con;
        
    }
}
