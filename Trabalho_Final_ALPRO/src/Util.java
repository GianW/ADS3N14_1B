import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Util {

	
	 public void incluiItinerario(){
		 ArrayList<CadastroPonto> listaPontos =
                 new ArrayList<CadastroPonto>();
		 
		 ArrayList<CadastroPonto> listaPontosAux =
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
			 for(CadastroPonto cadastro1 : listaPontos){
				/* System.out.println(cadastro1.getNome());*/
			 	
			
			 }
		 }	
		 
			
	 }
	 
}
