package Service;

import Enum.Enum.TipoParada;
import Model.ParadaModel;
import Model.PercursoModel;
import Model.VeiculoModel;

/**
 *
 * @author DKO
 */
public class Viagem {
    
    private final int tempoMaxSemParadas = 3; //H
    private final int kmMaxSemDescanso = 240;//km
    
    public PercursoModel RealizaPercurso(PercursoModel percurso){
        
        ParadaModel parada;
        Calculos calc = new Calculos();
        boolean continuarPercurso = true;
        
        //verifica se o tanque nao esta completo assim completa para um novo inicio de percurso
        if(!percurso.getVeiculo().getTanqueCheio()){
            parada = new ParadaModel();
            parada.setTipoParada(TipoParada.AbastecimentoDescanso);
            percurso.getParadas().add(parada);
        }
        
        while (continuarPercurso) {
            
            if(percurso.getTotalKmSeremPercorridos() > 0){
                
                parada = new ParadaModel();
                
                //parada de descanso se tive combustivel suficiente até a km permitida na direção
                if(percurso.getVeiculo().getCombustivelRestante() > calc.ConsumoAutomovel(percurso.getVeiculo().getConsumoCombustivel(), kmMaxSemDescanso)){
                    
                    parada.setTipoParada(TipoParada.Descanso);
                    percurso.getVeiculo().setCombustivelRestante(calc.ConsumoAutomovel(percurso.getVeiculo().getConsumoCombustivel(), kmMaxSemDescanso));
                    percurso.setTotalKmSeremPercorridos(percurso.getTotalKmSeremPercorridos() - kmMaxSemDescanso);
                }
                //parada de abastecimento
                else if(percurso.getTotalKmSeremPercorridos() > calc.TotalDeAutonomiaRestante(percurso.getVeiculo())){

                    parada.setTipoParada(TipoParada.Abastecimento);
                    
                    //desconto os km que poderiam sem percorridos
                    percurso.setTotalKmSeremPercorridos(percurso.getTotalKmSeremPercorridos() - calc.TotalDeAutonomiaRestante(percurso.getVeiculo()));
                    
                    // instancia um novo veiculo pois o mesmo ja vem reabastecido
                    percurso.setVeiculo(new VeiculoModel());
                }
                else{
                    
                    percurso.setTotalKmSeremPercorridos(0);
                    percurso.getVeiculo().setCombustivelRestante(calc.ConsumoAutomovel(percurso.getVeiculo().getConsumoCombustivel(),percurso.getTotalKmSeremPercorridos()));
                    continuarPercurso = false;
                }
            }
            else{
                percurso.setTotalKmSeremPercorridos(0);
                break;
            }
            
            if(parada.getTipoParada() != null)
                percurso.getParadas().add(parada);
        }
        
        return percurso;
    }
}
