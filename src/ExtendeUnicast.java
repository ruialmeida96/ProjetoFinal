
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
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
public class ExtendeUnicast extends UnicastRemoteObject implements InterfaceJogadores{
 
    Jogador jogador;
    ExtendeUnicast(Jogador aJogador) throws RemoteException{
        super();
        jogador=aJogador;
    }

    public void alteraTabuleiroAposJogo(String [][] tipoCor,String [][] tipoCorTabuleiroFantasma,InterfaceXadrez objRemoto,ArrayList<Mensagem> mensagem) throws RemoteException {
                tipoCor=objRemoto.devolveArrayPrincipal();
                tipoCorTabuleiroFantasma=objRemoto.devolveArrayFora();
                jogador.pecasDefault(tipoCor, tipoCorTabuleiroFantasma,mensagem,null);
    }

    public void atualizaTabelaObservadores(ArrayList<JogadorCaracteristicas> jogadores) throws RemoteException {
                jogador.pecasDefault(null, null,null,jogadores);
    }
    public void mensagensAltera(Mensagem mensagem){
        jogador.atualizaMensagens(mensagem);
    }

    public void utilizadoresAltera(JogadorCaracteristicas aJogador,int tipoAntigo) throws RemoteException {
        jogador.utilizadorAltera(aJogador,tipoAntigo);
    }

   
    
    
 
   
}
