/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author matia
 */
public class Observatorio {
    
    private int capacidad=50;
    private int invalidosDentro=0;
    private int visitantesDentro=0;
    private int investigadoresDentro=0;
    private int investigadoresEsperando;
    private int personalDentro=0;
    
    private final Lock lock = new ReentrantLock();
    
    private final Condition esperaVisitante = lock.newCondition();
    private final Condition esperaInvestigador = lock.newCondition();
    private final Condition esperaPersonal = lock.newCondition();
    
    
    public Observatorio(){
        
    }
    
    
    public void llegaVisitante(boolean invalido) throws InterruptedException{
        
        lock.lock();
        
        try {
            while(visitantesDentro+personalDentro>=capacidad || investigadoresDentro>0){
                esperaVisitante.await();
            }
            
            visitantesDentro++;
            
            if(invalido){
                capacidad=30;
                invalidosDentro++;
            }
        } finally {
            lock.unlock();
        }
    }
    
    
    public void saleVisitante(boolean invalido){
        
        lock.lock();
        
        try {
            visitantesDentro--;

            if(invalido){
                invalidosDentro--;
                if(invalidosDentro==0){
                    capacidad=50;
                    if(investigadoresDentro==0){
                        esperaVisitante.signalAll();
                    }
                }
            }
            
            if(visitantesDentro==0){
                if(investigadoresEsperando>0){
                    esperaInvestigador.signalAll();   
                }
                else{
                    esperaPersonal.signalAll();
                }
            }
            else if(visitantesDentro+personalDentro < capacidad){
                esperaVisitante.signal();
            }
            
        } finally {
            lock.unlock();
        }
    }
    
    
    public void llegaInvestigador() throws InterruptedException{
        
        lock.lock();
        
        try {
            if(visitantesDentro>0 || personalDentro>0){
               investigadoresEsperando++;
               esperaInvestigador.await();
            }
            
            investigadoresEsperando--;
            investigadoresDentro++;
        }
        
        finally{
            lock.unlock();
        }
    }
    
    
    public void saleInvestigador(){
        
        lock.lock();
        try {
            investigadoresDentro--;
            
            if(investigadoresDentro==0){
                esperaVisitante.signalAll();
            }
        } finally {
            lock.unlock();
        }        
    }


    public void llegaPersonal() throws InterruptedException{
        
        lock.lock();
        try {
            if(visitantesDentro>0 || investigadoresDentro>0){
                esperaPersonal.await();
            }
            
            personalDentro++;
            
        } finally {
            lock.unlock();
        }
    }
    
    
    public void salePersonal(){
                
        lock.lock();
        
        try {
            personalDentro--;
            
            if(visitantesDentro>0 && visitantesDentro+personalDentro < capacidad){
                esperaVisitante.signal();
            }            
            else if(personalDentro==0){
                esperaInvestigador.signalAll();   
            }
        } finally {
            lock.unlock();
        }
    }
    
}
