/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import GUI.AddDeletedUsers;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author johnleandro
 */
public class PDFReport {
    
    private String pdfFilename;
    private String author;
    private String appName;
    private String title;
    private String companyName;
    private String[] fields;
    private String[] dbFields;
    private ResultSet resultSet;

    /**
     * Default Constructor
     */
    public PDFReport() {
    }

    public PDFReport(String pdfFilename, String author, String appName, String title, String companyName, String[] fields, String[] dbFields, ResultSet resultSet) {
        this.pdfFilename = pdfFilename;
        this.author = author;
        this.appName = appName;
        this.title = title;
        this.companyName = companyName;
        this.fields = fields;
        this.dbFields = dbFields;
        this.resultSet = resultSet;
    }

    public String getPdfFilename() {
        return pdfFilename;
    }

    public void setPdfFilename(String pdfFilename) {
        this.pdfFilename = pdfFilename;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }

    public String[] getDbFields() {
        return dbFields;
    }

    public void setDbFields(String[] dbFields) {
        this.dbFields = dbFields;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    
    
    public void generatePDF() throws SQLException{
        Font bfBold12 = new Font (Font.FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.WHITE);
        Font b12 = new Font(Font.FontFamily.HELVETICA,  8);
        int columns = this.getFields().length;
        Paragraph header;
        
        
        try {
            Document doc  =  new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(this.getPdfFilename()));
            
            doc.addAuthor(this.getAuthor());
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator(this.getAppName());
            doc.addTitle(this.getTitle());
            doc.setPageSize(PageSize.LETTER);
            
            doc.open();
            
            header = new Paragraph(new Date().toString(),
                    FontFactory.getFont(FontFactory.COURIER, 8, Font.NORMAL));
            header.setAlignment(Element.ALIGN_RIGHT);
            doc.add(header);
            header = new Paragraph(this.getCompanyName(),
                    FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD));
            header.setAlignment(Element.ALIGN_RIGHT);            
            doc.add(header);
            header = new Paragraph(this.getTitle(),
                    FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLD));
            header.setAlignment(Element.ALIGN_CENTER);
            doc.add(header);
            
            header= new Paragraph ("");
            doc.add(header);
            
            PdfPTable table = new PdfPTable(columns);
            table.setWidthPercentage(95f);
            
             for (String field : this.getFields()) {
                this.insertPDFCell(table, field, Element.ALIGN_CENTER, 1, bfBold12, BaseColor.BLACK);
            }
            table.setHeaderRows(1);

            if (this.getResultSet() != null) {
                this.getResultSet().beforeFirst();
                while (this.getResultSet().next()) {
                    for (String dbField : this.getDbFields()) {
                        String value = (this.getResultSet().getString(dbField) == null)
                                ? "" : this.getResultSet().getString(dbField);
                        this.insertPDFCell(table, value, Element.ALIGN_CENTER, 1, b12, BaseColor.WHITE);
                    }
                }
            }

            doc.add(table);
            doc.close();
        } catch (DocumentException | FileNotFoundException ex) {
             Logger.getLogger(AddDeletedUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PDFReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

            
            
            
            
            
            
       

    private void insertPDFCell(PdfPTable table, String text, int align, int colspan, Font font, BaseColor Background) {
       
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        cell.setHorizontalAlignment(align);
        cell.setColspan(colspan);
        if (Background != BaseColor.WHITE) {
            cell.setBackgroundColor(Background);
        }
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        table.addCell(cell);
    }    

}
   
