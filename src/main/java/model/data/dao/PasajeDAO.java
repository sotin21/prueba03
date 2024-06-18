package model.data.dao;
import model.Pasaje;

import java.sql.*;

public class PasajeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/flyeasy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void savePasaje(Pasaje pasaje) {
        String sql = "INSERT INTO pasajes (numero_vuelo, documento_identidad, tipo, precio, disponible, asiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pasaje.getVuelo().getNumeroVuelo());
            statement.setString(2, pasaje.getPasajero().getDocumentoIdentidad());
            statement.setString(3, pasaje.getTipo());
            statement.setDouble(4, pasaje.getPrecio());
            statement.setBoolean(5, pasaje.isDisponible());
            statement.setString(6, pasaje.getAsiento());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
