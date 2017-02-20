package fr.imie.cours;

import java.math.BigDecimal;

import javax.ejb.Local;

@Local
public interface BankAccountLocal {

	public void transfer(BigDecimal amount, Integer a, Integer b);

}
