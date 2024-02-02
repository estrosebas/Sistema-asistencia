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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Entidad.Representante;

public class RepresentanteDAO {

    private final conexiones conexionDB;

    public RepresentanteDAO() {
        conexionDB = new conexiones();
    }

    public boolean insertar(Representante representante) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "INSERT INTO representante(dni_Repre, nom_Repre, ape_PRe, ape_MRe, sexo, id_distritoR,domicilio, ocupacion, lugar_traba, correo, id_telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, representante.getDni_Repre());
            ps.setString(2, representante.getNom_Repre());
            ps.setString(3, representante.getApe_PRe());
            ps.setString(4, representante.getApe_MRe());
            ps.setString(5, representante.getSexo());
            ps.setInt(6, representante.getId_distritoR());
            ps.setString(7, representante.getDomicilio());
            ps.setString(8, representante.getOcupacion());
            ps.setString(9, representante.getLugar_traba());
            ps.setString(10, representante.getCorreo());
            ps.setInt(11, representante.getId_telefono());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Representante> obtenerTodosLosRepresentantes() {
        List<Representante> representantes = new ArrayList<>();
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM representante";
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Obteniendo los valores en variables locales
                int id_Repre = rs.getInt("id_Repre");
                int dni_Repre = rs.getInt("dni_Repre");
                String nom_Repre = rs.getString("nom_Repre");
                String ape_PRe = rs.getString("ape_PRe");
                String ape_MRe = rs.getString("ape_MRe");
                String sexo = rs.getString("sexo");
                int id_distritoR = rs.getInt("id_distritoR"); // Asegúrate de que esto es correcto según tu base de datos
                String domicilio = rs.getString("domicilio");
                String ocupacion = rs.getString("ocupacion"); // Esto parece ser una cadena según el error previo
                String lugar_traba = rs.getString("lugar_traba");
                String correo = rs.getString("correo");
                int id_telefono = rs.getInt("id_telefono");

// Creando una nueva instancia de representante usando las variables locales
                Representante representante = new Representante(id_Repre, dni_Repre, nom_Repre, ape_PRe, ape_MRe, sexo, id_distritoR, domicilio, ocupacion, lugar_traba, correo, id_telefono);

                representantes.add(representante);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return representantes;
    }

    public Representante buscarRepresentantePorDni(int dni) {
        Representante representante = null;

        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM representante WHERE dni_Repre = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Obteniendo los valores en variables locales
                int id_Repre = rs.getInt("id_Repre");
                int dni_Repre = rs.getInt("dni_Repre");
                String nom_Repre = rs.getString("nom_Repre");
                String ape_PRe = rs.getString("ape_PRe");
                String ape_MRe = rs.getString("ape_MRe");
                String sexo = rs.getString("sexo");
                int id_distritoR = rs.getInt("id_distritoR");
                String domicilio = rs.getString("domicilio");
                String ocupacion = rs.getString("ocupacion");
                String lugar_traba = rs.getString("lugar_traba");
                String correo = rs.getString("correo");
                int id_telefono = rs.getInt("id_telefono");

                // Creando una nueva instancia de Representante usando las variables locales
                representante = new Representante(id_Repre, dni_Repre, nom_Repre, ape_PRe, ape_MRe, sexo, id_distritoR, domicilio, ocupacion, lugar_traba, correo, id_telefono);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return representante;
    }

    public boolean modificar(Representante representante) {
        try {
            Connection conexion = conexionDB.getConnection();
            // Ajusta la consulta para que coincida con la estructura de la tabla y los campos del representante
            String query = "UPDATE representante SET dni_Repre=?, nom_Repre=?, ape_PRe=?, ape_MRe=?, sexo=?, id_distritoR=?, domicilio=?, ocupacion=?, lugar_traba=?, correo=?, id_telefono=? WHERE id_Repre=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            // Configura los parámetros del PreparedStatement de acuerdo con los atributos de Representante
            ps.setInt(1, representante.getDni_Repre());
            ps.setString(2, representante.getNom_Repre());
            ps.setString(3, representante.getApe_PRe());
            ps.setString(4, representante.getApe_MRe());
            ps.setString(5, representante.getSexo());
            ps.setInt(6, representante.getId_distritoR());
            ps.setString(7, representante.getDomicilio());
            ps.setString(8, representante.getOcupacion());
            ps.setString(9, representante.getLugar_traba());
            ps.setString(10, representante.getCorreo());
            ps.setInt(11, representante.getId_telefono());
            ps.setInt(12, representante.getId_Repre()); // Asegúrate de que este es el campo correcto para WHERE

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int dniRepresentante) {
        try {
            Connection conexion = conexionDB.getConnection();
            // Cambia la tabla y la columna a las que corresponde el representante
            String query = "DELETE FROM representante WHERE dni_Repre=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            // Establece el DNI del representante para eliminar
            ps.setInt(1, dniRepresentante);

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {  // Código de error para violación de llave foránea
                // Manejar específicamente la violación de la llave foránea
                System.out.println("No se puede eliminar el representante porque está asociado con otros registros.");
                JOptionPane.showMessageDialog(null, "Error al eliminar, el representante está asociado con otros registros.");
            } else {
                // Otros errores SQL
                e.printStackTrace();
            }
            return false;
        }
    }

}
