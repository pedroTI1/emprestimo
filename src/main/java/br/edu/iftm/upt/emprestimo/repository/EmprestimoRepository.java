package br.edu.iftm.upt.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.iftm.upt.emprestimo.model.Emprestimo;
import br.edu.iftm.upt.emprestimo.repository.helper.EmprestimoQueries;


public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>, EmprestimoQueries{
	
	public Emprestimo findByCodigo(Long codigo);

}
