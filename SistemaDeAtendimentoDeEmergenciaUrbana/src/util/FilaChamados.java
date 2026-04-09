package util;

import entities.Chamado;

public class FilaChamados {
	private Chamado[] elementos;
	private int inicio;
	private int fim;
	private int tamanho;

	public FilaChamados(int capacidade) {
		elementos = new Chamado[capacidade];
		inicio = 0;
		fim = 0;
		tamanho = 0;
	}

	public boolean enqueue(Chamado chamado) {
		if (isFull()) {
			return false;
		}
		elementos[fim] = chamado;
		fim = (fim + 1) % elementos.length;
		tamanho++;
		return true;
	}

	public Chamado dequeue() {
		if (isEmpty()) {
			return null;
		}
		Chamado removido = elementos[inicio];
		inicio = (inicio + 1) % elementos.length;
		tamanho--;
		return removido;
	}

	public boolean isEmpty() {
		return tamanho == 0;
	}

	public boolean isFull() {
		return tamanho == elementos.length;
	}
}