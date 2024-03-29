package br.uff.es.pkg.sueca;

public class Juiz {
	
  private static int pontosD1=0;
  private static int pontosD2=0;
	
  public static Jogador DeterminaVencedorJogada(Carta cartas[], Jogador j[],Naipe trunfo){
	  //Retorna o nome do jogador vencedor
	  //Comecamos assumindo que o vencedor eh o trunfo
          Carta c[] = new Carta[cartas.length];
          for (int i=0;i<cartas.length;i++)
              c[i] = cartas[i];
          Carta cTrunfo = null;
          for(int i=0;i<4;i++){
              if ((c[i].getNaipe()==trunfo)&&cTrunfo==null)
                  cTrunfo = c[i];
            if ((c[i].getNaipe()==trunfo)&&(c[i].getValor().ordinal()>cTrunfo.getValor().ordinal())){
                cTrunfo = c[i];
                c[i] = null;
            }
          }
	  Carta cVencedor = null;
	  for(int i=0;i<4;i++){
              if (cVencedor==null && c[i]!=null)
                  cVencedor = c[i];

              if (c[i]!=null&&(c[i].getNaipe()==cVencedor.getNaipe())&&(c[i].getValor().ordinal()>cVencedor.getValor().ordinal())){
                      cVencedor = c[i];
              }
	  }
          cVencedor = cTrunfo==null?cVencedor:cTrunfo;
	  for (int i=0;i<j.length;i++){
		  if (cVencedor.getPertenceA().equals(j[i].getNome())) return j[i];
	  }
          //System.out.println("Carta: "+cVencedor+ " pertenceA "+cVencedor.getPertenceA());
	  return null;
  }
  
  public static void SomaPontos(Carta c[], Jogador j){
	  for (int i=0; i<c.length;i++){
		  switch(c[i].getValor()){
		  	case dama:
		  		j.setPontos(j.getPontos()+2);
		  		//System.out.println(j.getPontos());
		  		break;
		  	case valete:
		  		j.setPontos(j.getPontos()+3);
		  		//System.out.println(j.getPontos());
		  		break;
		  	case rei:
		  		j.setPontos(j.getPontos()+4);
		  		//System.out.println(j.getPontos());
		  		break;
		  	case sete:
		  		j.setPontos(j.getPontos()+10);
		  		//System.out.println(j.getPontos());
		  		break;
		  	case as:
		  		j.setPontos(j.getPontos()+11);
		  		//System.out.println(j.getPontos());
		  		break;	
	      }
		  c[i].setPertenceA(j.getNome());
		  //System.out.println("Carta "+c[i].toString()+" pertence agora a"+j.getNome());
	  }
  }

  public static int getPontosDupla1(Jogador j[]) {
      return (j[0].getPontos()+j[1].getPontos());
  }

  public static int getPontosDupla2(Jogador j[]) {
      return (j[2].getPontos()+j[3].getPontos());
  }
  
    public static int CalculaDuplaVencedora(Jogador j[]) {
        int d1 = j[0].getPontos() + j[1].getPontos();
        int d2 = j[2].getPontos() + j[3].getPontos();
        if (d1 >= 90) {
            pontosD1 += 2;

            System.out.println("Dupla 1 venceu com " + d1 + " pontos!");
            return 1;
        } else if (d1 >= 60) {
            pontosD1 += 1;
            System.out.println("Dupla 1 venceu com " + d1 + " pontos!");
            return 1;
        } else if (d2 >= 90) {
            pontosD2 += 2;
            System.out.println("Dupla 2 venceu com " + d2 + " pontos!");
            return 2;
        } else if (d2 > 60) {
            pontosD2 += 1;
            System.out.println("Dupla 2 venceu com " + d2 + " pontos!");
            return 2;
        }
        return 0;
    }

    public static int getPontosGeralDupla1() {
      return pontosD1;
    }

    public static int getPontosGeralDupla2() {
      return pontosD2;
    }
  
}
