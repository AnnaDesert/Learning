package org.senla.service.impl;

import lombok.RequiredArgsConstructor;
import org.senla.exception.NotFoundResourceException;
import org.senla.model.User;
import org.senla.swagger.model.ChangePasswordRequestDTO;
import org.senla.repository.UserRepository;
import org.senla.service.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        Optional<User> data = userRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found user on ID="+id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getById(Long id) {
        Optional<User> data = userRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found user on ID="+id);
        }
        return data;
    }

    @Override
    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        Optional<User> data = userRepository.findByEmail(email);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found user on email="+email);
        }
        return data;
    }

    @Override
    public Optional<User> getByPhoneNumber(String phoneNumber) {
        Optional<User> data = userRepository.findByPhoneNumber(phoneNumber);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found user on phoneNumber="+phoneNumber);
        }
        return data;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public Optional<User> update(User updateUser, Long id) {
        Optional<User> data = userRepository.findById(id);
        if(!data.isPresent()) {
            throw new NotFoundResourceException("Not found user on ID="+id);
        }
        return data
                .map(user -> {
                    updateUser.setId(user.getId());
                    return userRepository.save(updateUser);
                });
    }

    @Override
    public void changePassword(ChangePasswordRequestDTO request, Principal connectedUser) {
        User user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }
}