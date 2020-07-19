/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._2019_client;

/**
 *
 * @author signorautoma
 */
public class Launcher {
    public static void main(String[] args) {
        System.err.println("Starting Client Consumer");
        new ClientListener().start();
        System.err.println("Yoh");
    }
}
