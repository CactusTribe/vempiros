package model.entities;

import javafx.geometry.BoundingBox;
import model.Game;
import view.entities.EntityView;

public abstract class Entity {

    protected Game game;
    protected BoundingBox bounds;
    protected EntityView entityView;

    public boolean collidesWith(Entity other) {
        return this.bounds.intersects(other.getBounds());
    }

    public abstract void collidedBy(Entity other);

    public BoundingBox getBounds(){
        return this.bounds;
    }
    public EntityView getEntityView() { return this.entityView; }

    public void setBounds(BoundingBox bounds) { this.bounds = bounds; }
    public void setEntityView(EntityView entityView) { this.entityView = entityView; }

    public void setGame(Game game){
        this.game = game;
    }
}
