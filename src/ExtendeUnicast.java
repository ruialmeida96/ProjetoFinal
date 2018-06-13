
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JTextArea;


//class cliada para poder extender o UnicastRemote
public class ExtendeUnicast extends UnicastRemoteObject implements InterfaceJogadores {

    Jogador jogador;//guarda objecto jogador para poder fazer atualizaçoes na interface dele

    ExtendeUnicast(Jogador aJogador) throws RemoteException {
        super();
        jogador = aJogador;
    }
    
    //metodo que servidor invoca para alterar tabuleiro jogador se uma peça foi jogada, ou se ordenou ou se colocou as peças fora do tabuleiro. Envia as mensagem trocadas pelos jogadores
    public void alteraTabuleiroAposJogo(String[][] tipoCor, String[][] tipoCorTabuleiroFantasma, InterfaceXadrez objRemoto, ArrayList<Mensagem> mensagem) throws RemoteException {
        tipoCor = objRemoto.devolveArrayPrincipal();//tabuleiro principal
        tipoCorTabuleiroFantasma = objRemoto.devolveArrayFora();//tabuleiro de fora
        jogador.pecasDefault(tipoCor, tipoCorTabuleiroFantasma, mensagem, null);//metodo do jogador que altera as peças
    }

    //metodo que servidor invoca para enviar todo array com jogadores para montar interface no jogador novo (usado apenas quando o jogador entra no jogo)
    public void atualizaTabelaObservadores(ArrayList<JogadorCaracteristicas> jogadores) throws RemoteException {
        jogador.pecasDefault(null, null, null, jogadores);
    }
    
    //metodo que servidor invova para adicionar a mensagem enviada para o chat 
    public void mensagensAltera(Mensagem mensagem) {
        jogador.atualizaMensagens(mensagem);
    }
    
    //metodo que servidor invoca para enviar ao jogador o utilizador que saiu/entrou/sentou se/passou a observador
    public void utilizadoresAltera(JogadorCaracteristicas aJogador, int tipoAntigo) throws RemoteException {
        jogador.utilizadorAltera(aJogador, tipoAntigo);
    }

}
