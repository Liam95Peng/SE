/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.giugno2019_server_01;

/**
 *
 * @author signorautoma
 */
import javax.jws.WebService;

@WebService(endpointInterface = "com.mycompany.giugno2019_server_01.Service")
public class ServiceImpl implements Service {

    public Professor getDetails(String id) {

        return Professor.getProfessor(id);
    }

}
