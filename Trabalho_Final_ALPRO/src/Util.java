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
		 
		 //Lista com as paradas
		 ArrayList<CadastroParada> listaParadas =
				 new ArrayList<CadastroParada>();
		 
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
			 
			 if(listaItinerario.size() > 0){
				 int OdometroCombustivel = 0;
				 int OdometroAux = 0;				 
				 int inteiroAux = 0;
				 int AuxiliarKms = 0;
				 int sobraCombs = 0;
				 listaPontosAux = listaPontos;
				 
				 int OdometroDescanso = 0;
				 int sobraDescans = 0;
				 
				 
				 for(CadastroPonto cadastro : listaPontosAux){
					 
					 //Se sobrou kms no ultimo trajeto contabiliza para gerar parada.
					 if(sobraCombs > 0){
						 int qtdeFalta = 600 - sobraCombs;
						 int novoValor = cadastro.getCusto();
						 novoValor = novoValor - qtdeFalta;
						 cadastro.setCusto(novoValor);
						 CadastroParada paradaExtra = null;
						 paradaExtra.setNomeOrigem(cadastro.getNome());
						 paradaExtra.setNomeDestino(cadastro.getDestino());
						 paradaExtra.setTipo("Combustivel");
						 OdometroCombustivel = OdometroCombustivel + 600;
						 paradaExtra.setKms(OdometroCombustivel);
					 }
					 
					 					 
					 if(cadastro.getCusto() > 600){
						 inteiroAux = cadastro.getCusto() / 600;
						 OdometroAux = (inteiroAux - 1) * 600;
						 AuxiliarKms =  cadastro.getCusto() - OdometroAux;
						 
						 //Verificacao por falta de validação no float da divisão. nivel de poda 3.
						 if(AuxiliarKms < 600){ 
							 for(int cont=1 ; cont <= (inteiroAux - 1); cont++ ){
								 CadastroParada parada = null;
								 parada.setNomeOrigem(cadastro.getNome());
								 parada.setNomeDestino(cadastro.getDestino());
								 parada.setTipo("Combustivel");
								 OdometroCombustivel = OdometroCombustivel + 600;
								 parada.setKms(OdometroCombustivel);
								 listaParadas.add(parada);
								 sobraCombs = AuxiliarKms; 
								 
							 }
						 }						 
						 
					 }
					 
					 
					 //Incremento lista de descanso.
					 if(sobraDescans > 0){
						 int qtdeFalta = 240 - sobraDescans;
						 int novoValor = cadastro.getCusto();
						 novoValor = novoValor - qtdeFalta;
						 cadastro.setCusto(novoValor);
						 CadastroParada paradaExtra = null;
						 paradaExtra.setNomeOrigem(cadastro.getNome());
						 paradaExtra.setNomeDestino(cadastro.getDestino());
						 paradaExtra.setTipo("Descanso");
						 OdometroCombustivel = OdometroDescanso + 240;
						 paradaExtra.setKms(OdometroDescanso);
					 }
					 
					 if(cadastro.getCusto() > 240){
						 inteiroAux = cadastro.getCusto() / 240;
						 OdometroAux = (inteiroAux - 1) * 240;
						 AuxiliarKms =  cadastro.getCusto() - OdometroAux;
						 
						 if(AuxiliarKms < 240){
							 CadastroParada parada = null;
							 parada.setNomeOrigem(cadastro.getNome());
							 parada.setNomeDestino(cadastro.getDestino());
							 parada.setTipo("Descanso");
							 OdometroDescanso = OdometroDescanso + 240;
							 parada.setKms(OdometroDescanso);
							 listaParadas.add(parada);
							 sobraDescans = AuxiliarKms; 
							 
						 }
						 
					 }
					 
				 }
				 
				 
			 }
		 }		 
			
	 }
	 
}
