
import java.io.Serializable;
import java.rmi.RemoteException;

public class JogadorCaracteristicas implements Serializable {

    private String nome;
    private int index;
    private InterfaceJogadores referencia;
    private InterfaceXadrez objRemoto;
    private int tipoJogador;

    public JogadorCaracteristicas(String aNome, int aIndex, InterfaceJogadores aReferencia, InterfaceXadrez aObjRemoto, int aTipoJogador) {
        nome = aNome;
        index = aIndex;
        referencia = aReferencia;
        objRemoto = aObjRemoto;
        tipoJogador = aTipoJogador;
    }

    public String getNome() {
        return nome;
    }

    public int getIndex() {
        return index;
    }

    public InterfaceJogadores getReferencia() {
        return referencia;
    }

    public InterfaceXadrez getObjRemoto() {
        return objRemoto;
    }

    public int isTipoJogador() {
        return tipoJogador;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTipoJogador(int tipoJogador) {
        this.tipoJogador = tipoJogador;
    }

}
