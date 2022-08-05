/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oabmobile.persistence.connection;

import com.oabmobile.bussines.utils.PreparedStatementNamed;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author oabaquero
 */
public class ConexionBD {

    private static Connection cnn;

    public Connection bdConexion() {

        try {
            InitialContext contexto = new InitialContext();
            DataSource ds = (DataSource) contexto.lookup("java:/PoolDes");
//            Class.forName("org.postgresql.Driver");
//             cnn =DriverManager.getConnection("jdbc:postgresql://154.53.61.199:5432/parkapp_dev", "develop", "F3!Dcu9u7&ArVznWGrDZpzQHXZiyMJ#fUU5P0JmtN@ZBX3v^SF");
            cnn = ds.getConnection();
            cnn.setAutoCommit(false);
        } catch (Throwable ex) {
            ex.printStackTrace();
            System.out.println("ERROR conexion ..");
        }
        return cnn;
    }

    public void desConectar() {
        try {
            if (!cnn.isClosed()) {
                cnn.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void commit() {
        try {
            cnn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void rollBack() {
        try {
            cnn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void close(PreparedStatement sentencia) {
        if (sentencia != null) {
            try {
                sentencia.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Cierra los recursos de una conexión
     *
     * @param rs Libera los recursos de una consulta
     * @param ps Libera la sentencia que se ejecutó
     * @param cnn Libera la conexión a la base de datos para que quede
     * disponible para otra petición
     */
    public void cerrar(ResultSet rs, PreparedStatementNamed ps, Connection cnn) {
        cerrarResultado(rs);
        cerrarSentencia(ps);
        cerrarConexion(cnn);
    }

    public void cerrarCorreo(Connection cnn) {
        cerrarConexion(cnn);
    }

    private void cerrarResultado(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cerrarSentencia(PreparedStatementNamed ps) {
        if (ps == null) {
            return;
        }
        try {
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cerrarConexion(Connection cnn) {
        if (cnn == null) {
            return;
        }
        try {
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
