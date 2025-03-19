package org.example;

public class Hotel {
    private String nombre;
    private String ciudad;
    private double precio;
    private int estrellas;

    // Constructor vacío
    public Hotel() {}

    // Constructor con parámetros
    public Hotel(String nombre, String ciudad, double precio, int estrellas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.precio = precio;
        this.estrellas = estrellas;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getEstrellas() { return estrellas; }
    public void setEstrellas(int estrellas) { this.estrellas = estrellas; }
}
