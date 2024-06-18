package controller;

import model.data.dao.VueloDAO;
import model.Vuelo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/buscarVuelos")
public class BuscarVuelosServlet extends HttpServlet {
    private VueloDAO vueloDAO;

    @Override
    public void init() throws ServletException {
        vueloDAO = new VueloDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origen = req.getParameter("origen");
        String destino = req.getParameter("destino");
        Date fecha = null;
        String fechaStr = req.getParameter("fecha");
        if (fechaStr != null && !fechaStr.isEmpty()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                fecha = dateFormat.parse(fechaStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        List<Vuelo> vuelos = vueloDAO.buscarVuelo(origen, destino, fecha);
        req.setAttribute("vuelos", vuelos);
        RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/jsp/vuelos.jsp");
        dispatcher.forward(req, resp);
    }
}
