// samanSadeghyan
// samronsadeghyan@gmail.com

package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public class ControlFrame1 implements Initializable {



    @FXML
    private ImageView imageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {





        imageView.setImage(new Image(getClass().getResourceAsStream("/my_image.jpg")));


    }
}







