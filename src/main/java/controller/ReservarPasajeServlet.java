package controller;


import model.data.dao.PasajeDAO;
import model.Pasaje;
import model.Vuelo;
import model.Pasajero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reservarPasaje")
public class ReservarPasajeServlet extends HttpServlet {
    private PasajeDAO pasajeDAO;

    @Override
    public void init() throws ServletException {
        pasajeDAO = new PasajeDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numeroVuelo = req.getParameter("numeroVuelo");
        String documentoIdentidad = req.getParameter("documentoIdentidad");
        String tipo = req.getParameter("tipo");
        double precio = Double.parseDouble(req.getParameter("precio"));
        String asiento = req.getParameter("asiento");

        // Suponiendo que puedas obtener el vuelo y el pasajero según el número de vuelo y el documento de identidad
        Vuelo vuelo = obtenerVueloPorNumero(numeroVuelo);
        Pasajero pasajero = obtenerPasajeroPorDocumento(documentoIdentidad);

        Pasaje pasaje = new Pasaje();
        pasaje.setVuelo(vuelo);
        pasaje.setPasajero(pasajero);
        pasaje.setTipo(tipo);
        pasaje.setPrecio(precio);
        pasaje.setAsiento(asiento);
        pasaje.setDisponible(true);

        pasajeDAO.savePasaje(pasaje);
        resp.sendRedirect("confirmacion.jsp");
    }

    private Vuelo obtenerVueloPorNumero(String numeroVuelo) {
        return null;
    }

    private Pasajero obtenerPasajeroPorDocumento(String documentoIdentidad) {
        return null;
    }
}