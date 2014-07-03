package Service;

/**
 *
 * @author Riguel Figueiro
 */

import Model.GrafoModel;
import Model.VerticeModel;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

        // Atributos usados na funcao encontrarMenorCaminho

        // Lista que guarda os vertices pertencentes ao menor caminho encontrado
        List<VerticeModel> menorCaminho = new ArrayList<VerticeModel>();

        // Variavel que recebe os vertices pertencentes ao menor caminho
        VerticeModel verticeCaminho = new VerticeModel();

        // Variavel que guarda o vertice que esta sendo visitado
        VerticeModel atual = new VerticeModel();

        // Variavel que marca o vizinho do vertice atualmente visitado
        VerticeModel vizinho = new VerticeModel();

        // Lista dos vertices que ainda nao foram visitados
        List<VerticeModel> naoVisitados = new ArrayList<VerticeModel>();

        // Algoritmo de Dijkstra
        public List<VerticeModel> encontrarMenorCaminhoDijkstra(GrafoModel grafo, VerticeModel verticeOrigem,
                        VerticeModel verticeDestino) {

                // Adiciona a origem na lista do menor caminho
                menorCaminho.add(verticeOrigem);
 
                // Colocando a distancias iniciais
                for (int i = 0; i < grafo.getVertices().size(); i++) {

                        // VerticeModel atual tem distancia zero, e todos os outros,
                        // 9999("infinita")
                        if (grafo.getVertices().get(i).getDescricao()
                                        .equals(verticeOrigem.getDescricao())) {

                                grafo.getVertices().get(i).setDistancia(0);

                        } else {

                                grafo.getVertices().get(i).setDistancia(9999);
                        }
                        
                        // Insere o vertice na lista de vertices nao visitados
                        this.naoVisitados.add(grafo.getVertices().get(i));
                }

                Collections.sort(naoVisitados);

                // O algoritmo continua ate que todos os vertices sejam visitados
                while (!this.naoVisitados.isEmpty()) {

                        // Toma-se sempre o vertice com menor distancia, que eh o primeiro
                        // da
                        // lista

                        atual = this.naoVisitados.get(0);
                        System.out.println("Pegou esse vertice:  " + atual);
                        /*
                         * Para cada vizinho (cada aresta), calcula-se a sua possivel
                         * distancia, somando a distancia do vertice atual com a da aresta
                         * correspondente. Se essa distancia for menor que a distancia do
                         * vizinho, esta eh atualizada.
                         */
                        for (int i = 0; i < atual.getArestas().size(); i++) {

                                vizinho = atual.getArestas().get(i).getDestino();
                                System.out.println("Olhando o vizinho de " + atual + ": " + vizinho);
                                
                                //verifica se ja foi visitado
                                if (!vizinho.verificarVisita()) {
                                    
                                    double distanciaDoisPontos = this.CalcularDistanciaEntreDoisPontos(atual, vizinho);

                                        // Comparando a distância do vizinho com a possível
                                        // distância
                                        if (vizinho.getDistancia()  + distanciaDoisPontos > (atual.getDistancia() + atual.getArestas().get(i).getPeso())) {

                                                vizinho.setDistancia( (atual.getDistancia() + atual.getArestas().get(i).getPeso())  + distanciaDoisPontos);
                                                vizinho.setPai(atual);

                                                /*
                                                 * Se o vizinho eh o vertice procurado, e foi feita uma
                                                 * mudanca na distancia, a lista com o menor caminho
                                                 * anterior eh apagada, pois existe um caminho menor
                                                 * vertices pais, ateh o vertice origem.
                                                 */
                                                if (vizinho == verticeDestino) {
                                                        menorCaminho.clear();
                                                        verticeCaminho = vizinho;
                                                        menorCaminho.add(vizinho);
                                                        
                                                        while (verticeCaminho.getPai() != null) {

                                                                menorCaminho.add(verticeCaminho.getPai());
                                                                verticeCaminho = verticeCaminho.getPai();

                                                        }
                                                        
                                                        // Ordena a lista do menor caminho, para que ele
                                                        // seja exibido da origem ao destino.
                                                        Collections.sort(menorCaminho);
                                                }
                                        }
                                }

                        }
                        
                        // Marca o vertice atual como visitado e o retira da lista de nao
                        // visitados
                        atual.visitar();
                        this.naoVisitados.remove(atual);
                        
                        /*
                         * Ordena a lista, para que o vertice com menor distancia fique na
                         * primeira posicao - relaxamento
                         */
                        Collections.sort(naoVisitados);
                        System.out.println("Nao foram visitados ainda: " + naoVisitados);
                        
            }

                menorCaminho.add(0, verticeOrigem);
                return menorCaminho;
        }
        
        public static double CalcularDistanciaEntreDoisPontos(VerticeModel vA,VerticeModel vB){
             return sqrt( pow(vA.getCoordenadaX() - vB.getCoordenadaX(), 4) + pow(vA.getCoordenadaY() - vB.getCoordenadaY(), 4));
        }
}

