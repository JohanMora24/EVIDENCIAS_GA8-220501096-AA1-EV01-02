package com.kabodclientes.repository;

import com.kabodclientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
	 Cliente findByEmailCliente(String emailCliente);
    // para agregar métodos personalizados si se necesita más adelante
}

