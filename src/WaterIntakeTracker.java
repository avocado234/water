import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WaterIntakeTracker {

    private DefaultListModel<String> listModel;
    private double totalIntake;

    public WaterIntakeTracker() {
        totalIntake = 0;
        JFrame frame = new JFrame("Water Intake Tracker");

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        contentPane.add(inputPanel, BorderLayout.NORTH);

        inputPanel.add(new JLabel("Water intake (ml):"));
        JTextField waterIntakeField = new JTextField(20);
        inputPanel.add(waterIntakeField);

        JButton addButton = new JButton("Add");
        inputPanel.add(addButton);

        listModel = new DefaultListModel<>();
        JList<String> waterIntakeList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(waterIntakeList);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JLabel totalIntakeLabel = new JLabel("Total water intake: 0 ml");
        contentPane.add(totalIntakeLabel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double waterIntake = Double.parseDouble(waterIntakeField.getText());

                    if (waterIntake > 0) {
                        listModel.addElement(waterIntake + " ml");
                        totalIntake += waterIntake;
                        totalIntakeLabel.setText("Total water intake: " + (int)totalIntake + " ml");
                        waterIntakeField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid water intake value.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid water intake value.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new WaterIntakeTracker();
    }
}
