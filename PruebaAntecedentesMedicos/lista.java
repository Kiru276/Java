
package com.mycompany.reporteenfermedadesdeestudiantesubb;

public class lista {
    alumno primero;
    alumno ultimo;
    int ContadorGlobal;
    
    public lista(){
        primero = null;
        ultimo = null;
        ContadorGlobal = 0;
    }
    
    public void EntradaDatos(String Nombre, String RUT, int Edad, String Carrera, String Enfermedad){
        alumno nuevo = new alumno(Nombre,RUT,Edad,Carrera,Enfermedad,null);
        alumno actual = primero;
        
            if(primero == null){
                primero = nuevo;
            }else{
                while(actual.getSiguiente() != null){ 
                actual=actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
          }
            ContadorGlobal++;
    }
    
    public void ListamientoDatos(){
        alumno actual = primero;
        
        if(primero != null){
            while(actual != null){
                System.out.println("Nombre y apellidos: |" +actual.getNombreCompleto()+ "|");
                System.out.println("RUT: |" +actual.getRUT()+ "|");
                System.out.println("Edad: |" +actual.getEdad()+ "|");
                System.out.println("Carrera: |" +actual.getCarrera()+ "|");
                System.out.println("Antecedentes medicos: |" +actual.getEnfermedad()+ "|\n");
                
                actual=actual.getSiguiente();
            }
        }else{
            System.out.println("Lista vacia\n");
        }
    }
    
    public void EliminarAlumno(String RutAlumno){
        alumno actual = primero;
        boolean encontrado = false;
        alumno anterior = primero;
        
        if(primero != null){
            while(actual != null && encontrado != true){
                if(actual.getRUT().equals(RutAlumno)){
                    if(actual == primero){
                        primero = primero.getSiguiente();
                    }else if(actual == ultimo){
                        anterior.setSiguiente(null);
                    }else{
                        anterior.setSiguiente(actual.getSiguiente());
                    }
                    encontrado=true;
                    System.out.println("El alumno " +actual.getNombreCompleto()+ " fue eliminado existosamente de la lista\n");
                    ContadorGlobal--;
                }
                anterior = actual;
                actual =  actual.getSiguiente(); 
            }if(encontrado != true){
                System.out.println("RUT digitado no encontrado \n");
            }
        }else{
            System.out.println("Lista vacia\n");
        }
    }
}
