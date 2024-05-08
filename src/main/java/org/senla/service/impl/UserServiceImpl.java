package org.senla.service.impl;

import org.senla.exception.NotFoundResourceUserException;
import org.senla.model.User;
import org.senla.repository.UserRepository;
import org.senla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> save(User user) {
        return Optional.ofNullable(Optional.of(userRepository.save(user))
                .orElseThrow(() ->
                        new NotFoundResourceUserException("The user cannot be saved")));
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getById(Long id) {
        return Optional.ofNullable(Optional.of(userRepository.findById(id).get())
                .orElseThrow(() ->
                        new NotFoundResourceUserException("The user with id " + id + " not found")));
    }

    @Override
    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new NotFoundResourceUserException("The user with email " + email + " not found")));
    }

    @Override
    public Optional<User> getByPhoneNumber(String phoneNumber) {
        return Optional.ofNullable(userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() ->
                        new NotFoundResourceUserException("The user with phone" + phoneNumber + " not found")));
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public Optional<User> update(User updateUser, Long id) {
        return Optional.ofNullable(Optional.of(userRepository.findById(id).get())
                .map(user -> {
                    user.setName(updateUser.getName());
                    user.setSurname(updateUser.getSurname());
                    user.setPassword(updateUser.getPassword());
                    user.setEmail(updateUser.getEmail());
                    user.setPhoneNumber(updateUser.getPhoneNumber());
                    user.setRole(updateUser.getRole());
                    return userRepository.save(updateUser);
                })
                .orElseThrow(() ->
                        new NotFoundResourceUserException("The user cannot be updated")));
    }
}