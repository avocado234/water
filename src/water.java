import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class water {


    public water() {
        JFrame frame = new JFrame("Hydration Recommendation");

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel ageLabel = new JLabel("Age:");
        contentPane.add(ageLabel, constraints);

        constraints.gridx = 1;
        JTextField ageTextField = new JTextField(20);
        contentPane.add(ageTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        JLabel genderLabel = new JLabel("Gender (M/F):");
        contentPane.add(genderLabel, constraints);

        constraints.gridx = 1;
        JTextField genderTextField = new JTextField(20);
        contentPane.add(genderTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        JButton calculateButton = new JButton("Next");
        contentPane.add(calculateButton, constraints);

        JLabel resultLabel = new JLabel("");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

    
    calculateButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            try {
                int age = Integer.parseInt(ageTextField.getText());
                char gender = genderTextField.getText().charAt(0);
                System.out.println(gender);

                if (gender == 'M' || gender == 'F'||gender == 'm' || gender == 'f' && age > 0 || age <100) {
                    checkAge checkAge = new checkAge();
                    double WaterIntake = checkAge.check(age, gender);
                    JOptionPane.showMessageDialog(frame,"Recommended daily water intake : " +(int)WaterIntake + " Mlliliter");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid age and gender (M/F).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid age and gender (M/F).", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });
}
    
    
    public class WaterIntakeTracker {
        private double totalIntake;
        private DefaultListModel<String> listModel;
    
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
                            totalIntakeLabel.setText("Total water intake: " + (int) totalIntake + " ml");
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
            frame.setSize(350, 200);
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
        }
    }
    
    
        

        // constraints.gridx = 0;
        // constraints.gridy = 3;
        // constraints.gridwidth = 2;
        // constraints.anchor = GridBagConstraints.CENTER;
        // contentPane.add(resultLabel, constraints);

        
        // Center the frame on the screen

    
       public static void main(String[] args) {
        new water();
        
       }
    

    }

