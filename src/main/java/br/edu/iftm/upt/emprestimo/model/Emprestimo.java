package br.edu.iftm.upt.emprestimo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;


@Entity
@Table(name = "emprestimo")
public class Emprestimo implements Serializable {
	
	
	
	private static final long serialVersionUID = -6099029384105412514L;
	
	@Id
	@SequenceGenerator(name = "sequencia", sequenceName = "emprestimo_codigo_seq", allocationSize=1)
	@GeneratedValue(generator = "sequencia", strategy = GenerationType.SEQUENCE)
	private long codigo;
	private String descricao;
	@JoinColumn(name = "data_emprestimo")
	private LocalDate data_emprestimo;
	private int parcelas;
	private int parcelas_pagas;
	private float valor;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;
	@Enumerated(EnumType.STRING)
	private Situacao situacao;
	
	
	
	
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getData_emprestimo() {
		return data_emprestimo;
	}
	public void setData_emprestimo(LocalDate data_emprestimo) {
		this.data_emprestimo = data_emprestimo;
	}
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	public int getParcelas_pagas() {
		return parcelas_pagas;
	}
	public void setParcelas_pagas(int parcelas_pagas) {
		this.parcelas_pagas = parcelas_pagas;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
	@Override
	public String toString() {
		return "Emprestimo [codigo=" + codigo + ", descricao=" + descricao + ", data_emprestimo=" + data_emprestimo
				+ ", parcelas=" + parcelas + ", parcelas_pagas=" + parcelas_pagas + ", valor=" + valor + ", situacao="
				+ situacao + "]";
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
		Emprestimo other = (Emprestimo) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	

}
