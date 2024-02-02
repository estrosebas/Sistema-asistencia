/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author estrosebas
 */
public class DistritoAlum {
    private int id_distritoAlum;
    private String distritoA;

    public DistritoAlum(int id_distritoAlum, String distritoA) {
        this.id_distritoAlum = id_distritoAlum;
        this.distritoA = distritoA;
    }

    public DistritoAlum(String distritoA) {
        this.distritoA = distritoA;
    }

    public DistritoAlum() {
    }

    public int getId_distritoAlum() {
        return id_distritoAlum;
    }

    public void setId_distritoAlum(int id_distritoAlum) {
        this.id_distritoAlum = id_distritoAlum;
    }

    public String getDistritoA() {
        return distritoA;
    }

    public void setDistritoA(String distritoA) {
        this.distritoA = distritoA;
    }

    @Override
    public String toString() {
        return distritoA;
    }
    
}
