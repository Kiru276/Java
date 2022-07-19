
package com.mycompany.ejercicioferreteria;

import java.util.Scanner;


public class EjercicioFerreteria {

    
    public static void main(String[] args) {
        lista l = new lista();
        int opcion=0;
        Scanner teclado = new Scanner(System.in);
        
       //INFORMACION DE EJEMPLO:
        l.Ingresar("Factura", 1, 200, 38);
        l.Ingresar("Boleta", 2, 100, 0);
        l.Ingresar("Factura", 3, 400, 76);
        
        //ingreso de metodos de ejemplo //se pueden eliminar si es que desea
        l.listar(); 
        l.Mayor();
        l.PromedioVentas();
        l.CalculoIva();
        l.Eliminar(3);
        l.listar();
        l.Eliminar(1);
        l.Eliminar(2);
        l.listar();
        
        //MENU
        do{
            System.out.println("/////MENU/////");
            System.out.println("1)Ingresar Documento nuevo");
            System.out.println("2)Listar Documentos actuales");
            System.out.println("3)Comprobar Documento con monto mayor");
            System.out.println("4)Eliminar Documento anulado");
            System.out.println("5)Calculo promedio de ventas");
            System.out.println("6)Calculo IVA a pagar por ventas totales");
            System.out.println("7)SALIR");
            
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    //Ingreso de TipoDocumento
                    String TipoDocumento="";
                    int NumeroDocumento;
                    double TotalDocumento; double IvaDocumento=0; 
                    
                    opcion=0;
                    do{
                        System.out.println("Ingrese Tipo del docuemento:\n\n 1)Boleta\n 2)Factura\n");
                        opcion = teclado.nextInt();
                        if(opcion==1){
                            TipoDocumento="Boleta";
                        }
                        if(opcion==2){
                            TipoDocumento="Factura";
                        }
                        if(opcion<1 || opcion>2){
                            System.out.println("ERROR: Ingrese un valor valido (1 o 2)");
                        }
                    }while(opcion<1 || opcion>2);
                    
                    //Ingreso de NumeroDocumento
                    boolean NumDocExiste;
                    do{
                        System.out.println("Ingrese el numero del Documento:");
                        NumeroDocumento =  teclado.nextInt();
                        
                        if(NumeroDocumento < 1){
                            System.out.println("ERROR: Ingrese un numero de Documento valido (NO negativo):");
                        }
                        
                        NumDocExiste = l.ComprobacionNumDoc(NumeroDocumento);
                        
                        if(NumDocExiste == true){
                            System.out.println("ERROR: NumeroDocumento ingresado ya existe, porfavor digite otro");
                        }
                        
                    }while(NumeroDocumento < 1 || NumDocExiste == true);
                    
                    //Ingreso de TotalDocumento
                    do{
                        System.out.println("Ingrese el valor monetario total del Documento (pesos chilenos):");
                        TotalDocumento = teclado.nextDouble();
                        if(TotalDocumento<0){
                            System.out.println("ERROR: Ingrese un valor monetario valido para el documento (positivo)");
                        }
                    }while(TotalDocumento<0);
                    
                    //Ingreso de IvaDocumento
                    if(TotalDocumento > 180){ //mayor a 180, precio mayor a 180 se incluye IVA (19%) al producto
                        IvaDocumento = TotalDocumento*0.19;
                    }
                    
                    l.Ingresar(TipoDocumento, NumeroDocumento, TotalDocumento, IvaDocumento);
                    
                    break;
                    
                case 2:
                    System.out.println("Listando Documentos actuales...");
                    l.listar();
                    break;
                    
                case 3:
                    System.out.println("Comprobando Documento monto mayor...");
                    l.Mayor();
                    break;
                    
                case 4:
                    System.out.println("Ingrese el Documento a eliminar (NumeroDocumento):");
                    int EliminarDoc=teclado.nextInt();
                    l.Eliminar(EliminarDoc);
                    break;
                    
                case 5:
                    System.out.println("Calculando el promedio de ventas...");
                    l.PromedioVentas();
                    break;
                    
                case 6:
                    System.out.println("Calculando el IVA a pagar...");
                    l.CalculoIva();
                    break;
                    
                case 7:
                    System.out.println("Gracias por usar el programa!! xiao xiao");
                    break;
            }
        }while(opcion != 7);
    }
}
