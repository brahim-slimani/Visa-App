package VisaApp.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static VisaApp.Main.*;
import static javafx.fxml.FXMLLoader.load;

public class ForthFormController implements Initializable {


    @FXML private JFXComboBox frais;
    @FXML private JFXDatePicker dte;
    @FXML private JFXTextField lieu;
    @FXML private JFXComboBox typeFrais;


    @FXML private AnchorPane anc;


    ObservableList<String> listeD = FXCollections.observableArrayList();
    ObservableList<String> objets = FXCollections.observableArrayList();
    ObservableList<String> listeH = FXCollections.observableArrayList();
    ObservableList<String> listeF = FXCollections.observableArrayList();
    ObservableList<String> listeM = FXCollections.observableArrayList();
    public Stage alert = new Stage();

    public void next(ActionEvent e) throws IOException {
        if(
             String.valueOf(frais.getValue())=="null"
                || String.valueOf(typeFrais.getValue())=="null" || String.valueOf(dte.getValue()).equals("null") || lieu.getText().isEmpty()
                ){

            Alert alert = new Alert(Alert.AlertType.WARNING,"vous devez remplir les champs obligatoires !" );
            alert.showAndWait();
        }else{
            sfrais= String.valueOf(frais.getValue());
            stypeFrais= String.valueOf(typeFrais.getValue());slieu=lieu.getText();


            AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("VisaApp/views/5th_form.fxml"));
            anc.getChildren().setAll(pane);

            Parent root = load(getClass().getClassLoader().getResource("VisaApp/views/reussite.fxml"));
            alert.setTitle("Succes");
            alert.setScene(new Scene(root, 362, 149));
            alert.show();
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(ee -> alert.hide());
            delay.play();

        }

    }




    public void filling(){
        listeD.add("Passeport ordinaire");
        listeD.add("Passeport diplomatique");
        listeD.add("Passeport de service");
        listeD.add("Passeport officiel");
        listeD.add("Passeport spécial");

        listeH.add("Chez une personne");
        listeH.add("hôtel");

        listeF.add("par vous-même");
        listeF.add("par un garant");

        listeM.add("Argent liquide");
        listeM.add("Chèques de voyage");
        listeM.add("Carte de crédit");
        listeM.add("Hébergement prépayé");
        listeM.add("Transport prépayé");
        listeM.add("Hébergement prépayé");


        objets.add("Tourisme");
        objets.add("Affaires");
        objets.add("Visite à la famille ou à des amis");
        objets.add("Culture");
        objets.add("Sports");
        objets.add("Visite officielle");
        objets.add("Études");
        objets.add("Raisons médicales");
        objets.add("Transit");
        objets.add("Transit aéroportuaire");

        typeFrais.setItems(listeM);
        frais.setItems(listeF);

        dte.setValue(LocalDate.now());

    }


    public void last(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("VisaApp/views/3rd_form.fxml"));
        anc.getChildren().setAll(pane);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filling();

    }
}
