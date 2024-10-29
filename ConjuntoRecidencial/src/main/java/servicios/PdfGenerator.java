/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import seguridad.Registro;

/**
 *
 * @author USURIO
 */
public class PdfGenerator {
    private static final String ARCHIVO_CSV = "Propietarios.csv";

    public static void generarPDFUsuarios(boolean esEmpleado) {
        Document documento = new Document();

        try {
            // Definir nombre del archivo según el tipo de lista
            String nombreArchivo = esEmpleado ? "Lista_Empleados.pdf" : "Lista_Propietarios.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            documento.open();

            // Título del PDF
            documento.add(new Paragraph(esEmpleado ? "Lista de Empleados" : "Lista de Propietarios"));
            documento.add(new Paragraph("\n"));

            // Leer el archivo CSV
            try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CSV))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");

                    // Asegúrate de que la línea tenga los campos necesarios
                    if (datos.length >= 9) {
                        String nombre = datos[0].trim();
                        String edad = datos[1].trim();
                        String ocupacion = datos[2].trim();
                        String telefono = datos[3].trim();
                        String correo = datos[4].trim();
                        String cedula = datos[5].trim();
                        String estado = datos[8].trim();

                        // Verifica el estado
                        boolean esEstadoEmpleado = Boolean.parseBoolean(estado);
                        if (esEstadoEmpleado == esEmpleado) {
                            // Agrega la información al PDF
                            documento.add(new Paragraph("Nombre: " + nombre));
                            documento.add(new Paragraph("Edad: " + edad));
                            documento.add(new Paragraph("Ocupación: " + ocupacion));
                            documento.add(new Paragraph("Teléfono: " + telefono));
                            documento.add(new Paragraph("Correo: " + correo));
                            documento.add(new Paragraph("Cédula: " + cedula));
                            documento.add(new Paragraph("\n-------------------------\n"));
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo CSV: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al leer el archivo CSV: " + e.getMessage());
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "PDF generado exitosamente: " + nombreArchivo);
            
             File archivoPDF = new File(nombreArchivo);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoPDF);
            } else {
                JOptionPane.showMessageDialog(null, "El sistema no soporta la apertura automática de archivos.");
            }
        } catch (DocumentException | IOException e) {
            System.err.println("Error al crear el PDF: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al crear el PDF: " + e.getMessage());
        }
    }
    public static void generarPDFPropiedad() {
        Document documento = new Document();

        try {
            // Definir nombre del archivo según el tipo de lista
            String nombreArchivo = "Lista_Propiedades.pdf" ;
            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            documento.open();

            // Título del PDF
            documento.add(new Paragraph("Lista de Propiedades"));
            documento.add(new Paragraph("\n"));

            // Leer el archivo CSV
            try (BufferedReader reader = new BufferedReader(new FileReader("propiedades.csv"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");

                    // Asegúrate de que la línea tenga los campos necesarios
                    if (datos.length >= 3) {
                        String id = datos[0].trim();
                        String cedula = datos[1].trim();
                        String tamano = datos[2].trim();
                        
                        cedula = Registro.buscarPropietarioPorCedula(cedula);
                        
                        documento.add(new Paragraph("Numero de la propiedad: " +id));
                        documento.add(new Paragraph("Dueño: \n" + cedula));
                        documento.add(new Paragraph("Tamaño: " + tamano + "m2"));
                       
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer el archivo CSV: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error al leer el archivo CSV: " + e.getMessage());
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "PDF generado exitosamente: " + nombreArchivo);
            
             File archivoPDF = new File(nombreArchivo);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoPDF);
            } else {
                JOptionPane.showMessageDialog(null, "El sistema no soporta la apertura automática de archivos.");
            }
        } catch (DocumentException | IOException e) {
            System.err.println("Error al crear el PDF: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al crear el PDF: " + e.getMessage());
        }
    }
}
