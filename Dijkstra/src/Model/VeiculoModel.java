/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Riguel Figueiro
 */
public class VeiculoModel {
    
    private final int consumoCombustivel = 15; //k/L
    private final int autonomiaAutomovel = 600; //km
    private final int velocidadeMedia = 80; //km/H
    private double combustivelRestante = 0;
    private boolean tanqueCheio;

    public VeiculoModel(){
        //inicia veiculo com o tanque de combustivel cheio
        this.combustivelRestante = autonomiaAutomovel / consumoCombustivel;
    }
    
    public int getConsumoCombustivel() {
        return consumoCombustivel;
    }

    public int getAutonomiaAutomovel() {
        return autonomiaAutomovel;
    }

    public int getVelocidadeMedia() {
        return velocidadeMedia;
    }
   

    public double getCombustivelRestante() {
        return combustivelRestante;
    }

    public void setCombustivelRestante(double combustivelRestante) {
        this.combustivelRestante = combustivelRestante;
    }
    
    public boolean getTanqueCheio() {
        return !(this.getCombustivelRestante() < (this.autonomiaAutomovel / this.consumoCombustivel));
    }
}
