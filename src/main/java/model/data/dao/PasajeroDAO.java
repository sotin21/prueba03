package model.data.dao;
import model.Pasajero;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasajeroDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/flyeasy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public Pasajero getPasajero(String documentoIdentidad) {
        Pasajero pasajero = null;
        String sql = "SELECT * FROM pasajeros WHERE documento_identidad = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, documentoIdentidad);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                pasajero = new Pasajero();
                pasajero.setNombreCompleto(resultSet.getString("nombre_completo"));
                pasajero.setDocumentoIdentidad(resultSet.getString("documento_identidad"));
                pasajero.setTelefono(resultSet.getString("telefono"));
                pasajero.setCorreoElectronico(resultSet.getString("correo_electronico"));
                pasajero.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                pasajero.setNacionalidad(resultSet.getString("nacionalidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pasajero;
    }
}
