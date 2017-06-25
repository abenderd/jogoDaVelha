package jogador;

import marca.*;

public interface Jogador extends Cloneable
{
    Marca getMarca ();
    void facaSuaJogada ();
    String toString ();
    int hashCode ();
    boolean equals (Object obj);
    Object clone ();
}