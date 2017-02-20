package fr.imie.cours;

import java.math.BigDecimal;

import javax.ejb.Remote;

@Remote
public interface BankAccountRemote {

	public void transfer(BigDecimal amount, Integer a, Integer b);

}
