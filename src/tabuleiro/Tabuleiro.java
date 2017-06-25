package tabuleiro;

import marca.*;

public class Tabuleiro implements Cloneable
{
    // a principio, toda igual a null
    protected Marca matriz [][] = new Marca [3][3];

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        // valido lin e col e em seguida
	// verifico se em this.matriz[lin][col]
	// tem null, retornando false em caso
	// afirmativo, ou true em caso negativo
    	if (lin > 2 || lin < 0)
    		throw new Exception("Linha invalida");
    	
    	if (col > 2 || col < 0)
    		throw new Exception("Coluna invalida");
    	
    	if (this.matriz[lin][col] == null)
    		return false;
    	
    	return true;
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        // valido lin e col,
        // valido se haMarcaNaPosicao(lin,col)
        // e em seguida
	// retornar a marca que tem em
	// this.matriz[lin][col]
    	if (lin > 2 || lin < 0)
    		throw new Exception("Linha invalida");
    	
    	if (col > 2 || col < 0)
    		throw new Exception("Coluna invalida");
    	
    	if (this.matriz[lin][col] == null)
    		return null;
    	
    	return this.matriz[lin][col];
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        // valido lin e col,
        // valido se !haMarcaNaPosicao(lin,col)
        // e em seguida
    	// colocar mrc em this.matriz[lin][col]
    	if (lin > 2 || lin < 0)
    		throw new Exception("Linha invalida");
    	
    	if (col > 2 || col < 0)
    		throw new Exception("Coluna invalida");
    	
    	if (this.haMarcaNaPosicao(lin, col))
    		throw new Exception("Posicao ja preenchida");
    	this.matriz[lin][col] = mrc;
    	
    }

    public String toString ()
    {
        // retornar o tabuleiro,
        // apropriadamente preenchido,
        // na forma de um String,
        // com as linhas separadas por \n
        // e com a seguinte aparencia:
        //    0   1   2
        //  +---+---+---+
        //  |   |   |   |
        // 0|   |   |   |
        //  |   |   |   |
        //  +---+---+---+
        //  |   |   |   |
        // 1|   |   |   |
        //  |   |   |   |
        //  +---+---+---+
        //  |   |   |   |
        // 2|   |   |   |
        //  |   |   |   |
        //  +---+---+---+
    	String tab = "   0   1   2  \n +---+---+---+ \n |   |   |   |" ;
		for (int i = 0; i < 3; i++) {
			tab = tab + '\n' + i;
            for (int j = 0; j < 3; j++) {
            	tab = tab + "| ";
				if (this.matriz[i][j] != null)
					tab = tab + this.matriz[i][j].getSimbolo();
				else
					tab = tab + ' ';
				tab = tab + ' ';
            }
            tab = tab + "|\n +---+---+---+";
        }
        return tab;
    }

    public boolean equals (Object obj)
    {
	// verificar se this e obj sao
	// iguais em conteudo, retornando
	// true ou false, conforme o caso
    	if (this == obj)
    		return true;
    	return false;
    }

    public int hashCode ()
    {
	// calcular a partir os atributos
	// o hashCode do this
    	int ret = super.hashCode();
    	
    	for (int lin = 0; lin < 3; lin++)
    	{
    		for (int col = 0; col < 3; col++)
    		{
    			ret = 13 * ret + this.matriz[lin][col].hashCode();
    		}
    	}
    	return ret;
    }

    public Object clone ()
    {
        // retorna uma NOVA instancia, INDEPENDENTE de
        // this, com dados em tudo iguais aos presentes
        // em this
    	Tabuleiro copia = null;
    	
    	try
    	{
    		copia = new Tabuleiro (this);
    	}
    	catch (Exception e) 
    	{
    		System.out.println(e);
		}
    	
    	return copia;
    }

    public Tabuleiro (Tabuleiro modelo)
    {
        // inicia a instancia recem criada com NEW,
        // de forma que seja INDEPENDENTE de this,
        // porem com dados em tudo iguais aos presentes
        // em this
    	
    	this.matriz = new Marca [3][3];
    }
}