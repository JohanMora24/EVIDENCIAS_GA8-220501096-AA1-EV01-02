package com.kabodclientes.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "Id_Cliente")
    private Long idCliente;

    @Column(name = "Nombre_Cliente")
    private String nombreCliente;

    @Column(name = "Telefono_Cliente")
    private String telefonoCliente;

    @Column(name = "Email_Cliente")
    private String emailCliente;

    @Column(name = "Direccion_Cliente")
    private String direccionCliente;

    @Column(name = "Id_Vendedor")
    private Long idVendedor;

    @Column(name = "Contrasena")
    @JsonProperty("contrasena")
    private String contrasena;

    // Constructor vacío
    public Cliente() {}

    // Getters y Setters
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public Long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
