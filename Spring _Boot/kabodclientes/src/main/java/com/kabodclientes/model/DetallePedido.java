package com.kabodclientes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalle;

    private Integer idPedido;

    private String nombreProducto;

    private String medida;

    private String color;

    private Integer cantidad;

    private Float precioUnitario;

    // Getters y setters...

    public Integer getIdDetalle() { return idDetalle; }
    public void setIdDetalle(Integer idDetalle) { this.idDetalle = idDetalle; }

    public Integer getIdPedido() { return idPedido; }
    public void setIdPedido(Integer idPedido) { this.idPedido = idPedido; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public String getMedida() { return medida; }
    public void setMedida(String medida) { this.medida = medida; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Float getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(Float precioUnitario) { this.precioUnitario = precioUnitario; }
}
