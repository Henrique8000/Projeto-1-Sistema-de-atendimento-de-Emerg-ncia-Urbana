package entities;

import entities.enums.ChamadoStatus;
import exceptions.ChamadoException;

public class Chamado {
	
	private Integer id;
	private String bairro;
	private String descricao;
	private Integer nivelUrgencia;
	private ChamadoStatus status;
	
	public Chamado (Integer id, String bairro, String descricao, Integer nivelUrgencia, ChamadoStatus status) {
		
		if (id < 1 || id > 5) {
			throw new ChamadoException("Erro: o nivel de urgencia deve estar entre 1 e 5!");
		}
		
		this.id = id;
		this.bairro = bairro;
		this.descricao = descricao;
		this.nivelUrgencia = nivelUrgencia;
		this.status = status;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getNivelUrgencia() {
		return nivelUrgencia;
	}

	public void setNivelUrgencia(Integer nivelUrgencia) {
		this.nivelUrgencia = nivelUrgencia;
	}

	public ChamadoStatus getStatus() {
		return status;
	}

	public void setStatus(ChamadoStatus status) {
		this.status = status;
	}
	
	
}
