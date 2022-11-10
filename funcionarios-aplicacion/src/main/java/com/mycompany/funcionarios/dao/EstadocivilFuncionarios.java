package com.mycompany.funcionarios.dao;

import com.mycompany.funcionarios.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class EstadocivilFuncionarios {
    
    private static final String GET_ESTADO_CIVIL = "select * from estado_civil";
    
    
    public List<Estado_civil> getEstado_civil() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Estado_civil> estado_civil = new ArrayList<>();
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_ESTADO_CIVIL);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Estado_civil estado_civil = new Estado_civil();
                estado_civil.setId(resultSet.getInt("estado_civil_id"));
                estado_civil.setNombre(resultSet.getString("nombre"));
                estado_civil.add(estado_civil);
            }
            return estado_civil;
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
}
