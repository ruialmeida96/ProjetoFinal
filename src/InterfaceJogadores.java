
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
public interface InterfaceJogadores extends Remote{
    
   public void alteraTabuleiroAposJogo(String [][] tipoCor,String [][] tipoCorTabuleiroFantasma,InterfaceXadrez objRemoto)throws RemoteException;
   public void atualizaTabelaObservadores(ArrayList<JogadorCaracteristicas> jogadores)throws RemoteException;
}
