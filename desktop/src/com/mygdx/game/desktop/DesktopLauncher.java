package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
    protected static final int WIDTH_OF_SCREEN=128*8;
    protected static final int HEIGHT_OF_SCREEN=128*5;
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = WIDTH_OF_SCREEN;
        config.height = HEIGHT_OF_SCREEN;
        config.resizable = false;
        new LwjglApplication(new MyGdxGame(), config);
    }
}
