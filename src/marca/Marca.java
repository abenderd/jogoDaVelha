package marca;

public class Marca
{
    protected char simbolo;

    public Marca (char smb) throws Exception
    {
    // validar smb e coloca-lo em
	// this.simbolo
    	if (smb == 'X' || smb == 'O')
    		this.simbolo = smb;
    	else
    		throw new Exception("Simbolo nao valido, insira O ou X.");
    }

    public char getSimbolo ()
    {
	// retornar this.simbolo
    	return this.simbolo;
    }

    public String toString ()
    {
	// retornar this.simbolo em um String
    	return "" + this.simbolo;
    }

    public boolean equals (Object obj)
    {
	// verificar se this e obj sao
	// iguais em conteudo, retornando
	// true ou false, conforme o caso
    	if (obj == null)
    		return false;
    	
    	if (this == obj)
    		return true;
    	
    	return false;
    
    }

    public int hashCode ()
    {
	// calcular a partir os atributos
	// o hashCode do this
    	int ret = 1;
    	
    	ret = 13 * ret + new Integer(this.simbolo).hashCode();
    	
    	return ret;
    }
}