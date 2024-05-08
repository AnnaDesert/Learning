package org.senla.service;

import org.senla.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> save(User user);
    void remove(Long id);
    Optional<User> getById(Long id);
    List<User> getByName(String name);
    Optional<User> getByEmail(String email);
    Optional<User> getByPhoneNumber(String phoneNumber);
    List<User> getAll();
    Optional<User> update(User user, Long id);
}
