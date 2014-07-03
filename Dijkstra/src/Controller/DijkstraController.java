/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import static App.Main.EARTH_RADIUS_KM;
import Model.GrafoModel;
import Model.PercursoModel;
import Model.VerticeModel;
import Service.Arquivo;
import Service.Dijkstra;
import Service.GeoUtils;
import Service.Viagem;
import java.util.List;

/**
 *
 * @author Riguel Figueiro
 */
public class DijkstraController {
    
    public List<VerticeModel> ObterMenorCaminho(GrafoModel grafo, VerticeModel verticeOrigem,
                        VerticeModel verticeDestino) {
        
        return new Dijkstra().encontrarMenorCaminhoDijkstra(grafo, verticeOrigem, verticeDestino);
    }
    
    public List<VerticeModel> ObtemVertices(){
        
        return new Arquivo().GetVertices();
    }
    
    public double ObtemDistanciaEmKm(double firstLatitude,
			double firstLongitude, double secondLatitude, double secondLongitude) {

        return new GeoUtils().geoDistanceInKm(firstLatitude, firstLongitude, secondLatitude, secondLongitude);
    }
    
    public PercursoModel RealizaPercurso(double totalKmASeremPercorridos){

        return new Viagem().RealizaPercurso(new PercursoModel(totalKmASeremPercorridos));
    }
}
