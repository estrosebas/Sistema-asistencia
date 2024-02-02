/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author estrosebas
 */
public class DistritoRepre {
    private int id_distritoRepre;
    private String distritoR;

    public DistritoRepre(int id_distritoRepre, String distritoR) {
        this.id_distritoRepre = id_distritoRepre;
        this.distritoR = distritoR;
    }

    public DistritoRepre(String distritoR) {
        this.distritoR = distritoR;
    }

    public DistritoRepre(int id_distritoRepre) {
        this.id_distritoRepre = id_distritoRepre;
    }

    public DistritoRepre() {
    }
    
    public int getId_distritoRepre() {
        return id_distritoRepre;
    }

    public void setId_distritoRepre(int id_distritoRepre) {
        this.id_distritoRepre = id_distritoRepre;
    }

    public String getDistritoR() {
        return distritoR;
    }

    public void setDistritoR(String distritoR) {
        this.distritoR = distritoR;
    }

    @Override
    public String toString() {
        return "DistritoRepre{" + "id_distritoRepre=" + id_distritoRepre + ", distritoR=" + distritoR + '}';
    }
    
}
