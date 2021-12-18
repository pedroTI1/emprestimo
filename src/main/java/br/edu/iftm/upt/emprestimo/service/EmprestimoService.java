package br.edu.iftm.upt.emprestimo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.emprestimo.model.Emprestimo;
import br.edu.iftm.upt.emprestimo.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	private static final Logger logger = LoggerFactory.getLogger(EmprestimoService.class);
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;
	
	@Transactional
	public void salvar(Emprestimo emprestimo) {
		logger.debug("Salvando o emprestimo {}", emprestimo);
		emprestimoRepository.save(emprestimo);
		logger.debug("Emprestimo salvo com sucesso");
	}
	
	


}
