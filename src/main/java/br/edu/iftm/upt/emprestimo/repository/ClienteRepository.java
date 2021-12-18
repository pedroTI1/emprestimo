package br.edu.iftm.upt.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.edu.iftm.upt.emprestimo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public Cliente findByCodigo(Long codigo);

}
