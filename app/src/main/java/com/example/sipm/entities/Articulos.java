package com.example.sipm.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Articulos implements Serializable{
    private int art_id;

    private String nombre;

    private String marca;

    private String img;

    private BigDecimal precio;

    private BigDecimal descuento;

    private String descripcion;

    private int cat_id;

    private int ge_id;

    public int getArt_id() {
        return art_id;
    }
    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public BigDecimal getPrecio() {
        return precio;
    }
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    public BigDecimal getDescuento() {
        return descuento;
    }
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getCat_id() {
        return cat_id;
    }
    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }
    public int getGe_id() {
        return ge_id;
    }
    public void setGe_id(int ge_id) {
        this.ge_id = ge_id;
    }
}
