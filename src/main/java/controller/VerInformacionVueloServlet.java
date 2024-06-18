package controller;


import model.data.dao.VueloDAO;
import model.Vuelo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/verInformacionVuelo")
public class VerInformacionVueloServlet extends HttpServlet {
    private VueloDAO vueloDAO;

    @Override
    public void init() throws ServletException {
        vueloDAO = new VueloDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numeroVuelo = req.getParameter("numeroVuelo");
        Vuelo vuelo = vueloDAO.getVuelo(numeroVuelo);

        req.setAttribute("vuelo", vuelo);
        req.getRequestDispatcher("WEB-INF/jsp/verInformacionVuelo.jsp").forward(req, resp);
    }
}