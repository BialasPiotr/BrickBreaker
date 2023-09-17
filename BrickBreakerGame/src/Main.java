import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame menuFrame = new JFrame();
        JPanel panel = new JPanel();
        JButton newGameButton = new JButton("New Game");
        JButton exitButton = new JButton("Exit");
        JLabel titleLabel = new JLabel("BRICK BREAKER");

        // Styling buttons
        newGameButton.setFont(new Font("Arial", Font.PLAIN, 24));
        newGameButton.setBackground(Color.GREEN);
        newGameButton.setForeground(Color.WHITE);
        newGameButton.setPreferredSize(new Dimension(200, 60));
        newGameButton.setFocusPainted(false);

        exitButton.setFont(new Font("Arial", Font.PLAIN, 24));
        exitButton.setBackground(Color.RED);
        exitButton.setForeground(Color.WHITE);
        exitButton.setPreferredSize(new Dimension(200, 60));
        exitButton.setFocusPainted(false);

        // Action listeners for buttons
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gameFrame = new JFrame();
                GamePanel gamePanel = new GamePanel();
                gameFrame.setBounds(10, 10, 700, 600);
                gameFrame.setTitle("Brick Breaker");
                gameFrame.setResizable(false);
                gameFrame.setVisible(true);
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.add(gamePanel);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Title label settings
        titleLabel.setFont(new Font("Arial", Font.BOLD, 70));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);

        // Panel layout and background color
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(newGameButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        buttonPanel.add(exitButton);

        // Center panel for aligning the buttons
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerPanel.add(buttonPanel, gbc);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(centerPanel, BorderLayout.CENTER);

        menuFrame.add(panel);
        menuFrame.setBounds(10, 10, 700, 600);
        menuFrame.setTitle("Menu");
        menuFrame.setResizable(false);
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
