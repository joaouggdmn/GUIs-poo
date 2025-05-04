import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("CONVERSOR DE MOEDAS");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setBounds(500, 100, 800, 500);
        //janelaaa


        //camposs confg
        JTextField txtDolar = new JTextField();
        JTextField txtTaxa = new JTextField();
        JTextField txtResultado = new JTextField();
        JTextField txtInverso = new JTextField();
        txtResultado.setEditable(false);
        txtInverso.setEditable(false);


        //
        JButton btnCalcular = new JButton("CALCULE");
        btnCalcular.addActionListener(e -> calcular(
                txtDolar.getText(),
                txtTaxa.getText(),
                txtResultado,
                txtInverso));

        JButton btnLimpar = new JButton("LIMPAR");
        btnLimpar.addActionListener(e -> {
            txtDolar.setText("");
            txtTaxa.setText("");
            txtResultado.setText("");
            txtInverso.setText("");
        });

        JButton btnSair = new JButton("SAIR");
        btnSair.addActionListener(e -> System.exit(0));
        //botoess

        JPanel painel = new JPanel(new GridLayout(6, 2, 20, 5));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //config tam bot e grade

        painel.add(new JLabel("Quantidade em Dolar $U"));
        painel.add(txtDolar);
        painel.add(new JLabel("Valor do Dolar em Real (RS)"));
        painel.add(txtTaxa);
        painel.add(new JLabel("Dolar para Real"));
        painel.add(txtResultado);
        painel.add(new JLabel("Real para Dolar"));
        painel.add(txtInverso);
        painel.add(btnCalcular);
        painel.add(btnLimpar);
        painel.add(btnSair);

        janela.add(painel);
        janela.setVisible(true);
    }

    private static void calcular(String strDolar, String strTaxa, JTextField resultado, JTextField inverso) {
            double dolar = Double.parseDouble(strDolar);
            double taxa = Double.parseDouble(strTaxa);
            resultado.setText(String.format("%.6f", dolar * taxa));
            inverso.setText(String.format("%.2f", dolar / taxa));
    }
}