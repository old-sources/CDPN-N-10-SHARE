package fr.imie.cours;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BankAccountEJB implements BankAccountLocal, BankAccountRemote {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void transfer(BigDecimal amount, int idSource, int idTarget) {
		BankAccount source = em.find(BankAccount.class, idSource);
		BankAccount target = em.find(BankAccount.class, idTarget);
		target.setBalance(target.getBalance().add(amount));
		source.setBalance(source.getBalance().subtract(amount));
		em.merge(target);
		em.merge(source);
	}

}
