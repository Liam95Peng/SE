/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.giugno2019_server_01;

import javax.jws.WebService;

/**
 *
 * @author signorautoma
 */
@WebService
public interface Service {

    public Professor getDetails(String id);

}
