package utp.misiontic2022.c2.p51.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p51.reto4.util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException {
        var connection = JDBCUtilities.getConnection();

        var respuesta = new ArrayList<Requerimiento_2>();

        try{
            var stmt = connection.prepareStatement("SELECT DISTINCT Constructora, Ciudad"
            + " FROM Proyecto" 
            + " WHERE  Ciudad  LIKE 'B%' "
            + " ORDER BY Ciudad");
            var rset = stmt.executeQuery();

            while(rset.next()){
                var requerimiento2VO = new Requerimiento_2();
                requerimiento2VO.setConstructora(rset.getString("Constructora"));
                requerimiento2VO.setCiudad(rset.getString("Ciudad"));

                respuesta.add(requerimiento2VO);
            }
        }finally{
            if(connection != null){
                connection.close();
            }
        }

        return respuesta;       
        
    }
}