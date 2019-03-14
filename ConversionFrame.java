package conversion;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ConversionFrame extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JPanel leftPanel = new JPanel(new GridLayout(2,1));
    private JPanel rightPanel = new JPanel(new GridLayout(2,1));



    private JTextField inputField = new JTextField();
    private JTextField outputField = new JTextField();

    private JButton convertButton = new JButton("CONVERT");

    /**
     * ConversionFrame constructor
     */
    public ConversionFrame() {
        super();

        this.convertButton.addActionListener(e -> convertClick()); //actionListener le plus compact possible

        //Setup de l'interface
        this.build();
    }


    private void convertClick () {
        try{
            int celsius = Integer.parseInt(this.inputField.getText()); //récupération de l'input
            int farhenheit = celsius*(9/5)+32;

            this.outputField.setText(farhenheit + " Fahrenheit"); //output

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, this.inputField.getText() + "n'est pas une température valide");
        }
    }




    /**
     * build: construit la fenêtre avec toutes les spécifications nécessaires
     */
    private void build () {

        setTitle("Convert Celsius to Fahrenheit"); //On donne un titre à l'application
        setSize(400,200);
        setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//on arrête le processus quand le fenêtre est fermée

        //Avoir les bonnes tailles pour chaque texte
        Dimension  dimension = new Dimension(this.getWidth() / 2, this.inputField.getPreferredSize().height);
        this.inputField.setMaximumSize(dimension);
        this.inputField.setPreferredSize(dimension);
        this.outputField.setMaximumSize(dimension);
        this.outputField.setPreferredSize(dimension);

        // Enlever les borders
        this.outputField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
        this.outputField.setEditable(false);//

        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.X_AXIS));

        this.leftPanel.setBackground(Color.GRAY);
        this.rightPanel.setBackground(Color.GRAY);


        JPanel leftRow1 = new JPanel();
        leftRow1.add(inputField);
        JPanel leftRow2 = new JPanel();
        leftRow2.add(this.convertButton);


        leftRow1.setBackground(Color.WHITE);
        leftRow2.setBackground(Color.GRAY);

        leftRow1.setLayout(new BoxLayout(leftRow1, BoxLayout.Y_AXIS));
        leftRow2.setLayout(new BoxLayout(leftRow2, BoxLayout.Y_AXIS));

        this.leftPanel.add(leftRow1);
        this.leftPanel.add(leftRow2);


        JLabel label = new JLabel(" Celsius");
        rightPanel.add(label);
        this.outputField.setBackground(Color.GRAY);
        this.outputField.setForeground(Color.BLACK);
        this.outputField.setMaximumSize(new Dimension(this.getWidth(),this.outputField.getPreferredSize().height));
        rightPanel.add(outputField);








        this.mainPanel.add(this.leftPanel);
        this.mainPanel.add(this.rightPanel);

        this.setContentPane(this.mainPanel);

    }

}

