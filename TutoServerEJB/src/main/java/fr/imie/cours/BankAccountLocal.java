package fr.imie.cours;

import java.math.BigDecimal;

import javax.ejb.Local;

@Local
public interface BankAccountLocal {

	void transfer(BigDecimal amount, int idSource, int idTarget);

}
