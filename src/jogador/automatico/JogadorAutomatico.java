package jogador.automatico;

import jogador.*;
import marca.*;
import tabuleiro.*;

public class JogadorAutomatico implements Jogador
{
    protected Marca     marca     = null;
    protected Tabuleiro tabDoJogo = null;

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
	// atribuir tab para this.tabDoJogo
	// fazer o jogador escolher
	// via sorteio de numeros aleatorio
    	this.tabDoJogo = tab;
    	
    	try
    	{
    		int opcao = (int)Math.random() * 2;
    		if (opcao == 0)
    			this.marca = new Marca('X');
    		else
    			this.marca = new Marca('O');
    	}
    	catch (Exception err)
    	{
    		System.err.println(err);
    	}
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
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
        // faz o jogador fazer uma jogada
    	// INTELIGENTE (
        // Tentativa 1: verifique se ha numa linha,
        // ou numa coluna, ou numa diagonal
        // 2 marcas que sao equals a this.marca
        // e a terceira posicao estiver vazia,
        // jogue ali;
        // Tentativa 2: verifique se ha numa linha,
        // ou numa coluna, ou numa diagonal
        // 2 marcas que sao !equals a this.marca
        // e a terceira posicao estiver vazia,
        // jogue ali;
        // Tentativa 3: verifique se ha numa linha,
        // ou numa coluna, ou numa diagonal
        // 1 marca que é equals a this.marca
        // e as demais estiverem vazias,
        // jogue numa das vazias;
        // Tentativa 4: jogue em qualquer lugar livre).
    	
    	do {

    		int linha = (int)(Math.random() * 3);
        	int coluna = (int)(Math.random() * 3);
        	try
        	{            	
        		if (this.tabDoJogo.haMarcaNaPosicao(linha, coluna))
        			continue;

        		this.tabDoJogo.setMarcaNaPosicao(this.marca, linha, coluna);
				break;
        	}
        	catch (Exception e){
        		System.err.println(e);
        	}
    		break;
    	}
		while (true);
    }

    public String toString ()
    {
        // retorna o String "Jogador Automatico" seguido
        // pela marca do jogador entre parenteses
    	
    	String jogadorAutomatico = "Jogador Humano (" + this.marca + ")";
    	
    	return jogadorAutomatico;
    }

    public int hashCode ()
    {
        // calcular e retornar o hash code
    	int ret = super.hashCode();
    	
    	ret = ret * 13 + this.marca.hashCode();
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
    	JogadorAutomatico copia = null;
    	
    	try
    	{
    		copia = new JogadorAutomatico (this);
    	}
    	catch (Exception e) 
    	{
    		System.out.println(e);
		}
    	
    	return copia;
    }

    public JogadorAutomatico (JogadorAutomatico modelo)
    {
        // inicia a instancia recem criada com NEW,
        // de forma que seja INDEPENDENTE de this,
        // porem com dados em tudo iguais aos presentes
        // em this
    	
    	modelo = new JogadorAutomatico(modelo);
    }
}