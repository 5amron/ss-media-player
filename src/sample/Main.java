// samanSadeghyan
// samronsadeghyan@gmail.com


package sample;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    public static Stage primary_stage ;
    public static String file_path;

    public static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Main.primary_stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("player_frame_1.fxml"));

        Scene scene = new Scene(root, 633, 370);

        Main.primary_stage.setTitle("SS_Media_Player");
        Main.primary_stage.setScene(scene);
        Main.primary_stage.show();


        scene.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                if (db.hasFiles()) {
                    event.acceptTransferModes(TransferMode.ANY);
                } else {
                    event.consume();
                }
            }
        });

        // Dropping over surface
        scene.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasFiles()) {
                    success = true;
                    file_path = null;






                    for (File file:db.getFiles()) {
                        file_path = file.getAbsolutePath();
                        System.out.println(file_path);
                        goToPlaying();
                    }
                }
                event.setDropCompleted(success);
                event.consume();
            }
        });



    }

        public void goToPlaying(){
            try {


//                char[] converted_path1 = Main.file_path.toCharArray();
//
//
//                for (int i = 0; i < converted_path1.length; i++) {
//
//                    if (converted_path1[i]=='\\') {
//                        converted_path1[i]='/';
//                    }
//
//                }
//
//                String final_path1 = String.valueOf(converted_path1);
//
//
//                Media m1 = new Media("file:///" + final_path1);
//                MediaPlayer m2 = new MediaPlayer(m1);
//                MediaView media_view_id1 = new MediaView(m2);
//
//
//                final DoubleProperty width = media_view_id1.fitWidthProperty();
//                final DoubleProperty height = media_view_id1.fitHeightProperty();
//
//                width.bind(Bindings.selectDouble( "width"));
//                height.bind(Bindings.selectDouble( "height"));
//
//                int width1 = width.toString()
//                int height1 = height.intValue();
//                System.out.println(width1);
//                System.out.println(height1);




                Parent root = FXMLLoader.load(getClass().getResource("player_frame_2.fxml"));
                scene = new Scene(root,500 , 400, Color.BLACK);
                //scene.getStylesheets().add("player_frame_2.css");

                Main.primary_stage.setTitle(Main.file_path);
                Main.primary_stage.setScene(scene);
                Main.primary_stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        launch(args);
    }
}

