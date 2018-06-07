
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jessica
 */
public class ExtendeUnicast extends UnicastRemoteObject implements InterfaceJogadores{
 
    Jogador jogador;
    ExtendeUnicast(Jogador aJogador) throws RemoteException{
        super();
        jogador=aJogador;
    }

    public void alteraTabuleiroAposJogo(String [][] tipoCor,String [][] tipoCorTabuleiroFantasma,InterfaceXadrez objRemoto) throws RemoteException {
                tipoCor=objRemoto.devolveArrayPrincipal();
                tipoCorTabuleiroFantasma=objRemoto.devolveArrayFora();
                jogador.pecasDefault(tipoCor, tipoCorTabuleiroFantasma);
    }

 
   
}
