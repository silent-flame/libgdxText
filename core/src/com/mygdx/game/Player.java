package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    protected Vector2 position;
    private Vector2 velocity;
    private Vector2 acceleration;

    private int helth;
    protected static Texture textureOfPlayer = new Texture("player.png");

    protected Player(Vector2 position) {
        this.position = position;
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
    }

    protected void goToLeft() {
        position.x -= 10;
    }

    protected void goToRight() {
        position.x += 10;
    }

    protected void draw(SpriteBatch batch) {
        batch.draw(textureOfPlayer, position.x, position.y);
    }

    protected static void dispose() {
        textureOfPlayer.dispose();
    }

    protected void jump() {
        velocity.y = 18;
        acceleration.y = -1;
    }

    protected boolean isOnTheBlock(Block block) {
        if ((position.x >= block.position.x - textureOfPlayer.getWidth()) && (position.x <= block.position.x + block.getTextureSize().x))
            if ((position.y >= block.position.y + block.getTextureSize().y - 20) && position.y <= block.position.y + block.getTextureSize().y)
                switch (block.typeOfBlock) {
                    case BOX:
                    case RIGHT_TOP_GROUND:
                    case TOP_GROUND:
                    case BRIDGE:
                    case LEFT_TOP_GROUND:
                    return true;
                }
        return false;
    }

    protected boolean isOnTheGround(Block[] blocks) {
        for (Block b : blocks)
            if (isOnTheBlock(b)) return true;
        return false;
    }

    protected void update(Block[] blocks) {
        position.add(velocity);
        velocity.add(acceleration);
        if (isOnTheGround(blocks)) {
//            position.y = 64;
            velocity.y = 0;
            acceleration.y = 0;
        } else acceleration.y = -1;

    }
}
