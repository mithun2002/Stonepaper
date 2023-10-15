import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StonePaperScissorGUI extends JFrame implements ActionListener {

    private JLabel heading, result;
    private JButton stone, paper, scissor;
    private JPanel panel;

    public StonePaperScissorGUI() {
        setTitle("Stone Paper Scissor Game");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());

        heading = new JLabel("Choose one:");
        result = new JLabel("");

        stone = new JButton("Stone");
        paper = new JButton("Paper");
        scissor = new JButton("Scissor");

        stone.addActionListener(this);
        paper.addActionListener(this);
        scissor.addActionListener(this);

        panel.add(heading);
        panel.add(stone);
        panel.add(paper);
        panel.add(scissor);
        panel.add(result);

        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userChoice = e.getActionCommand();
        String[] choices = {"Stone", "Paper", "Scissor"};
        Random random = new Random();
        String computerChoice = choices[random.nextInt(choices.length)];

        String msg = "Computer chose " + computerChoice + ". ";

        if (userChoice.equals(computerChoice)) {
            msg += "It's a tie!";
        } else if ((userChoice.equals("Stone") && computerChoice.equals("Scissor")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Stone")) ||
                (userChoice.equals("Scissor") && computerChoice.equals("Paper"))) {
            msg += "You win!";
        } else {
            msg += "Computer wins!";
        }

        result.setText(msg);
    }

    public static void main(String[] args) {
        new StonePaperScissorGUI();
    }
}
