package model.data.dao;

import model.Vuelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class VueloDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/flyeasy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public Vuelo getVuelo(String numeroVuelo) {
        Vuelo vuelo = null;
        String sql = "SELECT * FROM vuelos WHERE numero_vuelo = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, numeroVuelo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                vuelo = new Vuelo();
                vuelo.setNumeroVuelo(resultSet.getString("numero_vuelo"));
                vuelo.setAerolinea(resultSet.getString("aerolinea"));
                vuelo.setOrigen(resultSet.getString("origen"));
                vuelo.setDestino(resultSet.getString("destino"));
                vuelo.setFechaSalida(resultSet.getDate("fecha_salida"));
                vuelo.setFechaLlegada(resultSet.getDate("fecha_llegada"));
                vuelo.setHorarioSalida(resultSet.getString("horario_salida"));
                vuelo.setHorarioLlegada(resultSet.getString("horario_llegada"));
                vuelo.setDuracionVuelo(resultSet.getInt("duracion_vuelo"));
                vuelo.setTipoAeronave(resultSet.getString("tipo_aeronave"));
                vuelo.setCapacidadPasajeros(resultSet.getInt("capacidad_pasajeros"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vuelo;
    }

    public List<Vuelo> buscarVuelo(String origen, String destino, Date fecha) {
    }
}
