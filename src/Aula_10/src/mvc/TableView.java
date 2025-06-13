package src.mvc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TableView extends View implements ActionListener, ModelObserver {

    private JTable table;
    private DefaultTableModel tableModel;

    public TableView(Controller theController, LeagueStatsModel theModel) {
        super(theController, theModel);
        theModel.addObserver(this); 
    }

    @Override
    public void createView() {
        frame = new JFrame("Tabela do Brasileirão");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Time", "Pontos", "Jogos", "Vitórias", "Empates", "Derrotas", "Gols Pró", "Gols Contra", "Saldo"}
        );
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        frame.add(btnPanel, BorderLayout.SOUTH);

        JButton updateButton = new JButton("Atualizar Tabela");
        updateButton.addActionListener(this);
        btnPanel.add(updateButton);

        populateTable();
    }

    public void populateTable() {
        tableModel.setRowCount(0); // Limpa a tabela

        for (TeamStats team : model.getResults()) {
            tableModel.addRow(new Object[]{
                team.getName(),
                team.getScore(),
                team.getNumberOfMatches(),
                team.getNumberOfWins(),
                team.getNumberOfDraws(),
                team.getNumberOfLosses(),
                team.getGoalsFor(),
                team.getGoalsAgainst(),
                team.getGoalsDifference()
            });
        }

        table.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        populateTable();
    }

    // Atualiza automaticamente quando o modelo muda
    @Override
    public void modelChanged() {
        populateTable();
    }
}
