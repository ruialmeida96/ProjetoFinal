
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jessica
 */
public class Servidor extends UnicastRemoteObject implements InterfaceXadrez {

    private ImageIcon imgSair;
    private static String[][] tipoCor = new String[9][9];
    private static String[][] tipoCorTabuleiroFantasma = new String[8][4];
    private String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private String[] letras2 = {"i", "j", "k", "l"};

    Servidor() throws RemoteException {
        super();
    }

    public boolean ordenaTabuleiro() throws RemoteException {
        ordena();
        //avisar todos os jogadores/observadores/CALLBACKS
        return true;
    }

    //função retorna tipo e cor da peça na possição x e y, se não tiver peça nessa possição retorna null 
    public String verificaCasa(int x, String y) throws RemoteException {
        if (stringNumero(y) != 0) {
            if (tipoCor[x][stringNumero(y)] != null) {
                return tipoCor[x][stringNumero(y)];
            }
        }
        if (stringNumero2(y) != 0) {
            if (tipoCorTabuleiroFantasma[x][stringNumero2(y)] != null) {
                return tipoCorTabuleiroFantasma[x][stringNumero2(y)];
            }
        }
        return null;
    }

    public boolean jogada(int x, String y, int x2, String y2, String tipoCorPeca) throws RemoteException {
        int valor = 0;
        //verifica se segunda casa tem peça
        if (stringNumero(y2) != 0) {//se segunda jogada for do tabuleiro principal entra           
            if (stringNumero(y) != 0) {//se a primeira jogada for do tabuleiro principal
                if (tipoCor[x][stringNumero(y)].equals(tipoCorPeca)) {//se a peça escolhida inicialmente ainda for a mesma, vai alterar
                    if (tipoCor[x2][stringNumero(y2)] != null) {//se na jogada 2 tiver peça, entra
                        //pega na segunda peça e enfia no tabuleiro de fora
                        for (int i = 0; i < 8; i++) {
                            for (int j = 0; j < 4; j++) {
                                if (tipoCorTabuleiroFantasma[i][j] == null && valor == 0) {
                                    tipoCorTabuleiroFantasma[i][j] = tipoCor[x2][stringNumero(y2)];
                                    valor = 1;
                                }
                            }
                        }
                        //mete na jogada 2 a peca da jogada 1 e remove a peca da jogada 1
                        tipoCor[x2][stringNumero(y2)] = tipoCor[x][stringNumero(y)];
                        tipoCor[x][stringNumero(y)] = null;
                        //avisar todos os jogadores/observadores/CALLBACKS
                        return true;

                    } else {//se na jogada 2 não tiver peça
                        //mete na jogada 2 a peca da jogada 1 e remove a peca da jogada 1
                        tipoCor[x2][stringNumero(y2)] = tipoCor[x][stringNumero(y)];
                        tipoCor[x][stringNumero(y)] = null;
                        //avisar todos os jogadores/observadores/CALLBACKS
                        return true;
                    }
                }
            } else if (stringNumero2(y) != 0) {//se a primeira jogada for do tabuleiro fora
                if (tipoCorTabuleiroFantasma[x][stringNumero2(y)].equals(tipoCorPeca)) {//se a peça escolhida inicialmente ainda for a mesma, vai alterar
                    //verificar se a segunda jogada é do tabuleiro principal
                    if (stringNumero(y2) != 0) {
                        //verificar se tem peca na segunda jogada
                        if (tipoCor[x2][stringNumero(y2)] != null) {
                            //pega na segunda peça e enfia no tabuleiro de fora
                            for (int i = 0; i < 8; i++) {
                                for (int j = 0; j < 4; j++) {
                                    if (tipoCorTabuleiroFantasma[i][j] == null && valor == 0) {
                                        tipoCorTabuleiroFantasma[i][j] = tipoCor[x2][stringNumero(y2)];
                                        valor = 1;
                                    }
                                }
                            }
                            tipoCor[x2][stringNumero(y2)] = tipoCorTabuleiroFantasma[x][stringNumero2(y)];
                            tipoCorTabuleiroFantasma[x][stringNumero2(y)] = null;
                            //avisar todos os jogadores/observadores/CALLBACKS

                            return true;
                        } else {
                            tipoCor[x2][stringNumero(y2)] = tipoCorTabuleiroFantasma[x][stringNumero2(y)];
                            tipoCorTabuleiroFantasma[x][stringNumero2(y)] = null;
                            //avisar todos os jogadores/observadores/CALLBACKS
                            return true;
                        }
                    }//se não for não faz nada
                }//se não xistir la aquela peça no tabuleiro de fora não faz nada
            }
        }
        return false;
    }

