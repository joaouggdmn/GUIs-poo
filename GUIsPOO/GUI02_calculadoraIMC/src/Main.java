import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("IMC");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 400);     //janelinha

        JTextField txtAltura = new JTextField();
        JTextField txtPeso = new JTextField();
        JTextField txtIMC = new JTextField();
        JTextField txtClassificacao = new JTextField();
        txtIMC.setEditable(false);
        txtClassificacao.setEditable(false);               //criação dos componnetes



        JButton btnCalcular = new JButton("Calcular MIC");
        btnCalcular.addActionListener(e -> calcularIMC(txtAltura.getText(), txtPeso.getText(), txtIMC, txtClassificacao));

        JButton btnLimpar = new JButton("LIMPAR");
        btnLimpar.addActionListener(e -> {
            txtAltura.setText("");
            txtPeso.setText("");
            txtIMC.setText("");
            txtClassificacao.setText("");
        });

        JButton btnSair = new JButton("SAIR");
        btnSair.addActionListener(e -> System.exit(0));
        JPanel painel = new JPanel(new GridLayout(7, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Sua Altura (m):"));
        painel.add(txtAltura);
        painel.add(new JLabel("Seu Peso (Kg):"));
        painel.add(txtPeso);
        painel.add(new JLabel("-------RESULTADO DO IMC-------"));
        painel.add(new JLabel(""));
        painel.add(new JLabel("SEU IMC:"));
        painel.add(txtIMC);
        painel.add(new JLabel("CLASSIFICAÇÃO:"));
        painel.add(txtClassificacao);
        painel.add(btnCalcular);
        painel.add(btnLimpar);
        painel.add(btnSair);

        janela.add(painel);
        janela.setVisible(true);
    }

    public static void calcularIMC(String strAltura, String strPeso, JTextField txtIMC, JTextField txtClassificacao) {
        double altura = Double.parseDouble(strAltura);
        double peso = Double.parseDouble(strPeso);
        double imc = peso / (altura * altura);
        txtIMC.setText(new DecimalFormat("#.###").format(imc));

        txtClassificacao.setText(classificarIMC(imc));//pega o resultado do método classficarIMC
    }
    public static String classificarIMC(double imc) {
        if (imc <18.5) return "ABAIXO DO PESO";
        else if (imc<25) return "PESO NORMAL";
        else if (imc<30) return "SOBREPESO";
        else if (imc <35) return "OBESIDADE GRAU I";
        else if (imc<40) return "OBESIDADE GRAU II";
        else return "OBESIDADE GRAU III";
    }
}
