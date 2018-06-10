
import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Servidor extends UnicastRemoteObject implements InterfaceXadrez{

    private ImageIcon imgSair;
    private static String[][] tipoCor = new String[9][9];
    private static String[][] tipoCorTabuleiroFantasma = new String[8][4];
    private static ArrayList<Mensagem> mensagens=null;
    private String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private String[] letras2 = {"i", "j", "k", "l"};
    private static ArrayList<JogadorCaracteristicas> utilizadores =null;
    private static Scanner sc=new Scanner(System.in);
    private static int numeroJog=1;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    Servidor() throws RemoteException  {
        super();
    }

    public boolean ordenaTabuleiro() throws RemoteException {
        ordena();
        //avisar todos os jogadores/observadores/CALLBACKS
        for (int i = 0; i < utilizadores.size(); i++) {
             if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().alteraTabuleiroAposJogo(tipoCor,tipoCorTabuleiroFantasma, utilizadores.get(i).getObjRemoto(),null);
             }
        return true;
    }
    public JogadorCaracteristicas Jogador(JogadorCaracteristicas jogador) throws RemoteException {
    //adicionar jogador a um array
    int tamanho=0;
    if(!verificaNome(jogador.getNome())){
         if(mensagens!=null)tamanho=mensagens.size();
        if(utilizadores==null)utilizadores=new ArrayList<JogadorCaracteristicas>();
            jogador.setIndex(tamanho);
            jogador.setTipoJogador(verificaTipoJogador());
            utilizadores.add(jogador);
            numeroJog++;
            jogador.getReferencia().atualizaTabelaObservadores(utilizadores);
        for (int i = 0; i < utilizadores.size(); i++) { 
           if(!utilizadores.get(i).getNome().equalsIgnoreCase(jogador.getNome()))utilizadores.get(i).getReferencia().utilizadoresAltera(jogador,0);
        }
    }
        return jogador;
    }
    
    public  JogadorCaracteristicas observar(JogadorCaracteristicas jogador) throws RemoteException{
                int posicaoArray2=0,observa=0,tipoAntigo=jogador.isTipoJogador();
        for (int i = 0; i < utilizadores.size(); i++) {
           if(utilizadores.get(i)!=null){
               if(utilizadores.get(i).getNome().equalsIgnoreCase(jogador.getNome()))posicaoArray2=i;
               if(utilizadores.get(i).isTipoJogador()==1 || utilizadores.get(i).isTipoJogador()==2)observa=-1;
           }
           
        }
        if(observa==-1){
                jogador.setTipoJogador(-1);
                utilizadores.add(jogador);
                utilizadores.remove(posicaoArray2);
                for (int i = 0; i < utilizadores.size(); i++) {
                   if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().utilizadoresAltera(jogador,tipoAntigo);
                }
                return jogador;
        }
        return jogador;

    }
     public ArrayList<Mensagem> enviaMensagens() throws RemoteException {
         return mensagens;
     }

    public boolean adicionaMensagem(Mensagem mensagem) throws RemoteException {
         if(mensagens==null)mensagens=new ArrayList<Mensagem>();
         mensagem.setHora( sdf.format(Calendar.getInstance().getTime()));
         mensagens.add(mensagem);
         for (int i = 0; i < utilizadores.size(); i++) {
             if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().mensagensAltera(mensagem);
             }
         return true;
     }
    public  JogadorCaracteristicas sentar(JogadorCaracteristicas jogador,int cadeira) throws RemoteException{
        int posicaoArray2=0,cadeira1=0,cadeira2=0,tipoAntigo=jogador.isTipoJogador();
        //verifica indice do utilizador no array
        for (int i = 0; i < utilizadores.size(); i++) {
           if(utilizadores.get(i)!=null){
               if(utilizadores.get(i).getNome().equalsIgnoreCase(jogador.getNome()))posicaoArray2=i;
               if(utilizadores.get(i).isTipoJogador()==1)cadeira1=1;
               if(utilizadores.get(i).isTipoJogador()==2)cadeira2=2;
           }
           
        }

        if(cadeira==0){
            if(cadeira1!=1){
               jogador.setTipoJogador(1);
                utilizadores.add(jogador);
                utilizadores.remove(posicaoArray2);
                for (int i = 0; i < utilizadores.size(); i++) {
                   if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().utilizadoresAltera(jogador,tipoAntigo);
                }
            }
        }else if(cadeira==1){
                    if(cadeira2!=2){
                       jogador.setTipoJogador(2);
                        utilizadores.add(jogador);
                        utilizadores.remove(posicaoArray2);
                         for (int i = 0; i < utilizadores.size(); i++) {
                                    if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().utilizadoresAltera(jogador,tipoAntigo);

                         }


                    }
                }
        
        return jogador;

        
    }
    
   public void desconectar(String nome) throws RemoteException {
        int posicaoArray=0,tipoAntigo=0;
        //verifica indice do utilizador no array
        for (int i = 0; i < utilizadores.size(); i++) {
           if(utilizadores.get(i)!=null)if(utilizadores.get(i).getNome().equalsIgnoreCase(nome)){
               posicaoArray=i;
               tipoAntigo=utilizadores.get(i).isTipoJogador();
           }
        }
       
               if(utilizadores.get(posicaoArray).getNome().equalsIgnoreCase(nome)){
                 utilizadores.remove(posicaoArray);

              
               }
          
        for (int i = 0; i < utilizadores.size(); i++) {
           if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().utilizadoresAltera(new JogadorCaracteristicas(nome, 0, null, null, 0),tipoAntigo);
        
        }
    }
    public boolean verificaNome(String aNome) {
    //verifica se o nome já existe
        if(utilizadores!=null){
            for (int i = 0; i < utilizadores.size(); i++) {
                if(utilizadores.get(i)!=null)if(utilizadores.get(i).getNome().equalsIgnoreCase(aNome))return true;
            }
        }
            return false;
    }
    @Override
    public int verificaTipoJogador() {
    //verifica se é jogador ou observador
        if(numeroJog>2)return -1;
        else 
        if(utilizadores==null){
            return 1;
        }else {
        for (int i = 0; i < utilizadores.size(); i++) {
            if(utilizadores.get(i).isTipoJogador()==1)return 2;
            if(utilizadores.get(i).isTipoJogador()==2)return 1;
        }
        }
        return 1;
    }
    public String[][] devolveArrayPrincipal() throws RemoteException {
        //devolve posições das peças do tabuleiro principal
        return tipoCor;
    }

    public String[][] devolveArrayFora() throws RemoteException {
                //devolve posições das peças do tabuleiro de fora
        return tipoCorTabuleiroFantasma;
    }
    //função retorna tipo e cor da peça na possição x e y, se não tiver peça nessa possição retorna null 
    public String verificaCasa(int x, String y) throws RemoteException {
        int passou=0;
        if (stringNumero(y) != 0) {
            passou=1;
            if (tipoCor[x][stringNumero(y)] != null) {
                return tipoCor[x][stringNumero(y)];
            }
        }

        if (stringNumero2(y)!=-1 && passou==0) {

            if (tipoCorTabuleiroFantasma[x][stringNumero2(y)] != null) {

                return tipoCorTabuleiroFantasma[x][stringNumero2(y)];
            }
        }
        return null;
    }

    public boolean jogada(int x, String y, int x2, String y2, String tipoCorPeca,String nome) throws RemoteException {
        int valor = 0;
        boolean pode=false;
        for (int i = 0; i < utilizadores.size(); i++) {
            if(utilizadores.get(i).getNome().equalsIgnoreCase(nome))if(utilizadores.get(i).isTipoJogador()!=-1)pode=true;
        }
        if(pode==true){
        //verifica se segunda casa tem peça
        if (stringNumero(y2) != 0) {//se segunda jogada for do tabuleiro principal entra           
            if (stringNumero(y) != 0) {//se a primeira jogada for do tabuleiro principal
                if(tipoCor[x][stringNumero(y)]!=null){
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
                         for (int i = 0; i < utilizadores.size(); i++) {
                                        if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().alteraTabuleiroAposJogo(tipoCor,tipoCorTabuleiroFantasma, utilizadores.get(i).getObjRemoto(),null);
                            }
                        return true;

                    } else {//se na jogada 2 não tiver peça
                        //mete na jogada 2 a peca da jogada 1 e remove a peca da jogada 1
                        tipoCor[x2][stringNumero(y2)] = tipoCor[x][stringNumero(y)];
                        tipoCor[x][stringNumero(y)] = null;
                        //avisar todos os jogadores/observadores/CALLBACKS
                         for (int i = 0; i < utilizadores.size(); i++) {
                                        if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().alteraTabuleiroAposJogo(tipoCor,tipoCorTabuleiroFantasma, utilizadores.get(i).getObjRemoto(),null);
                            }
                        return true;
                    }
                }
                }
            } else if (stringNumero2(y) != -1) {//se a primeira jogada for do tabuleiro fora
                if(tipoCorTabuleiroFantasma[x][stringNumero2(y)]!=null){
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
                             for (int i = 0; i < utilizadores.size(); i++) {
                                        if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().alteraTabuleiroAposJogo(tipoCor,tipoCorTabuleiroFantasma, utilizadores.get(i).getObjRemoto(),null);
                            }
                            return true;
                        } else {
                            tipoCor[x2][stringNumero(y2)] = tipoCorTabuleiroFantasma[x][stringNumero2(y)];
                            tipoCorTabuleiroFantasma[x][stringNumero2(y)] = null;
                            //avisar todos os jogadores/observadores/CALLBACKS
                            for (int i = 0; i < utilizadores.size(); i++) {
                                        if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().alteraTabuleiroAposJogo(tipoCor,tipoCorTabuleiroFantasma, utilizadores.get(i).getObjRemoto(),null);
                            }
                            return true;
                        }
                    }//se não for não faz nada
                }//se não xistir la aquela peça no tabuleiro de fora não faz nada
                }
            }
        
        }else{//se segunda jogada for do tabuleiro secundario
            //se primeira jogada for do tabuleiro principal
            if(stringNumero(y) != 0){
                tipoCorTabuleiroFantasma[x2][stringNumero2(y2)]=tipoCor[x][stringNumero(y)];
                tipoCor[x][stringNumero(y)]=null;
                 for (int i = 0; i < utilizadores.size(); i++) {
                                        if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().alteraTabuleiroAposJogo(tipoCor,tipoCorTabuleiroFantasma, utilizadores.get(i).getObjRemoto(),null);
                            }
                            return true;
            }
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

    public boolean pecasForaTabuleiro() throws RemoteException {
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
        tipoCorTabuleiroFantasma[0][0] = "31";
        tipoCorTabuleiroFantasma[0][1] = "11";
        tipoCorTabuleiroFantasma[0][2] = "21";
        tipoCorTabuleiroFantasma[0][3] = "41";
        tipoCorTabuleiroFantasma[1][0] = "51";
        tipoCorTabuleiroFantasma[1][1] = "21";
        tipoCorTabuleiroFantasma[1][2] = "11";
        tipoCorTabuleiroFantasma[1][3] = "31";

        //segunda linha de baixo, peças brancas
        tipoCorTabuleiroFantasma[2][0] = "01";
        tipoCorTabuleiroFantasma[2][1] = "01";
        tipoCorTabuleiroFantasma[2][2] = "01";
        tipoCorTabuleiroFantasma[2][3] = "01";
        tipoCorTabuleiroFantasma[3][0] = "01";
        tipoCorTabuleiroFantasma[3][1] = "01";
        tipoCorTabuleiroFantasma[3][2] = "01";
        tipoCorTabuleiroFantasma[3][3] = "01";

        //primeira linha de cima, peças pretas
        tipoCorTabuleiroFantasma[4][0] = "30";
        tipoCorTabuleiroFantasma[4][1] = "10";
        tipoCorTabuleiroFantasma[4][2] = "20";
        tipoCorTabuleiroFantasma[4][3] = "40";
        tipoCorTabuleiroFantasma[5][0] = "50";
        tipoCorTabuleiroFantasma[5][1] = "20";
        tipoCorTabuleiroFantasma[5][2] = "10";
        tipoCorTabuleiroFantasma[5][3] = "30";

        //segunda linha cima, peças pretas
        tipoCorTabuleiroFantasma[6][0] = "00";
        tipoCorTabuleiroFantasma[6][1] = "00";
        tipoCorTabuleiroFantasma[6][2] = "00";
        tipoCorTabuleiroFantasma[6][3] = "00";
        tipoCorTabuleiroFantasma[7][0] = "00";
        tipoCorTabuleiroFantasma[7][1] = "00";
        tipoCorTabuleiroFantasma[7][2] = "00";
        tipoCorTabuleiroFantasma[7][3] = "00";
        
         for (int i = 0; i < utilizadores.size(); i++) {
                                        if(utilizadores.get(i)!=null)utilizadores.get(i).getReferencia().alteraTabuleiroAposJogo(tipoCor,tipoCorTabuleiroFantasma, utilizadores.get(i).getObjRemoto(),null);
                            }
        return true;
    }

    
   
 
    public static void main(String args[]) {
        int porto=0;
        ordena();
     
        try {
         // formato de URL para RMI: "//host:port/name"
         // por omissao assume localhost e porto 1099
         // igual a Naming.rebind("//localhost:1099/meuContador", serv);
         do{
             System.out.println("Introduza o porto do servidor:");
            porto=sc.nextInt();
            if(porto>0 || porto<4000);//introduza porto entre x e y.
         }while(porto<0 && porto>4000);
         Registry reg = LocateRegistry.createRegistry(porto);
            Servidor serv = new Servidor();
        //referência é registada para depois poder ser procurada.
        reg.rebind("jogador",serv);

         System.out.println("servidor RMI iniciado");
      }
      catch (Exception e) {
         System.out.println(e);
      }
        
    }

   

    
   

}
