import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("MILHAS -> KM");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setBounds(300, 200, 700, 400);

        JPanel painel = new JPanel();
        painel.setLayout(null);
        janela.add(painel);

        JLabel lblMilhas = new JLabel("Milhas:");
        lblMilhas.setBounds(10, 50, 100, 20);
        painel.add(lblMilhas);

        JTextField txtMilhas = new JTextField();
        txtMilhas.setBounds(60, 50, 150, 20);
        painel.add(txtMilhas);

        JLabel lblKm = new JLabel("Quilômetros:");
        lblKm.setBounds(40, 130, 100, 20);
        painel.add(lblKm);

        JTextField txtKm = new JTextField();
        txtKm.setBounds(30, 150, 200, 70);
        txtKm.setEditable(false);
        painel.add(txtKm);

        // Botões
        JButton btnConverter = new JButton("Converter");
        btnConverter.setBounds(400, 70, 200, 40);
        btnConverter.addActionListener(e ->
                converterMilhasParaKm(
                        txtMilhas.getText(),
                        txtKm));
        painel.add(btnConverter);

        JButton btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(400, 120, 200, 40);
        btnLimpar.addActionListener(e -> {
            txtMilhas.setText("");
            txtKm.setText("");
        });
        painel.add(btnLimpar);

        JButton btnSair = new JButton("SAIR");
        btnSair.setBounds(400, 170, 200, 40);
        btnSair.addActionListener(e -> System.exit(0));
        painel.add(btnSair);

        janela.setVisible(true);
    }

    private static void converterMilhasParaKm(String strMilhas, JTextField txtKm) {
        double milhas = Double.parseDouble(strMilhas);
        double km = milhas * 1.60934; // Fator de conversão
        txtKm.setText(String.format("%.2f", km));
    }
}