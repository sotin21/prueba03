package controller;

import model.data.dao.PasajeDAO;
import model.data.dao.PasajeroDAO;
import model.data.dao.VueloDAO;
import model.Pasaje;
import model.Pasajero;
import model.Vuelo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comprarPasaje")
public class ComprarPasajeServlet extends HttpServlet {
    private VueloDAO vueloDAO;
    private PasajeroDAO pasajeroDAO;
    private PasajeDAO pasajeDAO;

    @Override
    public void init() throws ServletException {
        vueloDAO = new VueloDAO();
        pasajeroDAO = new PasajeroDAO();
        pasajeDAO = new PasajeDAO();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numeroVuelo = req.getParameter("numeroVuelo");
        String documentoIdentidad = req.getParameter("documentoIdentidad");
        String tipo = req.getParameter("tipo");
        double precio = Double.parseDouble(req.getParameter("precio"));
        String asiento = req.getParameter("asiento");

        Vuelo vuelo = vueloDAO.getVuelo(numeroVuelo);
        Pasajero pasajero = pasajeroDAO.getPasajero(documentoIdentidad);

        Pasaje pasaje = new Pasaje(vuelo, pasajero, tipo, precio, true, asiento);
        pasajeDAO.savePasaje(pasaje);

        resp.sendRedirect("confirmacion.jsp");
    }
}
