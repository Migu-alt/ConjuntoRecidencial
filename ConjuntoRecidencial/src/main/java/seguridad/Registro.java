/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seguridad;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
/**
 *
 * @author USURIO
 */
public class Registro {
    
    
    
    public static void guardarUsuario(Persona propie) throws IOException{
        
        Persona usuario =propie;
        if (propie != null){
            int aux = usuario.getCedula();
            String cedula = Integer.toString(aux);
            if(verificarCedulaExistente(cedula) == false){
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Propietarios.csv", true))) {
                writer.write(usuario.toCSV());
                writer.newLine();
                System.out.println("Usuario guardado exitosamente.");
                JOptionPane.showMessageDialog(null, "Usuario guardado exitosamente", "Aviso", JOptionPane.ERROR_MESSAGE);                
                }catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                
        }
            
      
    }
    }
    
    public static void guardarPropiedad(Propiedad propie) throws IOException{
        
        Propiedad usuario =propie;
        if (propie != null){
            int aux = usuario.getId();
            String id = Integer.toString(aux);
            if(verificarId(id)== false){
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Propiedades.csv", true))) {
                writer.write(usuario.toCSV());
                writer.newLine();
                System.out.println("Usuario guardado exitosamente.");
                JOptionPane.showMessageDialog(null, "Usuario guardado exitosamente", "Aviso", JOptionPane.ERROR_MESSAGE);                
                }catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                
        }
}
            
      
    }
    
    public static boolean verificarCedulaExistente(String cedula) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Propietarios.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(","); // Supone que los campos están separados por comas

                if (datos.length > 5 && datos[5].equals(cedula)) {
                    JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return true; // El correo ya existe
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return false; // El correo no existe
    }
    public static boolean verificarCedulaExistentePro(String cedula) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Propietarios.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(","); // Supone que los campos están separados por comas

                if (datos.length > 5 && datos[5].equals(cedula)) {
                    
                    return true; // El correo ya existe
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return false; // El correo no existe
    }
    public static boolean verificarId(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Propiedades.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(","); // Supone que los campos están separados por comas

                if (datos.length > 0 && datos[0].equals(id)) {
                    JOptionPane.showMessageDialog(null, "La propiedad ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                    return true; //si existe
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return false; // El correo no existe
    }
    public static boolean verificarPropie(String propie) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Propiedades.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(","); // Supone que los campos están separados por comas

                if (datos.length > 1 && datos[1].equals(propie)) {
                    JOptionPane.showMessageDialog(null, "El propietario ya es dueño de una propiedad", "Error", JOptionPane.ERROR_MESSAGE);
                    return true; //si existe
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
        return false; // El correo no existe
    }
     public static String buscarPropietarioPorCedula(String cedula) {
        String texto = "";
        String nombre = "";
        int edad = 0;
        String ocupacion = "";
        int telefono = 0;
        String correo = "";
        String usuario = "";
        String contrasena = "";

        try (BufferedReader reader = new BufferedReader(new FileReader("Propietarios.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");

                if (datos.length >= 8 && datos[5].trim().equals(cedula)) {
                    nombre = datos[0].trim();
                    edad = Integer.parseInt(datos[1].trim());
                    ocupacion = datos[2].trim();
                    telefono = Integer.parseInt(datos[3].trim());
                    correo = datos[4].trim();
                    usuario = datos[6].trim();
                    contrasena = datos[7].trim();
                    
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Edad: " + edad);
                    System.out.println("Ocupación: " + ocupacion);
                    System.out.println("Teléfono: " + telefono);
                    System.out.println("Correo: " + correo);
                    System.out.println("Usuario: " + usuario);
                    System.out.println("Contraseña: " + contrasena);
                    
                    texto= " Nombre: " + nombre +"\n Edad: " + edad +"\n Ocupación: " + ocupacion+
                            "\n Teléfono: " + telefono+"\n Correo: " + correo+
                            "\n Usuario: " + usuario+"\n Contraseña: " + contrasena;
                    
                    return texto;
                }
            }
            texto  = "No tiene propietario";
            return texto;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato en los datos numéricos: " + e.getMessage());
        }
        return null;
     }
     
    public static Persona buscarPropietarioPorUsuario(String usuario,String contrasena) {

        String nombre = "";
        int edad = 0;
        String ocupacion = "";
        int telefono = 0;        
        String correo = "";
        int cedula = 0;
        boolean estado;
        Persona obj = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("Propietarios.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");

                if (datos.length >= 8 && datos[6].trim().equals(usuario)&&datos[7].trim().equals(contrasena)) {
                    nombre = datos[0].trim();
                    edad = Integer.parseInt(datos[1].trim());
                    ocupacion = datos[2].trim();
                    telefono = Integer.parseInt(datos[3].trim());
                    correo = datos[4].trim();
                    cedula = Integer.parseInt(datos[5].trim());
                    estado = Boolean.parseBoolean(datos[8].trim());
                    
                    obj = new Persona(nombre,edad, ocupacion,telefono,correo,cedula,usuario,contrasena,estado);
                    
                    return obj;
                }
            }
            return obj;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato en los datos numéricos: " + e.getMessage());
        }
        return null;
     }
}

