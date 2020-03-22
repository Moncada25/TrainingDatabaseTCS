package com.tcs.training10.ejerciciobd.controller;

import com.tcs.training10.ejerciciobd.model.DataTable;
import com.tcs.training10.ejerciciobd.model.Database;
import com.tcs.training10.ejerciciobd.model.Departamento;
import com.tcs.training10.ejerciciobd.model.Empleado;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Cursor;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller extends Database {

    protected static final Color AZUL = new Color(21, 87, 163);
    protected static final Color ROJO = new Color(220, 12, 12);
    protected static final Font TEXT = new Font("Times New Roman", Font.BOLD, 20);
    protected static final Border BORDER = BorderFactory.createLineBorder(AZUL, 2, false);
    private static final Border BORDER2 = BorderFactory.createLineBorder(ROJO, 2, false);

    protected static JPanel getPanel(JFrame parent) {
        JPanel jPanel = new JPanel(new FlowLayout());
        jPanel.setBorder(getBorder());

        JLabel create = getLabel(" Create ", AZUL, jPanel, TEXT);
        create.setBorder(BORDER);
        create.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                createClicked(parent);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                create.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JLabel read = getLabel(" Read ", AZUL, jPanel, TEXT);
        read.setBorder(BORDER);
        read.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                readClicked(parent);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                read.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JLabel consult = getLabel(" Consult ", AZUL, jPanel, TEXT);
        consult.setBorder(BORDER);
        consult.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.setVisible(false);
                consultClicked(parent);
                parent.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                consult.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JLabel exit = getLabel(" Exit ", ROJO, jPanel, TEXT);
        exit.setBorder(BORDER2);
        exit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.setVisible(false);
                JOptionPane.showMessageDialog(null, "<html>" + getStyle() + "<h3>Goodbye</h3></html>", "Process Finished",
                        JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        return jPanel;
    }

    private static JLabel getLabel(String text, Color color, Container container, Font font) {

        JLabel jLabel = new JLabel(text);
        jLabel.setForeground(color);
        jLabel.setFont(font);
        container.add(jLabel);

        return jLabel;
    }

    private static Border getBorder() {

        TitledBorder border = BorderFactory.createTitledBorder(BORDER, "Select a option");
        border.setTitleColor(ROJO);
        border.setTitleFont(TEXT);
        border.setTitleJustification(TitledBorder.CENTER);

        return border;
    }

    protected static String getStyle() {
        return ""
                + "<style type='text/css'>"
                + "	h1{"
                + "		color: rgb(220, 70, 50);"
                + "		font-size: 17px;"
                + "		font-family: Times New Roman;"
                + "		font-style: italic;"
                + "		border: 3px groove red;"
                + "        border-top: none;"
                + "        border-left: none;"
                + "        border-right: none;"
                + "		 text-align: center;"
                + "        padding: 3px;"
                + "	}"
                + ""
                + "	h2{"
                + "		color: rgb(220, 70, 50);"
                + "		font-size: 15px;"
                + "		font-family: Times New Roman;"
                + "		font-style: italic;"
                + "		text-align: center;"
                + "	}"
                + ""
                + "	h3{"
                + "		color: rgb(21, 87, 163);"
                + "		font-size: 14px;"
                + "		font-family: Times New Roman;"
                + "		font-style: italic;"
                + "	}"
                + "</style>";
    }

    private static void createClicked(JFrame parent) {

        if (createTableDepartamento() && createTableEmpleado() && fillTables()) {
            JOptionPane.showMessageDialog(parent, "<html>" + getStyle() + "<h3>Tables created</h3></html>", "Success", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(parent, "<html>" + getStyle() + "<h2>Tables already created</h2></html>", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private static boolean fillTables() {

        String[][] dataE = {
                {"EMP01", "Armando", "López", "2"},
                {"EMP02", "Tatiana", "Vargas", "1"},
                {"EMP03", "Laura", "Iturria", "3"},
                {"EMP04", "Juan", "Pérez", "4"},
                {"EMP05", "Iván", "López", "4"},
                {"EMP06", "Margarita", "Hernández", "1"},
                {"EMP07", "Jesús", "Pérez", "3"},
                {"EMP08", "Tonatiuh", "Flores", "2"},
                {"EMP09", "Juan", "López", "4"},
                {"EMP10", "José", "Hernández", "5"}};

        String[][] dataD = {
                {"1", "Personal", "80000"},
                {"2", "Almacén", "70000"},
                {"3", "Contabilidad", "60000"},
                {"4", "Manufactura", "50000"},
                {"5", "Empaque", "30000"}};

        Empleado empleado;
        Departamento departamento;

        for (int i = 0; i < dataD.length; i++) {
            departamento = new Departamento(Integer.parseInt(dataD[i][0]), dataD[i][1], Integer.parseInt(dataD[i][2]));
            if (!insertDepartamento(departamento))
                return false;
        }

        for (int j = 0; j < dataE.length; j++) {
            empleado = new Empleado(dataE[j][0], dataE[j][1], dataE[j][2], Integer.parseInt(dataE[j][3]));
            if (!insertEmpleado(empleado))
                return false;
        }

        return true;
    }

    private static void readClicked(JFrame parent) {

        Object opcion;

        opcion = JOptionPane.showInputDialog(parent, "<html>" + getStyle() + "<h3>Select a table</h3></html>", "Read information", JOptionPane.PLAIN_MESSAGE, null,
                new Object[]{"Departamento", "Empleado"}, "Departamento");

        if (opcion != null) {

            if (opcion.toString().equals("Departamento")) {

                String[] columnsD = {"Clave", "Nombre", "Presupuesto"};
                String queryD = "SELECT * FROM DEPARTAMENTO";
                showTable(columnsD, queryD, parent, "Departamentos");
                parent.setVisible(true);

            } else if (opcion.toString().equals("Empleado")) {

                String[] columnsE = {"Clave Empleado", "Nombre", "Apellidos", "Clave Depto"};
                String queryE = "SELECT * FROM EMPLEADO";
                showTable(columnsE, queryE, parent, "Empleados");
                parent.setVisible(true);
            }
        }
    }

    private static void showTable(String[] columns, String query, JFrame parent, String title) {

        DataTable dataTable = new DataTable(parent, true, columns);
        DataTable.cleanTable((DefaultTableModel) dataTable.table.getModel());

        if (importTable(dataTable.table, query)) {

            dataTable.setSize(900, 250);
            dataTable.setResizable(false);
            dataTable.setLocationRelativeTo(null);
            dataTable.setTitle(title);
            parent.setVisible(false);
            dataTable.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(parent, "<html>" + getStyle() + "<h2>Empty table</h2></html>", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private static void consultClicked(JFrame parent) {

        int opcion;
        String query;

        String menu = ""
                + "<html>" + getStyle()
                + "	<h1>Consultas disponibles</h1>"
                + "	<h3>"
                + "		1. Nombres y apellidos de los empleados. <br>"
                + "		2. Apellidos de los empleados sin repetir. <br>"
                + "		3. Datos de los empleados que se apellidan 'lópez'. <br>"
                + "		4. Datos de los empleados que se apellidan 'lópez' y 'pérez'. <br>"
                + "		5. Nombre y clave de los empleados del departamento 4. <br>"
                + "		6. Datos de los empleados del departamento 1 ó 3 ordenados por nombre. <br>"
                + "        7. Nombre y apellidos de los empleados con apellido iniciado en 'H'. <br>"
                + "         8. Datos de los departamentos cuyo presupuesto esté entre $50,000 y $70,000. <br>"
                + "         9. Clave de empleado, nombre y apellidos de los empleados del departamento de contabilidad. <br>"
                + "         10. Nombre y apellidos, junto con el nombre de su departamento, de todos los empleados. <br>"
                + "         11. Volver."
                + "	</h3>"
                + "</html>";

        do try {

            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu, "Consultar", JOptionPane.PLAIN_MESSAGE));

            switch (opcion) {

                case 1:

                    query = "SELECT nombre, apellidos FROM EMPLEADO";

                    showTable(new String[]{"Nombre", "Apellidos"}, query, parent, "Resultado");

                    break;

                case 2:

                    query = "SELECT DISTINCT apellidos FROM EMPLEADO ";

                    showTable(new String[]{"Apellidos"}, query, parent, "Resultado");

                    break;

                case 3:

                    query = "SELECT * FROM EMPLEADO WHERE apellidos = 'López'";

                    showTable(new String[]{"Clave Empleado", "Nombre", "Apellidos", "Clave Depto"}, query, parent, "Resultado");

                    break;

                case 4:

                    query = "SELECT * FROM EMPLEADO WHERE apellidos IN('López','Pérez')";

                    showTable(new String[]{"Clave Empleado", "Nombre", "Apellidos", "Clave Depto"}, query, parent, "Resultado");

                    break;

                case 5:

                    query = "SELECT clave_empleado, nombre FROM EMPLEADO WHERE clave_depto = 4";

                    showTable(new String[]{"Clave Empleado", "Nombre"}, query, parent, "Resultado");

                    break;

                case 6:

                    query = "SELECT * FROM EMPLEADO WHERE clave_depto IN(1, 3) ORDER BY nombre ASC";

                    showTable(new String[]{"Clave Empleado", "Nombre", "Apellidos", "Clave Depto"}, query, parent, "Resultado");

                    break;

                case 7:

                    query = "SELECT nombre, apellidos FROM EMPLEADO WHERE apellidos LIKE 'H%'";

                    showTable(new String[]{"Nombre", "Apellidos"}, query, parent, "Resultado");

                    break;

                case 8:

                    query = "SELECT * FROM DEPARTAMENTO WHERE presupuesto BETWEEN 50000 AND 70000";

                    showTable(new String[]{"Clave Depto", "Nombre", "Presupuesto"}, query, parent, "Resultado");

                    break;

                case 9:

                    query = "SELECT E.clave_empleado, E.nombre, E.apellidos FROM EMPLEADO E \n" +
                            "INNER JOIN DEPARTAMENTO D \n" +
                            "ON E.clave_depto = D.clave_depto\n" +
                            "WHERE D.nombre = 'Contabilidad'";

                    showTable(new String[]{"Clave Empleado", "Nombre", "Apellidos"}, query, parent, "Resultado");

                    break;

                case 10:

                    query = "SELECT E.nombre, E.apellidos, D.nombre FROM EMPLEADO E INNER JOIN DEPARTAMENTO D ON E.clave_depto = D.clave_depto";

                    showTable(new String[]{"Nombre", "Apellidos", "Departamento"}, query, parent, "Resultado");

                    break;

                case 11:
                    opcion = 0;
                    break;

                default:

                    JOptionPane.showMessageDialog(null, "<html>" + getStyle() + "<h2>Consulta no disponible</h2></html>", "Error", JOptionPane.PLAIN_MESSAGE);
                    opcion = 2;

                    break;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "<html>" + getStyle() + "<h2>Ingrese un caracter numérico</h2></html>", "Error", JOptionPane.PLAIN_MESSAGE);
            opcion = 2;
        } while (opcion > 0 && opcion < 11);

        parent.setVisible(true);
    }
}