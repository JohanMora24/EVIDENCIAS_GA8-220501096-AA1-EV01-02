package com.kabodclientes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kabodclientes.model.Cliente;
import com.kabodclientes.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*") // Permitir peticiones desde tu frontend
public class LoginController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Endpoint para login
    @PostMapping("/login")
    public String login(@RequestBody Cliente loginData) {
        Cliente cliente = clienteRepository.findByEmailCliente(loginData.getEmailCliente());

        if (cliente == null) {
            return "ERROR: Usuario no encontrado";
        }

        if (!cliente.getContrasena().equals(loginData.getContrasena())) {
            return "ERROR: Contraseña incorrecta";
        }

        return "OK: Login exitoso";
    }
}


