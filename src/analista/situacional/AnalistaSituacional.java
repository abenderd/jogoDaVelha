package analista.situacional;

import marca.*;
import tabuleiro.*;

public class AnalistaSituacional
{
    protected Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        // colocar tab em this.tabDoJogo
    	this.tabDoJogo = tab;
    }

    public Marca getMarcaDoVencedor () throws Exception
    {
        // descobrir se ha um vencedor e retornar
	// a marca dele; retornara null, quando
	// nao houver vencedor
    
    	if (this.tabDoJogo.getMarcaNaPosicao(0, 0) == this.tabDoJogo.getMarcaNaPosicao(0, 1) && this.tabDoJogo.getMarcaNaPosicao(0, 1) == this.tabDoJogo.getMarcaNaPosicao(0, 2))
    		return this.tabDoJogo.getMarcaNaPosicao(0, 0);
       	
		if (this.tabDoJogo.getMarcaNaPosicao(1, 0) == this.tabDoJogo.getMarcaNaPosicao(1, 1) && this.tabDoJogo.getMarcaNaPosicao(1, 1) == this.tabDoJogo.getMarcaNaPosicao(1, 2))
			return this.tabDoJogo.getMarcaNaPosicao(1, 0);

		if (this.tabDoJogo.getMarcaNaPosicao(2, 0) == this.tabDoJogo.getMarcaNaPosicao(2, 1) && this.tabDoJogo.getMarcaNaPosicao(2, 1) == this.tabDoJogo.getMarcaNaPosicao(2, 2))
			return this.tabDoJogo.getMarcaNaPosicao(2, 0);
		
		if (this.tabDoJogo.getMarcaNaPosicao(0, 0) == this.tabDoJogo.getMarcaNaPosicao(1, 0) && this.tabDoJogo.getMarcaNaPosicao(1, 0) == this.tabDoJogo.getMarcaNaPosicao(2, 0))
			return this.tabDoJogo.getMarcaNaPosicao(0, 0);
		
		if (this.tabDoJogo.getMarcaNaPosicao(0, 1) == this.tabDoJogo.getMarcaNaPosicao(1, 1) && this.tabDoJogo.getMarcaNaPosicao(1, 1) == this.tabDoJogo.getMarcaNaPosicao(2, 1))
			return this.tabDoJogo.getMarcaNaPosicao(0, 1);

		if (this.tabDoJogo.getMarcaNaPosicao(0, 2) == this.tabDoJogo.getMarcaNaPosicao(1, 2) && this.tabDoJogo.getMarcaNaPosicao(1, 2) == this.tabDoJogo.getMarcaNaPosicao(2, 2))
			return this.tabDoJogo.getMarcaNaPosicao(0, 2);
		
		if (this.tabDoJogo.getMarcaNaPosicao(0, 0) == this.tabDoJogo.getMarcaNaPosicao(1, 1) && this.tabDoJogo.getMarcaNaPosicao(1, 1) == this.tabDoJogo.getMarcaNaPosicao(2, 2))
			return this.tabDoJogo.getMarcaNaPosicao(0, 0);

		if (this.tabDoJogo.getMarcaNaPosicao(0, 2) == this.tabDoJogo.getMarcaNaPosicao(1, 1) && this.tabDoJogo.getMarcaNaPosicao(1, 1) == this.tabDoJogo.getMarcaNaPosicao(2, 0))
			return this.tabDoJogo.getMarcaNaPosicao(0, 2);
		
		return null;	
    }

    private boolean tabuleiroCheio ()
    {
	// verificar se todas as posicoes do
	// tabuleiro estao preenchidas (!=null)
	// retornando true em caso afirmativo,
	// ou false em caso negativo
    	
    	try
    	{
    		for (int i = 0; i < 3; ++i)
    		{
    			for (int j = 0; j < 3; j++)
    			{
    				if(this.tabDoJogo.haMarcaNaPosicao(i, j))
    					return false;
    			}
    		}
    	}
    	catch (Exception Err)
    	{
    		System.err.println(Err);
    	}
    	return true;
    }

    public boolean fimDeJogo () throws Exception
    {
	// se getMarcaDoVencedor() != null,
	// retorna true
	// se tabuleiroCheio() == true,
	// retorna true
	// caso contrario, retorna false

    	if (getMarcaDoVencedor() != null)
    		return true;
    	if (tabuleiroCheio() == true)
    		return true;
    	return false;
    }

    public String toString ()
    {
        // produzir e retornar um String contendo
        // o tabuleiro seguido de uma menção do
        // estado do tabuleiro (jogo encerrado com
        // vencedor, jogo encerrado sem vencedor ou
        // jogo que pode ser continuado
    	

    	String tabuleiro = " ";
    	
    	try {
			if (getMarcaDoVencedor() != null)
				tabuleiro = this.tabDoJogo + "Ha um vencedor";
			if (tabuleiroCheio())
	    		tabuleiro = this.tabDoJogo +  "Nao houve vencedor";
			tabuleiro = this.tabDoJogo +  "Continue a jogar.";
		} catch (Exception e) {
			System.err.println(e);
		}
    	
    	return tabuleiro;
    }

    public int hashCode ()
    {
        // calcular e retornar o hash code
    	int ret = super.hashCode();
    	
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
}