package src.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddView extends View implements ActionListener {

    // Campos para adicionar resultado de jogo entre dois times
    private JTextField team1Field;
    private JTextField goals1Field;
    private JTextField team2Field;
    private JTextField goals2Field;

    public AddView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
    }

    @Override
    public void createView() {
        frame = new JFrame("Add Match Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setLayout(new BorderLayout());

        // Painel com campos para os times e placares
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        inputPanel.add(new JLabel("Team 1"));
        inputPanel.add(new JLabel("Goals 1"));
        inputPanel.add(new JLabel("Team 2"));
        inputPanel.add(new JLabel("Goals 2"));

        team1Field = new JTextField(4);
        goals1Field = new JTextField(2);
        team2Field = new JTextField(4);
        goals2Field = new JTextField(2);

        inputPanel.add(team1Field);
        inputPanel.add(goals1Field);
        inputPanel.add(team2Field);
        inputPanel.add(goals2Field);

        frame.add(inputPanel, BorderLayout.CENTER);

        // Botões
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add Result");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> frame.dispose());
        buttonPanel.add(cancelButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String team1 = team1Field.getText().trim();
            int goals1 = Integer.parseInt(goals1Field.getText().trim());
            String team2 = team2Field.getText().trim();
            int goals2 = Integer.parseInt(goals2Field.getText().trim());

            if(team1.isEmpty() || team2.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter names for both teams.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Aqui fazemos o cast para AddController para acessar o método que não está na interface
            ((AddController) controller).addMatchResult(team1, goals1, team2, goals2);

            JOptionPane.showMessageDialog(frame, "Match result added successfully!");

            // Limpar campos após adicionar
            team1Field.setText("");
            goals1Field.setText("");
            team2Field.setText("");
            goals2Field.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter valid integer goals.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
