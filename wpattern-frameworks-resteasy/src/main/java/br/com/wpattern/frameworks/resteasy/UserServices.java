package br.com.wpattern.frameworks.resteasy;

import java.util.List;

import javax.inject.Named;

import org.apache.log4j.Logger;

import br.com.wpattern.frameworks.resteasy.repositories.UserRepository;
import br.com.wpattern.frameworks.resteasy.utils.beans.UserBean;
import br.com.wpattern.frameworks.resteasy.utils.interfaces.IUserServices;

@Named
public class UserServices implements IUserServices {

	private static final Logger LOGGER = Logger.getLogger(UserServices.class);

	private UserRepository repository = new UserRepository();

	public UserServices() {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("User service instantiated.");
		}
	}

	@Override
	public List<UserBean> findAll() {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("Find all users.");
		}

		return this.repository.findAll();
	}

	@Override
	public UserBean add(UserBean user) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Add a new user [%s].", user));
		}

		return this.repository.add(user);
	}

	@Override
	public void update(UserBean user) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Update the user [%s].", user));
		}

		this.repository.update(user);
	}

	@Override
	public UserBean delete(UserBean user) {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info(String.format("Upate the user [%s].", user));
		}

		return this.repository.delete(user.getId());
	}

}
