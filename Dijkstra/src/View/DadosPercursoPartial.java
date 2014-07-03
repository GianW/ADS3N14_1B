package View;

import Model.PercursoModel;
import Service.Calculos;

/**
 *
 * @author Riguel
 */
public class DadosPercursoPartial {
    
    public void ImprimeDadosPercurso(PercursoModel model,String descricaoOrigem,String descricaoDestino){
        
        System.out.println("==================| Dados do percurso |============================");
        System.out.println();
        System.out.println(" Ponto de origem - destino                      : " + descricaoOrigem +" - "+ descricaoDestino);
        System.out.println(" Total de paradas                               : " + model.getParadas().size());
        System.out.println(" Total de paradas com abastecimento             : " + new Calculos().TotalParadasAbastecimento(model.getParadas()));
        System.out.println(" Total de paradas para descanso                 : " + new Calculos().TotalParadasDescanso(model.getParadas()));
        System.out.println(" Combustível restante                           : " + model.getVeiculo().getCombustivelRestante());
        System.out.println();
        System.out.println("===================================================================");
    }
}
