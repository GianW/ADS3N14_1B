package Model;

/**
 *
 * @author Riguel Figueiro
 */

import java.util.ArrayList;
import java.util.List;

public class GrafoModel {

        private List<VerticeModel> grafo = new ArrayList<VerticeModel>();

        public void setVertices(List<VerticeModel> vertices) {

                this.grafo.addAll(vertices);
        }

        public void adicionarVertice(VerticeModel novoVertice) {

                this.grafo.add(novoVertice);
        }

        public List<VerticeModel> getVertices() {

                return this.grafo;
        }

        // Método que retorna o vértice cuja descrição é igual à procurada.
        public VerticeModel encontrarVertice(String nome) {

                for (int i = 0; i < this.getVertices().size(); i++) {

                        if (nome.equalsIgnoreCase(this.getVertices().get(i).getDescricao())) {

                                return this.getVertices().get(i);

                        }
                }

                return null;
        }
}

