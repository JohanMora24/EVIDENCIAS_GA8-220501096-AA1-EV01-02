package com.kabodclientes.controller;

import com.kabodclientes.model.Pedido;
import com.kabodclientes.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*") // Permitir CORS para desarrollo frontend
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido) {
        try {
            // Asignar fecha actual y estado inicial
            pedido.setFecha(new Date());
            pedido.setEstado("Pendiente");
            // Si quieres, aquí puedes validar que el idCliente exista

            Pedido pedidoGuardado = pedidoService.guardarPedidoConDetalles(pedido);
            return ResponseEntity.ok(pedidoGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al crear el pedido");
        }
    }
}
