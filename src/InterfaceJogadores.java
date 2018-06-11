
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
//interface implementada pelo jogador para o servidor o poder enviar callback com as mudanças de jogo
public interface InterfaceJogadores extends Remote{
        //metodo que servidor invoca para alterar tabuleiro jogador se uma peça foi jogada, ou se ordenou ou se colocou as peças fora do tabuleiro. Envia as mensagem trocadas pelos jogadores
   public void alteraTabuleiroAposJogo(String [][] tipoCor,String [][] tipoCorTabuleiroFantasma,InterfaceXadrez objRemoto,ArrayList <Mensagem> mensagem)throws RemoteException;
    //metodo que servidor invoca para enviar todo array com jogadores para montar interface no jogador novo (usado apenas quando o jogador entra no jogo)
   public void atualizaTabelaObservadores(ArrayList<JogadorCaracteristicas> jogadores)throws RemoteException;
       //metodo que servidor invova para adicionar a mensagem enviada para o chat 
   public void mensagensAltera(Mensagem mensagem)throws RemoteException;
       //metodo que servidor invoca para enviar ao jogador o utilizador que saiu/entrou/sentou se/passou a observador
   public void utilizadoresAltera(JogadorCaracteristicas jogador,int tipoAntigo)throws RemoteException;

}
