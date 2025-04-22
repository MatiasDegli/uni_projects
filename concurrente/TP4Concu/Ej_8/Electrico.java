/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_8;

    import java.util.logging.Level;
    import java.util.logging.Logger;


    /**
     *
     * @author matia
     */
    public class Electrico extends Thread{


        private final LineaElectrico lineaE;
        private final String direccion;
        private boolean ensamblado = false;


        public Electrico(LineaElectrico linea) {
            this.lineaE = linea;
            direccion = "Norte";
        }


        public void run() {

            try {
                lineaE.llegaElectrico(this);
            } 
            catch (InterruptedException ex) {
                Logger.getLogger(Electrico.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


        public void setEnsamblado(){
            ensamblado=true;
        }


        public void sale(){

            System.out.println("\nEl producto electrico fue ensamblado correctamente");

        }


        public String getDireccion(){
            return direccion;
        }

    }
