package utp.misiontic2022.c2.p51.reto4.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;
import utp.misiontic2022.c2.p51.reto4.util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento_3> requerimiento3() throws SQLException {
        var connection = JDBCUtilities.getConnection();

        var respuesta = new ArrayList<Requerimiento_3>();

        try{
            var stmt = connection.prepareStatement(" SELECT Proveedor, Nombre_Material, Importado, Precio_Unidad, SUM(Cantidad) Cantidad "
            + " FROM MaterialConstruccion mc " 
            + " JOIN Compra c ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion "
            + " WHERE Proveedor = 'Homecenter' AND Importado = 'Si' "
            + " GROUP BY Nombre_Material "
            + " HAVING SUM (Cantidad) > 100 ");
            var rset = stmt.executeQuery();

            while(rset.next()){
                var requerimiento3VO = new Requerimiento_3();
                requerimiento3VO.setProveedor(rset.getString("Proveedor"));
                requerimiento3VO.setNombreMaterial(rset.getString("Nombre_Material"));
                requerimiento3VO.setImportado(rset.getString("Importado"));
                requerimiento3VO.setPrecioUnidad(rset.getInt("Precio_Unidad"));
                requerimiento3VO.setCantidad(rset.getInt("Cantidad"));
                respuesta.add(requerimiento3VO);
            }
        }finally{
            if(connection != null){
                connection.close();
            }
        }

        return respuesta;       
        
    }
}