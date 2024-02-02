/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author estrosebas
 */
import java.util.Date;

public class Alumno extends Persona {

    private int id_Alumno;
    private int dni_Alumno;
    private String nom_Alu;
    private String ape_PAl;
    private String ape_MAl;
    private Date fec_Nac;
    private int id_distritoAlum;
    private String nivel_ing;
    private int grado_ing;
    private String colegio_ant;
    private int id_habilidad;
    private int id_Repre;
    private String relacion;

    public Alumno(int id_Alumno, int dni_Alumno, String nom_Alu, String ape_PAl, String ape_MAl, Date fec_Nac, String sexo, int id_distritoAlum, String domicilio, String nivel_ing, int grado_ing, String colegio_ant, int id_habilidad, int id_Repre, String relacion) {
        super(sexo, domicilio);
        this.id_Alumno = id_Alumno;
        this.dni_Alumno = dni_Alumno;
        this.nom_Alu = nom_Alu;
        this.ape_PAl = ape_PAl;
        this.ape_MAl = ape_MAl;
        this.fec_Nac = fec_Nac;
        this.sexo = sexo;
        this.id_distritoAlum = id_distritoAlum;
        this.domicilio = domicilio;
        this.nivel_ing = nivel_ing;
        this.grado_ing = grado_ing;
        this.colegio_ant = colegio_ant;
        this.id_habilidad = id_habilidad;
        this.id_Repre = id_Repre;
        this.relacion = relacion;
    }

    public Alumno(int dni_Alumno, String nom_Alu, String ape_PAl, String ape_MAl, Date fec_Nac, String sexo, int id_distritoAlum, String domicilio, String nivel_ing, int grado_ing, String colegio_ant, int id_habilidad, int id_Repre, String relacion) {
        this.dni_Alumno = dni_Alumno;
        this.nom_Alu = nom_Alu;
        this.ape_PAl = ape_PAl;
        this.ape_MAl = ape_MAl;
        this.fec_Nac = fec_Nac;
        this.sexo = sexo;
        this.id_distritoAlum = id_distritoAlum;
        this.domicilio = domicilio;
        this.nivel_ing = nivel_ing;
        this.grado_ing = grado_ing;
        this.colegio_ant = colegio_ant;
        this.id_habilidad = id_habilidad;
        this.id_Repre = id_Repre;
        this.relacion = relacion;
    }

    public Alumno() {
    }

    public int getId_Alumno() {
        return id_Alumno;
    }

    public void setId_Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public int getDni_Alumno() {
        return dni_Alumno;
    }

    public void setDni_Alumno(int dni_Alumno) {
        this.dni_Alumno = dni_Alumno;
    }

    public String getNom_Alu() {
        return nom_Alu;
    }

    public void setNom_Alu(String nom_Alu) {
        this.nom_Alu = nom_Alu;
    }

    public String getApe_PAl() {
        return ape_PAl;
    }

    public void setApe_PAl(String ape_PAl) {
        this.ape_PAl = ape_PAl;
    }

    public String getApe_MAl() {
        return ape_MAl;
    }

    public void setApe_MAl(String ape_MAl) {
        this.ape_MAl = ape_MAl;
    }

    public Date getFec_Nac() {
        return fec_Nac;
    }

    public void setFec_Nac(Date fec_Nac) {
        this.fec_Nac = fec_Nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId_distritoAlum() {
        return id_distritoAlum;
    }

    public void setId_distritoAlum(int id_distritoAlum) {
        this.id_distritoAlum = id_distritoAlum;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNivel_ing() {
        return nivel_ing;
    }

    public void setNivel_ing(String nivel_ing) {
        this.nivel_ing = nivel_ing;
    }

    public int getGrado_ing() {
        return grado_ing;
    }

    public void setGrado_ing(int grado_ing) {
        this.grado_ing = grado_ing;
    }

    public String getColegio_ant() {
        return colegio_ant;
    }

    public void setColegio_ant(String colegio_ant) {
        this.colegio_ant = colegio_ant;
    }

    public int getId_habilidad() {
        return id_habilidad;
    }

    public void setId_habilidad(int id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    public int getId_Repre() {
        return id_Repre;
    }

    public void setId_Repre(int id_Repre) {
        this.id_Repre = id_Repre;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id_Alumno=" + id_Alumno + ", dni_Alumno=" + dni_Alumno + ", nom_Alu=" + nom_Alu + ", ape_PAl=" + ape_PAl + ", ape_MAl=" + ape_MAl + ", fec_Nac=" + fec_Nac + ", id_distritoAlum=" + id_distritoAlum + ", nivel_ing=" + nivel_ing + ", grado_ing=" + grado_ing + ", colegio_ant=" + colegio_ant + ", id_habilidad=" + id_habilidad + ", id_Repre=" + id_Repre + ", relacion=" + relacion + '}';
    }

}
