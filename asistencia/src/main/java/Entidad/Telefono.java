/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author estrosebas
 */
public class Telefono {
    private int id_telefono;
    private int telefono;

    public Telefono(int id_telefono, int telefono) {
        this.id_telefono = id_telefono;
        this.telefono = telefono;
    }

    public Telefono(int telefono) {
        this.telefono = telefono;
    }

    public Telefono() {
    }

    public int getId_telefono() {
        return id_telefono;
    }

    public void setId_telefono(int id_telefono) {
        this.id_telefono = id_telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
