
import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jessica
 */
public interface InterfaceXadrez extends Remote{
    //metodo que jogador invoca para pedir ao servidor que oredene peças do tabuleiro
   public boolean ordenaTabuleiro() throws RemoteException;
   //metodo que jogador invoca para pedir ao servidor que coloque peças fora do tabuleiro
   public boolean pecasForaTabuleiro() throws RemoteException;
   //metodo que jogador invoca para avisar servidor que fez uma jogada
   public boolean jogada(int x,String y,int x2,String y2,String tipoCorPeca,String nome) throws RemoteException;
   //metodo que jogador invoca para saber se naquelas coordenadas tem uma peça
   public String verificaCasa(int x,String y)throws RemoteException;
   //metodo que jogador invoca para entrar no jogo
   public JogadorCaracteristicas Jogador (JogadorCaracteristicas jogador) throws RemoteException;
   //metodo que jogador invoca para saber como esta o tabuleiro principal(usado apenas quando entra pela primeira vez no sistema)
   public String[][] devolveArrayPrincipal ()throws RemoteException;
   //metodo que jogador invoca para saber cmo esta tabuleiro de fora (usado apenas quando entra pela primeira vez no sistema)
   public String[][] devolveArrayFora ()throws RemoteException;
   //metodo que jogador invoca para saber as mensagens trocadas pelos users (usado apenas quando entra pela primeira vez no sistema)
   public ArrayList<Mensagem> enviaMensagens() throws RemoteException;
   //metodo que jogador invoca para saber se será observador ou jogador (usado apenas quando entra pela primeira vez no sistema)
   public int verificaTipoJogador() throws RemoteException;
   //metodo que jogador invoca para notificar o servidor que vai sair
   public void desconectar(String nome)throws RemoteException;
   //metodo que jogador invoca para pedir ao servidor que o sente na cadeira que ele pediu
   public JogadorCaracteristicas sentar(JogadorCaracteristicas jogador,int cadeira)throws RemoteException;
   //metodo que jogador invoca para pedir ao servidor que o coloque como observador
   public JogadorCaracteristicas observar(JogadorCaracteristicas jogador)throws RemoteException;
   //metodo que jogador invoca para enviar mensagem para o chat
   public boolean adicionaMensagem(Mensagem mensagem)throws RemoteException;

}
