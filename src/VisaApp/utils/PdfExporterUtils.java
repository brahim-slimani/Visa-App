package VisaApp.utils;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import static VisaApp.Main.*;

public class PdfExporterUtils {


    public void formBuild( ) throws DocumentException, IOException {

        Document doc = new Document();
        PdfWriter.getInstance(doc,new FileOutputStream("formulaire.pdf"));

        doc.open();


        Paragraph l = new Paragraph("__________________________________________________________________________",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,12, 1)));
        l.setSpacingAfter(1);                l.setIndentationLeft(20);
        doc.add(l);
        Paragraph cn = new Paragraph("***** Formaulaire demande de Visa *****",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,20, 1,BaseColor.RED)));
        cn.setIndentationLeft(80);
        cn.setSpacingAfter(1);
        doc.add(cn);
        Paragraph ll = new Paragraph("__________________________________________________________________________",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,12, 1)));
        ll.setSpacingAfter(20);ll.setIndentationLeft(20);
        doc.add(ll);

        Paragraph datee = new Paragraph("Formulaire rempli le : "+ LocalDate.now()+" à "+slieu ,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        datee.setSpacingAfter(25);

        doc.add(datee);

        Paragraph InfoC = new Paragraph("Informations personnelles du demandeur : _________________________________",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,12, 1)));
        InfoC.setSpacingAfter(5);
        doc.add(InfoC);
        Paragraph nmp = new Paragraph("    -Nom et prénom : "+snom+" "+sprenom ,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(nmp);
        Paragraph gn = new Paragraph("    -Adresse de résidence: "+sresidence,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(gn);
        Paragraph ec = new Paragraph("    -Sexe: "+genre,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(ec);
        Paragraph ad = new Paragraph("    -Etat civil: "+civil,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(ad);
        Paragraph dn = new Paragraph("    -Date et lieu de naissance : "+sdateN+" à "+slieuN,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(dn);
        Paragraph tel = new Paragraph("    -Nationalité actuelle : "+snation,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(tel);
        Paragraph pr = new Paragraph("    -Numéro de Téléphone : "+stel,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(pr);
        Paragraph dl = new Paragraph("    -Adresse éléctronique : "+semail,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        dl.setSpacingAfter(15);
        doc.add(dl);

        Paragraph InfoV = new Paragraph("Documents personnelles du demandeur : ___________________________________",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,12, 1)));
        InfoV.setSpacingAfter(5);
        doc.add(InfoV);
        Paragraph vl = new Paragraph("    -Numéro national d'identité : " +snumeroN,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(vl);

        Paragraph en = new Paragraph("    -Type de document du voyage  : "+stypeD   ,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(en);

        Paragraph kl = new Paragraph("    -Numéro de document du voyage : "+snumeroD,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(kl);

        Paragraph k2 = new Paragraph("    -Délivré le : "+sdateDD,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(k2);

        Paragraph k4 = new Paragraph("    -Profession actuelle : "+sprofession,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        k4.setSpacingAfter(15);
        doc.add(k4);

        Paragraph InfoD = new Paragraph("Information sur le voyage : ______________________________________________",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,12, 1)));
        InfoD.setSpacingAfter(5);
        doc.add(InfoD);
        Paragraph dd = new Paragraph("    -Objet principale du voyage :  "+stypeObjet,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(dd);

        Paragraph nj = new Paragraph("    -Nombre d'entrés demandés : "+snbre,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(nj);

        Paragraph n2 = new Paragraph("    -Autorisation d'entré dans le pays de déstination : "+sdateDV+" jusqu'au "+sdateFV,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        n2.setSpacingAfter(15);
        doc.add(n2);


        Paragraph InfoCD = new Paragraph("Information d'hébergeur : _______________________________________________",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,12, 1)));
        InfoCD.setSpacingAfter(5);
        doc.add(InfoCD);

        Paragraph ps = new Paragraph("    -Type d'hébergeur : "+stypeH,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(ps);
        Paragraph dps = new Paragraph("    -Adresse d'hébergeur  : "+sadresseH,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(dps);
        Paragraph ct = new Paragraph("    -Téléphone d'hébergeur : "+stelH,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        ct.setSpacingAfter(15);
        doc.add(ct);

        Paragraph InfoP = new Paragraph("Information de financement : _____________________________________________",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD,12, 1)));
        InfoP.setSpacingAfter(5);
        doc.add(InfoP);
        Paragraph pc = new Paragraph("    -Les frais du voyage sont financés par : "+sfrais,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        doc.add(pc);
        Paragraph pu = new Paragraph("    -Moyens de subsistance : "+stypeFrais,new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,10, 1)));
        pu.setSpacingAfter(60);
        doc.add(pu);


        LineSeparator line = new LineSeparator();
        doc.add(line);
        Paragraph rm = new Paragraph("Je soussigné, le demandeur certifie avoir prie connaissance des conditions générales de la demande de visa et j'accepte",new com.itextpdf.text.Font(FontFactory.getFont(FontFactory.HELVETICA,6, 1,BaseColor.RED)));
        rm.setSpacingAfter(10);
        doc.add(rm);



        doc.close();
        Desktop.getDesktop().open(new File("formulaire.pdf"));

    }


}
