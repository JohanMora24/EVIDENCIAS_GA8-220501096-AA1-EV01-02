package com.kabodclientes;

import com.kabodclientes.model.DetallePedido;
import com.kabodclientes.model.Pedido;
import com.kabodclientes.repository.DetallePedidoRepository;
import com.kabodclientes.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Transactional
    public Pedido guardarPedidoConDetalles(Pedido pedido) {
        // Guardar pedido primero
        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        // Guardar cada detalle con el idPedido generado
        if (pedido.getDetalles() != null) {
            for (DetallePedido detalle : pedido.getDetalles()) {
                detalle.setIdPedido(pedidoGuardado.getIdPedido());
                detallePedidoRepository.save(detalle);
            }
        }

        return pedidoGuardado;
    }
}
