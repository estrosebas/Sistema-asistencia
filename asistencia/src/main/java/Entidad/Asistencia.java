/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import java.sql.Date;

/**
 *
 * @author estrosebas
 */
public class Asistencia {
    private int id_asistencia;
    private int id_alumno;
    private Date fecha_hora;
    private Boolean llegada_temprano;
    private String dni;
    private String nom;
    private String apeP;
    private String apeM;
    public Asistencia() {
    }

    public Asistencia(int id_alumno, Date fecha_hora, Boolean llegada_temprano) {
        this.id_alumno = id_alumno;
        this.fecha_hora = fecha_hora;
        this.llegada_temprano = llegada_temprano;
    }

    public Asistencia(int id_asistencia, int id_alumno, Date fecha_hora, Boolean llegada_temprano) {
        this.id_asistencia = id_asistencia;
        this.id_alumno = id_alumno;
        this.fecha_hora = fecha_hora;
        this.llegada_temprano = llegada_temprano;
    }

    public Asistencia(Boolean llegada_temprano) {
        this.llegada_temprano = llegada_temprano;
    }

    public Asistencia(int id_asistencia, int id_alumno, Date fecha_hora, Boolean llegada_temprano, String dni) {
        this.id_asistencia = id_asistencia;
        this.id_alumno = id_alumno;
        this.fecha_hora = fecha_hora;
        this.llegada_temprano = llegada_temprano;
        this.dni = dni;
    }

    public Asistencia(int id_asistencia, Date fecha_hora, String dni, String nom, String apeP, String apeM) {
        this.id_asistencia = id_asistencia;
        this.fecha_hora = fecha_hora;
        this.dni = dni;
        this.nom = nom;
        this.apeP = apeP;
        this.apeM = apeM;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApeP() {
        return apeP;
    }

    public void setApeP(String apeP) {
        this.apeP = apeP;
    }

    public String getApeM() {
        return apeM;
    }

    public void setApeM(String apeM) {
        this.apeM = apeM;
    }
    
    public int getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(int id_asistencia) {
        this.id_asistencia = id_asistencia;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Boolean getLlegada_temprano() {
        return llegada_temprano;
    }

    public void setLlegada_temprano(Boolean llegada_temprano) {
        this.llegada_temprano = llegada_temprano;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "id_asistencia=" + id_asistencia + ", id_alumno=" + id_alumno + ", fecha_hora=" + fecha_hora + ", llegada_temprano=" + llegada_temprano + '}';
    }
    
}
