
package trabalho;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InserirData {
    public InserirData() {
    }
    public static Statement InsertInData(Connection con,String msg) throws SQLException{
            Statement Stat = con.createStatement();
            Stat.execute(msg);
            return Stat;
    }
}
