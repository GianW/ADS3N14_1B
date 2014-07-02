import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Util {

	
	 public void incluiItinerario(){
		 
		 //Lista que recebe os pontos inicias
		 ArrayList<CadastroPonto> listaPontos =
                 new ArrayList<CadastroPonto>();
		 //Lista auxiliar para ordenação
		 ArrayList<CadastroPonto> listaPontosAux =
                 new ArrayList<CadastroPonto>();
		 //Lista com os valores ordenados
		 ArrayList<CadastroPonto> listaItinerario =
                 new ArrayList<CadastroPonto>();
		 
		 String descricao = JOptionPane.showInputDialog(null,"Endereço de partida", "Endereço", 1);
		 int operacao = 0;
		 CadastroPonto inicial = new CadastroPonto(descricao, "", 0);
		 listaPontos.add(inicial);
		 
		 while(operacao == 0){
	            String ponto = JOptionPane.showInputDialog(null,
	                         "Ponto:", "Cadastro", 1);
	            
	            CadastroPonto objPonto = new CadastroPonto(ponto, "", 0);
	            listaPontos.add(objPonto);
	            
	            operacao = JOptionPane.showConfirmDialog(null,
	            		"Incluir mais pontos?", "Continua", 1);
		 }
		 
		 if(listaPontos.size() > 0){
			 listaPontosAux = listaPontos;
			 int Aux = 0;
			 String NomeAux = null;
			 CadastroPonto registro;
			 
			 for(CadastroPonto cadastro1 : listaPontos){			
				 listaPontosAux.remove(cadastro1.getNome());
				 Aux = listaPontosAux.get(0).getCusto();
				 NomeAux = listaPontosAux.get(0).getNome();
				 for(CadastroPonto cadastroAux : listaPontosAux){
					 //CHAMA DIJKISTRA PARA OBTER CUSTO ENTRE
					 // cadastro1.getNome() e cadastroAux.getNome();
					 
					if(Aux > cadastroAux.getCusto()){
						NomeAux = cadastroAux.getNome();
						Aux = cadastroAux.getCusto();
					}
				 }
				 
				registro = new CadastroPonto(cadastro1.getNome(), NomeAux, Aux);
				listaItinerario.add(registro);				
			 }
		 }	
		 
			
	 }
	 
}
