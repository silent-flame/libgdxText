package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Block {
    protected Vector2 position;

    protected enum TypeOfBlock {
        TOP_GROUND, LEFT_TOP_GROUND, RIGHT_TOP_GROUND, GROUND, BRIDGE,
        LEFT_BORDER_GROUND, LOWER_BORDER_GROUND, LEFT_LOWER_BORDER_GROUND, EXIT, BOX
    }

    protected TypeOfBlock typeOfBlock;

    private static final Texture textureOfTopGround = new Texture("PNG\\Tile_2.png");
    private static final Texture textureOfGround = new Texture("PNG\\Tile_5.png");
    private static final Texture textureOfLeftTopGround = new Texture("PNG\\Tile_3.png");
    private static final Texture textureOfRightTopGround = new Texture("PNG\\Tile_1.png");
    private static final Texture textureOfBridge = new Texture("PNG\\bridge.png");
    private static final Texture textureOfLeftBorderGround = new Texture("PNG\\Tile_4.png");
    private static final Texture textureOfLowerBorderGround = new Texture("PNG\\Tile_8.png");
    private static final Texture textureOfLeftLowerBorderGround = new Texture("PNG\\Tile_7.png");
    private static final Texture textureOfBox = new Texture("PNG\\box.png");
    private static final Texture textureOfExit = new Texture("PNG\\Object_5.png");


    protected Block(Vector2 position, TypeOfBlock type) {
        this.position = position;
        this.typeOfBlock = type;
    }

    protected void draw(SpriteBatch batch) {
        switch (typeOfBlock) {
            case TOP_GROUND: {
                batch.draw(textureOfTopGround, position.x, position.y, textureOfTopGround.getWidth() / 2, textureOfTopGround.getHeight() / 2);
                break;
            }
            case LEFT_TOP_GROUND: {
                batch.draw(textureOfLeftTopGround, position.x, position.y, textureOfLeftTopGround.getWidth() / 2, textureOfLeftTopGround.getHeight() / 2);
                break;
            }
            case RIGHT_TOP_GROUND: {
                batch.draw(textureOfRightTopGround, position.x, position.y, textureOfRightTopGround.getWidth() / 2, textureOfRightTopGround.getHeight() / 2);
                break;
            }
            case LEFT_BORDER_GROUND: {
                batch.draw(textureOfLeftBorderGround, position.x, position.y, textureOfLeftBorderGround.getWidth() / 2, textureOfLeftBorderGround.getHeight() / 2);
                break;
            }
            case LOWER_BORDER_GROUND: {
                batch.draw(textureOfLowerBorderGround, position.x, position.y, textureOfLowerBorderGround.getWidth() / 2, textureOfLowerBorderGround.getHeight() / 2);
                break;
            }
            case LEFT_LOWER_BORDER_GROUND: {
                batch.draw(textureOfLeftLowerBorderGround, position.x, position.y, textureOfLeftLowerBorderGround.getWidth() / 2, textureOfLeftLowerBorderGround.getHeight() / 2);
                break;
            }
            case BRIDGE: {
                batch.draw(textureOfBridge, position.x, position.y, textureOfBridge.getWidth() / 2, textureOfBridge.getHeight() / 2);
                break;
            }
            case GROUND: {
                batch.draw(textureOfGround, position.x, position.y, textureOfGround.getWidth() / 2, textureOfGround.getHeight() / 2);
                break;
            }
            case BOX: {
                batch.draw(textureOfBox, position.x, position.y, textureOfBox.getWidth() / 4, textureOfBox.getHeight() / 4);
                break;
            }
            case EXIT: {
                batch.draw(textureOfExit, position.x, position.y, textureOfExit.getWidth() / 2, textureOfExit.getHeight() / 2);
                break;
            }
        }
    }

    protected Vector2 getTextureSize() {
        Vector2 size = new Vector2();
        switch (typeOfBlock) {
            case TOP_GROUND: {
                size.x = textureOfTopGround.getWidth()/2;
                size.y = textureOfTopGround.getHeight()/2;
                break;
            }
            case LEFT_TOP_GROUND: {
                size.x = textureOfLeftTopGround.getWidth()/2;
                size.y = textureOfLeftTopGround.getHeight()/2;
                break;
            }
            case RIGHT_TOP_GROUND: {
                size.x = textureOfRightTopGround.getWidth()/2;
                size.y = textureOfRightTopGround.getHeight()/2;
                break;
            }
            case LEFT_BORDER_GROUND: {
                size.x = textureOfLeftBorderGround.getWidth()/2;
                size.y = textureOfLeftBorderGround.getHeight()/2;
                break;
            }
            case LOWER_BORDER_GROUND: {
                size.x = textureOfLowerBorderGround.getWidth()/2;
                size.y = textureOfLowerBorderGround.getHeight()/2;
                break;
            }
            case LEFT_LOWER_BORDER_GROUND: {
                size.x = textureOfLeftLowerBorderGround.getWidth()/2;
                size.y = textureOfLeftLowerBorderGround.getHeight()/2;
                break;
            }
            case BRIDGE: {
                size.x = textureOfBridge.getWidth()/2;
                size.y = textureOfBridge.getHeight()/2;
                break;
            }
            case GROUND: {
                size.x = textureOfGround.getWidth()/2;
                size.y = textureOfGround.getHeight()/2;
                break;
            }
            case BOX: {
                size.x = textureOfBox.getWidth()/4;
                size.y = textureOfBox.getHeight()/4;
                break;
            }
            case EXIT: {
                size.x = textureOfExit.getWidth()/2;
                size.y = textureOfExit.getHeight()/2;
                break;
            }
        }
        return size;
    }

    protected static void dispose() {
        textureOfBridge.dispose();
        textureOfGround.dispose();
        textureOfTopGround.dispose();
        textureOfLeftBorderGround.dispose();
        textureOfLeftLowerBorderGround.dispose();
        textureOfLeftTopGround.dispose();
        textureOfRightTopGround.dispose();
        textureOfTopGround.dispose();
        textureOfBox.dispose();
        textureOfExit.dispose();
    }
}
