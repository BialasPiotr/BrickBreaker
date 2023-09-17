import java.awt.*;
import java.util.Random;

public class BrickGenerator {
    public Brick[][] bricks;
    public int brickWidth;
    public int brickHeight;
    private Random random = new Random();

    public BrickGenerator(int row, int col) {
        bricks = new Brick[row][col];
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                Color brickColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
                bricks[i][j] = new Brick(1, brickColor);
            }
        }

        brickWidth = 540 / col;
        brickHeight = 150 / row;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                if (bricks[i][j].value > 0) {
                    g.setColor(bricks[i][j].color);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        bricks[row][col].value = value;
    }

    public static class Brick {
        int value;
        Color color;

        public Brick(int value, Color color) {
            this.value = value;
            this.color = color;
        }
    }
}
