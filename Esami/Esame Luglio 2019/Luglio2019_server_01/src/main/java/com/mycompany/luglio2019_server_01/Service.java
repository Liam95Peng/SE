/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.luglio2019_server_01;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;

/**
 *
 * @author signorautoma
 */
@WebService
public interface Service {

    public List<MovieDetail> getMoiviesList() throws SQLException;

}
