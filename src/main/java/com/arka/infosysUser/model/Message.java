/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arka.infosysUser.model;

/**
 *
 * @author arkaf
 */
public class Message {
    String message;

    public Message() {
        setMessage("Responded successful");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
