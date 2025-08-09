package com.kabodclientes.controller;

import com.kabodclientes.model.Contacto;
import com.kabodclientes.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacto")
@CrossOrigin(origins = "*")
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    @PostMapping
    public ResponseEntity<?> enviarMensaje(@RequestBody Contacto contacto) {
        if (contacto.getNombre() == null || contacto.getEmail() == null || contacto.getMensaje() == null) {
            return ResponseEntity.badRequest().body("Los campos nombre, email y mensaje son obligatorios");
        }
        contactoRepository.save(contacto);
        return ResponseEntity.ok("Mensaje enviado correctamente");
    }
}
