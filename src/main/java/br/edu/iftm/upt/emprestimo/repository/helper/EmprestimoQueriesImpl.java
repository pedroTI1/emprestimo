package br.edu.iftm.upt.emprestimo.repository.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.emprestimo.model.Emprestimo;
import br.edu.iftm.upt.emprestimo.model.Situacao;



public class EmprestimoQueriesImpl implements EmprestimoQueries{
	private static final Logger logger = LoggerFactory.getLogger(EmprestimoQueriesImpl.class);

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	@Transactional
	public List<Emprestimo> buscarComClienteSituacao(Situacao situacao) {
		String jpql = "select j from Emprestimo j inner join fetch j.cliente where j.situacao = :situacao";
		TypedQuery<Emprestimo> query = manager.createQuery(jpql, Emprestimo.class);
		query.setParameter("situacao", situacao);
		List<Emprestimo> emprestimos = query.getResultList();
		logger.debug("Emprestimos buscadas com cidadao");
		for (Emprestimo e : emprestimos) {
			logger.debug("{}", e);
			logger.debug("cliente: {}", e.getCliente());
		}
	
		return emprestimos;	
	} 
	


}
