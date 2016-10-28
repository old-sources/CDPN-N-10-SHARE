package fr.imie;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
	public List<UserEntity> getUsers() throws SQLException;

	UserEntity addUser(UserEntity user) throws SQLException ;
}
