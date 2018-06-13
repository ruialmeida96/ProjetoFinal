
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.NotBoundException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Jogador extends javax.swing.JFrame {

    private String url = "127.0.0.1";
    private Registry reg = null;
    private ImageIcon imgSair;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private SquarePanel[][] board = new SquarePanel[9][9];
    private SquarePanel[][] boardpecas = new SquarePanel[8][4];
    private String[][] tipoCor;
    private String[][] tipoCorTabuleiroFantasma;
    private String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private String[] letras2 = {"i", "j", "k", "l"};
    private InterfaceXadrez objRemoto = null;
    private int jog1 = -1;
    private JogadorCaracteristicas eu = null;
    private ExtendeUnicast client = null;
    private String jog1s = null, pecaJog1 = null;
    private ArrayList<Mensagem> mensagens = null;

    public Jogador() {
        initComponents();
        botoesinicio();
        PanelTabuleiro.setLayout(new GridLayout(8, 8));
        PanelPecas.setLayout(new GridLayout(8, 4));

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

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
        BotaoFora = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("IP");

        TextIp.setText("127.0.0.1");
        TextIp.setName("TextIp"); // NOI18N

        jLabel2.setText("Porto");

        TextPorto.setText("2000");
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
        BotaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSairActionPerformed(evt);
            }
        });

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
        BotaoSentar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSentar2ActionPerformed(evt);
            }
        });

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
        BotaoObservador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoObservadorActionPerformed(evt);
            }
        });

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

        BotaoFora.setText("Colocar peças fora");
        BotaoFora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoForaActionPerformed(evt);
            }
        });

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
                                .addComponent(BotaoSentar1))
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
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotaoFora)
                            .addComponent(BotaoOrdenar))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelJogador2)
                                    .addComponent(BotaoSentar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoOrdenar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BotaoFora)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoObservador)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//ativa e inativa botoes quando jogador antes de conectar ao jogo

    private void botoesinicio() {
        BotaoSair.setEnabled(false);
        BotaoSentar1.setEnabled(false);
        BotaoEnviarMsg.setEnabled(false);
        BotaoObservador.setEnabled(false);
        BotaoOrdenar.setEnabled(false);
        PanelTabuleiro.setEnabled(false);
        BotaoSentar2.setEnabled(false);
        BotaoFora.setEnabled(false);
        LabelJogador1.setText("");
        LabelJogador2.setText("");
        PanelTabuleiro.setEnabled(false);
        PanelPecas.setEnabled(false);
    }

    //ativa e inativa botoes quando observador conecta ao jogo
    private void botoesObservador() {
        BotaoEntrar.setEnabled(false);
        BotaoEnviarMsg.setEnabled(false);
        BotaoObservador.setEnabled(false);
        BotaoOrdenar.setEnabled(false);
        PanelTabuleiro.setEnabled(false);
        BotaoFora.setEnabled(false);
        PanelTabuleiro.setEnabled(false);
        PanelPecas.setEnabled(false);
        BotaoSair.setEnabled(true);
    }
    //ativa e inativa botoes quando jogador/observador desconecta ao jogo

    private void botoesSair() {
        TextMensagem.setText("");
        TextChat.setText("");
        TextObservador.setText("");
        BotaoSair.setEnabled(false);
        BotaoEntrar.setEnabled(true);
    }

    //ativa e inativa botoes quando jogador conecta ao jogo
    private void botoesJogadores() {
        BotaoEntrar.setEnabled(false);
        BotaoObservador.setEnabled(true);
        BotaoOrdenar.setEnabled(true);
        BotaoEnviarMsg.setEnabled(true);
        BotaoFora.setEnabled(true);
        PanelTabuleiro.setEnabled(true);
        PanelPecas.setEnabled(true);
        BotaoSair.setEnabled(true);
    }
    
    private void textFieldsON(){
        TextIp.setEditable(true);
        TextPorto.setEditable(true);
        TextNome.setEditable(true);
    }
    
    private void textFieldsOFF(){
        TextIp.setEditable(false);
        TextPorto.setEditable(false);
        TextNome.setEditable(false);;
    }

    //metodo que atualiza o chat, adicionando a nova mensagem
    public void atualizaMensagens(Mensagem aMensagens) {//atualiza adicionando uma mensagem
        TextChat.setText(TextChat.getText() + "" + aMensagens.getHora() + " " + aMensagens.getNome() + ": " + aMensagens.getMensagem() + "\n");
    }

    //se utilizador sair/entrar ou mudar para cadeira ou passar para observador, este metodo faz essa alteracao na interface
    public void utilizadorAltera(JogadorCaracteristicas jogador, int tipoAntigo) {
        //se for jogador
        if (jogador.isTipoJogador() == 1) {
            //passa para primeira cadeira e botao sentar fica inativo
            LabelJogador1.setText(jogador.getNome());
            BotaoSentar1.setEnabled(false);
            //se o que se sentou estava sentado na cadeira 2, mete ativa cadeira 2
            if (tipoAntigo == 2) {
                LabelJogador2.setText("");
                BotaoSentar2.setEnabled(true);
                //se jogador que se sentou na cadeira 2 era observador, elimina o seu nome da tabela de observadores
            } else if (tipoAntigo == -1) {
                TextObservador.setText(TextObservador.getText().replaceAll(jogador.getNome(), ""));//nao funciona!!
            }
            //se jogador se sentou na cadeira 2, desabilita o botao para sentar nessa cadeira e muda nome
        } else if (jogador.isTipoJogador() == 2) {
            LabelJogador2.setText(jogador.getNome());
            BotaoSentar2.setEnabled(false);
            //se o que se sentou estava sentado na cadeira 1, mete ativa cadeira 1
            if (tipoAntigo == 1) {
                LabelJogador1.setText("");
                BotaoSentar1.setEnabled(true);
                //se jogador que se sentou na cadeira 2 era observador, elimina o seu nome da tabela de observadores
            } else if (tipoAntigo == -1) {
                TextObservador.setText(TextObservador.getText().replaceAll(jogador.getNome(), ""));//nao funciona!!
            }
            //se jogador passou para observador adiciona o á tabela de observadores
        } else if (jogador.isTipoJogador() == -1) {
            TextObservador.setText(TextObservador.getText() + jogador.getNome() + "\n");
            //se o que se sentou estava sentado na cadeira 2, mete ativa cadeira 2
            if (tipoAntigo == 2) {
                LabelJogador2.setText("");
                BotaoSentar2.setEnabled(true);
                //se o que se sentou estava sentado na cadeira 1, mete ativa cadeira 1
            } else if (tipoAntigo == 1) {
                LabelJogador1.setText("");
                BotaoSentar1.setEnabled(true);
            }
            //se o saiu do jogo
        } else if (jogador.isTipoJogador() == 0) {
            //se ele estava sentado na cadeira 2, mete habilitado o botao para sentar
            if (tipoAntigo == 2) {
                LabelJogador2.setText("");
                BotaoSentar2.setEnabled(true);
                //se ele estava sentado na cadeira 1, mete habilitado o botao para sentar
            } else if (tipoAntigo == 1) {
                LabelJogador1.setText("");
                BotaoSentar1.setEnabled(true);
                //se ele estava como observador, retira-o da tabela de observadores
            } else {
                TextObservador.setText(TextObservador.getText().replaceAll(jogador.getNome(), ""));//nao funciona!!
            }
        }
    }

    //metodo que constroi a interface de raiz, tabuleiros,mensagens, jogadores
    public void pecasDefault(String[][] aTipocor, String[][] aTipoCorFantasma, ArrayList<Mensagem> aMensagens, ArrayList<JogadorCaracteristicas> jogadores) {
        //se for para montar tabuleiro principal
        if (aTipocor != null) {
            for (int i = 8; i >= 1; i--) {
                for (int j = 1; j < 9; j++) {
                    board[i][j].removePiece();//remove imagem que la podia ter
                    if (aTipocor[i][j] != null) {//adiciona peça se no array devolvido pelo servidor tiver peça nessa possição
                        String var = aTipocor[i][j];
                        board[i][j].setPiece(Character.getNumericValue(var.charAt(1)), Character.getNumericValue(var.charAt(0)));
                    }
                }
            }
        }
        //se for para montar tabuleiro fora
        if (aTipoCorFantasma != null) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    boardpecas[i][j].removePiece();//remove imagem que la podia ter
                    if (aTipoCorFantasma[i][j] != null) {//adiciona peça se no array devolvido pelo servidor tiver peça nessa possição 
                        String var = aTipoCorFantasma[i][j];
                        boardpecas[i][j].setPiece(Character.getNumericValue(var.charAt(1)), Character.getNumericValue(var.charAt(0)));
                    }
                }
            }
        }
        //se for para montar mensagens
        if (aMensagens != null) {
            TextChat.setText("");
            //mostra mensagens apartir do index que lhe foi atribuido quando entrou no sistema
            for (int i = eu.getIndex(); i < aMensagens.size(); i++) {
                TextChat.setText(TextChat.getText() + "" + aMensagens.get(i).getHora() + " " + aMensagens.get(i).getNome() + ": " + aMensagens.get(i).getMensagem() + "\n");
            }
        }
        //se for para montar jogadore/observadores
        if (jogadores != null) {
            TextObservador.setText("");
            LabelJogador1.setText("");
            BotaoSentar1.setEnabled(true);
            LabelJogador2.setText("");
            BotaoSentar2.setEnabled(true);
            for (int i = 0; i < jogadores.size(); i++) {
                //se for observador adiciona na tabela
                if (jogadores.get(i).isTipoJogador() == -1) {
                    TextObservador.setText(TextObservador.getText() + jogadores.get(i).getNome() + "\n");
                }
                //se for jogador, senta-o na cadeira 1
                if (jogadores.get(i).isTipoJogador() == 1) {
                    LabelJogador1.setText(jogadores.get(i).getNome());
                    BotaoSentar1.setEnabled(false);
                }
                //se for jogador senta-o na cadeira 2
                if (jogadores.get(i).isTipoJogador() == 2) {
                    LabelJogador2.setText(jogadores.get(i).getNome());
                    BotaoSentar2.setEnabled(false);
                }

            }
        }
    }

    //valida se ip é valido
    
    private static boolean validation(String ip) {
        Pattern p = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher m = p.matcher(ip);
        return m.find();
    }
    /*private static boolean validation(String ip) {
        //verificar se a string é valida ou não
        if (ip == null || ip.isEmpty()) {
            return false;
            //se a string for valida, entra dentro deste else
        } else {
            //verificar que o ip é localhost, se pretendermos adicionar esse ip como localhost
            if (ip.equalsIgnoreCase("localhost") == true || ip.equalsIgnoreCase("127.0.0.1")) {
                return true;
            }
            //verificar se a string tem 3 pontos, pontos que separam as diferentes divisoes do ip address
            String[] parts = ip.split("\\.");
            if (parts.length != 4) {
                //System.out.println("IP não contem 4 partes que o definem entre os pontos\n");
                return false;
            }

            //verificar se as varias divisões do ip address, se os numeros se encontram entre 0 e 255
            int x = 1;
            for (String s : parts) {
                if (x == 1) {
                    int i = Integer.parseInt(s);
                    if ((i < 224) || (i > 239)) {
                        //System.out.println("Valores não dentro dos parametros (entre 224 e 239)\n");
                        return false;
                    }
                } else {
                    int e = Integer.parseInt(s);
                    if ((e < 0) || (e > 255)) {
                        // System.out.println("Valores não dentro dos parametros (entre 0 e 255)\n");
                        return false;
                    }
                }
                x++;
            }

            //System.out.println("IP valido\n");
            return true;
        }
    }*/
    
    //retorna o numero que corresponde a cada letra (tabuleiro principar)
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

    //devolve numero que corresponde a cada letra(tabuleiro secundario)
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

    //coloca em array o tipo e cor da peça
    public int[] tipoCorF(String peca) {
        int[] tipocor = new int[2];
        tipocor[0] = Integer.parseInt("" + peca.charAt(1));
        tipocor[1] = Integer.parseInt("" + peca.charAt(0));
        return tipocor;
    }


    private void BotaoSentar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSentar1ActionPerformed
        try {
            JogadorCaracteristicas novoeu = null;
            novoeu = objRemoto.sentar(eu, 0);
            if (novoeu.isTipoJogador() != eu.isTipoJogador()) {
                botoesJogadores();
                eu = novoeu;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoSentar1ActionPerformed

    public void selected(int x, String y) throws RemoteException {

        if (jog1 == -1) {
            if (stringNumero(y) != 0) {//se for do tabuleiro principal
                pecaJog1 = objRemoto.verificaCasa(x, y);
                if (pecaJog1 != null) {
                    jog1 = x;
                    jog1s = y;
                }
            } else {//se for tabuleiro de fora
                pecaJog1 = objRemoto.verificaCasa(x, y);
                if (pecaJog1 != null) {
                    jog1 = x;
                    jog1s = y;
                }
            }
        } else {
            objRemoto.jogada(jog1, jog1s, x, y, pecaJog1, eu.getNome());

            jog1 = -1;
            jog1s = null;

        }

    }

    private void BotaoEnviarMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEnviarMsgActionPerformed
        try {
            objRemoto.adicionaMensagem(new Mensagem(sdf.format(Calendar.getInstance().getTime()), eu.getNome(), TextMensagem.getText()));
            TextMensagem.setText("");
        } catch (RemoteException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoEnviarMsgActionPerformed

    private void TextMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextMensagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextMensagemActionPerformed

    private void TextPortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextPortoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextPortoActionPerformed

    private void BotaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntrarActionPerformed
        int porto = 0;
        String url = null, nome = null;
        try {
            // formato URL de RMI: "//host:port/name"

            //mostrar os nomes ativos  
            porto = Integer.parseInt(TextPorto.getText());
            url = TextIp.getText();
            nome = TextNome.getText();

            if (validation(url)) {
                if (porto > 0 && porto < 4001) {
                    if (!TextNome.getText().equals("")) {
                        //if (validation(url) && porto > 0 && porto < 4001 && !TextNome.getText().equals("")) {
                        //cria o rmiregistry e retorna referencia para o registry no host e porto especificado
                        reg = LocateRegistry.getRegistry(url, porto);
                        //Jogador client = new Jogador( );
                        //InterfaceJogadores rem =(InterfaceJogadores) UnicastRemoteObject.exportObject(client,1099);
                        client = new ExtendeUnicast(this);
                        reg.rebind("jogador1", client);//indentificador do cliente remoto
                        //procura os objetos remotos registados, ao qual nos podemos ligar
                        objRemoto = (InterfaceXadrez) reg.lookup("jogador");           //pedir opcao

                        eu = new JogadorCaracteristicas(nome, 0, client, objRemoto, 0);
                        eu = objRemoto.Jogador(eu);
                        if (eu.getIndex() != -1) {
                            tipoCor = objRemoto.devolveArrayPrincipal();
                            tipoCorTabuleiroFantasma = objRemoto.devolveArrayFora();
                            mensagens = objRemoto.enviaMensagens();
                            pecasDefault(tipoCor, tipoCorTabuleiroFantasma, mensagens, null);
                            if (eu.isTipoJogador() != -1) {
                                botoesJogadores();
                                textFieldsOFF();
                            } else {
                                botoesObservador();
                                textFieldsOFF();
                            }
                            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                            this.addWindowListener(new WindowAdapter() {

                                public void windowClosing(WindowEvent event) {
                                    try {
                                        objRemoto.desconectar(eu.getNome());
                                        System.exit(0);
                                    } catch (RemoteException ex) {
                                        Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });
                        }
                        System.out.println("avisa utilizador que nome já está ocupado");
                        //avisa utilizador que nome já está ocupado
                    }else{
                        JOptionPane.showMessageDialog(null, "Introduza um nome válido", "" + "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Introduza um Porto entre 1 e 4000", "" + "Aviso", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Introduza um IP correto", "" + "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            //Mensagem de aviso-introduz os dados!!
            JOptionPane.showMessageDialog(null, "Introduza os dados necessarios para efetuar conexão", "" + "Aviso", JOptionPane.INFORMATION_MESSAGE);
            System.out.println(e);
        }


    }//GEN-LAST:event_BotaoEntrarActionPerformed

    private void TextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNomeActionPerformed

    private void BotaoOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoOrdenarActionPerformed
        try {
            //parte de ordenar o tabuleiro todo
            objRemoto.ordenaTabuleiro();

        } catch (RemoteException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoOrdenarActionPerformed


    private void BotaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSairActionPerformed
        try {
            objRemoto.desconectar(eu.getNome());
            botoesinicio();
            botoesSair();
            textFieldsON();
        } catch (RemoteException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }

     }//GEN-LAST:event_BotaoSairActionPerformed

    private void BotaoSentar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSentar2ActionPerformed
        try {
            JogadorCaracteristicas novoeu = null;
            novoeu = objRemoto.sentar(eu, 1);
            if (novoeu.isTipoJogador() != eu.isTipoJogador()) {
                botoesJogadores();
                eu = novoeu;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoSentar2ActionPerformed

    private void BotaoObservadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoObservadorActionPerformed
        try {
            JogadorCaracteristicas novoeu = null;
            novoeu = objRemoto.observar(eu);
            if (novoeu.isTipoJogador() != eu.isTipoJogador()) {
                botoesObservador();
                eu = novoeu;
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoObservadorActionPerformed

    private void BotaoForaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoForaActionPerformed
        try {
            objRemoto.pecasForaTabuleiro();
        } catch (RemoteException ex) {
            Logger.getLogger(Jogador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_BotaoForaActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Jogador().setVisible(true);
                Jogador interf = new Jogador();
                interf.setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEntrar;
    private javax.swing.JButton BotaoEnviarMsg;
    private javax.swing.JButton BotaoFora;
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
