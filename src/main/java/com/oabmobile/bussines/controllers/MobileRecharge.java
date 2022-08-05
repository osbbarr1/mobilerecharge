package com.oabmobile.bussines.controllers;

import com.oabmobile.bussines.service.GetDataClientService;
import com.oabmobile.bussines.utils.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/recharge")
public class MobileRecharge {

    @Autowired
    GetDataClientService getDataClientService;

    @GetMapping(path = "/getMobile", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse getdata() throws Exception {
        try {
            return getDataClientService.getClientNumber(3202229848L);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
//    @GetMapping(path="/getMobile/{idnumber}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public  GenericResponse getdata(@PathVariable(value="idNumber", required=true) int idNumber) throws Exception {
//        return  getDataClientService.getClientNumber(3202229848L);
//    }

    @GetMapping(path = "/getMobiles", produces = MediaType.APPLICATION_JSON_VALUE)
    public int getdatas() throws Exception {
        return 1;
    }
}
