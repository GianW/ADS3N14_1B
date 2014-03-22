package listaencadeada;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import listaencadeada.entidade.Contato;
/**
 *
 * @author Gian
 * Classe para manipulação dos registros
 */
public class Model {
    public static String teste;
    public static Contato contato;
    public static void leAgenda(){
        try{
            FileReader arquivoEntrada = new FileReader("contatos.txt");
            BufferedReader buffer = new BufferedReader(arquivoEntrada);
            
            String[] result;
            String linha;
            int contador = 1;
            while((linha = buffer.readLine()) != null) {
                result = linha.split("\\|");
                criaContato(result[0], result[1], contador);
               contador++;               
            }
          
            
        }catch(IOException e) {
            System.out.println("Arquivo nao encontrado");
	}  
    }    
    public static void criaContato(String nome, String telefone, int contador){                
                contato = new Contato(nome, telefone);
                System.out.println(contato.getNome());
        
    }
    


}

