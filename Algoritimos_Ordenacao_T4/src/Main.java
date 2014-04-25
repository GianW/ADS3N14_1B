import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 

public class Main {

	int[] lista = {5,3,2,4,7,8,6,9,1,0};
	 
		
	public static void main(String[] args) {	
		int operacao = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
		
		while(true){
			System.out.println("Escolha o algoritimo para ordenar a lista:");
			System.out.println("1 - Selection Sort");
			System.out.println("2 - Merge Sort");
			System.out.println("3- Sair");
			
			try {
				operacao = Integer.parseInt(reader.readLine());
			} catch (NumberFormatException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
						
			switch (operacao){
				case 1:
					System.out.println("Selection");
					break;
				case 2:
					System.out.println("Merge");
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Opção invalida");
					System.out.println(operacao);
					
			}
			
		}
		
		
	}

}
