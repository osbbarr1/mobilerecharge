/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oabmobile.persistence.dao;

//import com.google.gson.Gson;
import com.oabmobile.bussines.utils.GenericResponse;
import com.oabmobile.persistence.dto.GetDataClientDTO;
import com.oabmobile.bussines.utils.PreparedStatementNamed;
import com.oabmobile.persistence.connection.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oabaquero
 */
public class GetDataClientDAO {
    
    public Connection cnn ;
    
    public GetDataClientDAO(){
    }
    
    public GetDataClientDTO getDataClientMobileNumber(long idnumber) throws  Exception{
        
        ConexionBD conexionBD = new ConexionBD();
        PreparedStatementNamed ps = null;
        ResultSet rs = null;
//        Gson gson = new Gson();
        GetDataClientDTO getDataClientDTO = new GetDataClientDTO();
        try{
        StringBuilder query = new StringBuilder();
            query.append("SELECT peo.peo_name nam, peo.peo_lastname lastname, peo.peo_document documents, peo.peo_mail mail, finp.finp_debt debt, finp.finp_id finpid, peo.peo_id peoid FROM mob_mobile mob INNER JOIN asm_assignmobile asm on asm.mob_id = mob.mob_id INNER JOIN peo_people peo on peo.peo_id = asm.peo_id INNER JOIN finp_financespeople finp on finp.peo_id = peo.peo_id WHERE mob.mob_number = :idnumber ;");
            ps = new PreparedStatementNamed(conexionBD.bdConexion(), query.toString());
            ps.setObject("idnumber", idnumber);
            rs = ps.executeQuery();
            while (rs.next()) {
                getDataClientDTO.setFinpid(rs.getLong("finpid"));
                getDataClientDTO.setPeoid(rs.getLong("peoid"));
                getDataClientDTO.setDebt(rs.getDouble("debt"));
                getDataClientDTO.setDocuments(rs.getInt("documents"));
                getDataClientDTO.setMail(rs.getString("mail"));
                getDataClientDTO.setLastname(rs.getString("lastname"));
                getDataClientDTO.setName(rs.getString("nam"));
            }
        } catch (SQLException e) {
                    System.out.println("Error obteniendo data   " + e.toString());
        } finally {
            conexionBD.cerrar(rs, ps, cnn);
        }
        //System.out.println("\n Resultado data busqueda number..............   ---> \n\n " + gson.toJson(getDataClientDTO)+ "\n");
        return getDataClientDTO;
    }
}
