package br.edu.iftm.upt.emprestimo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.emprestimo.model.Pagamento;
import br.edu.iftm.upt.emprestimo.repository.PagamentoRepository;


@Service
public class PagamentoService {
private static final Logger logger = LoggerFactory.getLogger(PagamentoService.class);
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Transactional
	public void salvar(Pagamento pagamento) {
		pagamentoRepository.save(pagamento);
	
	}
	

}
