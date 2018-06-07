
import java.rmi.Remote;
import java.rmi.RemoteException;

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
   public boolean jogada(int x,String y,int x2,String y2,String tipoCorPeca) throws RemoteException;
   public String verificaCasa(int x,String y)throws RemoteException;
   public boolean Jogador (JogadorCaracteristicas referencia) throws RemoteException;
   public String[][] devolveArrayPrincipal ()throws RemoteException;
   public String[][] devolveArrayFora ()throws RemoteException;
   public boolean verificaTipoJogador() throws RemoteException;
   public boolean verificaNome(String aNome)throws RemoteException;


}
