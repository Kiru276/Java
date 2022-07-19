
package com.mycompany.ejercicioferreteria;


public class lista {
    Documento primero;
    Documento ultimo;
    int ContadorDocumentos=0;
    
    public lista(){
        primero=null;
        ultimo=null;
        ContadorDocumentos=0;
    }
    
    public void Ingresar(String TipoDoc, int NumeroDoc, double TotalDoc, double IvaDoc){
        Documento nuevo = new Documento(TipoDoc,NumeroDoc,TotalDoc,IvaDoc,null);
        Documento actual = primero;
        
        if(primero==null){
            primero=nuevo;
        }else{
            while(actual.getSiguiente() != null){ // FIFO 
                actual=actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        ContadorDocumentos++;
    }
    
    public void listar(){
        Documento actual = primero;
        if(primero!=null){
            do{
                System.out.println("Tipo de Documento: "+ actual.getTipoDocumento());
                System.out.println("Numero de Documento: |" +actual.getNumeroDocumento()+"|");
                System.out.println("Total de Documento: $"+ actual.getTotalDocumento());
                System.out.println("IVA del Documento extra por pagar: $"+ actual.getIvaDocumento()+"\n");

                actual=actual.getSiguiente();
            }while(actual != null);
        }else{
            System.out.println("ERROR: No hay registro de Documento alguno\n");
        }
        
    }
    
    public void Mayor(){
        Documento actual = primero;
        
        if(primero!=null){
            double mayor = primero.getTotalDocumento();
            
            do{
            if(actual.getTotalDocumento() > mayor){
                mayor = actual.getTotalDocumento();
            }
            actual=actual.getSiguiente();
            
            }while(actual != null);
            
            System.out.println("El monto mayor es de: |" +mayor+ "|\n");
        }else{
            System.out.println("ERROR: No hay registro de Documento alguno\n");
        }
    }
        
    
    public void Eliminar(int dato){
        Documento actual = primero;
        boolean encontrado = false;        
        Documento anterior = null;
        
        
        if(primero!=null){
            while(actual != null && encontrado != true){
                if(actual.getNumeroDocumento() == dato){
                    ContadorDocumentos--;
                    if(actual == primero){
                        primero=primero.getSiguiente();
                    }else if(actual == ultimo){
                        anterior.setSiguiente(null);
                        ultimo = anterior;
                    }else{
                        
                        anterior.setSiguiente(actual.getSiguiente());
                    }
                    encontrado=true;
                    System.out.println("Documento |" +dato+ "| eliminado exitosamente\n");
                }
                anterior=actual;
                actual=actual.getSiguiente();
            }
            if(encontrado == false){
                System.out.println("ERROR: NumeroDocumento |" +dato+ "| no encontrado\n");
            }
        }else{
            System.out.println("ERROR: No hay registro de Documento alguno\n");
        }
    }
    public void PromedioVentas(){
        Documento actual = primero;
        double promedio=0;
        
        if(primero != null){
            while(actual != null){
                promedio = actual.getTotalDocumento() + promedio;
                actual = actual.getSiguiente();
            }
            promedio = promedio/ContadorDocumentos;
            System.out.println("El promedio actual de ventas es de $" +Math.ceil(promedio)+ "\n");
        }else{                                                                                      
            System.out.println("ERROR: No hay registro de Documento alguno\n");
        }
    }
    
    public void CalculoIva(){
        Documento actual = primero;
        double IvaTotal = 0;
        
        if(primero != null){
            while(actual != null){
                if(actual.getTotalDocumento() > 180){
                    
                    IvaTotal = (actual.getTotalDocumento()*0.19) + IvaTotal;   //se podria cambiar tambien por
                    actual=actual.getSiguiente();                             //IvaTotal=actual.getIvaDocumento+Ivatotal;
                }else{
                    actual=actual.getSiguiente();
                }
            }
            System.out.println("El Iva total a pagar actualmente es de $" +Math.ceil(IvaTotal)+ "\n");
        }else{
            System.out.println("ERROR: No hay registro de Documento alguno\n");
        }
    }
    
    public boolean ComprobacionNumDoc(int dato){
        Documento actual = primero;
        boolean YaExiste = false;
        
        while(actual != null && YaExiste != true){
            if(actual.getNumeroDocumento() == dato){
                
                return true;
            }else{
                actual = actual.getSiguiente();
            }
        }
        return false;
    }
}
