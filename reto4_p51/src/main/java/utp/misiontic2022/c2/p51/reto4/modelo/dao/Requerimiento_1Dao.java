package utp.misiontic2022.c2.p51.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p51.reto4.util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException {
        var connection = JDBCUtilities.getConnection();

        var respuesta = new ArrayList<Requerimiento_1>();

        try{
            var stmt = connection.prepareStatement("SELECT Nombre_Material, Precio_Unidad"
            + " FROM MaterialConstruccion"
            + " WHERE Importado = 'Si' "
            + " ORDER BY Precio_Unidad DESC ");
            var rset = stmt.executeQuery();

            while(rset.next()){
                var requerimiento1VO = new Requerimiento_1();
                requerimiento1VO.setNombreMaterial(rset.getString("Nombre_Material"));
                requerimiento1VO.setPrecioUnidad(rset.getInt("Precio_Unidad"));

                respuesta.add(requerimiento1VO);
            }
        }finally{
            if(connection != null){
                connection.close();
            }
        }

        return respuesta;       
        
    }
}