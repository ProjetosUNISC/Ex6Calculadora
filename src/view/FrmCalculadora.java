package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import model.Calculo;

public class FrmCalculadora extends JFrame {

    //declaracao calculo
    Calculo calculo = new Calculo();

    //declaracao menus
    private JMenuBar menuBar = new JMenuBar();
    private JMenu edit = new JMenu("Editar");
    private JMenu view = new JMenu("Ver");
    private JMenu help = new JMenu("Ajuda");


    //declaracao paines
    private JPanel painelPrincipal;
    private JPanel painelCalculadora;
    private JPanel painelFuncao;
    private JPanel painelCientifico;
    private JPanel painelNormal;
    //CAMPO TEXTO
    private JTextField Valor;


    public FrmCalculadora() {

        //configuracao padrao
        super("Calculadora");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);


        //organização de paineis
        painelPrincipal = new JPanel(new BorderLayout());

        painelCalculadora = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelFuncao = new JPanel(new GridLayout(1,2));

        painelCientifico = new JPanel(new GridLayout(4,3,10,10));
        painelNormal = new JPanel(new GridLayout(4,3,10,10));

        //paineis de baixo
        painelFuncao.add(painelCientifico);
        painelFuncao.add(painelNormal);

        painelPrincipal.add(painelCalculadora, BorderLayout.NORTH);
        painelPrincipal.add(painelFuncao, BorderLayout.CENTER);

        this.add(painelPrincipal, BorderLayout.CENTER); //adiciona no principal


        //PARTE DO CAMPO DO TEXTO RESULTADO

        // Criar o botão "C"
        JButton botaoC = new JButton("C");
        botaoC.addActionListener(e -> Valor.setText(""));  //limpa texto
        botaoC.setFont(new Font("Arial", Font.BOLD, 24));
        painelCalculadora.add(botaoC);

        Valor = new JTextField();
        Valor.setEditable(false);
        Valor.setHorizontalAlignment(SwingConstants.CENTER);
        Valor.setPreferredSize(new Dimension(470, 40));
        Valor.setText("");
        Valor.setBackground(Color.WHITE);
        Valor.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Valor.setFont(new Font("Arial", Font.BOLD, 18));
        painelCalculadora.add(Valor);


        // Criar o botão "CE"
        JButton botaoCE = new JButton("CE");
        botaoCE.addActionListener(e -> {
            String textoParaLimpar = Valor.getText();
            if (textoParaLimpar.length() > 0) { //Ve se não ta vazio
                Valor.setText(textoParaLimpar.substring(0, textoParaLimpar.length() - 1)); //Remove o ultimo
            }
        });
        botaoCE.setFont(new Font("Arial", Font.BOLD, 24));
        painelCalculadora.add(botaoCE);



        //parte painel direito Standart
        painelNormal.setBorder(new TitledBorder("Padrão"));
        JButton botao7 = new JButton("7");
        botao7.addActionListener(e -> adicionarNumero("7"));

        JButton botao8 = new JButton("8");
        botao8.addActionListener(e -> adicionarNumero("8"));

        JButton botao9 = new JButton("9");
        botao9.addActionListener(e -> adicionarNumero("9"));

        JButton botaoDiv = new JButton("/");
        botaoDiv.addActionListener(e -> adicionarNumero("/"));

        JButton botao4 = new JButton("4");
        botao4.addActionListener(e -> adicionarNumero("4"));

        JButton botao5 = new JButton("5");
        botao5.addActionListener(e -> adicionarNumero("5"));

        JButton botao6 = new JButton("6");
        botao6.addActionListener(e -> adicionarNumero("6"));

        JButton botaoMulti = new JButton("*");
        botaoMulti.addActionListener(e -> adicionarNumero("*"));

        JButton botao1 = new JButton("1");
        botao1.addActionListener(e -> adicionarNumero("1"));

        JButton botao2 = new JButton("2");
        botao2.addActionListener(e -> adicionarNumero("2"));

        JButton botao3 = new JButton("3");
        botao3.addActionListener(e -> adicionarNumero("3"));

        JButton botaoMeno = new JButton("-");
        botaoMeno.addActionListener(e -> {adicionarNumero("-");});

        JButton botao0 = new JButton("0");
        botao0.addActionListener(e -> adicionarNumero("0"));

        JButton botaoDot = new JButton(".");
        botaoDot.addActionListener(e -> adicionarNumero("."));

        JButton botaoResul = new JButton("="); //esse dai vai ser calculo
        botaoResul.addActionListener(e -> {

        });


        JButton botaoPlus = new JButton("+");
        botaoPlus.addActionListener(e -> adicionarNumero("+"));



        //agrupa tudo para fazer alterações em conjunto
        JButton[] botoesNormal = {
                botao7, botao8, botao9, botaoDiv,
                botao4, botao5, botao6, botaoMulti,
                botao1, botao2, botao3, botaoMeno,
                botao0, botaoDot, botaoResul, botaoPlus
        };

        //muda fonte dele
        for (JButton botao : botoesNormal) {
            botao.setFont(new Font("Arial", Font.BOLD, 24));
            painelNormal.add(botao);
        }

        //painel esquerdo Cientifico
        painelCientifico.setBorder(new TitledBorder("Científica"));
        JButton botaoSqrt = new JButton("sqrt");
        JButton botaoByX = new JButton("1/x");
        JButton botaoSin = new JButton("sin");
        JButton botaoPor = new JButton("%");
        JButton botaoExp = new JButton("Exp");
        JButton botaoCos = new JButton("Cos");
        JButton botaoX3 = new JButton("X^3");
        JButton botaoIn = new JButton("In");
        JButton botaoTan = new JButton("Tan");
        JButton botaoX2 = new JButton("X^2");
        JButton botaoN = new JButton("n!");
        JButton botaoSec = new JButton("sec");

        //grupo dos botoes
        JButton[] botoesCientificos = {
                botaoSqrt, botaoByX, botaoSin,
                botaoPor, botaoExp, botaoCos,
                botaoX3, botaoIn, botaoTan,
                botaoX2, botaoN, botaoSec
        };
        //ajusta eles e adiciona
        for (JButton botao : botoesCientificos) {
            botao.setFont(new Font("Arial", Font.BOLD, 24));
            botao.addActionListener(e -> {
                String operacao = ((JButton) e.getSource()).getText().toLowerCase();
                double valor = Double.parseDouble(Valor.getText());
                double resultado = calculo.calcular(operacao, valor);
                Valor.setText(String.valueOf(resultado));
            });
            painelCientifico.add(botao);
        }









        //organizacao menu
        this.add(menuBar, BorderLayout.NORTH);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);




        this.pack();
        this.setVisible(true);
    }

    //adicionar numero no texto
    public void adicionarNumero(String numero) {
        String textoAtual = Valor.getText();
        String novoTexto = textoAtual + numero;
        Valor.setText(novoTexto);
    }

}
