package org.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.io.RandomAccessReadBufferedFile;

import java.io.File;
import java.io.IOException;

public class PDFRepair {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\bunty\\Downloads\\Maths.pdf");
            
            // Use PDFParser for damaged files
            PDFParser parser = new PDFParser(new RandomAccessReadBufferedFile(file));
            //parser.parse(); // Try to parse the corrupted PDF
            
            PDDocument document =  parser.parse();
            if (document != null) {
                document.setAllSecurityToBeRemoved(true);
                document.save("C:\\path\\to\\repaired.pdf");
                document.close();
                System.out.println("✅ PDF repaired and unlocked!");
            } else {
                System.out.println("❌ PDF is too damaged to recover.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
