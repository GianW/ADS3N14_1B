package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riguel Figueiro
 */
public class VerticeModel implements Comparable<VerticeModel>{
        
        private double coordenadaX , coordenadaY;
        private String descricao;
        private double distancia;
        private boolean visitado = false;
        private VerticeModel pai;
        private List<ArestaModel> arestas = new ArrayList<ArestaModel>();
        private List<VerticeModel> vizinhos = new ArrayList<VerticeModel>();

        public double getCoordenadaX() {
            return coordenadaX;
        }

        public void setCoordenadaX(double coordenadaX) {
            this.coordenadaX = coordenadaX;
        }

        public double getCoordenadaY() {
            return coordenadaY;
        }

        public void setCoordenadaY(double coordenadaY) {
            this.coordenadaY = coordenadaY;
        }

        public boolean isVisitado() {
            return visitado;
        }

        public void setVisitado(boolean visitado) {
            this.visitado = visitado;
        }
        
        public void setDescricao(String nome){
                
                this.descricao = nome;
        }
        
        public String getDescricao(){
                
                return descricao;
        }
        
        public void visitar (){
                
                this.visitado = true;
        }
        
        public boolean verificarVisita(){
                
                return visitado;
        }
        
        public void setDistancia(double distancia){
                
                this.distancia = distancia;
        }
        
        public double getDistancia(){
                
                return this.distancia;
        }
        
        public void setPai(VerticeModel pai){
                
                this.pai = pai;
        }
        
        public VerticeModel getPai(){
                
                return this.pai;
        }

        public void setVizinhos(List<VerticeModel> vizinhos) {
                
                this.vizinhos.addAll(vizinhos);
                                
        }
        
        public List<VerticeModel> getVizinhos(){
                
                return this.vizinhos;
        }
        
        public void setArestas(List <ArestaModel> arestas){
                
                this.arestas.addAll(arestas);
                
        }
        
        public List<ArestaModel> getArestas() {
                
                return arestas;
        }

        public int compareTo(VerticeModel vertice) {
                  if(this.getDistancia() < vertice.getDistancia()) return -1;
          else if(this.getDistancia() == vertice.getDistancia()) return 0;
          
          return 1;

                
        }
        
        @Override
        public boolean equals(Object obj) {
                if(obj instanceof VerticeModel){
                        VerticeModel vRef = (VerticeModel) obj;
                        if(this.getDescricao().equals(vRef.getDescricao())) return true;
                }
                return false;
        }
        
        @Override
        public String toString() {
                String s = " ";
                s+= this.getDescricao();
                return s;
        }
        
        
        
        
}
