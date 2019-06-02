/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epicgamer;

import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 *
 * @author kuh1409
 */
public class Enemy extends Circle {
    
    //the path for moving
    private Shape shape;
    
    //default constructor
    public Enemy (int x, int y, int r, Paint c) {
        
        // making the circle
        super (x, y, r);
        
        super.setFill(c);
//        Circle circle = new Circle(100);
//        PathTransition transition = new PathTransition();
//        transition.setNode(circle);
//        transition.setDuration(Duration.seconds(2));
//        transition.setCycleCount(PathTransition.INDEFINITE);
//        transition.play();
//        //the path for moving
//        this.shape = circle;
        
    }
    
    
    
}
