package VisaApp.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static VisaApp.Main.*;
import static javafx.fxml.FXMLLoader.load;

public class FirstFormController implements Initializable {
    @FXML private JFXTextField nom;
    @FXML private JFXTextField prenom;
    @FXML private JFXDatePicker dateN;

    @FXML private JFXTextField lieuN;
    @FXML private JFXTextField paysN;
    @FXML private JFXTextField nation;
    @FXML private JFXTextField tel;
    @FXML private JFXTextField email;
    @FXML private JFXCheckBox homme;
    @FXML private JFXCheckBox femme;
    @FXML private JFXCheckBox celibataire;
    @FXML private JFXCheckBox marie;
    @FXML private JFXCheckBox divorce;
    @FXML private ImageView imageV;

    @FXML private AnchorPane anc;

    static Stage primaryStage;
    private FileInputStream fis;
    private FileChooser fileChooser;
    private File file;
    private Image img = null;


    public Stage alert = new Stage();


    public void browse(ActionEvent e){
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files","*.png","*.jpg","*.gif")
        );

        file = fileChooser.showOpenDialog(primaryStage);

        img = new Image(file.toURI().toString());
        imageV.setImage(img);
    }


    public void next(ActionEvent e) throws IOException {
        if(nom.getText().isEmpty() || prenom.getText().isEmpty() || lieuN.getText().isEmpty() || paysN.getText().isEmpty()
                || nation.getText().isEmpty() || tel.getText().isEmpty()

                || String.valueOf(dateN.getValue()).equals("null") ||

                 (!homme.isSelected() && !femme.isSelected())
                ||  (!celibataire.isSelected() && !marie.isSelected() && !divorce.isSelected())){

            Alert alert = new Alert(Alert.AlertType.WARNING,"vous devez remplir les champs obligatoires !" );
            alert.showAndWait();
        }else{
            snom=nom.getText();sprenom=prenom.getText();slieuN=lieuN.getText();spaysN=paysN.getText();snation=nation.getText();
            stel=tel.getText();sdateN= String.valueOf(dateN.getValue());semail=email.getText();
            if(homme.isSelected()){genre=homme.getText();}else{genre=femme.getText();}
            if(celibataire.isSelected()){civil=celibataire.getText();}else if(marie.isSelected()){civil=marie.getText();}else
            {civil=divorce.getText();}

            Parent root = load(getClass().getClassLoader().getResource("VisaApp/views/reussite.fxml"));
            alert.setTitle("Succes");
            alert.setScene(new Scene(root, 362, 149));
            alert.show();
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(ee -> alert.hide());
            delay.play();

            AnchorPane pane = load(getClass().getClassLoader().getResource("VisaApp/views/form2.fxml"));
            anc.getChildren().setAll(pane);
        }



    }

    public void action1(ActionEvent e){
        if(homme.isSelected()){femme.setSelected(false);}
        if(femme.isSelected()){homme.setSelected(false);}

    }

    public void action2(ActionEvent e){
        if(femme.isSelected()){homme.setSelected(false);}
        if(homme.isSelected()){femme.setSelected(false);}
    }

    public void action3(ActionEvent e){
        if(celibataire.isSelected()){marie.setSelected(false);divorce.setSelected(false);}
        if(marie.isSelected()){celibataire.setSelected(false);divorce.setSelected(false);}
        if(divorce.isSelected()){marie.setSelected(false);celibataire.setSelected(false);}


    }

    public void action4(ActionEvent e){
        if(marie.isSelected()){celibataire.setSelected(false);divorce.setSelected(false);}
        if(celibataire.isSelected()){marie.setSelected(false);divorce.setSelected(false);}
        if(divorce.isSelected()){marie.setSelected(false);celibataire.setSelected(false);}

    }

    public void action5(ActionEvent e){
        if(divorce.isSelected()){marie.setSelected(false);celibataire.setSelected(false);}
        if(marie.isSelected()){celibataire.setSelected(false);divorce.setSelected(false);}
        if(celibataire.isSelected()){marie.setSelected(false);divorce.setSelected(false);}
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
