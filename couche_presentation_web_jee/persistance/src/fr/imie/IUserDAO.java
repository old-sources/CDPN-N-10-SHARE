package fr.imie;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
	public List<UserEntity> getUsers() throws SQLException;

	UserEntity addUser(UserEntity user) throws SQLException ;

	public UserEntity getUsersById(Integer userId) throws SQLException;

	public UserEntity getUsersLoginAndPassword(String login, String passw) throws SQLException;
}
