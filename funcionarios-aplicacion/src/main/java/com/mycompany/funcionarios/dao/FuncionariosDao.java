    package com.mycompany.funcionarios.dao;

import com.mycompany.funcionarios.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class FuncionariosDao {
   
    private static final String GET_FUNCIONARIOS = "select funcionarios.*, estado_civil.name "
            + "from funcionarios "
            + "inner join estado_civil on funcionarios.estado_civil_id = estado_civil.estado_civil_id";
    private static final String CREATE_FUNCIONARIOS = "insert into movie(nombre, id, apellido,"
            + "estado_civil_id, tipo_identificacion) values(?, ?, ?, ?, ?)";
    private static final String GET_FUNCIONARIOS_BY_ID = "select funcionarios.*, estado_civil.name "
            + "from funcionarios "
            + "inner join genre on funcionarios.estado_civil_id = estado_civil.estado_civil_id "
            + "where funcionarios.funcionarios_id = ?";
    private static final String UPDATE_FUNCIONARIOS = "update funcionarios set nombre = ? , id = ?, "
            + "apellido = ?, estado_civil_id  = ?, tipo_identificacion = ? where funcionarios_id = ?";

    private static final String DELETE_FUNCIONARIOS = "delete from funcionarios where funcionarios_id = ?";
    
    
        public List<Movie> getFuncionarios() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionarios> funcionarios = new ArrayList<>();
        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Funcionarios funcionarios = new Funcionarios();
                funcionarios.setId(resultSet.getInt("id"));
                funcionarios.setNombre(resultSet.getString("nombre"));
                funcionarios.setApellido(resultSet.getString("apellido"));
                funcionarios.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
                funcionarios.setEstado_civil_id(resultSet.getString("estado_civil_id"));
                funcionarios.add(funcionarios);
            }
            return funcionarios;
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
        
        public void create(Funcionarios funcionarios) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_FUNCIONARIOS);
            preparedStatement.setString(1, funcionarios.getNombre());
            preparedStatement.setString(2, funcionarios.getId());
            preparedStatement.setString(3, funcionarios.getApellido());
 //           preparedStatement.setInt(4, funcionarios.getGenre().getId());
            preparedStatement.setString(4, funcionarios.getEstado_civil());
            preparedStatement.executeUpdate();

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }
        
         public Movie getFuncionarios(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionarios funcionarios = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                funcionarios = new Funcionarios();
                funcionarios.setId(resultSet.getInt("id"));
                funcionarios.setNombre(resultSet.getString("nombre"));
                funcionarios.setEstado_civil_id(resultSet.getString("estado_civil_id"));
                funcionarios.setApellido(resultSet.getString("apellido"));
                funcionarios.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
            }
            return funcionarios;
        } finally {

            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    public void updateFuncionarios(int id, Funcionarios funcionarios) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIOS);
            preparedStatement.setString(1, movie.getNombre());
            preparedStatement.setString(2, movie.getTipo_identificacion());
            preparedStatement.setString(3, movie.getApellido());
            preparedStatement.setString(4, movie.getEstado_civil_id());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                preparedStatement.close();
            }
        }
    }

    public void deleteFuncionarios(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIOS);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
}
