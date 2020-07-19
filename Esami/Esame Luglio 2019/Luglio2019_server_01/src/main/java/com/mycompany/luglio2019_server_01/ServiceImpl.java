/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luglio2019_server_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author signorautoma
 *
 */
@WebService(endpointInterface = "com.mycompany.luglio2019_server_01.Service")
public class ServiceImpl implements Service {

    Connection connection = null;
    Statement statement = null;

    public ServiceImpl() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:luglio2019_01_database.db");

        statement = connection.createStatement();
        statement.setQueryTimeout(30);

    }

    @Override
    public List<MovieDetail> getMoiviesList() throws SQLException {
        try {

            ResultSet rs1 = statement.executeQuery("SELECT * FROM MOVIES JOIN DIRECTORS ON MOVIES.directorID = DIRECTORS.ID");
            List<MovieDetail> movieList = new ArrayList<>();

            // Here i'm not doing the best thing in the world
            // but it's fast, lol.
            // Anyways i don't know if i will ever rewrite this code
            // So at least change the id with moive ID.
            // To do this you should change the query with alias instead of the SELECT *
            if (rs1 != null) {
                int i = 0;
                while (rs1.next()) {
                    MovieDetail item = new MovieDetail();

                    item.setTitle(rs1.getString("title"));
                    item.setYear(rs1.getString("year"));
                    item.setDirectorName(rs1.getString("name"));
                    item.setDirectorYearOfBirth(rs1.getString("yearOfBirth"));

                    System.out.println("Movie " + item.getTitle() + " was shoot in " + item.getYear() + ", by " + item.getDirectorName() + " born in " + item.getDirectorYearOfBirth());
                    //movieList.add(item);
                    movieList.add(i, item);
                    i = i++;
                }
            }

            System.out.println("Tutto bene fratelli: " + movieList);
            return movieList;

        } catch (SQLException sQLException) {
            System.err.println(sQLException.getMessage());
            return null;
        }
    }
}
