package VisaApp.controller;


import VisaApp.utils.PdfExporterUtils;
import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;

import java.io.IOException;

public class FifthFormController {

    public void print(ActionEvent e) throws IOException, DocumentException {
        PdfExporterUtils pr = new PdfExporterUtils();
        pr.formBuild();

    }
}
