/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

/**
 *
 * @author USURIO
 */
public class Factura {
    private int id;// id de la propiedad
    private int cedulaP;//identificador de propietario
    private int cedulaE;//identificador de Empleado
    private String descripcion;
    private int valorapagar;

    public Factura(int id, int cedulaP, int cedulaE, String descripcion, int valorapagar) {
        this.id = id;
        this.cedulaP = cedulaP;
        this.cedulaE = cedulaE;
        this.descripcion = descripcion;
        this.valorapagar = valorapagar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedulaP() {
        return cedulaP;
    }

    public void setCedulaP(int cedulaP) {
        this.cedulaP = cedulaP;
    }

    public int getCedulaE() {
        return cedulaE;
    }

    public void setCedulaE(int cedulaE) {
        this.cedulaE = cedulaE;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValorapagar() {
        return valorapagar;
    }

    public void setValorapagar(int valorapagar) {
        this.valorapagar = valorapagar;
    }
    
    
}
