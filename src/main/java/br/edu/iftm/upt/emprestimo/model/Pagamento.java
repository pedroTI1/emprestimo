package br.edu.iftm.upt.emprestimo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 8112647712590110107L;
	
	
	@Id
	@SequenceGenerator(name = "sequencia", sequenceName = "pagamento_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "sequencia", strategy = GenerationType.SEQUENCE)
	private long codigo;
	@JoinColumn(name = "data_pagamento")
	private LocalDate data_pagamento;
	private int qtd_pagas;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_emprestimo")
	private Emprestimo emprestimo;
	
	
	
	public long getCodigo() {
		return codigo;
	}


	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}


	public LocalDate getData_pagamento() {
		return data_pagamento;
	}


	public void setData_pagamento(LocalDate data_pagamento) {
		this.data_pagamento = data_pagamento;
	}


	public int getQtd_pagas() {
		return qtd_pagas;
	}


	public void setQtd_pagas(int qtd_pagas) {
		this.qtd_pagas = qtd_pagas;
	}


	public Emprestimo getEmprestimo() {
		return emprestimo;
	}


	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}


	@Override
	public String toString() {
		return "Pagamento [codigo=" + codigo + ", data=" + data_pagamento + ", qtd_pagas=" + qtd_pagas + ", emprestimo="
				+ emprestimo + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
	

	
	

}