    public int stringNumero(String letra) {
        if (letra.equals("a")) {
            return 1;
        }
        if (letra.equals("b")) {
            return 2;
        }
        if (letra.equals("c")) {
            return 3;
        }
        if (letra.equals("d")) {
            return 4;
        }
        if (letra.equals("e")) {
            return 5;
        }
        if (letra.equals("f")) {
            return 6;
        }
        if (letra.equals("g")) {
            return 7;
        }
        if (letra.equals("h")) {
            return 8;
        }

        return 0;
    }

    public int stringNumero2(String letra) {
        if (letra.equals("i")) {
            return 0;
        }
        if (letra.equals("j")) {
            return 1;
        }
        if (letra.equals("k")) {
            return 2;
        }
        if (letra.equals("l")) {
            return 3;
        }

        return -1;
    }

    public int[] tipoCorF(String peca) {
        int[] tipocor = new int[2];
        tipocor[0] = Integer.parseInt("" + peca.charAt(1));
        tipocor[1] = Integer.parseInt("" + peca.charAt(0));
        return tipocor;
    }

    public void colocaPecaTabuleiroFantasma(String peca) {
        int[] cortipo = tipoCorF(peca);
        int valor = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (tipoCorTabuleiroFantasma[i][j] == null && valor == 0) {
                    tipoCorTabuleiroFantasma[i][j] = peca;
                }
            }
        }
    }

    private static void ordena() {
        for (int i = 8; i >= 1; i--) {
            for (int j = 1; j < 9; j++) {
                tipoCor[i][j] = null;
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                tipoCorTabuleiroFantasma[i][j] = null;
            }
        }
        //linha primeira de baixo, peças brancas
        tipoCor[8][1] = "31";
        tipoCor[8][2] = "11";
        tipoCor[8][3] = "21";
        tipoCor[8][4] = "41";
        tipoCor[8][5] = "51";
        tipoCor[8][6] = "21";
        tipoCor[8][7] = "11";
        tipoCor[8][8] = "31";

        //segunda linha de baixo, peças brancas
        tipoCor[7][1] = "01";
        tipoCor[7][2] = "01";
        tipoCor[7][3] = "01";
        tipoCor[7][4] = "01";
        tipoCor[7][5] = "01";
        tipoCor[7][6] = "01";
        tipoCor[7][7] = "01";
        tipoCor[7][8] = "01";

        //primeira linha de cima, peças pretas
        tipoCor[1][1] = "30";
        tipoCor[1][2] = "10";
        tipoCor[1][3] = "20";
        tipoCor[1][4] = "40";
        tipoCor[1][5] = "50";
        tipoCor[1][6] = "20";
        tipoCor[1][7] = "10";
        tipoCor[1][8] = "30";

        //segunda linha cima, peças pretas
        tipoCor[2][1] = "00";
        tipoCor[2][2] = "00";
        tipoCor[2][3] = "00";
        tipoCor[2][4] = "00";
        tipoCor[2][5] = "00";
        tipoCor[2][6] = "00";
        tipoCor[2][7] = "00";
        tipoCor[2][8] = "00";
    }

    public static void main(String args[]) {

        ordena();
        try {
            // formato de URL para RMI: "//host:port/name"
            // por omissao assume localhost e porto 1099
            // igual a Naming.rebind("//localhost:1099/meuContador", serv);

            Registry reg = LocateRegistry.createRegistry(1099);
            Servidor serv = new Servidor();
            //referência é registada para depois poder ser procurada.
            reg.rebind("contador", serv);

            System.out.println("servidor RMI iniciado");
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    public void referenciaCliente(InterfaceCliente referencia) {
        //adicionar jogador a um array
    }

}
