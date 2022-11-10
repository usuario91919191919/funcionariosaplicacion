package com.mycompany.funcionarios.domain;


public class Estado_Civil {
    private int estadocivil_id;
    private String nombre;

    public int getEstadocivil_id() {
        return estadocivil_id;
    }

    public void setEstadocivil_id(int estadocivil_id) {
        this.estadocivil_id = estadocivil_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
            
}
