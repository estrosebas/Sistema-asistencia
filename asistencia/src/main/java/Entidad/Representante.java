/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author estrosebas
 */
public class Representante extends Persona{
    private int id_Repre;
    private int dni_Repre;
    private String nom_Repre;
    private String ape_PRe;
    private String ape_MRe;
    private int id_distritoR;
    private String ocupacion;
    private String lugar_traba;
    private String correo;
    private int id_telefono;

    public Representante(int id_Repre, int dni_Repre, String nom_Repre, String ape_PRe, String ape_MRe, String sexo, int id_distritoR,String domicilio,String ocupacion ,String lugar_traba, String correo, int id_telefono) {
        super(sexo, domicilio);
        this.id_Repre = id_Repre;
        this.dni_Repre = dni_Repre;
        this.nom_Repre = nom_Repre;
        this.ape_PRe = ape_PRe;
        this.ape_MRe = ape_MRe;
        this.id_distritoR = id_distritoR;
        this.ocupacion = ocupacion;
        this.lugar_traba = lugar_traba;
        this.correo = correo;
        this.id_telefono = id_telefono;
    }

    public Representante(int dni_Repre, String nom_Repre, String ape_PRe, String ape_MRe, String sexo, int id_distritoR, String domicilio,String ocupacion, String lugar_traba, String correo, int id_telefono) {
        super(sexo, domicilio);
        this.dni_Repre = dni_Repre;
        this.nom_Repre = nom_Repre;
        this.ape_PRe = ape_PRe;
        this.ape_MRe = ape_MRe;
        this.id_distritoR = id_distritoR;
        this.ocupacion = ocupacion;
        this.lugar_traba = lugar_traba;
        this.correo = correo;
        this.id_telefono = id_telefono;
    }

    public int getId_Repre() {
        return id_Repre;
    }

    public void setId_Repre(int id_Repre) {
        this.id_Repre = id_Repre;
    }

    public int getDni_Repre() {
        return dni_Repre;
    }

    public void setDni_Repre(int dni_Repre) {
        this.dni_Repre = dni_Repre;
    }

    public String getNom_Repre() {
        return nom_Repre;
    }

    public void setNom_Repre(String nom_Repre) {
        this.nom_Repre = nom_Repre;
    }

    public String getApe_PRe() {
        return ape_PRe;
    }

    public void setApe_PRe(String ape_PRe) {
        this.ape_PRe = ape_PRe;
    }

    public String getApe_MRe() {
        return ape_MRe;
    }

    public void setApe_MRe(String ape_MRe) {
        this.ape_MRe = ape_MRe;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId_distritoR() {
        return id_distritoR;
    }

    public void setId_distritoR(int id_distritoR) {
        this.id_distritoR = id_distritoR;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getLugar_traba() {
        return lugar_traba;
    }

    public void setLugar_traba(String lugar_traba) {
        this.lugar_traba = lugar_traba;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
}
