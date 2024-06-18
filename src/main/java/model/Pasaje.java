package model;

public class Pasaje {
    private Vuelo vuelo;
    private Pasajero pasajero;
    private String tipo;
    private double precio;
    private boolean disponible;
    private String asiento;

    public Pasaje(Vuelo vuelo, Pasajero pasajero, String tipo, double precio, boolean disponible, String asiento) {
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
        this.asiento = asiento;
    }

    // Getters y Setters
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
}
