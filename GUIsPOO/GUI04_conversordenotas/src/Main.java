import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Configuração da janela
        JFrame janela = new JFrame("Conversor de Notas");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setBounds(400,100,600,500);

        //Criação do painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //campo valor
        JPanel painelValor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelValor.add(new JLabel("VALOR:"));
        JTextField txtValor = new JTextField(10);
        painelValor.add(txtValor);
        painelPrincipal.add(painelValor);


        String[] notas = {"100", "50", "20", "10", "5", "2", "1"};
        JTextField[] camposNotas = new JTextField[notas.length];

        //painel primeira fileira 3 colunas
        JPanel painelFileira1 = new JPanel(new GridLayout(1, 3, 10, 10));
        painelFileira1.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // segunda fileira 3 colunas
        JPanel painelFileira2 = new JPanel(new GridLayout(1, 3, 10, 10));
        painelFileira2.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        //adiciona notas à fileira
        for (int i = 0; i < notas.length; i++) {
            JPanel painelNota = criarPainelNota(notas[i], i);

            //adiciona à fileira correspondente
            if (i < 3) {
                painelFileira1.add(painelNota);
            } else {
                painelFileira2.add(painelNota);
            }

            camposNotas[i] = new JTextField("0", 3);
            camposNotas[i].setEditable(false);
            painelNota.add(camposNotas[i]);
        }

        painelPrincipal.add(painelFileira1);
        painelPrincipal.add(painelFileira2);

        //painel de botões
        JPanel painelBotoes = new JPanel();
        JButton btnCalcular = new JButton("CALCULAR");
        btnCalcular.addActionListener(e -> calcularNotas(txtValor.getText(), camposNotas));

        JButton btnLimpar = new JButton("LIMPAR");
        btnLimpar.addActionListener(e -> {
            txtValor.setText("");
            for (JTextField txt : camposNotas) txt.setText("0");
        });
        JButton btnSair = new JButton("SAIR");
        btnSair.addActionListener(e -> System.exit(0));

        painelBotoes.add(btnCalcular);
        painelBotoes.add(btnSair);
        painelBotoes.add(btnLimpar);
        painelPrincipal.add(painelBotoes);


        janela.add(painelPrincipal);
        janela.setVisible(true);
    }

    private static JPanel criarPainelNota(String valorNota, int index) {
        JPanel painelNota = new JPanel();
        painelNota.setLayout(new BoxLayout(painelNota, BoxLayout.Y_AXIS));
        painelNota.setAlignmentX(Component.CENTER_ALIGNMENT);

        //bota as imagens das notas em seus respectivos campos
        ImageIcon icon = new ImageIcon("img/" + valorNota + "reais.jpg");
        Image img = icon.getImage().getScaledInstance(130, 59, Image.SCALE_SMOOTH);
        JLabel lblImagem = new JLabel(new ImageIcon(img));
        painelNota.add(lblImagem);

        return painelNota;
    }


//calcula as notas............
    private static void calcularNotas(String valorStr, JTextField[] campos) {
        try {
            int valor = Integer.parseInt(valorStr);
            if (valor <= 0) {
                JOptionPane.showMessageDialog(null, "Valor deve ser positivo!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int[] valoresNotas = {100, 50, 20, 10, 5, 2, 1};
            int resto = valor;
            for (int i = 0; i < valoresNotas.length; i++) {
                int qtd = resto / valoresNotas[i];
                campos[i].setText(String.valueOf(qtd));
                resto %= valoresNotas[i];
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Digite um valor numérico válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}