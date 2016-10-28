package fr.imie;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Default
public class UserService implements IUserService {

	@Inject IUserDAO userDAO;
	
	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> retour= null;
		try {
			retour= userDAO.getUsers();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return retour;
	}

	@Override
	public UserEntity verifyUsers(UserEntity userToVerify) {
		UserEntity out= null;
		try {
			out= userDAO.getUsersLoginAndPassword(userToVerify.getLogin(),userToVerify.getPassw());
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return out;
	}


}
