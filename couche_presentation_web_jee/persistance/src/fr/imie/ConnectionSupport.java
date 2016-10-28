package fr.imie;

import java.sql.Connection;

public interface ConnectionSupport {
	void setConnection(Connection conn);
	Connection getConnection();

}
