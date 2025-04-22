/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

/**
 *
 * @author matia
 */
public class CuentaBanco {
    
    private int balance = 50;
    
    
    public CuentaBanco(){
        
    }
    
    
    public int getBalance(){
        return balance;
    }
    
    
    public void retiroBancario(int retiro){
        balance = balance - retiro;
    }
    
}