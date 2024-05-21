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
        
        System.out.println("Digite o nome do primeiro jogador");
        String jogador1 = input.next();
        System.out.println("Digite o nome do segundo jogador");
        String jogador2 = input.next();
        System.out.println("Bem-vindos: " + X + " e " + O);
        
       
        linha = leiaCoordenadaLinha();
        coluna = leiaCoordenadaColuna();
        
        boolean preenchido = posicaoValida(linha, coluna, tabuleiro);
        
        if(preenchido == false){
           jogadaUsuario(linha, coluna, tabuleiro, X); 
        }
        
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
        System.out.println("Digite a linha desejada: ");
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
    
    public static void jogadaUsuario(int l, int c, char[][] tabuleiro, String jogador) {
        jogar(l, c, tabuleiro, jogador);
        
    }
    
    public static void jogar(int l, int c, char[][] tabuleiro, String jogador ){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(jogador1 == true){
                    tabuleiro[l][c] = 'X';
                }
            }
        }
    
    }
}