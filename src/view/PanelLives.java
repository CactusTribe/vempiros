package view;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * Created by cactustribe on 13/03/17.
 */
public class PanelLives extends HBox{

    private int nbLives;
    private IntegerProperty current_life = new SimpleIntegerProperty(0);

    private static Image HEART = new Image("file:resources/images/heart.png");
    private static Image HEART_OFF = new Image("file:resources/images/heart-off.png");

    public PanelLives(int nbLives){
        this.nbLives = nbLives;
        this.current_life.set(nbLives);

        current_life.addListener(
                (observable, oldValue, newValue) -> {
            System.out.println(String.format("LIFE CHANGED : %d -> %d", oldValue, newValue));
            this.repaint();
        });

        this.repaint();
    }

    public void setCurrentLife(int life){
        if(life <= nbLives && life >= 0){
            this.current_life.set(life);
            this.repaint();
        }
    }

    public IntegerProperty current_life(){
        return this.current_life;
    }

    public void repaint(){
        this.getChildren().clear();

        for(int i=0; i<nbLives; i++){
            ImageView heart;

            if(i < current_life.getValue())
                heart = new ImageView(HEART);
            else
                heart = new ImageView(HEART_OFF);

            heart.setFitWidth(35);
            heart.setFitHeight(40);
            this.getChildren().add(heart);
        }
    }
}
