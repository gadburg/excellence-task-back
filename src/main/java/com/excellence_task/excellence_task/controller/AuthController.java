package com.excellence_task.excellence_task.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excellence_task.excellence_task.security.JwtTokenUtil;
import com.excellence_task.excellence_task.security.JwtUserDetailsService;

@CrossOrigin
@RestController
@RequestMapping("/api/usuarios")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    // Endpoint para iniciar sesión y generar token JWT
    @PostMapping("/login")
    public Map<String, String> autenticarUsuario(@RequestBody Map<String, String> credenciales) throws Exception {
        String email = credenciales.get("email");
        String contraseña = credenciales.get("contraseña");

        try {
            // Autenticar al usuario
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, contraseña));
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales incorrectas", e);
        }

        // Cargar los detalles del usuario
        final UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        // Generar el token JWT
        final String jwt = jwtTokenUtil.generateToken(userDetails.getUsername());

        // Devolver el token en la respuesta
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("token", jwt);
        return respuesta;
    }
}