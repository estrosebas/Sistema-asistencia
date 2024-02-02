/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Entidad.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javax.swing.JOptionPane;
import Entidad.Asistencia;
import Entidad.Telefono;

/**
 *
 * @author estrosebas
 */
public class AsistenciaDAO {

    private final conexiones conexionDB;

    public AsistenciaDAO() {
        conexionDB = new conexiones();
    }

    public boolean marcarAsistencia(Asistencia asistencia) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "INSERT INTO asistencia(id_alumno, fecha, llegada_temprano) VALUES (?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, asistencia.getId_alumno());
            ps.setDate(2, new java.sql.Date(asistencia.getFecha_hora().getTime()));
            ps.setBoolean(3, asistencia.getLlegada_temprano());

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Asistencia> obtenerAsistenciaPorDNI(int dni) {
        List<Asistencia> asistencias = new ArrayList<>();

        try {
            AlumnoDAO alumDAO = new AlumnoDAO();
            Alumno alu = alumDAO.buscarAlumnoPorDni(dni);
            if (alu != null) {
                int id_alu = alu.getId_Alumno();

                Connection conexion = conexionDB.getConnection();
                String query = "SELECT * FROM asistencia WHERE id_Alumno = ?";
                PreparedStatement ps = conexion.prepareStatement(query);
                ps.setInt(1, id_alu);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int idAsistencia = rs.getInt("id_asistencia");
                    int idAlumno = rs.getInt("id_alumno");
                    Date fechaHoraAsistencia = rs.getDate("fecha");
                    Boolean llegadaTemprano = rs.getBoolean("llegada_temprano");

                    Asistencia asistencia = new Asistencia(idAsistencia, idAlumno, fechaHoraAsistencia, llegadaTemprano, Integer.toString(dni));
                    asistencias.add(asistencia);
                }

                conexion.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return asistencias;
    }

    public boolean actualizarEstadoAsistencia(int idAsistencia, Boolean nuevaLlegadaTemprano) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "UPDATE asistencia SET llegada_temprano=? WHERE id_asistencia=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setBoolean(1, nuevaLlegadaTemprano);
            ps.setInt(2, idAsistencia);

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarAsistencia(int idAsistencia) {
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "DELETE FROM asistencia WHERE id_asistencia=?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idAsistencia);

            int res = ps.executeUpdate();
            conexion.close();
            return res > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Asistencia buscarAsistenciaPorId(int idAsistencia) {
        Asistencia asistencia = null;
        try {
            Connection conexion = conexionDB.getConnection();
            String query = "SELECT * FROM asistencia WHERE id_asistencia = ?";
            PreparedStatement ps = conexion.prepareStatement(query);

            ps.setInt(1, idAsistencia);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                boolean llegada = rs.getBoolean("llegada_temprano");
                asistencia = new Asistencia(llegada);
            }

            conexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return asistencia;
    }

}
