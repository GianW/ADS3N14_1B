
public class Main {

	
	public static void main(String[] args) {
		String[][] Tabuleiro = new String[10][10];
		
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++){
				Tabuleiro[i][j] = ".";
			}			
		}
		
		System.out.print("   ");
		for (int i = 0; i < 10; i++){
			System.out.print(" " + i);
		}
		
		for (int i = 0; i < 10; i++){
			System.out.println(" ");
			System.out.print(i + "  ");
			for (int j = 0; j < 10; j++){
				System.out.print(" " + Tabuleiro[i][j]);
			}			
		}
				
		
		
	}

}
