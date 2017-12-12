package CopyData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirData {
    Connection con = Conexao.getConnection();
    public InserirData() {
    }
    public static Statement InsertInData(Connection con,String msg) throws SQLException{
            Statement Stat = con.createStatement();
            Stat.execute(msg);
            return Stat;
    }
}
