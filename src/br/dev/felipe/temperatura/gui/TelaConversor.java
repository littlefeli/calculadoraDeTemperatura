package br.dev.felipe.temperatura.gui;

import br.dev.felipe.temperatura.model.Temperatura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaConversor extends JFrame {

    private JTextField campoEntrada;
    private JLabel campoResultado;
    private JComboBox<String> comboOrigem;
    private JComboBox<String> comboDestino;

    public TelaConversor() {
        setTitle("Conversor de Temperatura");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout
        setLayout(new GridLayout(5, 2, 10, 10));

        // Componentes
        add(new JLabel("Temperatura:"));
        campoEntrada = new JTextField();
        add(campoEntrada);

        add(new JLabel("De:"));
        comboOrigem = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        add(comboOrigem);

        add(new JLabel("Para:"));
        comboDestino = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        add(comboDestino);

        JButton btnCalcular = new JButton("Calcular");
        JButton btnLimpar = new JButton("Limpar");
        add(btnCalcular);
        add(btnLimpar);

        add(new JLabel("Resultado:"));
        campoResultado = new JLabel("");
        add(campoResultado);

        // Ações
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double valor = Double.parseDouble(campoEntrada.getText());
                    String origem = comboOrigem.getSelectedItem().toString();
                    String destino = comboDestino.getSelectedItem().toString();
                    double convertido = Temperatura.converter(valor, origem, destino);
                    campoResultado.setText(String.format("%.2f %s", convertido, destino));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Insira um número válido.");
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoEntrada.setText("");
                campoResultado.setText("");
                comboOrigem.setSelectedIndex(0);
                comboDestino.setSelectedIndex(0);
            }
        });
    }
}