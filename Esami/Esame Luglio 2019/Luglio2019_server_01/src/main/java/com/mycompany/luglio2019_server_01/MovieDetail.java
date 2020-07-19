/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luglio2019_server_01;

import java.util.Map;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author signorautoma
 */
@XmlRootElement(name = "MovieDetail")
public class MovieDetail {

    public MovieDetail() {
    }

    private String title;
    private String year;
    private String directorName;

    @Override
    public String toString() {
        return "Movie " + title + " was shoot in" + year + ", by " + directorName + " that was born in " + directorYearOfBirth;
    }
    private String directorYearOfBirth;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getDirectorYearOfBirth() {
        return directorYearOfBirth;
    }

    public void setDirectorYearOfBirth(String directorYearOfBirth) {
        this.directorYearOfBirth = directorYearOfBirth;
    }

}
