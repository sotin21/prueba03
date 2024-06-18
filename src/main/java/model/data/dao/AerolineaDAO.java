package model.data.dao;

import model.Aerolinea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AerolineaDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/flyeasy";
    private String jdbcUsername = "root";
    private String jdbcPassword = "password";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public Aerolinea getAerolinea(String codigoIATA) {
        Aerolinea aerolinea = null;
        String sql = "SELECT * FROM aerolineas WHERE codigo_iata = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, codigoIATA);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                aerolinea = new Aerolinea();
                aerolinea.setNombre(resultSet.getString("nombre"));
                aerolinea.setCodigoIATA(resultSet.getString("codigo_iata"));
                aerolinea.setImagenCorporativa(resultSet.getString("imagen_corporativa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aerolinea;
    }
}
