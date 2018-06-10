
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
    
   public boolean ordenaTabuleiro() throws RemoteException;
   public boolean pecasForaTabuleiro() throws RemoteException;
   public boolean jogada(int x,String y,int x2,String y2,String tipoCorPeca,String nome) throws RemoteException;
   public String verificaCasa(int x,String y)throws RemoteException;
   public JogadorCaracteristicas Jogador (JogadorCaracteristicas jogador) throws RemoteException;
   public String[][] devolveArrayPrincipal ()throws RemoteException;
   public String[][] devolveArrayFora ()throws RemoteException;
   public ArrayList<Mensagem> enviaMensagens() throws RemoteException;
   public int verificaTipoJogador() throws RemoteException;
   public void desconectar(String nome)throws RemoteException;
   public JogadorCaracteristicas sentar(JogadorCaracteristicas jogador,int cadeira)throws RemoteException;
   public JogadorCaracteristicas observar(JogadorCaracteristicas jogador)throws RemoteException;
   public boolean adicionaMensagem(Mensagem mensagem)throws RemoteException;

}
