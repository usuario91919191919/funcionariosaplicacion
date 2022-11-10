package com.mycompany.funcionarios;

import java.lang.invoke.MethodHandles;
import jdk.dynalink.linker.support.Lookup;


public class Main2 {
    
    public static void getFuncionarios(FuncionariosController funcionariosController) {
        try {
            List<Funcionarios> funcionarios = funcionariosController.getFuncionarios();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay datos ");
            } else {
                movies.forEach(funcionarios -> {
                    System.out.println("id: " + funcionarios.getId());
                    System.out.println("Nombre: " + funcionarios.getNombre());
                    System.out.println("Apellido: " + funcionarios.getApellido());
                    System.out.println("Estado civil: " + funcionarios.getEstado_civil_id());
                    System.out.println("Tipo de identificacion Id: " + funcionarios.getTipo_identificacion());

                    System.out.println("---------------------------------");
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void create(FuncionariosController funcionariosController) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite nombre: ");
            String nombre = sc.nextLine();
            System.out.println("Nombre: " + nombre);
            System.out.println("----------------------- ");

            System.out.println("Digite id: ");
            String anio = sc.nextLine();
            System.out.println("el id es: " + id);
            System.out.println("------------------------ ");

            System.out.println("Digite apellido: ");
            String actor = sc.nextLine();
            System.out.println("Apellido: " + apellido);
            System.out.println("------------------------- ");

            System.out.println("Digite el estado civil: ");
            String genre = sc.nextLine();
            System.out.println("estado civil: " + estado_civil_id);
            System.out.println("-------------------------- ");


            Funcionarios funcionarios = new Funcionarios();
            funcionarios.setNombre(nombre);
            funcionarios.setId(id);
            funcionarios.setApellido(apellido);
            funcionarios.setEstado_civil_id(estado_civil_id);
            funcionariosController.create(funcionarios);
            System.out.println("Se ha creado un nuevo funcionario: ");
            
            getFuncionarios(funcionariosController);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void getFuncionarios(FuncionariosController funcionariosController) {

        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite el id: ");
            int id = sc.nextInt();
            System.out.println("id: " + id);
            System.out.println("-------------------------- ");
            
            Movie funcionarios = funcionariosController.getFuncionarios(id);
            System.out.println("movie = " + funcionarios);
            System.out.println("-------------------------------------------- ");
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void editFuncionarios(FuncionariosController funcionariosController){
        
        try {
            
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Digite ID del funcionario a actualizar");
            int id = sc.nextInt();
            System.out.println("el ID es: " + id);
            System.out.println("--------------------------------------- ");
            
            Funcionarios funcionariosExits = funcionariosController.getFuncionarios(id);
            if(funcionariosExits == null){
                System.out.println("No existe funcionario");
                return;
            }
            
            Scanner tl = new Scanner(System.in);
            System.out.println("Digite el nombre: ");
            String nombre = tl.nextLine();
            System.out.println("el nombre es: " + titulo);
            System.out.println("--------------------------------------- ");
            
            Scanner an = new Scanner(System.in);
            System.out.println("Digite apellido: ");
            String apellido = an.nextLine();
            System.out.println("El apellido es: " + apellido);
            System.out.println("--------------------------------------- ");
            
            Scanner ac = new Scanner(System.in);
            System.out.println("Digite el estado civil");
            String estado_civil_id = ac.nextLine();
            System.out.println("El estado civil es: " + estado_civil_id);
            System.out.println("--------------------------------------- ");
            
            Scanner gn = new Scanner(System.in);
            System.out.println("Digite el tipo de identificacion");
            String tipo_identificacion = gn.nextLine();
            System.out.println("El tipo de identificacion es: " + tipo_identificacion);
            System.out.println("--------------------------------------- ");
            
            Funcionarios funcionarios = new Funcionarios();
            funcionarios.setNombre(nombre);
            funcionarios.setId(id);
            funcionarios.setApellido(apellido);
            funcionarios.setEstado_civil_id(estado_civil_id);
            funcionariosController.updateFuncionarios(id, funcionarios);
            System.out.println("Se actualizó correctamente el funcionario");
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void deleteFuncionarios(FuncionariosController funcionariosController){
            try{
                Scanner sc = new Scanner(System.in);
                
                System.out.println("Digite el ID del funcionario a eliminar: ");
                int id = sc.nextInt();
                System.out.println("el id del funcionario es: " + id);
                Funcionarios funcionariosExists = funcionariosController.getFuncionarios(id);
                if(funcionariosExists == null){
                    System.out.println("No existe funcionario ");
                    return;
                }
                
                funcionariosController.deleteFuncionarios(id);
                System.out.println("Funcionario eliminado con exito ");
                System.out.println("-----------------------------------------");
                getFuncionarios(funcionariosController);
                
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            
            public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        FuncionariosController funcionariosController = new FuncionariosController();
        while(opcion != 0){
            System.out.println("----------------------------------");
            System.out.println("ELIGE UNA OPCIÓN");
            System.out.println("----------------------------------");
            
            System.out.println("1. Listar Funcionarios "  );        
            System.out.println("2. Agregar Funcionarios");
            System.out.println("3. Listar por Id");
            System.out.println("4. Editar Funcionarios");
            System.out.println("5. Eliminar Funcionario");
            
            System.out.println("----------------------------------");
            
            opcion = Integer.parseInt(scanner.nextLine());
            switch(opcion){
                case 0:
                    System.out.println("Ha salido de la aplicación ");
                    break;
                case 1:
                    getFuncionarios(funcionariosController);
                    break;
                case 2:
                    create(funcionariosController);
                    break;
                case 3:
                    getFuncionarios(funcionariosController);
                    break;
                case 4:
                    editFuncionarios(funcionariosController);
                    break;
                case 5:
                    deleteFuncionarios(funcionariosController);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }     
            
}
