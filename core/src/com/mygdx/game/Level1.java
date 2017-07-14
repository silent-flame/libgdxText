package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Level1 {
    protected static int SCREEN_WIDTH;
    protected static int SCREEN_HEIGHT;

    private static final Texture textureOfBackground = new Texture("PNG\\Background.png");
    protected static Player player;
    private static int COUNT_OF_BLOCKS = 18;
    private static Block[] blocks = new Block[COUNT_OF_BLOCKS];
    private static BitmapFont bmf;
    private static float time = 0;
    private static int timeDirection = 1;


    protected static void create() {
        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
        bmf = new BitmapFont(Gdx.files.internal("MyFont.fnt"), Gdx.files.internal("MyFont.png"), false);
        player = new Player(new Vector2(1, 64));
        blocks[16] = new Block(new Vector2(0, 0), Block.TypeOfBlock.TOP_GROUND);
        blocks[1] = new Block(new Vector2(128, 0), Block.TypeOfBlock.TOP_GROUND);
        blocks[2] = new Block(new Vector2(128 * 2, 0), Block.TypeOfBlock.LEFT_TOP_GROUND);


        blocks[3] = new Block(new Vector2(128 * 5 + 64, 0), Block.TypeOfBlock.RIGHT_TOP_GROUND);
        blocks[4] = new Block(new Vector2(128 * 6, 0), Block.TypeOfBlock.TOP_GROUND);
        blocks[5] = new Block(new Vector2(128 * 7, 0), Block.TypeOfBlock.TOP_GROUND);




        blocks[6] = new Block(new Vector2(128 * 3 - 64, 32), Block.TypeOfBlock.BRIDGE);
        blocks[7] = new Block(new Vector2(128 * 4 - 64, 32), Block.TypeOfBlock.BRIDGE);
        blocks[8] = new Block(new Vector2(128 * 5 - 64, 32), Block.TypeOfBlock.BRIDGE);


        blocks[9] = new Block(new Vector2(1024 - 128, 640 - 64 - 128), Block.TypeOfBlock.TOP_GROUND);
        blocks[10] = new Block(new Vector2(1024 - 128, 640 - 64 - 2 * 128), Block.TypeOfBlock.GROUND);
        blocks[11] = new Block(new Vector2(1024 - 128, 640 - 64 - 3 * 128), Block.TypeOfBlock.LOWER_BORDER_GROUND);


        blocks[12] = new Block(new Vector2(1024 - 256 + 41, 640 - 64 - 128), Block.TypeOfBlock.RIGHT_TOP_GROUND);
        blocks[13] = new Block(new Vector2(1024 - 256, 640 - 64 - 2 * 128), Block.TypeOfBlock.LEFT_BORDER_GROUND);

        blocks[14] = new Block(new Vector2(1024 - 256, 640 - 64 - 3 * 128), Block.TypeOfBlock.LEFT_LOWER_BORDER_GROUND);

        blocks[15] = new Block(new Vector2(1024 - 128, 640 - 64 - 3 * 128), Block.TypeOfBlock.LOWER_BORDER_GROUND);
        blocks[0] = new Block(new Vector2(640, 800), Block.TypeOfBlock.BOX);
        blocks[17] = new Block(new Vector2(1024 - 128, 640 - 128), Block.TypeOfBlock.EXIT);

    }

    protected static void drawLevel1(SpriteBatch batch) {
        time = time + timeDirection * Gdx.graphics.getDeltaTime();

        if (((Gdx.input.isKeyPressed(Input.Keys.LEFT)) || (Gdx.input.isKeyPressed(Input.Keys.A))) && (player.position.x > 0))
            player.goToLeft();
        if (((Gdx.input.isKeyPressed(Input.Keys.RIGHT)) || (Gdx.input.isKeyPressed(Input.Keys.D))) && (player.position.x < SCREEN_WIDTH - Player.textureOfPlayer.getWidth()))
            player.goToRight();
        if (((Gdx.input.isKeyPressed(Input.Keys.SPACE)) || (Gdx.input.isKeyPressed(Input.Keys.W)) ||
                (Gdx.input.isKeyPressed(Input.Keys.UP))) && (player.isOnTheGround(blocks))) player.jump();


        if (Gdx.input.isKeyJustPressed(Input.Keys.I)) timeDirection = (-1) * timeDirection;


        player.update(blocks);

        if ((blocks[0].position.y > 64) && timeDirection == 1) blocks[0].position.y -= 5;
        if (timeDirection == -1) {
            blocks[0].position.y += 5;
            if (player.isOnTheBlock(blocks[0])) player.position.y += 5;
        }



        batch.draw(textureOfBackground, 0, 0);
        for (Block bl : blocks) {
            bl.draw(batch);
        }
        player.draw(batch);

        if((time>60)&&(!(player.isOnTheBlock(blocks[9])||player.isOnTheBlock(blocks[12]))))
            bmf.draw(batch,"Try pressing the  \"I\" ",200,300);

        bmf.draw(batch, "time " + (int) Math.floor(time / 60) + ":" + Integer.toString((int) Math.floor((time % 60) / 10)) + (int) time % 10, 10, SCREEN_HEIGHT - bmf.getXHeight());
        if (player.isOnTheBlock(blocks[9])||player.isOnTheBlock(blocks[12]))
            bmf.draw(batch,"Level completed",200,300);


    }

    protected static void dispose() {
        Player.dispose();
        Block.dispose();
        bmf.dispose();
    }

}
