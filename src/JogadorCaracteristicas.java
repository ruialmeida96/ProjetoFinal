
import java.io.Serializable;
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
public class JogadorCaracteristicas implements Serializable
{
    
    private String nome;
    private int index;
    private InterfaceJogadores referencia;
    private InterfaceXadrez objRemoto;
    private boolean tipoJogador;

    public JogadorCaracteristicas(String aNome,int aIndex, InterfaceJogadores aReferencia,InterfaceXadrez aObjRemoto, boolean aTipoJogador ) {
        nome=aNome;
        index=aIndex;
        referencia=aReferencia;
        objRemoto=aObjRemoto;
        tipoJogador=aTipoJogador;
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

    public boolean isTipoJogador() {
        return tipoJogador;
    }

   

    
    
    
    
    
}
