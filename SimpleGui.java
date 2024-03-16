
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
        gui.go();
    }

    public void go() {
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change Color ");
        button.addActionListener(this);

        MyDrawPanel myDrawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, myDrawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();
    }
}

class MyDrawPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int greenStart = (int) (Math.random() * 255);
        int redStart = (int) (Math.random() * 255);
        int blueStart = (int) (Math.random() * 255);
        Color startColor = new Color(redStart, greenStart, blueStart);

        int greenEnd = (int) (Math.random() * 255);
        int redEnd = (int) (Math.random() * 255);
        int blueEnd = (int) (Math.random() * 255);
        Color endColor = new Color(redEnd, greenEnd, blueEnd);

        GradientPaint gradient = new GradientPaint(70, 70, startColor, 170, 170, endColor);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }
}







