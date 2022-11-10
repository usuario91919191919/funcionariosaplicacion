package com.mycompany.funcionarios.controller;

import com.mycompany.funcionarios.dao.FuncionariosDao;
import com.mycompany.funcionarios.domain.Funcionarios;
import java.sql.SQLException;
import java.util.List;


public class FuncionariosController {
   
    private FuncionariosDao funcionariosDao;
    
    public FuncionariosController(){
        funcionariosDao = new FuncionariosDao();
    }
    
    public List<Funcionarios> getFuncionarios() throws SQLException{
       return funcionariosDao.getFuncionarios();
    }
    
    public void create(Funcionarios funcionarios) throws SQLException{
        movieDao.create(movie);
    }
    
    public Funcionarios getFuncionarios(int id) throws SQLException{
        return funcionariosDao.getFuncionarios(id);
    }
    
    public void updateFuncionarios(int id, Funcionarios funcionarios) throws SQLException{
        funcionariosDao.updateFuncionarios(id, funcionarios);
    }
    
    public void deleteFuncionarios(int id) throws SQLException{
        funcionariosDao.deleteFuncionarios(id);
    }
}
