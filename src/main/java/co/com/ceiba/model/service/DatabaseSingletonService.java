package co.com.ceiba.model.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseSingletonService {

    private static String db_url;
    private static String db_port;
    private static String db_name;
    private static String db_user;
    private static String db_pass;
    private static Statement connection;

    private DatabaseSingletonService() {
        /*
         *Parámetros por defecto de la base de datos
         */
        db_url = "jdbc:mysql://localhost";
        db_port = "3306";
        db_name = "accountingHomedb";
        db_user = "jorge";
        db_pass = "jorge123";
        /* Creación de una instancia del estado de la conexión*/
        connection = setConnection();
    }

    /* Método privado encargado de setear la conexión*/
    private static Statement setConnection() {
        try {
            String url = "" + db_url + ":" + db_port + "/" + db_name + "";
            java.sql.Connection conn = DriverManager.getConnection(url, db_user, db_pass);
            //Creación del objeto Estado (Statement)
            return conn.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(DatabaseSingletonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /* Clase Privada interna responsable de instanciar la instancia única del singleton */
    private static class DbSingletonManagerHolder {
        private final static DatabaseSingletonService instance = new DatabaseSingletonService();
    }

    /**
     * @return Método público, el cual es el único autorizado a devolver una instancia del singleton (aquí la instancia es la conexión a la base de datos).
     */
    public static DatabaseSingletonService getInstance() {
        try {
            return DbSingletonManagerHolder.instance;
        } catch (ExceptionInInitializerError ex) {
            Logger.getLogger(DatabaseSingletonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Statement getStatement() {
        return connection;
    }
}
