public class Algoritimos {
	public int mergeComparacoes = 0;
	public int mergeTrocas = 0;
	/**
	 * Fun��o que recebe lista, ordena e imprime
	 * conforme algoritimo Selection Sort.
	 * Exibe numero de compara��es e trocas
	 * @param Lista para ordenar
	 */
	public void selection(int[] listaOriginal){
		int aux = 0;
		int comparacoes = 0;
		int trocas = 0;
		
		 for (int indiceA = 0; indiceA < listaOriginal.length; indiceA++){
			 			 
			 for(int indiceB = indiceA + 1; indiceB < listaOriginal.length; indiceB++){
				 comparacoes++;
				 if(listaOriginal[indiceA] > listaOriginal[indiceB]){
					 aux = listaOriginal[indiceA];
					 listaOriginal[indiceA] = listaOriginal[indiceB];
					 listaOriginal[indiceB] = aux;
					 trocas++;
				 }				
			 }
			 
		 }
		 System.out.println("***** SELECTION SORT *****");
		 System.out.print("Lista ordenada: ");
		 for(int i = 0; i < listaOriginal.length; i++){			 
			 System.out.print( listaOriginal[i] + " ");
		 }
		 System.out.println("");
		 System.out.println("Numero de compara��es: " + comparacoes);
		 System.out.println("Numero de trocas: " + trocas);
		 System.out.println("___________________________________________________________________");
		 		
	}
	
	/**
	 * Fun��o que recebe lista, ordena e imprime
	 * conforme algoritimo Merge Sort
	 * @param listaOriginal
	 */
	public void merge(int[] listaOriginal){
		mergeComparacoes = 0;
		mergeTrocas = 0; 
		int[] listaAuxiliar = mergeS(listaOriginal);
		
		System.out.println("***** MERGE SORT *****");
		System.out.print("Lista ordenada: ");
		for(int i = 0; i < listaAuxiliar.length; i++){			 
			 System.out.print( listaAuxiliar[i] + " ");
		 }
		 System.out.println("");
		 System.out.println("Numero de compara��es: " + mergeComparacoes);
		 System.out.println("Numero de trocas: " + mergeTrocas);
		 System.out.println("___________________________________________________________________");
	}
	
	public int[] mergeS(int[] listaOriginal){
		if (listaOriginal.length > 1) {
			int[] esq = ldEsq(listaOriginal);
            int[] dir = ldDir(listaOriginal);
            
            mergeS(esq);
            mergeS(dir);
            
            mergeComp(listaOriginal, esq, dir);
		}
		return listaOriginal;
		
	}
	
	public int[] ldEsq(int[] lista) {
        int tam = lista.length / 2;
        int[] ldEsq = new int[tam];
        for (int i = 0; i < tam; i++) {
        	ldEsq[i] = lista[i];
        }
        return ldEsq;
    }
	
    public int[] ldDir(int[] lista) {
        int tam = lista.length / 2;
        int tamAux = lista.length - tam;
        int[] ldDir = new int[tamAux];
        for (int i = 0; i < tamAux; i++) {
        	ldDir[i] = lista[i + tam];
        }
        return ldDir;
    }
    
    public void mergeComp(int[] result, int[] left, int[] right) {
		int i1 = 0;   // indice da esquerda
		int i2 = 0;   // indice da direita
		
		for (int i = 0; i < result.length; i++) {
			mergeComparacoes++;
			if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {								
				result[i] = left[i1];    // jogar para esquerda				
				i1++;
			} else {
				result[i] = right[i2];   // jogar para direita				
				mergeTrocas++;
				i2++;
			}
		}

	}


}
