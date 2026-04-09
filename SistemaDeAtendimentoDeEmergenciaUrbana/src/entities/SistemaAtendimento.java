package entities;

import java.util.ArrayList;
import java.util.LinkedList;

import util.FilaChamados;
import util.PilhaChamados;

public class SistemaAtendimento {
	private PilhaChamados emergencias;
	private FilaChamados filaComum;
	private LinkedList<Chamado> historico;
	private ArrayList<Chamado> atendimentosAtivos;

	public SistemaAtendimento() {
		emergencias = new PilhaChamados(30);
		filaComum = new FilaChamados(30);
		historico = new LinkedList<>();
		atendimentosAtivos = new ArrayList<>(50);
	}

	public boolean idJaExiste(int id) {
		for (Chamado c : historico) {
			if (c.getId() == id) {
				return true;
			}
		}
		return false;
	}

	public void abrirChamado(int id, String bairro, String descricao, int nivelUrgencia) {
		if (id <= 0) {
			System.out.println("ID inválido.");
			return;
		}

		if (bairro == null || bairro.isBlank()) {
			System.out.println("Bairro inválido.");
			return;
		}

		if (descricao == null || descricao.isBlank()) {
			System.out.println("Descrição inválida.");
			return;
		}

		if (nivelUrgencia < 1 || nivelUrgencia > 5) {
			System.out.println("Nível de urgência inválido.");
			return;
		}

		if (idJaExiste(id)) {
			System.out.println("Já existe chamado com esse ID.");
			return;
		}

		Chamado chamado = new Chamado(id, bairro, descricao, nivelUrgencia);

		if (nivelUrgencia >= 4) {
			if (!emergencias.push(chamado)) {
				System.out.println("Pilha de emergências cheia.");
				return;
			}
		} else {
			if (!filaComum.enqueue(chamado)) {
				System.out.println("Fila de chamados comuns cheia.");
				return;
			}
		}

		historico.add(chamado);
		System.out.println("Chamado cadastrado com sucesso: " + chamado);
	}

	public void atenderProximoChamado() {
		Chamado chamado;

		if (!emergencias.isEmpty()) {
			chamado = emergencias.pop();
		} else {
			chamado = filaComum.dequeue();
		}

		if (chamado == null) {
			System.out.println("Não há chamados para atendimento.");
			return;
		}

		chamado.setStatus("EM_ATENDIMENTO");
		atendimentosAtivos.add(chamado);

		System.out.println("Chamado em atendimento: " + chamado);
	}

	public void finalizarAtendimento(int id) {
		Chamado chamadoAtivo = null;

		for (Chamado c : atendimentosAtivos) {
			if (c.getId() == id) {
				chamadoAtivo = c;
				break;
			}
		}

		if (chamadoAtivo == null) {
			System.out.println("Chamado não encontrado na lista de atendimentos ativos.");
			return;
		}

		atendimentosAtivos.remove(chamadoAtivo);

		for (Chamado c : historico) {
			if (c.getId() == id) {
				c.setStatus("FINALIZADO");
				break;
			}
		}

		System.out.println("Atendimento finalizado com sucesso.");
	}

	public void mostrarHistorico() {
		System.out.println("\n=== HISTÓRICO COMPLETO ===");
		for (Chamado c : historico) {
			System.out.println(c);
		}
	}

	public void mostrarAtivos() {
		System.out.println("\n=== ATENDIMENTOS ATIVOS ===");
		if (atendimentosAtivos.isEmpty()) {
			System.out.println("Nenhum chamado em atendimento.");
			return;
		}

		for (Chamado c : atendimentosAtivos) {
			System.out.println(c);
		}
	}

	public void relatorioTotalPorBairro() {
		System.out.println("\n=== TOTAL DE CHAMADOS POR BAIRRO ===");

		ArrayList<String> bairros = new ArrayList<>();
		ArrayList<Integer> totais = new ArrayList<>();

		for (Chamado c : historico) {
			String bairro = c.getBairro();
			int pos = bairros.indexOf(bairro);

			if (pos == -1) {
				bairros.add(bairro);
				totais.add(1);
			} else {
				totais.set(pos, totais.get(pos) + 1);
			}
		}

		for (int i = 0; i < bairros.size(); i++) {
			System.out.println(bairros.get(i) + ": " + totais.get(i));
		}
	}

	public void relatorioMediaUrgencia() {
		System.out.println("\n=== MÉDIA DE URGÊNCIA ===");

		if (historico.isEmpty()) {
			System.out.println("Nenhum chamado cadastrado.");
			return;
		}

		int soma = 0;
		for (Chamado c : historico) {
			soma += c.getNivelUrgencia();
		}

		double media = (double) soma / historico.size();
		System.out.printf("Média de urgência: %.2f%n", media);
	}

	public void relatorioPendentes() {
		System.out.println("\n=== CHAMADOS PENDENTES ===");

		boolean encontrou = false;

		for (Chamado c : historico) {
			if (!c.getStatus().equals("FINALIZADO")) {
				System.out.println(c);
				encontrou = true;
			}
		}

		if (!encontrou) {
			System.out.println("Nenhum chamado pendente.");
		}
	}

	public void rankingBairros() {
		System.out.println("\n=== RANKING DE BAIRROS MAIS PROBLEMÁTICOS ===");

		ArrayList<String> bairros = new ArrayList<>();
		ArrayList<Integer> totais = new ArrayList<>();

		for (Chamado c : historico) {
			String bairro = c.getBairro();
			int pos = bairros.indexOf(bairro);

			if (pos == -1) {
				bairros.add(bairro);
				totais.add(1);
			} else {
				totais.set(pos, totais.get(pos) + 1);
			}
		}

		// Selection Sort manual em ordem decrescente
		for (int i = 0; i < totais.size() - 1; i++) {
			int maior = i;

			for (int j = i + 1; j < totais.size(); j++) {
				if (totais.get(j) > totais.get(maior)) {
					maior = j;
				}
			}

			if (maior != i) {
				int tempTotal = totais.get(i);
				totais.set(i, totais.get(maior));
				totais.set(maior, tempTotal);

				String tempBairro = bairros.get(i);
				bairros.set(i, bairros.get(maior));
				bairros.set(maior, tempBairro);
			}
		}

		for (int i = 0; i < bairros.size(); i++) {
			System.out.println((i + 1) + "º " + bairros.get(i) + " - " + totais.get(i) + " chamados");
		}
	}
}