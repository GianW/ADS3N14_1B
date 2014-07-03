/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author DKO
 */
public class ArestaModel {
    
     private double peso;
        private VerticeModel origem;
        private VerticeModel destino;

        public ArestaModel(VerticeModel v1, VerticeModel v2) {

                this.peso = 1;
                this.origem = v1;
                this.destino = v2;
        }

        public void setPeso(int novoPeso) {

                this.peso = novoPeso;
        }

        public double getPeso() {

                return peso;
        }

        public void setDestino(VerticeModel destino) {
                this.destino = destino;
        }

        public VerticeModel getDestino() {
                return destino;
        }

        public void setOrigem(VerticeModel origem) {
                this.origem = origem;
        }

        public VerticeModel getOrigem() {
                return origem;
        }
}
