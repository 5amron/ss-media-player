// samanSadeghyan
// samronsadeghyan@gmail.com

package sample;


import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class ControlFrame2 implements Initializable {

    @FXML
    private BorderPane border_pane_id;
//    @FXML
//    private HBox my_bar;



    public static MediaPlayer my_player;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        System.out.println(Main.file_path);

        File file = new File(Main.file_path);
        final String MEDIA_URL = file.toURI().toString();



        Media my_media = new Media(MEDIA_URL);
        my_player = new MediaPlayer(my_media);
        MediaView media_view_id = new MediaView(my_player);


        Pane my_pane = new Pane();

        my_pane.getChildren().add(media_view_id);
//        border_pane_id.getChildren().add(my_pane);

        border_pane_id.setCenter(my_pane);


        final DoubleProperty width = media_view_id.fitWidthProperty();
        final DoubleProperty height = media_view_id.fitHeightProperty();

        width.bind(Bindings.selectDouble(media_view_id.sceneProperty(), "width"));
        height.bind(Bindings.selectDouble(media_view_id.sceneProperty(), "height"));





        media_view_id.setPreserveRatio(true);




        //border_pane_id.setStyle("-fx-background-color: #bfc2");



        Bar my_bar = new Bar();
        border_pane_id.setBottom(my_bar);


//        my_bar.play_btn.setStyle("-fx-background-color: linear-gradient(#dc9656, #ab4642)");
//        my_bar.vol.setStyle("-fx-background-color: linear-gradient(#dc9656, #ab4642)");
//        my_bar.time.setStyle("-fx-background-color: linear-gradient(#dc9656, #ab4642)");
//        my_bar.volume.setStyle("-fx-color-label-visible:  aliceblue");
//        my_bar.setStyle("-fx-border-width: 2px");
//        my_bar.setStyle("-fx-border-color: chocolate");




        my_player.play();





//        final ReadOnlyDoubleProperty width1 = Main.primary_stage.widthProperty();
//        final ReadOnlyDoubleProperty height1 = Main.primary_stage.heightProperty();
//
//        width1.
//        height1.bind(Bindings.selectDouble(Main.primary_stage.sceneProperty(), "height"));



//        width.bind(Bindings.selectDouble(Main.primary_stage.sceneProperty(), "width"));
//        height.bind(Bindings.selectDouble(Main.primary_stage.sceneProperty(), "height"));
//        Main.primary_stage.setWidth(media_view_id.getFitWidth());
//        Main.primary_stage.setHeight(media_view_id.getFitHeight());

//        System.out.println(width);
//        System.out.println(height);








    }



}