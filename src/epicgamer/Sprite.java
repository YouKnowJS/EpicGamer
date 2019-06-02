/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epicgamer;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Hugo Ku
 */
public class Sprite extends Rectangle {

    //bounds from scene
    private final int boundX = 1280;
    private final int boundY = 720;

    //speed
    private final int speed = 5;

    //state
    private int fixed;

    //default constructor
    public Sprite(int x, int y, int width, int height, Paint c, int state) {

        //calling rectangle class
        super(x, y, width, height);
        super.setFill(c);
        this.fixed = state;

    }

    //player movements
    public void moveUp(Map map) {

        if (super.getY() > 0 && checkUp(map)) {
            super.setY(super.getY() - speed);
        }

    }

    public void moveDown(Map map) {

        if (super.getY() + super.getHeight() < boundY && checkDown(map)) {
            super.setY(super.getY() + speed);
        }

    }

    public void moveLeft(Map map) {

        if (super.getX() > 0 && checkLeft(map)) {
            super.setX(super.getX() - speed);
        }

    }

    public void moveRight(Map map) {

        if (super.getX() + super.getWidth() < boundX && checkRight(map)) {
            super.setX(super.getX() + speed);
        }

    }

    private int checkBetweenUpDown(Map map) {

        //contained within one block
        if (super.getX() >= ((int)super.getX() / map.returnWidth() * map.returnWidth()) && ((super.getX() + super.getWidth()) <= (((int)super.getX() / map.returnWidth() + 1) * map.returnWidth()))) {
            System.out.println("yes");
            return 1;
        }
        
        //contained within two blocks
        else {
            System.out.println("no");
            return 3;
        }

    }

    private int checkBetweenLeftRight(Map map) {

        //contained within one block
        if (super.getY() >= ((int)super.getY() / map.returnHeight() * map.returnHeight()) && ((super.getY() + super.getHeight()) <= (((int)super.getY() / map.returnHeight() + 1) * map.returnWidth()))) {
            return 1;
        }
        
        //contained within two blocks
        else {
            return 3;
        }

    }

    private boolean checkLeft(Map map) {

        //checking
        boolean check = true;

        //comparing variables for check
        int x1, y1, y2;

        //find x
        double x = super.getX() - speed;

        //find y
        double y = super.getY();

        //find the x for block
        x1 = (int) (x / 40);

        //find the y for block
        y1 = (int) (y / 40);
        y2 = y1 + 1;

        //checking
        switch (checkBetweenLeftRight(map)) {
            case 1:
                if ((map.returnArray((int) (y1 * 32 + x1)).fixed == 1)) {
                    check = false;
                }
                break;
            case 3:
                if ((map.returnArray((int) (y1 * 32 + x1)).fixed == 1) || (map.returnArray((int) (y2 * 32 + x1)).fixed == 1)) {
                    check = false;
                }
                break;
        }

        return check;

    }

    private boolean checkRight(Map map) {

        //checking
        boolean check = true;

        //comparing variables for check
        int x1, y1, y2;

        //find x
        double x = super.getX() + super.getWidth();

        //find y
        double y = super.getY();

        //find the x for block
        x1 = (int) (x / 40);

        //find the y for block
        y1 = (int) (y / 40);
        y2 = y1 + 1;

        //checking
        switch (checkBetweenLeftRight(map)) {
            case 1:
                if ((map.returnArray((int) (y1 * 32 + x1)).fixed == 1)) {
                    check = false;
                }
                break;
            case 3:
                if ((map.returnArray((int) (y1 * 32 + x1)).fixed == 1) || (map.returnArray((int) (y2 * 32 + x1)).fixed == 1)) {
                    check = false;
                }
                break;
        }

        return check;

    }

    private boolean checkUp(Map map) {

        //checking
        boolean check = true;

        //comparing variables for check
        int x1, y1, x2;

        //find x
        double x = super.getX();

        //find y
        double y = super.getY() - speed;

        //find the x for block
        x1 = (int) (x / 40);
        x2 = x1 + 1;

        //find the y for block
        y1 = (int) (y / 40);

        //checking
        switch (checkBetweenUpDown(map)) {
            case 1:
                if ((map.returnArray((int) (y1 * 32 + x1)).fixed == 1)) {
                    check = false;
                }
                break;
            case 3:
                if ((map.returnArray((int) (y1 * 32 + x1)).fixed == 1) || (map.returnArray((int) (y1 * 32 + x2)).fixed == 1)) {
                    check = false;
                }
                break;
        }

        return check;

    }

    private boolean checkDown(Map map) {

        //checking
        boolean check = true;

        //comparing variables for check
        int x1, y1, x2;

        //find x
        double x = super.getX();

        //find y
        double y = super.getY() + super.getHeight();

        //find the x for block
        x1 = (int) (x / 40);
        x2 = x1 + 1;

        //find the y for block
        y1 = (int) (y / 40);

        //checking
        switch (checkBetweenUpDown(map)) {
            case 1:
                if ((map.returnArray((int) (y1 * 32 + x1)).fixed == 1)) {
                    check = false;
                }
                break;
            case 3:
                if ((map.returnArray((int) (y1 * 32 + x1)).fixed == 1) || (map.returnArray((int) (y1 * 32 + x2)).fixed == 1)) {
                    check = false;
                }
                break;
        }

        return check;

    }

}
