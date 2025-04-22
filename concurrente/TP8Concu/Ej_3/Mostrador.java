/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_3;

/**
 *
 * @author matia
 */
public class Mostrador {

    private int[] cantEspacio;
    private Pastel[] pastel;
    private Caja caja;

    public Mostrador(Caja c) {
        caja = c;
    }

    public int agarraPastel() {

        int i=0;

        while (pastel[i] != null) {

        }

        return i;
    }

    public boolean chequeoPeso(int nroPastel) {
        
        return pastel[nroPastel].getPeso()+caja.getPeso() < caja.getPesoMax();
        
    }

}
