package br.edu.iftm.upt.emprestimo.repository.helper;

import java.util.List;

import br.edu.iftm.upt.emprestimo.model.Emprestimo;
import br.edu.iftm.upt.emprestimo.model.Situacao;


public interface EmprestimoQueries {
	
	public List<Emprestimo> buscarComClienteSituacao(Situacao situacao);

}
