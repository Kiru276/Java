
package com.mycompany.reporteenfermedadesdeestudiantesubb;


public class alumno {
    String NombreCompleto;
    String RUT;
    int Edad;
    String Carrera;
    String Enfermedad;
    alumno siguiente;
    //contacto emergencia, casa, etc
    public alumno(String NombreCompleto, String RUT, int Edad, String Carrera, String Enfermedad, alumno siguiente) {
        this.NombreCompleto = NombreCompleto;
        this.RUT = RUT;
        this.Edad = Edad;
        this.Carrera = Carrera;
        this.Enfermedad = Enfermedad;
        this.siguiente = siguiente;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getRUT() {
        return RUT;
    }

    public void setRUT(String RUT) {
        this.RUT = RUT;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public String getEnfermedad() {
        return Enfermedad;
    }

    public void setEnfermedad(String Enfermedad) {
        this.Enfermedad = Enfermedad;
    }

    public alumno getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(alumno siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
