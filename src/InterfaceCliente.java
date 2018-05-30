
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InterfaceCliente extends javax.swing.JFrame {

    private ImageIcon imgSair;
    private SquarePanel busca=new SquarePanel(0,"",null);
    private SquarePanel[][] board = new SquarePanel[9][9];
    private SquarePanel[][] boardpecas = new SquarePanel[8][4];
    private String[][] tipoCor = new String[9][9];
    private String[][] tipoCorTabuleiroFantasma = new String[8][4];
    private String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private String[] letras2 = {"i", "j", "k", "l"};

    private int jog1 = -1;
    private String jog1s = null;

    public InterfaceCliente() {
        initComponents();
        botoesinicio();
        colocaPecaTipoCor();
        PanelTabuleiro.setLayout(new GridLayout(8, 8));
        PanelPecas.setLayout(new GridLayout(8, 4));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        SquarePanel.loadPieceImages();
        //for tabuleiro
        for (int i = 8; i >= 1; i--) {
            for (int j = 1; j < 9; j++) {
                SquarePanel sqPanel = new SquarePanel(i, letras[j - 1], this);
                sqPanel.setBackColor((i + j) % 2);
                //String l = letras[j-1];
                board[i][j] = sqPanel;
                PanelTabuleiro.add(sqPanel);
            }
        }
        //for peças fora de jogo
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                SquarePanel sqPanel = new SquarePanel(i, letras2[j], this);
                boardpecas[i][j] = sqPanel;
                //boardpecas[i][j].setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)));
                PanelPecas.add(sqPanel);
            }
        }
        //borda cinzenta de peças fora de jogo
        PanelPecas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.DARK_GRAY)));

        add(PanelTabuleiro, BorderLayout.CENTER);
        
        pecasDefault();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextIp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TextPorto = new javax.swing.JTextField();
        BotaoEntrar = new javax.swing.JButton();
        BotaoSair = new javax.swing.JButton();
        PanelTabuleiro = new javax.swing.JPanel();
        BotaoSentar1 = new javax.swing.JButton();
        BotaoSentar2 = new javax.swing.JButton();
        LabelJogador1 = new javax.swing.JLabel();
        LabelJogador2 = new javax.swing.JLabel();
        BotaoOrdenar = new javax.swing.JButton();
        BotaoEnviarMsg = new javax.swing.JButton();
        TextMensagem = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TextObservador = new javax.swing.JTextArea();
        BotaoObservador = new javax.swing.JButton();
        PanelPecas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TextNome = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextChat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("IP");

        TextIp.setName("TextIp"); // NOI18N

        jLabel2.setText("Porto");

        TextPorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextPortoActionPerformed(evt);
            }
        });

        BotaoEntrar.setText("Entrar");
        BotaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEntrarActionPerformed(evt);
            }
        });

        BotaoSair.setText("Sair");

        PanelTabuleiro.setBackground(new java.awt.Color(102, 102, 102));
        PanelTabuleiro.setForeground(new java.awt.Color(51, 51, 51));
        PanelTabuleiro.setName("PanelTabuleiro"); // NOI18N

        javax.swing.GroupLayout PanelTabuleiroLayout = new javax.swing.GroupLayout(PanelTabuleiro);
        PanelTabuleiro.setLayout(PanelTabuleiroLayout);
        PanelTabuleiroLayout.setHorizontalGroup(
            PanelTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        PanelTabuleiroLayout.setVerticalGroup(
            PanelTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        BotaoSentar1.setText("Sentar");
        BotaoSentar1.setActionCommand("cadeira1");
        BotaoSentar1.setName("BotaoSentar1"); // NOI18N
        BotaoSentar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSentar1ActionPerformed(evt);
            }
        });

        BotaoSentar2.setText("Sentar");
        BotaoSentar2.setName("cadeira2"); // NOI18N

        LabelJogador1.setText("Nome Jogador 1");

        LabelJogador2.setText("Nome Jogador 2");

        BotaoOrdenar.setText("Ordenar Tabuleiro");
        BotaoOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoOrdenarActionPerformed(evt);
            }
        });

        BotaoEnviarMsg.setText("Enviar");
        BotaoEnviarMsg.setToolTipText("");
        BotaoEnviarMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEnviarMsgActionPerformed(evt);
            }
        });

        TextMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextMensagemActionPerformed(evt);
            }
        });

        TextObservador.setEditable(false);
        TextObservador.setColumns(20);
        TextObservador.setRows(5);
        jScrollPane3.setViewportView(TextObservador);

        BotaoObservador.setText("Observador");

        PanelPecas.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout PanelPecasLayout = new javax.swing.GroupLayout(PanelPecas);
        PanelPecas.setLayout(PanelPecasLayout);
        PanelPecasLayout.setHorizontalGroup(
            PanelPecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        PanelPecasLayout.setVerticalGroup(
            PanelPecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );

        jLabel5.setText("Lista de Observadores");

        jLabel6.setText("Nome");

        TextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNomeActionPerformed(evt);
            }
        });

        TextChat.setEditable(false);
        TextChat.setColumns(20);
        TextChat.setRows(5);
        jScrollPane1.setViewportView(TextChat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(318, 318, 318)
                                .addComponent(LabelJogador1)
                                .addGap(54, 54, 54)
                                .addComponent(BotaoSentar1)
                                .addGap(89, 89, 89))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextIp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TextPorto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PanelPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(PanelTabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(46, 46, 46))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(BotaoOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LabelJogador2)
                        .addGap(41, 41, 41)
                        .addComponent(BotaoSentar2)
                        .addGap(97, 97, 97)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(BotaoEntrar)
                        .addGap(33, 33, 33)
                        .addComponent(BotaoSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(100, 100, 100))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TextMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoEnviarMsg))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BotaoObservador)
                                .addGap(106, 106, 106))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(TextPorto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoEntrar)
                    .addComponent(BotaoSair)
                    .addComponent(jLabel6)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSentar1)
                    .addComponent(LabelJogador1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotaoEnviarMsg)))
                            .addComponent(PanelTabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LabelJogador2)
                                .addComponent(BotaoSentar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(BotaoOrdenar))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoObservador)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botoesinicio(){
        BotaoSair.setEnabled(false);
        BotaoSentar1.setEnabled(false);
        BotaoSentar2.setEnabled(false);
        BotaoEnviarMsg.setEnabled(false);
        BotaoObservador.setEnabled(false);
        BotaoOrdenar.setEnabled(false);
       // PanelTabuleiro.setEnabled(false);
    }
    
    private void colocaPecaTipoCor() {
        //linha primeira de baixo, peças brancas
        tipoCor[8][1] = "31";
        tipoCor[8][2] = "11";
        tipoCor[8][3] = "21";
        tipoCor[8][4] = "41";
        tipoCor[8][5] = "51";
        tipoCor[8][6] = "21";
        tipoCor[8][7] = "11";
        tipoCor[8][8] = "31";

        //segunda linha de baixo, peças brancas
        tipoCor[7][1] = "01";
        tipoCor[7][2] = "01";
        tipoCor[7][3] = "01";
        tipoCor[7][4] = "01";
        tipoCor[7][5] = "01";
        tipoCor[7][6] = "01";
        tipoCor[7][7] = "01";
        tipoCor[7][8] = "01";

        //primeira linha de cima, peças pretas
        tipoCor[1][1] = "30";
        tipoCor[1][2] = "10";
        tipoCor[1][3] = "20";
        tipoCor[1][4] = "40";
        tipoCor[1][5] = "50";
        tipoCor[1][6] = "20";
        tipoCor[1][7] = "10";
        tipoCor[1][8] = "30";

        //segunda linha cima, peças pretas
        tipoCor[2][1] = "00";
        tipoCor[2][2] = "00";
        tipoCor[2][3] = "00";
        tipoCor[2][4] = "00";
        tipoCor[2][5] = "00";
        tipoCor[2][6] = "00";
        tipoCor[2][7] = "00";
        tipoCor[2][8] = "00";
    }
    
    public void pecasDefault(){
         for (int i = 8; i >= 1; i--) {
            for (int j = 1; j < 9; j++) {
                board[i][j].removePiece();
            }
        }
          for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                boardpecas[i][j].removePiece();
                tipoCorTabuleiroFantasma[i][j]=null;
            }
        }
        //linha primeira de baixo, peças brancas
        board[8][1].setPiece(1, 3);
        board[8][2].setPiece(1, 1);
        board[8][3].setPiece(1, 2);
        board[8][4].setPiece(1, 4);
        board[8][5].setPiece(1, 5);
        board[8][6].setPiece(1, 2);
        board[8][7].setPiece(1, 1);
        board[8][8].setPiece(1, 3);

        //segunda linha de baixo, peças brancas
        board[7][1].setPiece(1, 0);
        board[7][2].setPiece(1, 0);
        board[7][3].setPiece(1, 0);
        board[7][4].setPiece(1, 0);
        board[7][5].setPiece(1, 0);
        board[7][6].setPiece(1, 0);
        board[7][7].setPiece(1, 0);
        board[7][8].setPiece(1, 0);

        //primeira linha de cima, peças pretas
        board[1][1].setPiece(0, 3);
        board[1][2].setPiece(0, 1);
        board[1][3].setPiece(0, 2);
        board[1][4].setPiece(0, 4);
        board[1][5].setPiece(0, 5);
        board[1][6].setPiece(0, 2);
        board[1][7].setPiece(0, 1);
        board[1][8].setPiece(0, 3);

        //segunda linha cima, peças pretas
        board[2][1].setPiece(0, 0);
        board[2][2].setPiece(0, 0);
        board[2][3].setPiece(0, 0);
        board[2][4].setPiece(0, 0);
        board[2][5].setPiece(0, 0);
        board[2][6].setPiece(0, 0);
        board[2][7].setPiece(0, 0);
        board[2][8].setPiece(0, 0);
    }

    public int stringNumero(String letra) {
        if (letra.equals("a")) {
            return 1;
        }
        if (letra.equals("b")) {
            return 2;
        }
        if (letra.equals("c")) {
            return 3;
        }
        if (letra.equals("d")) {
            return 4;
        }
        if (letra.equals("e")) {
            return 5;
        }
        if (letra.equals("f")) {
            return 6;
        }
        if (letra.equals("g")) {
            return 7;
        }
        if (letra.equals("h")) {
            return 8;
        }

        return 0;
    }

    public int stringNumero2(String letra) {
        if (letra.equals("i")) {
            return 0;
        }
        if (letra.equals("j")) {
            return 1;
        }
        if (letra.equals("k")) {
            return 2;
        }
        if (letra.equals("l")) {
            return 3;
        }

        return -1;
    }

    public int[] tipoCorF(String peca) {
        int[] tipocor = new int[2];
        tipocor[0] = Integer.parseInt("" + peca.charAt(1));
        tipocor[1] = Integer.parseInt("" + peca.charAt(0));
        return tipocor;
    }

    public void colocaPecaTabuleiroFantasma(String peca) {
        int[] cortipo = tipoCorF(peca);
        int valor = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (tipoCorTabuleiroFantasma[i][j] == null && valor == 0) {
                    boardpecas[i][j].setPiece(cortipo[0], cortipo[1]);
                    tipoCorTabuleiroFantasma[i][j] = peca;
                    valor = 1;
                }
            }
        }
    }
    private void BotaoSentar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSentar1ActionPerformed
        // TODO add your handling code here:
        imgSair = new ImageIcon("entracadeira.png");
        BotaoSentar1 = new JButton(imgSair);

    }//GEN-LAST:event_BotaoSentar1ActionPerformed

    public void selected(int x, String y) {
        if (jog1 == -1) {
            if (stringNumero(y) != 0) {
                if (tipoCor[x][stringNumero(y)] != null) {
                    jog1 = x;
                    jog1s = y;
                }
            } else {
                if (tipoCorTabuleiroFantasma[x][stringNumero2(y)] != null) {
                    jog1 = x;
                    jog1s = y;
                }
            }
        } else {
            if (stringNumero(y) != 0) {
                String name = null;
                //vai buscar o tipo e cor da peça na primeira posição "0b"
                board[jog1][stringNumero(jog1s)].setBorder(null);
                System.out.println("InterfaceCliente.selected()");
                if (stringNumero(jog1s) != 0) {
                    name = tipoCor[jog1][stringNumero(jog1s)];
                } else {
                    name = tipoCorTabuleiroFantasma[jog1][stringNumero2(jog1s)];
                }

                int[] cortipo = tipoCorF(name);
                //mete no tanuleiro visivel a peça no lugar onde queriamos
                board[x][stringNumero(y)].setPiece(cortipo[0], cortipo[1]);
                // se o destino tiver uma peça, temos de passar essa peça para o tabuleiro de fora
                if (tipoCor[x][stringNumero(y)] != null && (jog1 != x || !jog1s.equals(y))) {
                    colocaPecaTabuleiroFantasma(tipoCor[x][stringNumero(y)]);
                }
                //muda no tabuleiro fantasma a peça para onde queriamos
                if (stringNumero(jog1s) != 0) {
                    tipoCor[x][stringNumero(y)] = tipoCor[jog1][stringNumero(jog1s)];
                } else {
                    tipoCor[x][stringNumero(y)] = tipoCorTabuleiroFantasma[jog1][stringNumero2(jog1s)];
                }
                //remove no tabuleiro fantasma a primeira peça clicada
                if (stringNumero(jog1s) != 0) {
                    if (jog1 != x || !jog1s.equals(y)) {
                        tipoCor[jog1][stringNumero(jog1s)] = null;
                    }
                }
                if (stringNumero2(jog1s) != -1) {
                    if (jog1 != x || !jog1s.equals(y)) {
                        tipoCorTabuleiroFantasma[jog1][stringNumero2(jog1s)] = null;
                    }
                }
                //remove a peça no tabuleiro visivel
                if (stringNumero(jog1s) != 0) {
                    if (jog1 != x || !jog1s.equals(y)) {
                        board[jog1][stringNumero(jog1s)].removePiece();
                    }
                }
                if (stringNumero2(jog1s) != -1) {
                    if (jog1 != x || !jog1s.equals(y)) {
                        boardpecas[jog1][stringNumero2(jog1s)].removePiece();
                    }
                }

                 if (stringNumero(jog1s) != 0) board[jog1][stringNumero(jog1s)].setBorder(null);
                 //if (stringNumero(jog1s) != 0) board[x][stringNumero(y)].setBorder(null);

            }
            jog1 = -1;
            jog1s = null;

        }

    }

    private void BotaoEnviarMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviarMsgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoEnviarMsgActionPerformed

    private void TextMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextMensagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextMensagemActionPerformed

    private void TextPortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPortoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextPortoActionPerformed

    private void BotaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoEntrarActionPerformed

    private void TextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNomeActionPerformed

    private void BotaoOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoOrdenarActionPerformed
        // TODO add your handling code here:
        //parte de ordenar o tabuleiro todo
        colocaPecaTipoCor();
        pecasDefault();
        
        //falta colocar a parte de retirar as peças que tinha dentro do painel das peças
        //estava a trabalhar aqui
        
    }//GEN-LAST:event_BotaoOrdenarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new InterfaceCliente().setVisible(true);
                InterfaceCliente interf = new InterfaceCliente();
                interf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEntrar;
    private javax.swing.JButton BotaoEnviarMsg;
    private javax.swing.JButton BotaoObservador;
    private javax.swing.JButton BotaoOrdenar;
    private javax.swing.JButton BotaoSair;
    private javax.swing.JButton BotaoSentar1;
    private javax.swing.JButton BotaoSentar2;
    private javax.swing.JLabel LabelJogador1;
    private javax.swing.JLabel LabelJogador2;
    private javax.swing.JPanel PanelPecas;
    private javax.swing.JPanel PanelTabuleiro;
    private javax.swing.JTextArea TextChat;
    private javax.swing.JTextField TextIp;
    private javax.swing.JTextField TextMensagem;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextArea TextObservador;
    private javax.swing.JTextField TextPorto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
