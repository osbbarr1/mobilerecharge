/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oabmobile.bussines.service;

import com.oabmobile.bussines.utils.GenericResponse;
import com.oabmobile.persistence.connection.ConexionBD;
import com.oabmobile.persistence.dao.GetDataClientDAO;
import java.sql.SQLException;
import javax.naming.NamingException;
import org.springframework.stereotype.Service;

/**
 *
 * @author oabaquero
 */

@Service
public class GetDataClientService {
    
    public GetDataClientDAO getDataClientDAO;
    
    public GetDataClientService() {
        getDataClientDAO = new GetDataClientDAO();
    }
    
    public GenericResponse getClientNumber(long number) throws Exception{
        
        GenericResponse genericResponse = new GenericResponse();
            genericResponse.setCode(1);
            genericResponse.setMessage("Number cliente ");
            genericResponse.setData(getDataClientDAO.getDataClientMobileNumber(number));
        return genericResponse;
        
    }
    
    
}
