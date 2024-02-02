/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author estrosebas
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class conexiones {
   private static final String DIRECTORIO_MATRICULAS = "C:\\matriculas";
   private static final String ARCHIVO_CONFIG = DIRECTORIO_MATRICULAS + "\\config.txt"; // Ruta al archivo de configuración

    Connection conexion;

    public conexiones() {
        try {
            // Verificar y crear el directorio si no existe
            verificarCrearDirectorio();

            String eleccion = leerOpcionConexionDesdeArchivo();
            if (eleccion == null) {
                // Si no se encuentra la opción, establecer la conexión por defecto a servidor y escribir en el archivo
                eleccion = "servidor";
                System.out.println("usando version servidor");
                escribirOpcionConexion(eleccion);
            }
            establecerConexionSegunOpcion(eleccion);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void verificarCrearDirectorio() {
        Path path = FileSystems.getDefault().getPath(DIRECTORIO_MATRICULAS);
        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace(); // Manejo adecuado de excepciones
            }
        }
    }

    private void establecerConexionSegunOpcion(String eleccion) {
        try {
            switch (eleccion) {
                case "local":
                    // Configurar para conexión local
                    conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculas", "root", "");
                    break;
                case "servidor":
                    // Configurar para conexión al servidor
                    conexion = DriverManager.getConnection("jdbc:mysql://bxzafa0u3qliscp3gxtn-mysql.services.clever-cloud.com:3306/bxzafa0u3qliscp3gxtn", "uxmrkfdlbcdtt2la", "kUNzLZadxm8gAy3ZRm5c");
                    break;
                // Otros casos según necesidad
            }
        } catch (SQLException e) {
            e.printStackTrace(); // O manejo adecuado de excepciones
            JOptionPane.showMessageDialog(null, "Error al hacer la conexión", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String leerOpcionConexionDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_CONFIG))) {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones
            return null; // Retorna null si no se puede leer el archivo
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    // Método para cambiar a la conexión local
    public void cambiarLocal() {
        escribirOpcionConexion("local");
        establecerConexionSegunOpcion("local");
    }

    // Método para cambiar a la conexión del servidor
    public void cambiarServidor() {
        escribirOpcionConexion("servidor");
        establecerConexionSegunOpcion("servidor");
    }

    // Método privado para escribir la opción de conexión en el archivo
    private void escribirOpcionConexion(String eleccion) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_CONFIG))) {
            bw.write(eleccion);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo adecuado de excepciones
        }
    }
    public boolean verificarConexionLocal() {
        try {
            // Intentar establecer conexión local sin realmente conectarse
            DriverManager.getConnection("jdbc:mysql://localhost:3306/matriculas", "root", "").close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
