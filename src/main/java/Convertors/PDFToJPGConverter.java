package Convertors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class PDFToJPGConverter {
    public static void main(String[] args) {

        selectPdf();

    }

    //allow images selection for converting
    public static void selectPdf() {

        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF", "pdf");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(false);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            convertPDFToJPG(file.toString());
        }


    }

    public static void convertPDFToJPG(String src) {

        try {

            //load pdf file in the document object
            PDDocument doc = PDDocument.load(new FileInputStream(src));
            //Get all pages from document and store them in a list
            List<PDPage> pages = doc.getDocumentCatalog().getAllPages();
            //create iterator object so it is easy to access each page from the list
            Iterator<PDPage> i = pages.iterator();
            int count = 1; //count variable used to separate each image file
            //Convert every page of the pdf document to a unique image file
            System.out.println("Please wait...");
            while (i.hasNext()) {
                PDPage page = i.next();
                BufferedImage bi = page.convertToImage();
                ImageIO.write(bi, "jpg", new File("pdfimage" + count + ".jpg"));
                count++;
            }
            System.out.println("Conversion complete");
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }


}