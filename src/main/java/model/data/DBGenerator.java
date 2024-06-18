package model.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;

public class DBGenerator {

    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaVuelo(create);
        crearTablaAerolinea(create);
        crearTablaPasajero(create);
        crearTablaPasaje(create);
        DBConnector.closeConnection();
    }

    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearBaseDato(DSLContext create, String nombreBD) {
        create.createDatabaseIfNotExists(nombreBD).execute();
    }

    private static DSLContext actualizarConexion(Connection connection, String nombreBD) {
        DBConnector.closeConnection();
        connection = DBConnector.connection(nombreBD, "root", "");
        DSLContext create = DSL.using(connection);
        return create;
    }

    private static void crearTablaVuelo(DSLContext create) {
        create.createTableIfNotExists("Vuelo")
                .column("id", INTEGER.identity(true))
                .column("numeroVuelo", VARCHAR(255))
                .column("aerolinea", VARCHAR(255))
                .column("origen", VARCHAR(255))
                .column("destino", VARCHAR(255))
                .column("fechaSalida", VARCHAR(255))
                .column("fechaLlegada", VARCHAR(255))
                .column("horaSalida", VARCHAR(255))
                .column("horaLlegada", VARCHAR(255))
                .column("duracion", VARCHAR(255))
                .column("tipoAeronave", VARCHAR(255))
                .column("capacidadPasajeros", INTEGER)
                .constraint(primaryKey("id")).execute();
    }

    private static void crearTablaAerolinea(DSLContext create) {
        create.createTableIfNotExists("Aerolinea")
                .column("id", INTEGER.identity(true))
                .column("nombre", VARCHAR(100))
                .column("codigoIATA", VARCHAR(100))
                .column("imagenCorporativa", VARCHAR(100))
                .constraint(primaryKey("id")).execute();
    }

    private static void crearTablaPasajero(DSLContext create) {
        create.createTableIfNotExists("Pasajero")
                .column("id", INTEGER.identity(true))
                .column("nombreCompleto", VARCHAR(200))
                .column("documentoIdentidad", VARCHAR(50))
                .column("numeroTelefono", VARCHAR(50))
                .column("correoElectronico", VARCHAR(100))
                .column("fechaViaje", VARCHAR(50))
                .column("fechaNacimiento", VARCHAR(50))
                .column("nacionalidad", VARCHAR(50))
                .constraint(primaryKey("id")).execute();
    }

    private static void crearTablaPasaje(DSLContext create) {
        create.createTableIfNotExists("Pasaje")
                .column("id", INTEGER.identity(true))
                .column("idVuelo", INTEGER)
                .column("idPasajero", INTEGER)
                .column("tipoPasaje", VARCHAR(50))
                .column("asiento", VARCHAR(50))
                .constraint(primaryKey("id")).execute();
    }

    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion) {
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }

    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna) {
        create.alterTableIfExists(nombreTabla).addColumn(columna, tipoColumna);
    }
}