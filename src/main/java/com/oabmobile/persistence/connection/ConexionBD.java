/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oabmobile.persistence.connection;

import java.sql.Connection;
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
	
	
	public static Connection bdConexion() throws NamingException, SQLException {
		InitialContext contexto = new InitialContext();
		DataSource ds = (DataSource) contexto.lookup("java:/PoolDesarrollo");
		cnn = ds.getConnection();
		cnn.setAutoCommit(false);
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
	
	  
    public void commit(){
        try {
            cnn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    
    public void rollBack(){
        try {
            cnn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }  

}
