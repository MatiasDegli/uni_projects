/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author matia
 */
public class GestorSala {

    private final Lock lock = new ReentrantLock(true);

    private final Condition hayJubilados = lock.newCondition();
    private final Condition puedeEntrar = lock.newCondition();
    private final Condition puedeEntrarJubilado = lock.newCondition();

    private int personasEsperando = 0;
    private int jubiladosEsperando = 0;
    private int personasDentro = 0;
    private int capacidad = 10;

    public void entrarSala() throws InterruptedException {

        lock.lock();

        personasEsperando++;

        try {
            if (jubiladosEsperando > 0) {
                hayJubilados.await();
            }

            if (personasDentro >= capacidad) {
                puedeEntrar.await();
            }

            personasDentro++;

            personasEsperando--;

        } finally {
            lock.unlock();
        }
    }

    public void entrarSalaJubilado() throws InterruptedException {

        lock.lock();

        jubiladosEsperando++;

        try {
            if (personasDentro >= capacidad) {
                puedeEntrarJubilado.await();
            }

            personasDentro++;

            jubiladosEsperando--;

            if (jubiladosEsperando == 0) {
                hayJubilados.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void salirSala() {

        lock.lock();

        try {
            personasDentro--;

            if (personasDentro < capacidad) {

                if (jubiladosEsperando > 0) {
                    puedeEntrarJubilado.signal();
                } else {
                    puedeEntrar.signal();
                }

            }
        } finally {
            lock.unlock();
        }
    }

    public void notificarTemp(int temp) {

        lock.lock();
        try {
            if (temp > 30) {
                capacidad = 5;
                System.out.println("Se llego a 30 grados !!!");
            } else {

                if (capacidad == 5) {

                    System.out.println("Se bajo de 30 grados !!!");

                    capacidad = 10;

                    for (int i = 0; i < capacidad - personasDentro; i++) {

                        if (jubiladosEsperando > 0) {
                            puedeEntrarJubilado.signal();
                        } else if (personasEsperando > 0) {
                            puedeEntrar.signal();
                        }

                    }
                }

                capacidad = 10;

            }
        } finally {
            lock.unlock();
        }
    }

}
