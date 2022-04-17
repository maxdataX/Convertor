import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class convert {

    public JFrame frame;
    public JTextField textField;
    public JTextField textField_1;
    public JLabel  lblNewLabel_1;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    convert window = new convert();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
        public void clock()
        {
            Calendar cal=new GregorianCalendar();
            int second=cal.get(Calendar.SECOND);
            int minute=cal.get(Calendar.MINUTE);
            int hour=cal.get(Calendar.HOUR);
            lblNewLabel_1.setText(hour+":"+minute+":"+second);

        }


    public convert() {
        initialize();
        clock();

    }


    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(Color.CYAN);
        frame.getContentPane().setForeground(Color.CYAN);
        frame.setBounds(100, 100, 670, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);



        JLabel lblNewLabel = new JLabel("CONVERTOR");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 204, 0));
        lblNewLabel.setFont(new Font("Kristen ITC", Font.ITALIC, 33));
        lblNewLabel.setBounds(161, 15, 311, 52);
        frame.getContentPane().add(lblNewLabel);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
        comboBox.setForeground(Color.RED);
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Select", "Valutar", "Temperatura", "Greutate", "Viteza"}));
        comboBox.setBounds(260, 85, 146, 22);
        frame.getContentPane().add(comboBox);


        String[] valute = {"Select", "EUR", "USD", "RON", "GBP"};
        String[] temperatura = {"Select", "Celsius", "Fahrenheit", "Kelvin", "Rankine"};
        String[] greu = {"Select", "Kilogram", "Livre", "Grame", "Uncii", "Pietre"};
        String[] vit = {"Select", "Km/H", "Mph"};
        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        comboBox_1.setForeground(Color.BLUE);
        comboBox_1.setModel(new DefaultComboBoxModel(valute));
        comboBox_1.setBounds(47, 150, 193, 22);
        frame.getContentPane().add(comboBox_1);

        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
        comboBox_1_1.setForeground(Color.BLUE);
        comboBox_1_1.setModel(new DefaultComboBoxModel(new String[]{"select", "EUR", "USD", "RON", "GBP"}));
        comboBox_1_1.setBounds(393, 150, 193, 22);
        frame.getContentPane().add(comboBox_1_1);

        textField = new JTextField();
        textField.setForeground(new Color(0, 128, 0));
        textField.setBounds(47, 201, 193, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField.setForeground(new Color(255, 255, 0));
        textField_1.setBounds(393, 201, 193, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);



        JButton btnNewButton_1 = new JButton("Convert");
        btnNewButton_1.setFont(new Font("Lucida Console", Font.BOLD | Font.ITALIC, 11));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

            }
        });
        btnNewButton_1.setBounds(272, 200, 89, 23);
        frame.getContentPane().add(btnNewButton_1);
         lblNewLabel_1 = new JLabel("  Clock");
         lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(482, 11, 169, 36);
        lblNewLabel_1.setForeground(new Color(0,0,205));
        lblNewLabel_1.setFont(new Font("Tahoma",Font.BOLD,16));
        frame.getContentPane().add(lblNewLabel_1);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem().equals("Valutar")) {
                    comboBox_1.setModel(new DefaultComboBoxModel(valute));
                    comboBox_1_1.setModel(new DefaultComboBoxModel(valute));


                } else {
                    comboBox_1.setModel(new DefaultComboBoxModel(temperatura));
                    comboBox_1_1.setModel(new DefaultComboBoxModel(temperatura));

                }
                if (comboBox.getSelectedItem().equals("Greutate")) {
                    comboBox_1.setModel(new DefaultComboBoxModel(greu));
                    comboBox_1_1.setModel(new DefaultComboBoxModel(greu));
                }
                if (comboBox.getSelectedItem().equals("Viteza")) {
                    comboBox_1.setModel(new DefaultComboBoxModel(vit));
                    comboBox_1_1.setModel(new DefaultComboBoxModel(vit));
                }

            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Pentru Valuta
                if (comboBox_1.getSelectedItem().equals("EUR") && comboBox_1_1.getSelectedItem().equals("USD"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 1.22));
                if (comboBox_1.getSelectedItem().equals("EUR") && comboBox_1_1.getSelectedItem().equals("RON"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 4.8));
                if (comboBox_1.getSelectedItem().equals("EUR") && comboBox_1_1.getSelectedItem().equals("GBP"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.91));


                if (comboBox_1.getSelectedItem().equals("USD") && comboBox_1_1.getSelectedItem().equals("EUR"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.81));
                if (comboBox_1.getSelectedItem().equals("USD") && comboBox_1_1.getSelectedItem().equals("RON"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 3.99));
                if (comboBox_1.getSelectedItem().equals("USD") && comboBox_1_1.getSelectedItem().equals("GBP"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.74));


                if (comboBox_1.getSelectedItem().equals("RON") && comboBox_1_1.getSelectedItem().equals("EUR"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.20));
                if (comboBox_1.getSelectedItem().equals("RON") && comboBox_1_1.getSelectedItem().equals("USD"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.81));
                if (comboBox_1.getSelectedItem().equals("RON") && comboBox_1_1.getSelectedItem().equals("GBP"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.18));


                if (comboBox_1.getSelectedItem().equals("GBP") && comboBox_1_1.getSelectedItem().equals("EUR"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 1.10));
                if (comboBox_1.getSelectedItem().equals("GBP") && comboBox_1_1.getSelectedItem().equals("USD"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 1.34));
                if (comboBox_1.getSelectedItem().equals("GBP") && comboBox_1_1.getSelectedItem().equals("RON"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 5.38));

