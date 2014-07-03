package App;

import Controller.DijkstraController;
import Model.GrafoModel;
import Model.VerticeModel;
import View.DadosPercursoPartial;
import View.FormDestinoPartial;
import View.FormOrigemPartial;
import View.Menu;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Riguel Figueiro
 */
public class Main {
//public static int EARTH_RADIUS_KM = 6371;
    public static int EARTH_RADIUS_KM = 12000;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        DijkstraController djkController =  new DijkstraController();
        
        new Menu().ImprimeMenu();
        String origem = new FormOrigemPartial().ImprimeFormOrigem();
        String destino = new FormDestinoPartial().ImprimeFormDestino();
                
        System.out.println();
        System.out.print("========================================");
        GrafoModel grafoPrincipal = new GrafoModel();
        grafoPrincipal = new GrafoModel();
        
        VerticeModel verticeOrigem = new VerticeModel();
        VerticeModel verticeDestino = new VerticeModel();

        // obtem os vertices do arquivo
        grafoPrincipal.setVertices(new DijkstraController().ObtemVertices());
        
        verticeOrigem = grafoPrincipal.encontrarVertice(origem);
        verticeDestino = grafoPrincipal.encontrarVertice(destino);

        System.out.println();
        List<VerticeModel> resultado = djkController.ObterMenorCaminho(grafoPrincipal, verticeOrigem, verticeDestino);

        System.out.println("Esse é o menor caminho feito pelo algoritmo:" + resultado);
        
        System.out.println("Calculo distancias ");

        //mostra a distancia entre os pontos
        for (int i = 0; i < resultado.size(); i++) {
            //scape2
            if(i +1 >=  resultado.size())
                break;
            
            double totalDistancia = djkController.ObtemDistanciaEmKm(resultado.get(i).getCoordenadaX(),resultado.get(i).getCoordenadaY(),resultado.get(i + 1).getCoordenadaX(),resultado.get(i+1).getCoordenadaY());
            
            //imprime os dados do percurso
            new DadosPercursoPartial().ImprimeDadosPercurso(djkController.RealizaPercurso(totalDistancia),resultado.get(i).getDescricao(),resultado.get(i+1).getDescricao());
        }
    }
}
