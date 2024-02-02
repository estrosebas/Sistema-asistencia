/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author estrosebas
 */
public class Login {
    private String id_Usuario;
    private String contra;
    private int id_admini;
    private String nombre;
    public Login(String id_Usuario, String contra, int id_admini) {
        this.id_Usuario = id_Usuario;
        this.contra = contra;
        this.id_admini = id_admini;
    }

    public Login(String id_Usuario, String contra) {
        this.id_Usuario = id_Usuario;
        this.contra = contra;
    }

    public Login(int id_admini, String nombre) {
        this.id_admini = id_admini;
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public Login(int id_admini) {
        this.id_admini = id_admini;
    }

    public int getId_admini() {
        return id_admini;
    }

    public void setId_admini(int id_admini) {
        this.id_admini = id_admini;
    }
    

    public String getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(String id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
}
