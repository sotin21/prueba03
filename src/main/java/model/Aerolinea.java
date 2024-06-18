package model;

public class Aerolinea {
    private String nombre;
    private String codigoIATA;
    private String imagenCorporativa;

    public Aerolinea() {
        this.nombre = nombre;
        this.codigoIATA = codigoIATA;
        this.imagenCorporativa = imagenCorporativa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getImagenCorporativa() {
        return imagenCorporativa;
    }

    public void setImagenCorporativa(String imagenCorporativa) {
        this.imagenCorporativa = imagenCorporativa;
    }
}
