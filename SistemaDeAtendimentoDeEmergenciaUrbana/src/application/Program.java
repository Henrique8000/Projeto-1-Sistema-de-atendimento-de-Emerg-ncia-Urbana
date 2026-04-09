package application;

//HENRIQUE FLÁVIO GUIMARÃES / 10427920
//LUCAS ZEFERINO BARACAT / 10396267
//MATHEUS JUNETTI SEVCIUC MACHADO / 10408848
//RAFAEL STOCCO VIEIRA / 10419207

import entities.SistemaAtendimento;

public class Program {
	public static void main(String[] args) {
		SistemaAtendimento sistema = new SistemaAtendimento();

		sistema.abrirChamado(101, "Centro", "Queda de energia", 2);
		sistema.abrirChamado(102, "Jardins", "Incêndio em residência", 5);
		sistema.abrirChamado(103, "Centro", "Vazamento de água", 3);
		sistema.abrirChamado(104, "Mooca", "Vazamento de gás", 4);
		sistema.abrirChamado(105, "Centro", "Alagamento leve", 1);
		sistema.abrirChamado(106, "Pinheiros", "Semáforo quebrado", 2);
		sistema.abrirChamado(107, "Jardins", "Incêndio em comércio", 5);
		sistema.abrirChamado(108, "Mooca", "Falta de iluminação", 2);
		sistema.abrirChamado(109, "Centro", "Buraco na via", 3);
		sistema.abrirChamado(110, "Pinheiros", "Vazamento de água", 2);
		sistema.abrirChamado(111, "Mooca", "Pane elétrica", 1);
		sistema.abrirChamado(112, "Centro", "Poste inclinado", 2);
		sistema.abrirChamado(113, "Jardins", "Explosão de gás", 5);

		System.out.println("\n=== INÍCIO DOS ATENDIMENTOS ===");
		sistema.atenderProximoChamado();
		sistema.atenderProximoChamado();
		sistema.atenderProximoChamado();
		sistema.atenderProximoChamado();

		sistema.mostrarAtivos();

		sistema.finalizarAtendimento(113);
		sistema.finalizarAtendimento(107);

		sistema.mostrarAtivos();
		sistema.mostrarHistorico();

		sistema.relatorioTotalPorBairro();
		sistema.rankingBairros();
		sistema.relatorioMediaUrgencia();
		sistema.relatorioPendentes();
	}
}