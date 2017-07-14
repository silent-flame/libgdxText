package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;


    enum StateOfApplication {
        LEVEL1, LEVEL2, EXIT
    }

    StateOfApplication stateOfApplication;


    @Override
    public void create() {//вызывается только при создании окна приложения. Инициализация
        batch = new SpriteBatch();
        stateOfApplication = StateOfApplication.LEVEL1;
        Level1.create();


    }

    static Color colorOfBackground = new Color(0f / 255, 255f / 255, 127f / 255, 255f / 255);

    @Override
    public void render() {

        Gdx.gl.glClearColor(colorOfBackground.r, colorOfBackground.g, colorOfBackground.b, colorOfBackground.a);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        Level1.drawLevel1(batch);


        batch.end();
        if (stateOfApplication == StateOfApplication.EXIT) {
            dispose();
            System.exit(0);
        }
    }

    @Override
    public void dispose() {//вызывается при закрытии. Освобождение ресурсов
        Level1.dispose();
        batch.dispose();
    }
}


//        Pixmap pixmap = new Pixmap( 64, 64, Pixmap.Format.RGBA8888 );
//        pixmap.setColor( 0, 1, 0, 0.75f );
//        pixmap.fil
//        pixmap.fillCircle( 32, 32, 32 );
//        Texture pixmaptex = new Texture( pixmap );
//        pixmap.dispose();