// samanSadeghyan
// samronsadeghyan@gmail.com


package sample;


import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

public class Bar extends HBox{



    Slider time = new Slider();
    Slider vol = new Slider();


    Button play_btn = new Button("||");

    Label volume = new Label("volume: ");
    

    public Bar(){
        setAlignment(Pos.CENTER);
        vol.setPrefWidth(70);
        vol.setMinWidth(30);
        vol.setValue(100);
        

        HBox.setHgrow(time, Priority.ALWAYS);

        play_btn.setPrefWidth(30);

        getChildren().add(play_btn);
        getChildren().add(time);
        getChildren().add(volume);
        getChildren().add(vol);


        play_btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MediaPlayer.Status status = ControlFrame2.my_player.getStatus();

                if(status == MediaPlayer.Status.PLAYING){
                    if(ControlFrame2.my_player.getCurrentTime().greaterThanOrEqualTo(ControlFrame2.my_player.getTotalDuration())){
                        ControlFrame2.my_player.seek(ControlFrame2.my_player.getStartTime());
                        ControlFrame2.my_player.play();
                    }else{
                        ControlFrame2.my_player.pause();
                        play_btn.setText(">");
                    }
                }
                if(status == MediaPlayer.Status.PAUSED || status==status.HALTED ||status== MediaPlayer.Status.STOPPED){
                    ControlFrame2.my_player.play();
                    play_btn.setText("||");
                }


            }
        });

        ControlFrame2.my_player.currentTimeProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                updateValue();
            }
        });

        time.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(time.isPressed()){
                    ControlFrame2.my_player.seek(ControlFrame2.my_player.getMedia().getDuration().multiply(time.getValue()/100));
                }
            }
        });


        vol.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(vol.isPressed()){
                    ControlFrame2.my_player.setVolume(vol.getValue()/100);
                }
            }
        });

    }


    protected void updateValue(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                time.setValue(ControlFrame2.my_player.getCurrentTime().toMillis()/ControlFrame2.my_player.getTotalDuration().toMillis()*100);
            }
        });
    }


}
