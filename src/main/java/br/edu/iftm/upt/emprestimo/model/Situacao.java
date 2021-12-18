package br.edu.iftm.upt.emprestimo.model;

public enum Situacao {
	ABERTO("Aberto"),
	FECHADO("Fechado");
	
	private String descricao;
	
	private Situacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
