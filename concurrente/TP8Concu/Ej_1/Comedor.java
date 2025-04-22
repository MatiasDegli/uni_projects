/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej_1;

import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author matia
 */
public class Comedor {

    // Cantidad de abridores de gaseosas
    private final Semaphore abridor = new Semaphore(10);

    private final Lock lock = new ReentrantLock();
    private final Condition[] esperaColaA;
    private final Condition[] esperaColaP;
    
    // Mostradores de almuerzo
    private final MostradorAlmuerzo[] mostradoresA;

    // Mostradores de postre
    private final MostradorPostre[] mostradoresP;

    public Comedor(int cantMostradoresA, int cantMostradoresP) {

        mostradoresA = new MostradorAlmuerzo[cantMostradoresA];
        esperaColaA = new Condition[cantMostradoresA];

        for (int i = 0; i < cantMostradoresA; i++) {
            mostradoresA[i] = new MostradorAlmuerzo();
            esperaColaA[i] = lock.newCondition();
        }

        mostradoresP = new MostradorPostre[cantMostradoresP];
        esperaColaP = new Condition[cantMostradoresP];

        for (int i = 0; i < cantMostradoresP; i++) {
            mostradoresP[i] = new MostradorPostre();
            esperaColaP[i] = lock.newCondition();
        }
    }

    public int llegaMostradorAlmuerzo(int nro, boolean gaseosa) throws InterruptedException {

        lock.lock();
        try {
            // Los hilos van llegando al mostrador
            mostradoresA[nro].llegaSoldado();
        } finally {
            lock.unlock();
        }

        lock.lock();

        int decision = 0;

        try {
            if (mostradoresA[nro].cantSoldados() - 1 > 0) {
                // Si hay mas soldados aparte de el mismo esperando, se queda esperando
                esperaColaA[nro].await();
            }
            /* Hay 3 decisiones posibles, 0 si no hay comida, 1 si hay comida
            pero no la bebida que quiere y 2 si hay ambas */

            if (mostradoresA[nro].quedaComida()) {
                if (gaseosa && mostradoresA[nro].quedaGaseosa()) {
                    mostradoresA[nro].eligeGaseosa();
                    decision = 2;
                } else if (!gaseosa && mostradoresA[nro].quedaAgua()) {
                    mostradoresA[nro].eligeAgua();
                    decision = 2;
                } else {
                    decision = 1;
                }
            }
        } finally {
            lock.unlock();
        }

        return decision;
    }

    public void saleMostradorAlmuerzo(int nro) {

        lock.lock();
        try {
            mostradoresA[nro].saleSoldado();
            esperaColaA[nro].signal();
        } finally {
            lock.unlock();
        }
    }

    public int menorColaA(Map<Integer, Integer> chequear, boolean recorrioTodos) {

        int cant = 999;
        int menorCola = 0;
        int verificador;

        if (!recorrioTodos) {
            // El mostrador i tiene el value -1 si no fue visitado
            verificador = -1;
        } else {
            // El mostrador i tiene el value 1 si fue visitado y no tenia la bebida preferida
            verificador = 1;
        }

        for (int i = 0; i < mostradoresA.length; i++) {
            // Verifica si la clave i está en el mapa
            if (chequear.containsKey(i) && chequear.get(i) == verificador) {
                if (mostradoresA[i].cantSoldados() < cant) {
                    menorCola = i;
                    cant = mostradoresA[i].cantSoldados();
                }
            }
        }

        return menorCola;
    }

    
    public int getCantMostradoresA() {
        return mostradoresA.length;
    }

    
    public int llegaMostradorPostre(int nro) throws InterruptedException {

        lock.lock();
        try {
            // Los hilos van llegando al mostrador
            mostradoresP[nro].llegaSoldado();
        } finally {
            lock.unlock();
        }
        
        lock.lock();

        int decision = 0;

        try {
            if (mostradoresP[nro].cantSoldados() - 1 > 0) {
                // Si hay mas soldados aparte de el mismo esperando, se queda esperando
                esperaColaP[nro].await();
            }

            if (mostradoresP[nro].quedaPostre()) {
                // Si hay postre, retorna 1, sino 0
                decision = 1;
            }
            
        } finally {
            lock.unlock();
        }

        return decision;
    }

    
    public void saleMostradorPostre(int nro) {

        lock.lock();
        try {
            mostradoresP[nro].saleSoldado();
            esperaColaP[nro].signal();
        } finally {
            lock.unlock();
        }
    }

    
    public int menorColaP(Map<Integer, Integer> chequear) {

        int cant = 999;
        int menorCola = 0;

        for (int i = 0; i < mostradoresP.length; i++) {

            if (chequear.get(i) == -1) {
                if (mostradoresP[i].cantSoldados() < cant) {
                    menorCola = i;
                    cant = mostradoresP[i].cantSoldados();
                }
            }
        }

        return menorCola;
    }
    

    public int getCantMostradoresP() {
        return mostradoresP.length;
    }

    
    public void agarrarAbridor() throws InterruptedException {
        abridor.acquire(1);
    }

    
    public void dejarAbridor() {
        abridor.release();
    }

}
