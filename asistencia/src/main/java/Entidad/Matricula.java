/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author estrosebas
 */
public class Matricula {
    private int id_Matricula;
    private int id_Alumno;
    private String nivel_m;
    private int grado_m;
    private String estado_m;
    private String metodo_Pago;
    private Double monto_Pago;
    private String observaciones;
    private String id_Usuario;

    public Matricula(int id_Matricula, int id_Alumno, String nivel_m, int grado_m, String estado_m, String metodo_Pago, Double monto_Pago, String observaciones, String id_Usuario) {
        this.id_Matricula = id_Matricula;
        this.id_Alumno = id_Alumno;
        this.nivel_m = nivel_m;
        this.grado_m = grado_m;
        this.estado_m = estado_m;
        this.metodo_Pago = metodo_Pago;
        this.monto_Pago = monto_Pago;
        this.observaciones = observaciones;
        this.id_Usuario = id_Usuario;
    }

    public Matricula(int id_Alumno, String nivel_m, int grado_m, String estado_m, String metodo_Pago, Double monto_Pago, String observaciones, String id_Usuario) {
        this.id_Alumno = id_Alumno;
        this.nivel_m = nivel_m;
        this.grado_m = grado_m;
        this.estado_m = estado_m;
        this.metodo_Pago = metodo_Pago;
        this.monto_Pago = monto_Pago;
        this.observaciones = observaciones;
        this.id_Usuario = id_Usuario;
    }

    public Matricula() {
    }

    public int getId_Matricula() {
        return id_Matricula;
    }

    public void setId_Matricula(int id_Matricula) {
        this.id_Matricula = id_Matricula;
    }

    public int getId_Alumno() {
        return id_Alumno;
    }

    public void setId_Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public String getNivel_m() {
        return nivel_m;
    }

    public void setNivel_m(String nivel_m) {
        this.nivel_m = nivel_m;
    }

    public int getGrado_m() {
        return grado_m;
    }

    public void setGrado_m(int grado_m) {
        this.grado_m = grado_m;
    }

    public String getEstado_m() {
        return estado_m;
    }

    public void setEstado_m(String estado_m) {
        this.estado_m = estado_m;
    }

    public String getMetodo_Pago() {
        return metodo_Pago;
    }

    public void setMetodo_Pago(String metodo_Pago) {
        this.metodo_Pago = metodo_Pago;
    }

    public Double getMonto_Pago() {
        return monto_Pago;
    }

    public void setMonto_Pago(Double monto_Pago) {
        this.monto_Pago = monto_Pago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }
    
}
