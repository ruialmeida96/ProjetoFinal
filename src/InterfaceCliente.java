
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.lang.reflect.Array;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class InterfaceCliente extends javax.swing.JFrame {

    private ImageIcon imgSair;
    private SquarePanel[][] board = new SquarePanel[9][9];

    public InterfaceCliente() {
        initComponents();
        PanelTabuleiro.setLayout(new GridLayout(8,8));
        PanelPecas.setLayout(new GridLayout(4,8));
        String[] letras = {"a","b","c","d","e","f","g","h"};
        
        SquarePanel.loadPieceImages();
        
        for (int i = 8; i >= 1; i--){
        	for (int j = 1; j < 9; j++){
                SquarePanel sqPanel = new SquarePanel(i,letras[j-1],this);
                sqPanel.setBackColor((i + j) % 2);
                //String l = letras[j-1];
                board[i][j] = sqPanel;
                PanelTabuleiro.add(sqPanel);
        	}
        }
        
        add(PanelTabuleiro,BorderLayout.CENTER);
        
        //linha primeira de baixo, peças brancas
        board[8][1].setPiece(1,3);
        board[8][2].setPiece(1,1);
        board[8][3].setPiece(1,2);
        board[8][4].setPiece(1,4);
        board[8][5].setPiece(1,5);
        board[8][6].setPiece(1,2);
        board[8][7].setPiece(1,1);
        board[8][8].setPiece(1,3);
                
        //segunda linha de baixo, peças brancas
        board[7][1].setPiece(1,0);
        board[7][2].setPiece(1,0);
        board[7][3].setPiece(1,0);
        board[7][4].setPiece(1,0);
        board[7][5].setPiece(1,0);
        board[7][6].setPiece(1,0);
        board[7][7].setPiece(1,0);
        board[7][8].setPiece(1,0);
        
        
        //primeira linha de cima, peças pretas
        board[1][1].setPiece(0,3);
        board[1][2].setPiece(0,1);
        board[1][3].setPiece(0,2);
        board[1][4].setPiece(0,4);
        board[1][5].setPiece(0,5);
        board[1][6].setPiece(0,2);
        board[1][7].setPiece(0,1);
        board[1][8].setPiece(0,3);
        
        //segunda linha cima, peças pretas
        board[2][1].setPiece(0,0);
        board[2][2].setPiece(0,0);
        board[2][3].setPiece(0,0);
        board[2][4].setPiece(0,0);
        board[2][5].setPiece(0,0);
        board[2][6].setPiece(0,0);
        board[2][7].setPiece(0,0);
        board[2][8].setPiece(0,0);
        
        
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
            .addGap(0, 373, Short.MAX_VALUE)
        );
        PanelTabuleiroLayout.setVerticalGroup(
            PanelTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addGap(0, 104, Short.MAX_VALUE)
        );
        PanelPecasLayout.setVerticalGroup(
            PanelPecasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LabelJogador1)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoSentar1)
                        .addGap(190, 190, 190))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(PanelPecas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(BotaoOrdenar)))
                                .addGap(63, 63, 63)
                                .addComponent(PanelTabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextIp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextPorto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(BotaoEntrar)
                        .addGap(33, 33, 33)
                        .addComponent(BotaoSair)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(85, 85, 85))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TextMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BotaoEnviarMsg))
                                    .addComponent(jScrollPane1))
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(BotaoObservador)
                                        .addGap(33, 33, 33)))
                                .addGap(58, 58, 58))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(LabelJogador2)
                .addGap(18, 18, 18)
                .addComponent(BotaoSentar2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(PanelPecas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(BotaoOrdenar))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotaoObservador)))
                        .addGap(107, 107, 107))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelTabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TextMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotaoEnviarMsg))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelJogador2)
                            .addComponent(BotaoSentar2))
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoSentar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSentar1ActionPerformed
        // TODO add your handling code here:
        imgSair = new ImageIcon("entracadeira.png");
        BotaoSentar1 = new JButton(imgSair);

    }//GEN-LAST:event_BotaoSentar1ActionPerformed

    
    public void selected(int x, String y){
    	System.out.printf("mouse pressed at:"+x+", "+y+"\n");
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
