package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.swing.JOptionPane;
import Entidad.Alumno;
public class AlumnoDAO {

    private final conexiones conexionDB;

    public AlumnoDAO() {
        conexionDB = new conexiones();
    }

    public boolean insertar(Alumno alumno) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "INSERT INTO alumno(dni_Alumno, nom_Alu, ape_PAl, ape_MAl, fec_Nac, sexo, id_distritoAlum, domicilio, nivel_ing, grado_ing, colegio_ant, id_habilidad, id_Repre, relacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, alumno.getDni_Alumno());
            ps.setString(2, alumno.getNom_Alu());
            ps.setString(3, alumno.getApe_PAl());
            ps.setString(4, alumno.getApe_MAl());
            ps.setDate(5, new java.sql.Date(alumno.getFec_Nac().getTime()));
            ps.setString(6, alumno.getSexo());
            ps.setInt(7, alumno.getId_distritoAlum());
            ps.setString(8, alumno.getDomicilio());
            ps.setString(9, alumno.getNivel_ing());
            ps.setInt(10, alumno.getGrado_ing());
            ps.setString(11, alumno.getColegio_ant());
            ps.setInt(12, alumno.getId_habilidad());
            ps.setInt(13, alumno.getId_Repre());
            ps.setString(14, alumno.getRelacion());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Alumno> obtenerTodosLosAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();

        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM alumno";
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // Obteniendo los valores en variables locales
                int id_Alumno = rs.getInt("id_Alumno");
                int dni_Alumno = rs.getInt("dni_Alumno");
                String nom_Alu = rs.getString("nom_Alu");
                String ape_PAl = rs.getString("ape_PAl");
                String ape_MAl = rs.getString("ape_MAl");
                Date fec_Nac = rs.getDate("fec_Nac");
                String sexo = rs.getString("sexo");
                int id_distritoAlum = rs.getInt("id_distritoAlum"); // Asegúrate de que esto es correcto según tu base de datos
                String domicilio = rs.getString("domicilio");
                String nivel_ing = rs.getString("nivel_ing"); // Esto parece ser una cadena según el error previo
                int grado_ing = rs.getInt("grado_ing");
                String colegio_ant = rs.getString("colegio_ant");
                int id_habilidad = rs.getInt("id_habilidad");
                int id_Repre = rs.getInt("id_Repre");
                String relacion = rs.getString("relacion");

// Creando una nueva instancia de Alumno usando las variables locales
                Alumno alumno = new Alumno(id_Alumno, dni_Alumno, nom_Alu, ape_PAl, ape_MAl, fec_Nac, sexo, id_distritoAlum, domicilio, nivel_ing, grado_ing, colegio_ant, id_habilidad, id_Repre, relacion);

                alumnos.add(alumno);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumnos;
    }

    public boolean modificar(Alumno alumno) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "UPDATE alumno SET dni_Alumno=?, nom_Alu=?, ape_PAl=?, ape_MAl=?, fec_Nac=?, sexo=?, id_distritoAlum=?, domicilio=?, nivel_ing=?, grado_ing=?, colegio_ant=?, id_habilidad=?, id_Repre=?, relacion=? WHERE id_Alumno=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, alumno.getDni_Alumno());
            ps.setString(2, alumno.getNom_Alu());
            ps.setString(3, alumno.getApe_PAl());
            ps.setString(4, alumno.getApe_MAl());
            ps.setDate(5, new java.sql.Date(alumno.getFec_Nac().getTime()));
            ps.setString(6, alumno.getSexo());
            ps.setInt(7, alumno.getId_distritoAlum());
            ps.setString(8, alumno.getDomicilio());
            ps.setString(9, alumno.getNivel_ing());
            ps.setInt(10, alumno.getGrado_ing());
            ps.setString(11, alumno.getColegio_ant());
            ps.setInt(12, alumno.getId_habilidad());
            ps.setInt(13, alumno.getId_Repre());
            ps.setString(14, alumno.getRelacion());
            ps.setInt(15, alumno.getId_Alumno());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int dni) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "DELETE FROM alumno WHERE dni_Alumno=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, dni);  // Asumiendo que DNI es un string, si es numérico, usa setInt

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {  // Código de error para violación de llave foránea
                // Manejar específicamente la violación de la llave foránea
                System.out.println("No se puede eliminar el alumno porque está matriculado.");
                JOptionPane.showMessageDialog(null, "Error al eliminar, el alumno esta matriculado");
            } else {
                // Otros errores SQL
                e.printStackTrace();
            }
            return false;
        }
    }

    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno alumno = null;

        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM alumno WHERE dni_Alumno = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Obteniendo los valores en variables locales
                int id_Alumno = rs.getInt("id_Alumno");
                int dni_Alumno = rs.getInt("dni_Alumno");
                String nom_Alu = rs.getString("nom_Alu");
                String ape_PAl = rs.getString("ape_PAl");
                String ape_MAl = rs.getString("ape_MAl");
                Date fec_Nac = rs.getDate("fec_Nac");
                String sexo = rs.getString("sexo");
                int id_distritoAlum = rs.getInt("id_distritoAlum");
                String domicilio = rs.getString("domicilio");
                String nivel_ing = rs.getString("nivel_ing");
                int grado_ing = rs.getInt("grado_ing");
                String colegio_ant = rs.getString("colegio_ant");
                int id_habilidad = rs.getInt("id_habilidad");
                int id_Repre = rs.getInt("id_Repre");
                String relacion = rs.getString("relacion");

                // Creando una nueva instancia de Alumno usando las variables locales
                alumno = new Alumno(id_Alumno, dni_Alumno, nom_Alu, ape_PAl, ape_MAl, fec_Nac, sexo, id_distritoAlum, domicilio, nivel_ing, grado_ing, colegio_ant, id_habilidad, id_Repre, relacion);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return alumno;
    }


}
