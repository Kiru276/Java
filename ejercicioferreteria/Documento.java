
package com.mycompany.ejercicioferreteria;


public class Documento{
    private String TipoDocumento;
    private int NumeroDocumento;
    private double TotalDocumento;
    private double IvaDocumento;
    private Documento siguiente;

    public Documento(String TipoDocumento, int NumeroDocumento, double TotalDocumento, double IvaDocumento, Documento siguiente) {
        this.TipoDocumento = TipoDocumento;
        this.NumeroDocumento = NumeroDocumento;
        this.TotalDocumento = TotalDocumento;
        this.IvaDocumento = IvaDocumento;
        this.siguiente = siguiente;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public int getNumeroDocumento() {
        return NumeroDocumento;
    }

    public void setNumeroDocumento(int NumeroDocumento) {
        this.NumeroDocumento = NumeroDocumento;
    }

    public double getTotalDocumento() {
        return TotalDocumento;
    }

    public void setTotalDocumento(double TotalDocumento) {
        this.TotalDocumento = TotalDocumento;
    }

    public double getIvaDocumento() {
        return IvaDocumento;
    }

    public void setIvaDocumento(double IvaDocumento) {
        this.IvaDocumento = IvaDocumento;
    }

    public Documento getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Documento siguiente) {
        this.siguiente = siguiente;
    }
}
