package br.edu.iftm.upt.emprestimo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.emprestimo.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
