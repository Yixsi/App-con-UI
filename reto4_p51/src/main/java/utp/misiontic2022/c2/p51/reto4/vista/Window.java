package utp.misiontic2022.c2.p51.reto4.vista;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;


import utp.misiontic2022.c2.p51.reto4.controlador.ControladorRequerimientos;
import utp.misiontic2022.c2.p51.reto4.modelo.vo.*;

public class Window extends JFrame{

    private JTable tabla;
    private ControladorRequerimientos controlador;
    
    public Window(){

        controlador = new ControladorRequerimientos();
        initUI();
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.CYAN);
        
    
    }

    private void initUI(){
        setTitle("Interfaz Reto_5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        var tbd = new   JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);

        var panel = new JPanel();
        panel.setLayout(new BorderLayout());

        tbd.addTab("Requerimientos DataBase", panel);

        var enterPanel = new JPanel();

        var buttonConsulta = new JButton("Requerimiento 1");
        buttonConsulta.addActionListener(e -> cargarTablaConsulta());
        enterPanel.add(buttonConsulta);
        
        var buttonConsulta2 = new JButton("Requerimiento 2");
        buttonConsulta2.addActionListener(e -> cargarTablaConsulta2());
        enterPanel.add(buttonConsulta2);

        var buttonConsulta3 = new JButton("Requerimiento 3");
        buttonConsulta3.addActionListener(e -> cargarTablaConsulta3());
        enterPanel.add(buttonConsulta3);

        panel.add(enterPanel, BorderLayout.PAGE_START);
        
        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void cargarTablaConsulta() {
        try {
            var lista = controlador.consultarRequerimiento1();
            var tableModel = new Requerimiento1TableModel();

            tableModel.setData(lista);
            tabla.setModel(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento1TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_1> data;

        public void setData(ArrayList<Requerimiento_1> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0:
                    return "Nombre Material";
                case 1:
                    return "Precio por Unidad";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch(columnIndex){
                case 0:
                    return registro.getNombreMaterial();
                case 1:
                    return registro.getPrecioUnidad();
            }
            return null;
        }
    }

    private void cargarTablaConsulta2() {
        try {
            var lista = controlador.consultarRequerimiento2();
            var tableModel = new Requerimiento2TableModel();

            tableModel.setData(lista);
            tabla.setModel(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento2TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_2> data;

        public void setData(ArrayList<Requerimiento_2> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0:
                    return "Constructora";
                case 1:
                    return "Ciudad";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch(columnIndex){
                case 0:
                    return registro.getConstructora();
                case 1:
                    return registro.getCiudad();
            }
            return null;
        }
    }

    private void cargarTablaConsulta3() {
        try {
            var lista = controlador.consultarRequerimiento3();
            var tableModel = new Requerimiento3TableModel();

            tableModel.setData(lista);
            tabla.setModel(tableModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento3TableModel extends AbstractTableModel{
        private ArrayList<Requerimiento_3> data;

        public void setData(ArrayList<Requerimiento_3> data) {
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {
            switch(column){
                case 0:
                    return "Proveedor";
                case 1:
                    return "Nombre Material";
                case 2:
                    return "Importado";
                case 3:
                    return "Precio Unidad";
                case 4:
                    return "Cantidad";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);

            switch(columnIndex){
                case 0:
                    return registro.getProveedor();
                case 1:
                    return registro.getNombreMaterial();
                case 2:
                    return registro.getImportado();
                case 3:
                    return registro.getPrecioUnidad();
                case 4:
                    return registro.getCantidad();
            }
            return null;
        }
    }

    
   
}