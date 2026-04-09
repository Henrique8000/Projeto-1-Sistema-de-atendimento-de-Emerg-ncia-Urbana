package entities;

public class Chamado {
	private int id;
	private String bairro;
	private String descricao;
	private int nivelUrgencia;
	private String status;

	public Chamado(int id, String bairro, String descricao, int nivelUrgencia) {
		this.id = id;
		this.bairro = bairro;
		this.descricao = descricao;
		this.nivelUrgencia = nivelUrgencia;
		this.status = "ABERTO";
	}

	public int getId() {
		return id;
	}

	public String getBairro() {
		return bairro;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getNivelUrgencia() {
		return nivelUrgencia;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Bairro: " + bairro + " | Descrição: " + descricao + " | Urgência: " + nivelUrgencia
				+ " | Status: " + status;
	}
}