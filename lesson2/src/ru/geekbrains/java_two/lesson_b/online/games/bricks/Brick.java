package ru.geekbrains.java_two.lesson_b.online.games.bricks;

import ru.geekbrains.java_two.lesson_b.online.games.common.GameCanvas;
import ru.geekbrains.java_two.lesson_b.online.games.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Brick extends Sprite {
    Random rnd = new Random();
//    private final Color color = new Color (
//            (int)(Math.random() * 255),
//            (int)(Math.random() * 255),
//            (int)(Math.random() * 255)
//    );

    private final Color color;
    private float vX;
    private float vY;

    Brick() {
        halfHeight = 20 + (float) (Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = (float) (100f + (Math.random() * 200f));
        vY = (float) (100f + (Math.random() * 200f));
    }


    Brick(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    @Override
    public void update(GameCanvas canvas, float deltaTime) {

    }

    @Override
    public void render(GameCanvas canvas, Graphics g) {
        g.setColor(color);
        g.drawRect((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }
}
