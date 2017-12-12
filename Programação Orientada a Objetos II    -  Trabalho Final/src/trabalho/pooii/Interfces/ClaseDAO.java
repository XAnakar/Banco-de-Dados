package trabalho.pooii.Interfces;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import trabalho.pooii.DataBase.Conexao;

public class ClaseDAO {

    public static  ArrayList <Variaveis> Read() throws SQLException{
        ArrayList <Variaveis> Lista = new ArrayList <>();

      
        String Query = "select * from cadastro;"; //Pesquisa
        PreparedStatement Stat = Conexao.getConnection().prepareStatement(Query);
        ResultSet Dados;
        Dados = Stat.executeQuery(Query);
        while(Dados.next()){
            Variaveis Var = new Variaveis();
            Var.setId(Dados.getString("cod"));
            Var.setNome(Dados.getString("nome"));
            Var.setCpf(Dados.getString("cpf"));
            Var.setTelefone(Dados.getString("telefone"));
            Var.setNascimento(Dados.getString("nascimento"));
            Lista.add(Var);
        }
        Dados.close();
        Stat.close();
        
        return Lista;
    }     
    public static void Write(Variaveis X) throws SQLException{
        
        Statement Stat = Conexao.getConnection().createStatement();
        String Insert = "insert into cadastro (cod,nome,cpf,telefone,nascimento) values (DEFAULT,'"+X.getNome()+"','"+X.getCpf()+"','"+X.getTelefone()+"','"+X.getNascimento()+"');";
        Stat.execute(Insert);
    }
}