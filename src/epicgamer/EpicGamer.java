/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epicgamer;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 *
 * @author Hugo Ku
 */
public class EpicGamer extends Application {

    //width height
    private final int width = 1280;
    private final int height = 720;

    //arary move
    private final int[] movement = new int[4];

    //root
    private final Pane root = new Pane();
    
    //load map
    Map map = new Map (1);

    //making me
    private final Sprite hugo = new Sprite(width / 2, height / 2, 20, 20, Color.CORNFLOWERBLUE, 3);
    private final Enemy enemy = new Enemy (width/2+100, height/2+100, 50, Color.BLUE);

    //adding me into group
    private void addChild(ArrayList<Sprite> wall) {
        for (int i = 0; i < wall.size(); i++) {
            root.getChildren().add(wall.get(i));
        }
        root.getChildren().addAll(hugo);
        root.getChildren().addAll(enemy);
    }

    //controls
    public void controls() {

        if (movement[2] == 1) {
            hugo.moveLeft(map);
        }
        if (movement[3] == 1) {
            hugo.moveRight(map);
        }
        if (movement[0] == 1) {
            hugo.moveUp(map);
        }
        if (movement[1] == 1) {
            hugo.moveDown(map);
        }

    }

    
    
    
    
    
    
    @Override
    public void start(Stage stage) throws Exception {

        

        //epic scene
        Scene scene = new Scene(root, width, height);

        //controls
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            //learned online
            //https://www.youtube.com/watch?v=FVo1fm52hz0
            @Override
            public void handle(KeyEvent e) {
                
                if (e.getCode() == (KeyCode.UP)) {
                    movement[0] = 1;
                }
                if (e.getCode() == (KeyCode.DOWN)) {
                    movement[1] = 1;
                }
                if (e.getCode() == (KeyCode.LEFT)) {
                    movement[2] = 1;
                }
                if (e.getCode() == (KeyCode.RIGHT)) {
                    movement[3] = 1;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent e) {

                if (e.getCode() == (KeyCode.UP)) {
                    movement[0] = 0;
                }
                if (e.getCode() == (KeyCode.DOWN)) {
                    movement[1] = 0;
                }
                if (e.getCode() == (KeyCode.LEFT)) {
                    movement[2] = 0;
                }
                if (e.getCode() == (KeyCode.RIGHT)) {
                    movement[3] = 0;
                }
            }
        });
        
        
        
        //making stuff
        addChild(map.makeMap());

        //animation timer
        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controls();
            }
        };

        at.start();

        stage.setResizable(false);
        stage.setTitle("I wanna die");
        stage.setScene(scene);

        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
