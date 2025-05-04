import javax.swing.*;
import java.awt.*;

public class Teste {
    public static void main(String[] args) {
        // Configuração da janela
        JFrame janela = new JFrame("Conversor de Notas");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(600, 500); // Tamanho ajustado para 2 linhas de 3 colunas

        // Painel principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campo de valor
        JPanel painelValor = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelValor.add(new JLabel("VALOR:"));
        JTextField txtValor = new JTextField(10);
        painelValor.add(txtValor);
        painelPrincipal.add(painelValor);

        // Notas monetárias (7 notas: 100, 50, 20, 10, 5, 2, 1)
        String[] notas = {"100", "50", "20", "10", "5", "2", "1"};
        JTextField[] camposNotas = new JTextField[notas.length];

        // Painel para a primeira fileira (3 colunas)
        JPanel painelFileira1 = new JPanel(new GridLayout(1, 3, 10, 10));
        painelFileira1.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Painel para a segunda fileira (3 colunas)
        JPanel painelFileira2 = new JPanel(new GridLayout(1, 3, 10, 10));
        painelFileira2.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Adiciona as notas às fileiras
        for (int i = 0; i < notas.length; i++) {
            JPanel painelNota = criarPainelNota(notas[i], i);

            // Adiciona à fileira correspondente
            if (i < 3) {
                painelFileira1.add(painelNota);
            } else {
                painelFileira2.add(painelNota);
            }

            // Cria e armazena o campo de texto
            camposNotas[i] = new JTextField("0", 3);
            camposNotas[i].setEditable(false);
            painelNota.add(camposNotas[i]);
        }

        painelPrincipal.add(painelFileira1);
        painelPrincipal.add(painelFileira2);

        // Painel de botões
        JPanel painelBotoes = new JPanel();
        JButton btnCalcular = new JButton("CALCULAR");
        btnCalcular.addActionListener(e -> calcularNotas(txtValor.getText(), camposNotas));

        JButton btnLimpar = new JButton("LIMPAR");
        btnLimpar.addActionListener(e -> {
            txtValor.setText("");
            for (JTextField txt : camposNotas) txt.setText("0");
        });

        painelBotoes.add(btnCalcular);
        painelBotoes.add(btnLimpar);
        painelPrincipal.add(painelBotoes);

        janela.add(painelPrincipal);
        janela.setVisible(true);
    }

    private static JPanel criarPainelNota(String valorNota, int index) {
        JPanel painelNota = new JPanel();
        painelNota.setLayout(new BoxLayout(painelNota, BoxLayout.Y_AXIS));
        painelNota.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Carrega a imagem (130x59 pixels)
            ImageIcon icon = new ImageIcon("img/" + valorNota + "reais.jpg");
            Image img = icon.getImage().getScaledInstance(130, 59, Image.SCALE_SMOOTH);
            JLabel lblImagem = new JLabel(new ImageIcon(img));
            painelNota.add(lblImagem);

        return painelNota;
    }

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