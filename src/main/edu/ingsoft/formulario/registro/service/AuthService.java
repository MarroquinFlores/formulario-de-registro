package main.edu.ingsoft.formulario.registro.service;

import main.edu.ingsoft.formulario.registro.dto.request.LoginRequest;
import main.edu.ingsoft.formulario.registro.dto.response.LoginResponse;
import main.edu.ingsoft.formulario.registro.repository.AuthRepository;
import main.edu.ingsoft.formulario.registro.security.jbcrypt.BCrypt;

public class AuthService {
    //atributo
    private final AuthRepository authRepository;
    
    //constructor
    public AuthService(AuthRepository authRepository){
            this.authRepository = authRepository;

    }

    public LoginResponse login(LoginRequest loginRequest) throws Exception {
        if (loginRequest == null) {
            throw new RuntimeException("Credenciales vacias.");
        } else if (loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            throw new RuntimeException("El correo o la contraseña no pueden estar vacios.");
        }
        LoginResponse response = authRepository.findUserByEmail(loginRequest);

        if (response == null) {
            throw new RuntimeException("usuario no encontrado");
        }
        String contrasenaHashed = response.getContrasena_hash();

        if (contrasenaHashed == null) {
            throw new RuntimeException("contraseña invalida");
        } else {
            if (BCrypt.checkpw(loginRequest.getPassword(), contrasenaHashed)) {
                return response;
            }

        }
        return null;
    }

}
