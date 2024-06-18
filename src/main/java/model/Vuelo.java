package model;

import java.util.Date;

public class Vuelo {
    private String numeroVuelo;
    private String aerolinea;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaLlegada;
    private String horarioSalida;
    private String horarioLlegada;
    private int duracionVuelo;
    private String tipoAeronave;
    private int capacidadPasajeros;

    public Vuelo() {
        this.numeroVuelo = numeroVuelo;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.horarioSalida = horarioSalida;
        this.horarioLlegada = horarioLlegada;
        this.duracionVuelo = duracionVuelo;
        this.tipoAeronave = tipoAeronave;
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getHorarioSalida() {
        return horarioSalida;
    }

    public void setHorarioSalida(String horarioSalida) {
        this.horarioSalida = horarioSalida;
    }

    public String getHorarioLlegada() {
        return horarioLlegada;
    }

    public void setHorarioLlegada(String horarioLlegada) {
        this.horarioLlegada = horarioLlegada;
    }

    public int getDuracionVuelo() {
        return duracionVuelo;
    }

    public void setDuracionVuelo(int duracionVuelo) {
        this.duracionVuelo = duracionVuelo;
    }

    public String getTipoAeronave() {
        return tipoAeronave;
    }

    public void setTipoAeronave(String tipoAeronave) {
        this.tipoAeronave = tipoAeronave;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }
}
