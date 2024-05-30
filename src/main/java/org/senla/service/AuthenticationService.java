package org.senla.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.senla.model.dto.AuthenticationRequestDTO;
import org.senla.model.dto.AuthenticationResponseDTO;
import org.senla.model.dto.UserCreationDTO;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponseDTO register(UserCreationDTO request);
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
