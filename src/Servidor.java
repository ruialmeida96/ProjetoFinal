
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
    private String[][] tipoCor = new String[9][9];
    private String[][] tipoCorTabuleiroFantasma = new String[8][4];
    private String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private String[] letras2 = {"i", "j", "k", "l"};
    
    Servidor() throws RemoteException {
      super();
    }
    
    
    public Array[] ordenaTabuleiro() throws RemoteException {
        colocaPecaTipoCor();
        
        return null;
    }

    public Array[] jogada(int x, String y) throws RemoteException {
        return null;
    }
    
   

     private void colocaPecaTipoCor() {
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
     
       
      try {
         // formato de URL para RMI: "//host:port/name"
         // por omissao assume localhost e porto 1099
         // igual a Naming.rebind("//localhost:1099/meuContador", serv);
         
         Registry reg = LocateRegistry.createRegistry(1099);
        Servidor serv = new Servidor();
        //referência é registada para depois poder ser procurada.
        reg.rebind("contador",serv);

         System.out.println("servidor RMI iniciado");
        
      }
      catch (Exception e) {
         System.out.println(e);
      }
  }

}
