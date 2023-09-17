import java.awt.*;
import java.util.Random;

public class BrickGenerator {
    public int[][] bricks;
    public int brickWidth;
    public int brickHeight;
    private Random random = new Random();
    private Color brickColor = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

    public BrickGenerator(int row, int col) {
        bricks = new int[row][col];
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                bricks[i][j] = 1;
            }
        }

        brickWidth = 540 / col;
        brickHeight = 150 / row;
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[0].length; j++) {
                if (bricks[i][j] > 0) {
                    g.setColor(brickColor);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col) {
        bricks[row][col] = value;
    }
}
