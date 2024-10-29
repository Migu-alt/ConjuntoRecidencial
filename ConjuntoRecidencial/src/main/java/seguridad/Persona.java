/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad;

/**
 *
 * @author USURIO
 */
public class Persona {
    
    private String nombre;    
    private int edad;
    private String ocupacion;
    private int telefono;
    private String correo;
    private int cedula;
    private String usuario;
    private String contrasena;
    private boolean estado;

    public Persona(String nombre,int edad, String ocupacion,  int telefono, String correo, int cedula,String usuario,String contrasena,boolean estado) {
        this.nombre = nombre;
        this.ocupacion = ocupacion;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado = estado;
    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
        public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String Usuario) {
        this.usuario = Usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.contrasena = Contrasena;
    }
    
    public String toCSV() {
        return nombre + "," + edad + "," + ocupacion + "," + telefono + "," + correo  + "," + cedula + "," + usuario  + "," + contrasena + "," + estado;
    }

    public boolean isPropietario() {
        return estado;
    }

    public void setPropietario(boolean estado) {
        this.estado = estado;
    }

    


}
