package com.romain.tp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.romain.tp.model.User;
import com.romain.tp.repository.IUserRepository;

@Service
public class UserService {
	@Autowired
	private IUserRepository userRepository;

	public Optional<User> getUser(final Long id) {
		return userRepository.findById(id);
	}

	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(final Long id) {
		userRepository.deleteById(id);
	}

	public User saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
}