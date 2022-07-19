
package com.mycompany.reporteenfermedadesdeestudiantesubb;

import java.util.Scanner;

public class ReporteEnfermedadesDeEstudiantesUBB {

    public static void main(String[] args) {
        lista l = new lista();
        Scanner lectura = new Scanner(System.in);
        int opcion=0;
        
        
        do{
            System.out.println("----Bienvenido al dignostico de salud voluntario UBB-----");
            System.out.println("| 1)Ingresar a un nuevo alumno                          |");
            System.out.println("| 2)Listar alumnos diagnosticados actuales              |");
            System.out.println("| 3)Eliminar alumno registrado                          |");
            System.out.println("| 4)SALIR                                               |\n");
            System.out.print("¿Que opcion desea realizar?:");
            
            opcion = lectura.nextInt();
            
            switch(opcion){
                case 1:
                    String NombreCompleto; String RUT; String Carrera; String Enfermedad;
                    int edad;
                    
                    lectura.nextLine();//borra \n de: opcion = lectura.nextInt();
                    //NOMBRE
                    System.out.println("\nIngrese el nombre completo del alumno (ej: Juan Riveras Candia):");
                    NombreCompleto = lectura.nextLine();
                    
                    //RUT
                    boolean correcto = false;
                    do{
                        System.out.println("\nIngrese el R.U.T del alumno (ej: 12345678-9):");
                        RUT = lectura.nextLine();
                        
                        if(RUT.length() != 10){
                            System.out.println("ERROR: Ingrese un RUT valido"); //parametro ingresado NO posee los 10 carateres
                        }else if(RUT.charAt(8)=='-'){   //parametro ingresado posee los 10 carateres
                            correcto = true;            //parametro ingresado posee el guion donde corresponde
                        }else{
                            System.out.println("ERROR: Ingrese el guion de forma correspondiente"); //parametro ingresado NO posee el guion correspondiente
                        }
                    }while(RUT.length() != 10 || correcto != true);//charAt() empieza a contar desde 0;
                    
                    
                    //Edad
                    do{
                        System.out.println("\nIngrese la edad del alumno: ");
                        edad = lectura.nextInt();
                        
                        if(edad < 15 || edad > 120){
                            System.out.println("Edad ingresada no es valida, porfavor ingrese una correcta\n");
                        }
                    }while(edad < 15 || edad > 120);
                    
                    lectura.nextLine();//borra \n de: edad = lectura.nextInt();
                    //Carrera
                    System.out.println("\nIngrese la carrera universitaria que esta cursando: (Ingenieria Ejecucion En Computacion e Informatica):");
                    Carrera = lectura.nextLine();
                    
                    //Enfermedad
                    System.out.println("\nIngrese sus antecedentes medicos (Ej: Cardiopatia e hipertension)");
                    Enfermedad = lectura.nextLine();
                    
                    l.EntradaDatos(NombreCompleto, RUT, edad, Carrera, Enfermedad);
                
                    break;
                
                case 2:
                    l.ListamientoDatos();
                    break;
                
                case 3:
                    System.out.println("\nIngrese el RUT del alumno a eliminar de la lista:");
                    lectura.nextLine();
                    String RutAlumno = lectura.nextLine();
                    l.EliminarAlumno(RutAlumno);
                    break;
                
                case 4:
                    System.out.println("\n\nMuchas Gracias por tu aporte, xiao xiao!!");
                    break;
                    
            }
            
        }while(opcion != 4);
    }
}
