package org.example;

public class Viaje {
    private String origen;
    private String destino;
    private String fecha;
    private double precio;
    private String conductor;

    // Constructor vacío
    public Viaje() {}

    // Constructor con parámetros
    public Viaje(String origen, String destino, String fecha, double precio, String conductor) {
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.precio = precio;
        this.conductor = conductor;
    }

    // Getters y Setters
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getConductor() { return conductor; }
    public void setConductor(String conductor) { this.conductor = conductor; }
}
