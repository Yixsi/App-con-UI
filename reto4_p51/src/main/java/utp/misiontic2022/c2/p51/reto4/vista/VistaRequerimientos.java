package utp.misiontic2022.c2.p51.reto4.vista;

import java.util.ArrayList;

import utp.misiontic2022.c2.p51.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.Requerimiento_3;

public class VistaRequerimientos {

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    public static void requerimiento1(){
        try {
            var requerimiento_1s = controlador.consultarRequerimiento1();

            for(Requerimiento_1 registro: requerimiento_1s){
                System.out.printf("%s %d %n",
                                        registro.getNombreMaterial(),
                                        registro.getPrecioUnidad()                             
                );
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento2(){
        try {
            var requerimiento_2s = controlador.consultarRequerimiento2();

            for(Requerimiento_2 registro: requerimiento_2s){
                System.out.printf("%s %s %n",
                                        registro.getConstructora(), 
                                        registro.getCiudad()                              
                );
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void requerimiento3(){
        try {
            var requerimiento_3s = controlador.consultarRequerimiento3();

            for(Requerimiento_3 registro: requerimiento_3s){
                System.out.printf("%s %s %s %d %d %n", registro.getProveedor(), 
                                        registro.getNombreMaterial(),
                                        registro.getImportado(),
                                        registro.getPrecioUnidad(),
                                        registro.getCantidad()                                
                );
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
}
