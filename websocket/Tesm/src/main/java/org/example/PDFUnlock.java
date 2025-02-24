package org.example;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;

public class PDFUnlock {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\bunty\\Downloads\\Maths.pdf");

            // Load the PDF with the password
            PDDocument document = Loader.loadPDF(file, "cMy9OGD5T6-pAsKWaDTgfE");

            // Remove all security settings
            document.setAllSecurityToBeRemoved(true);

            // Save the unlocked PDF
            document.save("E:\\Rahul\\unlocked.pdf");
            document.close();

            System.out.println("✅ PDF Unlocked Successfully!");
        } catch (IOException e) {
            System.out.println("❌ Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
