/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oabmobile.persistence.dto;

/**
 *
 * @author oabaquero
 */
public class GetDataClientDTO {
    
    public long finpid;
    public long peoid;
    public int documents;
    public String name;
    public String lastname;
    public String mail;
    public double debt;

    public long getFinpid() {
        return finpid;
    }

    public void setFinpid(long finpid) {
        this.finpid = finpid;
    }

    public long getPeoid() {
        return peoid;
    }

    public void setPeoid(long peoid) {
        this.peoid = peoid;
    }

    public int getDocuments() {
        return documents;
    }

    public void setDocuments(int documents) {
        this.documents = documents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }
    
    
    
    
    
}
