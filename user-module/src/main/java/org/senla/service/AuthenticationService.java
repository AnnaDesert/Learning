package org.senla.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.senla.swagger.model.AuthenticationRequestDTO;
import org.senla.swagger.model.AuthenticationResponseDTO;
import org.senla.swagger.model.UserCreationDTO;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponseDTO register(UserCreationDTO request);
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
