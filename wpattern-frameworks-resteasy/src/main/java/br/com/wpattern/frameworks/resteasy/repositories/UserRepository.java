package br.com.wpattern.frameworks.resteasy.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.wpattern.frameworks.resteasy.utils.beans.UserBean;

public final class UserRepository {

	private static List<UserBean> users = new ArrayList<>();

	private static long countId = 0;

	static {
		UserRepository repository = new UserRepository();

		repository.add(new UserBean("User 1", 18, "user1@gmail.com"));
		repository.add(new UserBean("User 2", 30, "user2@gmail.com"));
		repository.add(new UserBean("User 3", 25, "user3@gmail.com"));
		repository.add(new UserBean("User 4", 41, "user4@gmail.com"));
	}

	public UserRepository() {
	}

	public List<UserBean> findAll() {
		return users;
	}

	public UserBean add(UserBean user) {
		user.setId(countId++);
		users.add(user);

		return user;
	}

	public UserBean delete(Long id) {
		UserBean user = this.findById(id);

		if (user != null) {
			users.remove(user);
		}

		return user;
	}

	public void delete(UserBean userDel) {
		this.delete(userDel.getId());
	}

	public void update(UserBean userUp) {
		UserBean user = this.findById(userUp.getId());

		if (user != null) {
			users.set(users.indexOf(user), userUp);
		}
	}

	public UserBean findById(Long id) {
		for (UserBean user : users) {
			if (user.getId() == id) {
				return user;
			}
		}

		return null;
	}

}
