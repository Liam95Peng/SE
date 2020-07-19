/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sapienza.softeng.rest.api;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

/**
 *
 * @author studente
 */
public class APIServer {
    public static void main(String args[]) throws Exception {
        // code snippets shown above
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(CoursesRepository.class);
        factoryBean.setResourceProvider(new SingletonResourceProvider(new CoursesRepository()));
        factoryBean.setAddress("http://localhost:8080/");
        Server server = factoryBean.create();
        System.out.println("Server ready!");
        while(true){
        }
    }
}
