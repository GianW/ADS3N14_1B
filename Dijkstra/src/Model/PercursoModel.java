package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riguel Figueiro
 */
public class PercursoModel {
    
    private VeiculoModel veiculo;
    private List<ParadaModel> paradas;
    private double TotalKmSeremPercorridos;

    public PercursoModel(double totalKmSeremPercorridos){
        this.veiculo = new VeiculoModel();
        this.paradas = new ArrayList<>();
        this.TotalKmSeremPercorridos = totalKmSeremPercorridos;
    }

    public double getTotalKmSeremPercorridos() {
        return TotalKmSeremPercorridos;
    }

    public void setTotalKmSeremPercorridos(double TotalKmSeremPercorridos) {
        this.TotalKmSeremPercorridos = TotalKmSeremPercorridos;
    }

    public VeiculoModel getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(VeiculoModel veiculo) {
        this.veiculo = veiculo;
    }

    public List<ParadaModel> getParadas() {
        return paradas;
    }

    public void setParadas(List<ParadaModel> paradas) {
        this.paradas = paradas;
    }
}
