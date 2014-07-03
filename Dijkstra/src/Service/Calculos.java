/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Enum.Enum.TipoParada;
import Model.ParadaModel;
import Model.VeiculoModel;
import java.util.List;

/**
 *
 * @author Riguel Figueiro
 */
public class Calculos {
    
    
    private final int tempoMaxSemParadas = 3; //H
    
    public int TotalDeParadas(double totalDeKm){
        
        return (int) Math.round(totalDeKm / tempoMaxSemParadas);
    }
    
    public double ConsumoAutomovel(double consumoVeiculo, double kmPercorridos){
        
        return kmPercorridos / consumoVeiculo;
    }
    
    public double TotalDeAutonomiaRestante(VeiculoModel veiculo){
        
        return veiculo.getCombustivelRestante() * veiculo.getConsumoCombustivel();
    }
    
    public int TotalParadasAbastecimento(List<ParadaModel> paradas){
        
        int total = 0;
        
        for (ParadaModel paradaModel : paradas) {
            if(paradaModel.getTipoParada().equals(TipoParada.Abastecimento))
                total++;
        }
        
        return total;
    }
    
    public int TotalParadasDescanso(List<ParadaModel> paradas){
        
        int total = 0;
        
        for (ParadaModel paradaModel : paradas) {
            if(paradaModel.getTipoParada().equals(TipoParada.Descanso))
                total++;
        }
        
        return total;
    }
    
    public int TotalParadasAbastecimentoDescanso(List<ParadaModel> paradas){
        
        int total = 0;
        
        for (ParadaModel paradaModel : paradas) {
            if(paradaModel.getTipoParada().equals(TipoParada.AbastecimentoDescanso))
                total++;
        }
        
        return total;
    }
}
