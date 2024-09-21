package com.ulp.farmacias.model;

import java.io.Serializable;

public class Farmacia implements Serializable {
    private String nombre;
    private String direccion;
    private String horario;
    private int foto;

    public Farmacia(String nombre, String direccion, String horario, int foto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
