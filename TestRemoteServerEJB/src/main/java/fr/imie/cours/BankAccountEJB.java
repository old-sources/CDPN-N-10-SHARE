package fr.imie.cours;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
// (mappedName = "BankAccountEJB")
public class BankAccountEJB implements BankAccountLocal, BankAccountRemote {

	@PersistenceContext
	EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void transfer(BigDecimal amount, Integer a, Integer b) {
		BankAccount aa = em.find(BankAccount.class, a);
		BankAccount bb = em.find(BankAccount.class, b);
		aa.setBalance(aa.getBalance().add(amount));
		em.merge(aa);
		// if (1==1) throw new RuntimeException();
		bb.setBalance(bb.getBalance().subtract(amount));
		em.merge(bb);
	}

}
