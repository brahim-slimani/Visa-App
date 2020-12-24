package VisaApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static boolean brr=false;
    public static String snom;
    public static String sprenom;
    public static String sdateN=null;
    public static String sdateDD;
    public static String sdateDV;
    public static String sdateFV;
    public static String sdate;
    public static String slieuN;
    public static String spaysN;
    public static String snation;
    public static String stel;
    public static String semail;
    public static String genre=null;
    public static String civil;
    public static String snbre;
    public static String snumeroN;
    public static String stypeD;
    public static String stypeH;
    public static String sfrais;
    public static String stypeObjet;
    public static String stypeFrais;
    public static String snumeroD;
    public static String sdelivreD;
    public static String sresidence;
    public static String sprofession;
    public static String sadresseH;
    public static String semailH;
    public static String stelH;
    public static String slieu;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("VisaApp/views/1st_form.fxml"));
        primaryStage.setTitle("Formulaire de visa ");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