// Pentru Temperatura

                if (comboBox_1.getSelectedItem().equals("Celsius") && comboBox_1_1.getSelectedItem().equals("Fahrenheit"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 1.80 + 32));
                if (comboBox_1.getSelectedItem().equals("Celsius") && comboBox_1_1.getSelectedItem().equals("Kelvin"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) + 273.15));
                if (comboBox_1.getSelectedItem().equals("Celsius") && comboBox_1_1.getSelectedItem().equals("Rankine"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) + 273.15 * 1.8 + 8));

                if (comboBox_1.getSelectedItem().equals("Fahrenheit") && comboBox_1_1.getSelectedItem().equals("Celsius"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) - 32 / 1.80));
                if (comboBox_1.getSelectedItem().equals("Fahrenheit") && comboBox_1_1.getSelectedItem().equals("Kelvin"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) + 459.67 * 1.8));
                if (comboBox_1.getSelectedItem().equals("Fahrenheit") && comboBox_1_1.getSelectedItem().equals("Rankine"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) + 459.67));


                if (comboBox_1.getSelectedItem().equals("Kelvin") && comboBox_1_1.getSelectedItem().equals("Celsius"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) - 273.15));
                if (comboBox_1.getSelectedItem().equals("Kelvin") && comboBox_1_1.getSelectedItem().equals("Fahrenheit"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 1.8 - 459.67));
                if (comboBox_1.getSelectedItem().equals("Kelvin") && comboBox_1_1.getSelectedItem().equals("Rankine"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) - 32 / 1.80));


                if (comboBox_1.getSelectedItem().equals("Rankine") && comboBox_1_1.getSelectedItem().equals("Celsius"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) - 491.67 * 0.55));
                if (comboBox_1.getSelectedItem().equals("Rankine") && comboBox_1_1.getSelectedItem().equals("Kelvin"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.55));
                if (comboBox_1.getSelectedItem().equals("Rankine") && comboBox_1_1.getSelectedItem().equals("Fahrenheit"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) - 459.67));
                //Pentru Greutate


                if (comboBox_1.getSelectedItem().equals("Kilogram") && comboBox_1_1.getSelectedItem().equals("Livre"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 2.20));
                if (comboBox_1.getSelectedItem().equals("Kilogram") && comboBox_1_1.getSelectedItem().equals("Grame"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) / 1000));
                if (comboBox_1.getSelectedItem().equals("Kilogram") && comboBox_1_1.getSelectedItem().equals("Uncii"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 35.27));
                if (comboBox_1.getSelectedItem().equals("Kilogram") && comboBox_1_1.getSelectedItem().equals("Pietre"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.15));
                // Pentru Viteza
                if (comboBox_1.getSelectedItem().equals("Km/H") && comboBox_1_1.getSelectedItem().equals("Mph"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 0.62));
                if (comboBox_1.getSelectedItem().equals("Mph") && comboBox_1_1.getSelectedItem().equals("Km/H"))
                    textField_1.setText(String.valueOf(Integer.parseInt(textField.getText()) * 1.62));

            }
        });
    }

}