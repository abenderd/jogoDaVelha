package jogador.humano;

import java.io.*;
import jogador.*;
import marca.*;
import tabuleiro.*;


public class JogadorHumano implements Jogador
{
    protected Marca          marca     = null;
    protected Tabuleiro      tabDoJogo = null;
    protected BufferedReader entrada   = new BufferedReader
                                        (new InputStreamReader
                                        (System.in));

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
	// atribuir tab para this.tabDoJogo
	// pedir para o jogador escolher
	// sua marca e permitir digitacao
	// intanciando this.marca
    	this.tabDoJogo = tab;
    	char simbolo = ' ';
    	
    	while (true)
    	{
    		System.out.println("\n Quer jogar com X ou O? \n");
    		try
    		{
    			simbolo = this.entrada.readLine().charAt(0);
    		}
    		catch (Exception e) 
    		{
				System.out.println(e);
			}
    		
    		if (simbolo == 'X' || simbolo == 'O')
    		{
    			break;
    		}
    		else
    		{
    			System.err.println("Erro, escolha entre X ou O.");
    		}
    	}
    	
    	try
    	{
    		this.marca = new Marca(simbolo);
    	}
    	catch (Exception e){
    		System.err.println(e);
    	}
    }

    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
    {
	// atribuir tab para this.tabDoJogo
	// e mrc para this.marca
    	this.tabDoJogo = tab;
    	this.marca = mrc;    	
    }

    public Marca getMarca ()
    {
	// retorna a marca do jogador
    	return this.marca;
    }

    public void facaSuaJogada ()
    {
	// pergunta para o jogador onde ele quer
	// jogar, permitindo digitacao e chamando
	// os métodos apropriados de this.tabDoJogo
    	int lin = 0;
    	int col = 0;    	
    	
    	System.out.println(this.tabDoJogo);
    	while(true)
    	{
    		System.out.println("Em qual linha quer jogar? \n");	
    		try 
    		{
    			lin = Integer.parseInt(this.entrada.readLine());
    		}
    		catch (Exception e){
    			System.err.println(e);
    		}
    		if (lin < 0 || lin > 2){
    			System.err.println("Linha invalida.");
    		}
    		else{
    			while(true){
    	    		System.out.println("Em qual coluna quer jogar? \n");	
    	    		try {
    	    			col = Integer.parseInt(this.entrada.readLine());
    	    		}
    	    		catch (Exception e){
    	    			System.err.println(e);
    	    		}    	    		
    	    		if (col >= 0 && col <= 2){
    	    			break;
    	    		}
    	    		System.err.println("Coluna Invalida.");
				}
    			try{    		
    				if (!this.tabDoJogo.haMarcaNaPosicao(lin, col))
    					break;    		
    				System.out.println("Ja possui marca na posicao");
    			}
    			catch (Exception e){
    				System.err.println(e);
    			}
    		}
	    }
    	try{
    		this.tabDoJogo.setMarcaNaPosicao(this.marca, lin, col);
    	}
		catch (Exception e){
			System.err.println(e);
		}
    
    }

    public void vcGanhou ()
    {
	// mostra mensagem indicando vitoria
    	System.out.println("Parabens, voce ganhou! =)" + this.tabDoJogo);
    }

    public void vcPerdeu ()
    {
	// mostra mensagem indicando derrota
    	System.out.println("Que pena, voce perdeu. Tente novamente! ;)" + this.tabDoJogo);
    }

    public void deuVelha ()
    {
	// mostra mensagem indicando empate
    	System.out.println("Uia! Deu empate. oO" + this.tabDoJogo);
    }

    public boolean querMaisUmaPartida ()
    {
	// perguntar se deseja jogar de novo
	// permitindo digitacao e retornando
	// true ou false, conforme a resposta
    	char resposta = ' ';
    	
    	System.out.println("Que tal jogar de novo? Digite S para continuar.");
		try
		{
			resposta = this.entrada.readLine().charAt(0);
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		if (resposta == 'S' || resposta == 's')
		{
			return true;
		}
		else
		{
			System.exit(0);
			return false;
		}
    }

    public String toString ()
    {
        // retorna o String "Jogador Humano" seguido
        // pela marca do jogador entre parenteses
    	String jogadorHumano = "Jogador Humano (" + this.marca + ")";
    	
    	return jogadorHumano;
    }

    public int hashCode ()
    {
        // calcular e retornar o hash code
    	int ret = super.hashCode();
    	
    	ret = ret * 13 + this.marca.hashCode(); 
    	ret = ret * 13 + this.entrada.hashCode();
    	ret = ret * 13 + this.tabDoJogo.hashCode();
    			
    	return ret;
    }

    public boolean equals (Object obj)
    {
        // verificar se o conteudo de this e obj sao
        // iguais, retornando true em caso afirmativo,
        // ou false em caso negativo
    	if (this == obj)
    		return true;
    	return false;
    }

    public Object clone ()
    {
        // retorna uma NOVA instancia, INDEPENDENTE de
        // this, com dados em tudo iguais aos presentes
        // em this
    	
    	JogadorHumano copia = null;

    	try
    	{
    		copia = new JogadorHumano (this);
    	}
    	catch (Exception e) 
    	{
    		System.out.println(e);
		}
    	
    	return copia;

    }

    public JogadorHumano (JogadorHumano modelo)
    {
        // inicia a instancia recem criada com NEW,
        // de forma que seja INDEPENDENTE de this,
        // porem com dados em tudo iguais aos presentes
        // em this
    	modelo = new JogadorHumano(modelo);    	
    }
}