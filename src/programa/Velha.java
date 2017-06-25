package programa;

import marca.*;
import tabuleiro.*;
import jogador.*;
import jogador.humano.*;
import jogador.automatico.*;
import analista.situacional.*;

public class Velha
{
    public static void main (String args [])
    {
        Tabuleiro           tabDoJogo = null;

        Jogador             jogador  = null;
        JogadorHumano       jogadorH = null;
        JogadorAutomatico   jogadorA = null;

        AnalistaSituacional analista;

        boolean jogadorHumanoComeca = (int)(Math.random()*2) == 0;

        do
        {
            try
            {
                tabDoJogo = new Tabuleiro (tabDoJogo);

                if (jogadorHumanoComeca)
                {
                    jogadorH = new JogadorHumano (tabDoJogo);
                    jogadorA = new JogadorAutomatico
                              (tabDoJogo,
                               new Marca(jogadorH.getMarca().getSimbolo()=='X'?'O':'X'));

                    jogador  = jogadorH;
                }
                else
                {
                    jogadorA = new JogadorAutomatico (tabDoJogo);
                    jogadorH = new JogadorHumano
                              (tabDoJogo,
                               new Marca(jogadorA.getMarca().getSimbolo()=='X'?'O':'X'));

                    jogador  = jogadorA;
                }

                analista = new AnalistaSituacional (tabDoJogo);

                do
                {
                    jogador.facaSuaJogada();

                    if (jogador==jogadorA)
                        jogador = jogadorH;
                    else
                        jogador = jogadorA;
                }
                while (!analista.fimDeJogo());

                if (analista.getMarcaDoVencedor()==null)
                    jogadorH.deuVelha ();
                else
                    if (analista.getMarcaDoVencedor().equals(jogadorH.getMarca()))
                        jogadorH.vcGanhou ();
                    else
                        jogadorH.vcPerdeu ();

                jogadorHumanoComeca = !jogadorHumanoComeca;
            }
            catch (Exception e)
            {}
        }
        while (jogadorH.querMaisUmaPartida());
    }
}