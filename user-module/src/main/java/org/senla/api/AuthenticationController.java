package org.senla.api;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.senla.swagger.model.AuthenticationRequestDTO;
import org.senla.swagger.model.AuthenticationResponseDTO;
import org.senla.swagger.model.UserCreationDTO;
import org.senla.service.AuthenticationService;
import org.senla.swagger.api.AuthApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationController implements AuthApi {
    private final AuthenticationService service;

//    @PostMapping("/register")
    @Override
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody UserCreationDTO request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

//    @PostMapping("/auth/authenticate")
    @Override
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestDTO request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

//    @PostMapping("/refresh-token")
//    public void refreshToken(
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws IOException {
//        service.refreshToken(request, response);
//    }
}
