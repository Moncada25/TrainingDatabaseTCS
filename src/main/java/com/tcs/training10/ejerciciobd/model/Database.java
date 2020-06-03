package com.tcs.training10.ejerciciobd.model;

import static java.sql.DriverManager.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Database {

  private static Connection connection;
  private static Statement statement;
  private static PreparedStatement preparedStatement;

  protected static boolean Connect() {

    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = getConnection("jdbc:mysql://localhost:3306/personal?serverTimezone=UTC", "root",
          "");

      return true;

    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return false;
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return false;
  }

  protected static void Disconnect() {

    try {

        if (connection != null) {
            connection.close();
        }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  protected static boolean createTableDepartamento() {

    try {

      if (Connect()) {

        String query = "CREATE TABLE IF NOT EXISTS `departamento` (\n" +
            "\n" +
            "  `clave_depto` int NOT NULL,   \n" +
            "  `nombre` varchar(30),       \n" +
            "  `presupuesto` int,     \n" +
            "   PRIMARY KEY  (`clave_depto`)\n" +
            "\n" +
            ");";

        statement = connection.createStatement();
        statement.execute(query);

        return true;
      }

    } catch (SQLException e) {
      return false;
    } finally {
      Disconnect();
    }

    return false;
  }

  protected static boolean createTableEmpleado() {

    try {

      if (Connect()) {

        String query = "CREATE TABLE IF NOT EXISTS `empleado` (\n" +
            "\n" +
            "  `clave_empleado` varchar(8) NOT NULL,   \n" +
            "  `nombre` varchar(30),       \n" +
            "  `apellidos` varchar(30) ,     \n" +
            "  `clave_depto`  int NOT NULL,     \n" +
            "   PRIMARY KEY  (`clave_empleado`)\n" +
            "\n" +
            ");";

        statement = connection.createStatement();

        statement.execute(query);

        createForeignKey();

        return true;
      }

    } catch (SQLException e) {
      return false;
    } finally {
      Disconnect();
    }

    return false;
  }

  protected static void createForeignKey() {

    try {

      if (Connect()) {

        statement = connection.createStatement();
        statement.execute(
            "ALTER TABLE empleado ADD FOREIGN KEY(clave_depto) REFERENCES departamento (clave_depto)");

      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      Disconnect();
    }
  }

  protected static boolean insertDepartamento(Departamento departamento) {

    try {

      if (Connect()) {

        preparedStatement = connection.prepareStatement(
            "INSERT INTO DEPARTAMENTO (clave_depto, nombre, presupuesto) VALUES (?,?,?)");
        preparedStatement.setInt(1, departamento.getClave_depto());
        preparedStatement.setString(2, departamento.getNombre());
        preparedStatement.setInt(3, departamento.getPresupueto());
        preparedStatement.execute();

        return true;
      }

    } catch (SQLException e) {
      return false;
    } finally {
      Disconnect();
    }

    return false;
  }

  protected static boolean insertEmpleado(Empleado empleado) {

    try {

      if (Connect()) {

        preparedStatement = connection.prepareStatement(
            "INSERT INTO EMPLEADO (clave_empleado, nombre, apellidos, clave_depto) VALUES (?,?,?,?)");
        preparedStatement.setString(1, empleado.getClave_empleado());
        preparedStatement.setString(2, empleado.getNombre());
        preparedStatement.setString(3, empleado.getApellidos());
        preparedStatement.setInt(4, empleado.getClave_depto());
        preparedStatement.execute();

        return true;
      }

    } catch (SQLException e) {
      return false;
    } finally {
      Disconnect();
    }

    return false;
  }

  protected static boolean importTable(JTable table, String query) {

    try {

      if (Connect()) {

        preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        ArrayList<Object[]> data = new ArrayList<>();

        while (resultSet.next()) {

          Object[] filas = new Object[resultSetMetaData.getColumnCount()];

            for (int i = 0; i < filas.length; i++) {
                filas[i] = resultSet.getObject(i + 1);
            }
          data.add(filas);
        }

        if (data.isEmpty()) {
          return false;
        } else {

          DefaultTableModel modelo = (DefaultTableModel) table.getModel();

            for (Object[] datum : data) {
                modelo.addRow(datum);
            }

          return true;
        }
      }

    } catch (SQLException e) {
      return false;
    } finally {
      Disconnect();
    }

    return false;
  }
}