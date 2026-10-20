package org.example;

public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private int nivel;
    private int ps;

    public Pokemon() {
    }

    public Pokemon(int id, String nombre, String tipo, int nivel, int ps) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.ps = ps;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getPs() { return ps; }
    public void setPs(int ps) { this.ps = ps; }
}