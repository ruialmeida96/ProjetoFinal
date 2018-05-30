
import java.lang.reflect.Array;
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
    
   public Array[]  ordenaTabuleiro() throws RemoteException;
   public Array[] jogada(int x,String y) throws RemoteException;
    
}
