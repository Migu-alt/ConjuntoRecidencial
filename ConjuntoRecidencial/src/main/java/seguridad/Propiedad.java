/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad;

/**
 *
 * @author USURIO
 */
public class Propiedad {
    private int id; //se parado de forma si es la primera calle y la primera cas 101 si es la segunda 102 etc
    private int cedula;
    private  final String TAMANO = "1000";
    

    public Propiedad( int id,int propietario) {
        this.id = id;
        this.cedula = propietario;
        
    }

    public Propiedad(int id) {
        this.id = id;
    }
    
    



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTAMANO() {
        return TAMANO;
    }
    
     public String toCSV() {
        return id + "," + cedula + ","+ TAMANO;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
}
