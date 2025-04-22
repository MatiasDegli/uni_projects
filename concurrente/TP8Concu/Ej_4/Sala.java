/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matia
 */
public class Sala {

    private final Semaphore llamaPacientes = new Semaphore(1);
    private final Semaphore camilla = new Semaphore(4);
    private final Semaphore revista = new Semaphore(9);
    private int camillasLibres = 4;
    private Lock lock = new ReentrantLock();
    private Condition esperaTV = lock.newCondition();
    private Condition esperaRevista = lock.newCondition();

    public Sala() {

    }

    public synchronized boolean llegaPersona() {

        boolean tomaRevista = false;

        if (revista.tryAcquire()) {
            tomaRevista = true;
            System.out.println("Paciente toma revista");
        } else {
            System.out.println("Paciente mirando tv");
        }
        return tomaRevista;
    }

    public void esperaLlamada(boolean tieneRevista) throws InterruptedException {

        lock.lock();

        try {
            if (tieneRevista) {
                esperaRevista.await();
            } else {
                esperaTV.await();
            }

            intentaEntrar(tieneRevista);
        } finally {
            lock.unlock();
        }
    }

    public void intentaEntrar(boolean tieneRevista) throws InterruptedException {

        lock.lock();

        try {
            if (camilla.tryAcquire()) {
                camillasLibres--;
                if (tieneRevista) {
                    revista.release();
                }
            } else {
                if (revista.tryAcquire()) {
                    System.out.println("El paciente consiguio revista");
                }
                esperaLlamada(tieneRevista);
            }
        } finally {
            lock.unlock();
        }

    }

    public void llamadaCamilla()  {

        lock.lock();

        try {
            esperaTV.signalAll();
            esperaRevista.signalAll();

            if (camillasLibres == 0) {
                try {
                    llamaPacientes.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Sala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void salePersona() {

        lock.lock();

        try {
            llamaPacientes.release();
            camilla.release();
            camillasLibres++;
        } finally {
            lock.unlock();
        }
    }

}
