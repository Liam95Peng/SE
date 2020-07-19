/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._2019_server;

import javax.xml.ws.Endpoint;

/**
 *
 * @author signorautoma
 */
public class Server {

    public static void main(String[] args) {
        Professor.insertProfessor(new Professor("Toro", "Cas"));
        Professor.insertProfessor(new Professor("Quinto", "Tordi"));
        Professor.insertProfessor(new Professor("Quilie", "Quis"));
        Professor.insertProfessor(new Professor("Latore", "Venti"));
        Professor.insertProfessor(new Professor("Arcoditri", "Onfo"));
        Professor.insertProfessor(new Professor("Silio", "Samba"));
        Professor.insertProfessor(new Professor("Gina", "Scorre"));

        
        ServiceImpl implementor = new ServiceImpl();

        String address = "http://localhost:8080/Service";
        Endpoint.publish(address, implementor);
        System.out.println("Server ready...");
        

    }
}
