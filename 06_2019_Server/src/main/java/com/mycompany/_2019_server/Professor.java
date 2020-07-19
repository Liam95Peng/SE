/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany._2019_server;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author signorautoma
 */
@XmlRootElement(name = "Professor")
public class Professor {

    private String name;
    private static Integer id = -1;
    private String surname;

    private static Map<String, Professor> professors = new HashMap<String, Professor>();

    public Professor() {
    }

    public Professor(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessors(Map<String, Professor> professors) {
        this.professors = professors;
    }

    static void insertProfessor(Professor professor) {
        id = id + 1;
        professors.put(id.toString(), professor);
    }

    static Professor getProfessor(String id) {
        System.out.println("Get professor " + id);
        return professors.get(id);
    }

}
