import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    private int ballPosX = 120;
    private int ballPosY = 350;
    private int ballDirX = -1;
    private int ballDirY = -2;
    private int paddlePosX = 310;
    private double speedMultiplier = 1.0;
    private BrickGenerator brickGenerator;

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        Timer timer = new Timer(8, this);
        timer.start();
        brickGenerator = new BrickGenerator(5, 10);
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 700, 600);
        brickGenerator.draw((Graphics2D) g);
        g.setColor(Color.RED);
        g.fillOval(ballPosX, ballPosY, 15, 15);
        g.setColor(Color.GREEN);
        g.fillRect(paddlePosX, 550, 100, 8);
    }

    public void actionPerformed(ActionEvent e) {
        ballPosX += (int) (ballDirX * speedMultiplier);
        ballPosY += (int) (ballDirY * speedMultiplier);
        if (ballPosX < 0 || ballPosX > 670) ballDirX = -ballDirX;
        if (ballPosY < 0) ballDirY = -ballDirY;
        if (new Rectangle(ballPosX, ballPosY, 15, 15).intersects(new Rectangle(paddlePosX, 550, 100, 8))) {
            ballDirY = -Math.abs(ballDirY);
            speedMultiplier += 0.1;
        }
        for (int i = 0; i < brickGenerator.bricks.length; i++) {
            for (int j = 0; j < brickGenerator.bricks[0].length; j++) {
                if (brickGenerator.bricks[i][j].value > 0) {
                    int brickX = j * brickGenerator.brickWidth + 80;
                    int brickY = i * brickGenerator.brickHeight + 50;
                    int brickWidth = brickGenerator.brickWidth;
                    int brickHeight = brickGenerator.brickHeight;
                    Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                    Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 15, 15);
                    if (ballRect.intersects(rect)) {
                        brickGenerator.setBrickValue(0, i, j);
                        if (ballPosX + 14 <= rect.x || ballPosX + 1 >= rect.x + rect.width) {
                            ballDirX = -ballDirX;
                        } else {
                            ballDirY = -ballDirY;
                        }
                        break;
                    }
                }
            }
        }
        if (ballPosY > 670) {
            ballPosX = 120;
            ballPosY = 350;
            ballDirX = -1;
            ballDirY = -2;
            speedMultiplier = 1.0;
            paddlePosX = 310;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT && paddlePosX > 0) paddlePosX -= 20;
        if (keyCode == KeyEvent.VK_RIGHT && paddlePosX < 600) paddlePosX += 20;
    }

    public void keyReleased(KeyEvent e) {}
}
