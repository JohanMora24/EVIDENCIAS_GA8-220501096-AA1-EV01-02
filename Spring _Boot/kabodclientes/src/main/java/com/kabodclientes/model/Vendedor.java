package com.kabodclientes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendedor")
public class Vendedor {

    @Id
    @Column(name = "Id_Vendedor")
    private int idVendedor;

    @Column(name = "Nombre_Vendedor")
    private String nombreVendedor;

    @Column(name = "Telefono_Vendedor")
    private String telefonoVendedor;

    @Column(name = "Email_Vendedor")
    private String emailVendedor;

    // Getters y Setters

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getTelefonoVendedor() {
        return telefonoVendedor;
    }

    public void setTelefonoVendedor(String telefonoVendedor) {
        this.telefonoVendedor = telefonoVendedor;
    }

    public String getEmailVendedor() {
        return emailVendedor;
    }

    public void setEmailVendedor(String emailVendedor) {
        this.emailVendedor = emailVendedor;
    }
}
