//package jogovelha;

import java.util.Scanner;

/**
 * ******************************************************************
 */
/**
 * Centro Universitario Senac *
 */
/**
 * TADS - 1o semestre de 2024 *
 */
/**
 * Professor: Fernando *
 */
/**
 * *
 */
/**
 * Projeto SEMESTRAL I *
 */
/**
 * Arquivo: <nome do arquivo> *
 */
/**
 * *
 */
/**
 * Ana Beatriz Santos Tolentino *
 */
/**
 * Igor Souza Pureza *
 */
/**
 * João Carlos Rodrigues Assis *
 */
/**
 * *
 */
/**
 * 27 de Maio 2024 *
 */
/**
 * ******************************************************************
 */
public class JogoVelha {

    static Scanner input = new Scanner(System.in);
    static int linha;
    static int coluna;
    static int simboloX = 0;
    static int simboloO = 0;
    static int jogadas = 9;

    public static void main(String[] args) {
        imprimeMenuPrincipal();
        

    }

    public static void imprimeMenuPrincipal() {
        boolean escolha = false;
        do {
            System.out.println("******MENU****");
            System.out.println("(1) Modo Jogador");
            System.out.println("(2) Modo Fácil");
            System.out.println("(3) Modo Dificil");
            System.out.println("(4) Sair");
            int op = input.nextInt();
            switch (op) {
                case 1:
                    modoJogador();
                    escolha = true;
                    break;
                case 2:
                    modoFacil();
                    escolha = true;
                    break;
                case 3:
                    modoDificil();
                    escolha = true;
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida!!!");
                    escolha = false;
            }

        } while (escolha == false);
    }

    public static void modoJogador() {
        System.out.println("modo jogador");
        char[][] tabuleiro = inicializarTabuleiro();
        
        impimeTabuleiro(tabuleiro);
        //jogador1 = X
        //jogador2 = O
        System.out.println("Digite o nome do primeiro jogador");
        String jogador1 = input.next();
        System.out.println("Digite o nome do segundo jogador");
        String jogador2 = input.next();
        System.out.println("Bem-vindos: " + jogador1 + " e " + jogador2);
        System.out.println(jogador1 + " digite o símbolo que vc deseja jogar (X ou O)");
        char simboloJogador1 = input.next().charAt(0);
        char simboloJogador2;
        if(simboloJogador1 == 'X'){
            System.out.println(jogador1 + "seu símbolo será X");
            simboloJogador2 = 'O';
            System.out.println(jogador2 + "seu símbolo será O");
        } else {
           System.out.println(jogador2 + "seu símbolo será X");
            simboloJogador2 = 'X'; 
        }

        do{
        
        linha = leiaCoordenadaLinha();
        coluna = leiaCoordenadaColuna();
        
        boolean preenchido = posicaoValida(linha, coluna, tabuleiro);
        System.out.println("validou posicao");
        if(jogadas % 2 == 0){
            if(preenchido == false){
                jogadaUsuario(linha, coluna, tabuleiro, simboloJogador2);
            }    
        }else{
            if(preenchido == false){
                jogadaUsuario(linha, coluna, tabuleiro, simboloJogador1);
            }  
        }
        
        if(jogadas < 7){
            verificaVencendor(tabuleiro, simboloJogador2);
        }
                 
        jogadas--;
        }while(jogadas > 0);
    
    }

    public static void modoFacil() {
        System.out.println("modo facil");
        char[][] tabuleiro = inicializarTabuleiro();
        impimeTabuleiro(tabuleiro);

    }

    public static void modoDificil() {
        System.out.println("Modo dificl");
        char[][] tabuleiro = inicializarTabuleiro();
        impimeTabuleiro(tabuleiro);
    }

    public static char[][] inicializarTabuleiro() {
        char[][] tabuleiro = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '_';
            }
        }
        return tabuleiro;
    }
    
    public static void impimeTabuleiro(char[][] tabuleiro){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(j < 2){
                 System.out.print(tabuleiro[i][j] + " | ");
                }
                else{
                  System.out.print(tabuleiro[i][j] + "\n");
                }
               
            } 
      }
    }
    
    public static int leiaCoordenadaLinha(){
        System.out.println("Digite a linha desejada: ");
        linha = input.nextInt();
        return linha;
    
    }
    
    
    public static int leiaCoordenadaColuna(){
        System.out.println("Digite a coluna desejada: ");
        coluna = input.nextInt();
        return coluna;
    
    }
    
     
    public static boolean posicaoValida(int l, int c, char[][] tabuleiro){
        boolean preenchido;
        if(tabuleiro[l][c] == 'X' || tabuleiro[l][c] == 'O'){
            System.out.println("Posicão já preenchida!");
            preenchido = true;
        }else{
            preenchido = false;
            
        }
        
       return preenchido;     
    
    }
    
    public static void jogadaUsuario(int l, int c, char[][] tabuleiro, char jogador) {
       //atribuindo a jogada
       tabuleiro = jogar(l, c, tabuleiro, jogador);
       
       //mostrando o tabuleiro
       for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(j < 2){
                 System.out.print(tabuleiro[i][j] + " | ");
                }
                else{
                  System.out.print(tabuleiro[i][j] + "\n");
                }
               
        }
            
        if(jogadas < 7){
            verificaVencendor(tabuleiro, jogador);
        }    
    
     }

        
    }
    
    public static char[][] jogar(int l, int c, char[][] tabuleiro, char jogador ){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if('X' == jogador){
                    tabuleiro[l][c] = 'X';
                }else{
                    tabuleiro[l][c] = 'O';
                }
            }
        }
        return tabuleiro;
    }
    
    public static void verificaVencendor(char[][] tabuleiro, char simbolo){
        //verificando diagonal esquerda
        if(tabuleiro[0][0] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][2] == simbolo){
             System.out.println("O " + simbolo + " ganhou");
             imprimePontos(simbolo, 'G');
        //verificando diagonal direita
        }else if(tabuleiro[0][2] == simbolo && tabuleiro[1][1] == simbolo && tabuleiro[2][0] == simbolo){
             System.out.println("O " + simbolo + " ganhou");
             imprimePontos(simbolo, 'G');
        }else{
            //verificando linhas
            for(int i = 0; i < 3; i++){
                if(tabuleiro[i][0] == simbolo && tabuleiro[i][1] == simbolo && tabuleiro[i][2] == simbolo){
                    System.out.println("O " + simbolo + " ganhou");
             imprimePontos(simbolo, 'G');
                }else{
                    for(int j = 0; j < 3; j++){
                        //verificando colunas
                        if(tabuleiro[0][j] == simbolo && tabuleiro[1][j] == simbolo && tabuleiro[2][j] == simbolo){
                            System.out.println("O " + simbolo + " ganhou");
             imprimePontos(simbolo, 'G');
                        }
                    }
                    verificaVelha(simbolo, 'V');

                }
            }
            
    }
    }
        
        
    public static void verificaVelha(char simbolo, char acao){
        System.out.println("Deu velha. Nenhum ganhou");
        imprimePontos(simbolo, acao);
    }     
    
    public static void imprimePontos(char simbolo, char acao){
     
      if(simboloX < 3 && simboloO < 3 && acao == 'G'){ 
        if(simbolo == 'X'){
           simboloX++;
        }else{
            simboloO++;
        }
      }
      
      System.out.println("Pontuação:"); 
      System.out.println(simboloX + " pontuacao do X");
      System.out.println(simboloO + " pontuacao O");
        
 
    }
}
