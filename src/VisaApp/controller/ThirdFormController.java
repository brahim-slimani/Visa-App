package VisaApp.controller;

import com.jfoenix.controls.JFXCheckBox;
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
import java.util.ResourceBundle;

import static VisaApp.Main.*;
import static javafx.fxml.FXMLLoader.load;

public class ThirdFormController implements Initializable {

    @FXML private JFXDatePicker dateDV;
    @FXML private JFXDatePicker dateFV;
    @FXML private JFXCheckBox une;
    @FXML private JFXCheckBox deux;
    @FXML private JFXCheckBox plus;
    @FXML private JFXCheckBox oui;
    @FXML private JFXCheckBox non;
    @FXML private JFXComboBox typeH;
    @FXML private JFXTextField adresseH;
    @FXML private JFXTextField telH;
    @FXML private JFXComboBox typeObjet;
    @FXML private AnchorPane anc;


    ObservableList<String> listeD = FXCollections.observableArrayList();
    ObservableList<String> objets = FXCollections.observableArrayList();
    ObservableList<String> listeH = FXCollections.observableArrayList();
    ObservableList<String> listeF = FXCollections.observableArrayList();
    ObservableList<String> listeM = FXCollections.observableArrayList();
    public Stage alert = new Stage();



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

        typeH.setItems(listeH);
        typeObjet.setItems(objets);


    }

    public void next(ActionEvent e) throws IOException {
        if(

                adresseH.getText().isEmpty()
                || telH.getText().isEmpty()
                || String.valueOf(dateDV.getValue()).equals("null") || String.valueOf(dateFV.getValue()).equals("null")
                || String.valueOf(typeH.getValue())=="null"
                || (!oui.isSelected() && !non.isSelected())
                || (!une.isSelected() && !deux.isSelected() && !plus.isSelected()) ){

            Alert alert = new Alert(Alert.AlertType.WARNING,"vous devez remplir les champs obligatoires !" );
            alert.showAndWait();
        }else{

            if(dateDV.getValue().isAfter(dateFV.getValue())){
                Alert alert = new Alert(Alert.AlertType.ERROR,"la date début doit ètre avant de celle fin !" );
                alert.showAndWait();}else{
                stypeObjet= String.valueOf(typeObjet.getValue());
                if(une.isSelected()){snbre=une.getText();}else if(deux.isSelected()){snbre=deux.getText();}else
                {snbre=plus.getText();}
                sdateDV= String.valueOf(dateDV.getValue());sdateFV= String.valueOf(dateFV.getValue());
                stypeH= String.valueOf(typeH.getValue());sadresseH=adresseH.getText();stelH=telH.getText();


                Parent root = load(getClass().getClassLoader().getResource("VisaApp/views/reussite.fxml"));
                alert.setTitle("Succes");
                alert.setScene(new Scene(root, 362, 149));
                alert.show();
                PauseTransition delay = new PauseTransition(Duration.seconds(2));
                delay.setOnFinished(ee -> alert.hide());
                delay.play();

                AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("VisaApp/views/4th_form.fxml"));
                anc.getChildren().setAll(pane);
            }



        }


    }
    public void last(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("VisaApp/views/2nd_form.fxml"));
        anc.getChildren().setAll(pane);

    }

    public void action1(ActionEvent e){
        if(oui.isSelected()){non.setSelected(false);}
        if(non.isSelected()){oui.setSelected(false);}

    }

    public void action2(ActionEvent e){
        if(non.isSelected()){oui.setSelected(false);}
        if(oui.isSelected()){non.setSelected(false);}
    }

    public void action3(ActionEvent e){
        if(une.isSelected()){deux.setSelected(false);plus.setSelected(false);}
        if(deux.isSelected()){une.setSelected(false);plus.setSelected(false);}
        if(plus.isSelected()){une.setSelected(false);deux.setSelected(false);}


    }

    public void action4(ActionEvent e){
        if(deux.isSelected()){une.setSelected(false);plus.setSelected(false);}
        if(une.isSelected()){deux.setSelected(false);plus.setSelected(false);}
        if(plus.isSelected()){une.setSelected(false);deux.setSelected(false);}

    }

    public void action5(ActionEvent e){
        if(plus.isSelected()){une.setSelected(false);deux.setSelected(false);}
        if(une.isSelected()){deux.setSelected(false);plus.setSelected(false);}
        if(deux.isSelected()){une.setSelected(false);plus.setSelected(false);}
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filling();

    }
}
