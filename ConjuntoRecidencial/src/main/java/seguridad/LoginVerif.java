/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import view.Administrador;
import view.Empleados;
import view.Propietarios;

/**
 *
 * @author USURIO
 */
public class LoginVerif {
        private static final String ARCHIVO = "Propietarios.csv"; // Archivo CSV donde se guardan los datos

    public static boolean verificarCredenciales(String nombreUsuario, String contrasena) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                
                int posicionusuario = 6; 
                int posicioncontrasena = 7;
                
                // Ajusta los índices de `posicionUsuario` y `posicionContrasena` según la estructura de tu CSV
                if (datos.length > posicioncontrasena) {
                    String usuarioGuardado = datos[posicionusuario].trim();
                    String contrasenaGuardada = datos[posicioncontrasena].trim();

                    if (usuarioGuardado.equals(nombreUsuario) && contrasenaGuardada.equals(contrasena)) {
                        return true; // Credenciales coinciden
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false; // Credenciales no coinciden
    }
        public static boolean verificarEstado(String nombreUsuario) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                
                int posicionusuario = 6; 
                int posicionestado = 8;
                
                // Ajusta los índices de `posicionUsuario` y `posicionContrasena` según la estructura de tu CSV
                if (datos.length > posicionestado) {
                    String usuarioGuardado = datos[posicionusuario].trim();
                    String estadoGuardado = datos[posicionestado].trim();
                    boolean aux = Boolean.parseBoolean(estadoGuardado);

                    if (usuarioGuardado.equals(nombreUsuario)) {
                        if (aux) {
                            return true; // Es un Empleado
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false; // Es un propietario
    }

    public static void iniciarSesion(String usuario, String contrasena) {
        if ("1".equals(usuario) && "1".equals(contrasena)){
            Administrador administrador = new Administrador();
            administrador.setVisible(true);
        }else{
        if (verificarCredenciales(usuario, contrasena)) {
            if(verificarEstado(usuario)){
                System.out.println("Inicio de sesión exitoso.");
                Empleados view = new Empleados(Registro.buscarPropietarioPorUsuario(usuario, contrasena));
                view.setVisible(true);
            }else{
                System.out.println("Inicio de sesión exitoso.");
                Propietarios view = new Propietarios();
                view.setVisible(true);
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos.");
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    
}
