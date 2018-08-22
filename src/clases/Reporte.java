package clases;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import formularios.frmReporteFacturas;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.itextpdf.text.pdf.PdfPCell;

public class Reporte {

    public static void reporteFacturas(String archivo, ResultSet rs) {
        String linea = "________________________________________"
                      + "_____________________________________";
        try {
            //Document documento = new Document(PageSize.LETTER, 80, 80, 75, 75);
            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(archivo));
            documento.open();

            //Colocamos el título del reporte
            Font fontTitulo = new Font(Font.FontFamily.HELVETICA, 13, Font.BOLD);
            String texto = "Reporte de Facturas";
            Paragraph titulo = new Paragraph(texto, fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            documento.add(new Paragraph(" "));
            //documento.add(new Chunk(linea));
            
            // creamos tipos de fuente
            Font font1 = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
            Font font3 = new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC);

            //Declaración de totales
            int totCanFac = 0;
            int totValFac = 0;
            int totCanGen = 0;
            int totValGen = 0;
            
            PdfPTable tabla;
            Paragraph parrafo;
            //Cuerpo del reporte
            String tab = "         "; //Definimos un tabulador
            boolean hayRegistros = rs.next();
            while (hayRegistros) {
                //Inicializamos totales de factura
                totCanFac = 0;
                totValFac = 0;
                
                documento.add(new Chunk(linea));
                documento.add(new Paragraph(" "));
                
                //Imprimimos el encabezado de la factura
                Phrase cabecera = new Phrase();                
                cabecera.add(new Chunk("Nº Factura: ", font1));
                cabecera.add(new Chunk("0001-" + Utilidades.agregarCeros(
                        rs.getString("idFactura"), 8) + tab, font2));
                cabecera.add(new Chunk("Fecha: ", font1));
                cabecera.add(new Chunk(Utilidades.dateToString(
                        rs.getDate("fecha")) + tab, font2));
                cabecera.add(new Chunk("Cliente: ", font1));
                cabecera.add(new Chunk(rs.getString("nomCliente") + tab, font2));
                documento.add(new Paragraph(cabecera));
                documento.add(new Paragraph(" "));                
                 
                //Imprimimos cabecera de detalle
                tabla = new PdfPTable(5);                
                tabla.setWidths(new float[] { 2, 5, 1, 2, 2 });                
                tabla.addCell(new Paragraph("ID Prod.", font1));
                tabla.addCell(new Paragraph("Descripción", font1));
                tabla.addCell(new Paragraph("Cant.", font1));
                tabla.addCell(new Paragraph("Precio", font1));
                tabla.addCell(new Paragraph("valor", font1));
                parrafo = new Paragraph();
                parrafo.add(tabla);
                documento.add(parrafo);                
                
                //Imprimimos las líneas del detalle
                int facturaActual = rs.getInt("idFactura");
                
                while (hayRegistros && facturaActual == rs.getInt("idFactura")) {
                    tabla = new PdfPTable(5);
                    tabla.setWidths(new float[] { 2, 5, 1, 2, 2 });
                    tabla.addCell(new PdfPCell(new Paragraph(rs.getString("idProducto"), font2)));
                    tabla.addCell(new Paragraph(rs.getString("descripcion"), font2));
                    tabla.addCell(new Paragraph(rs.getString("cantidad"), font2));
                    tabla.addCell(new Paragraph(rs.getString("precio"), font2));
                    tabla.addCell(new Paragraph(rs.getString("valor"), font2));
                    parrafo = new Paragraph();
                    parrafo.add(tabla);
                    documento.add(parrafo); 
                    
                    totCanFac += rs.getInt("cantidad");
                    totValFac += rs.getInt("valor");
                
                    hayRegistros = rs.next();
                }
                //Imprimimos los totales
                tabla = new PdfPTable(5);
                tabla.setWidths(new float[] { 2, 5, 1, 2, 2 });
                tabla.addCell(new PdfPCell(new Paragraph("Total fac.", font1)));
                tabla.addCell(new Paragraph(" ", font2));
                tabla.addCell(new Paragraph("" + totCanFac, font1));
                tabla.addCell(new Paragraph( " ", font2));
                tabla.addCell(new Paragraph("" + totValFac, font1));
                parrafo = new Paragraph();
                parrafo.add(tabla);
                documento.add(parrafo);
                
                //Acumulamos los totales generales
                totCanGen += totCanFac;
                totValGen += totValFac;
            }
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            //Imprimimos los totales generales
            tabla = new PdfPTable(5);
            tabla.setWidths(new float[] { 2, 5, 1, 2, 2 });
            tabla.addCell(new PdfPCell(new Paragraph("Total gral.:", font1)));
            tabla.addCell(new Paragraph(" ", font2));
            tabla.addCell(new Paragraph("" + totCanGen, font1));
            tabla.addCell(new Paragraph( " ", font2));
            tabla.addCell(new Paragraph("" + totValGen, font1));
            parrafo = new Paragraph();
            parrafo.add(tabla);
            documento.add(parrafo);
            
            documento.close();

        } catch (Exception ex) {
            Logger.getLogger(frmReporteFacturas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
