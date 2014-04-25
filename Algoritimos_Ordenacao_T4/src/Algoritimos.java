public class Algoritimos {
	
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
		 System.out.println("Numero de comparações: " + comparacoes);
		 System.out.println("Numero de trocas: " + trocas);
		 System.out.println("___________________________________________________________________");
		 		
	}
	
	public void merge(){
		System.out.println("Merge");
	}


}
