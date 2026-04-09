package util;

import entities.Chamado;

public class PilhaChamados {
    private Chamado[] elementos;
    private int topo;

    public PilhaChamados(int capacidade) {
        elementos = new Chamado[capacidade];
        topo = -1;
    }

    public boolean push(Chamado chamado) {
        if (isFull()) {
            return false;
        }
        topo++;
        elementos[topo] = chamado;
        return true;
    }

    public Chamado pop() {
        if (isEmpty()) {
            return null;
        }
        Chamado removido = elementos[topo];
        topo--;
        return removido;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == elementos.length - 1;
    }
}