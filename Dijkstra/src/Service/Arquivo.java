/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;

import Model.VerticeModel;
import Model.ArestaModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Riguel Figueiro
 */
public class Arquivo {
    public List<VerticeModel> GetVertices() {

                List<VerticeModel> listaVertices = new ArrayList<VerticeModel>();
                List<ArestaModel> listaArestas = new ArrayList<ArestaModel>();
                File f = new File(new File(".").getAbsolutePath()+ "/src/service/" + "grafo.txt");
                String dadosLiha[];
                String linha;

                try {
                        BufferedReader br = new BufferedReader(new FileReader(f));

                        //monta lista de vertices 
                        while (!(linha = br.readLine()).equals("arestas")) {
                            
                            if(linha.equals("vertices"))
                                linha = br.readLine();
                            
                            dadosLiha = linha.split(" ");
                            VerticeModel v = new VerticeModel();
                            v.setDescricao(dadosLiha[0]);
                            v.setCoordenadaX(Double.parseDouble(dadosLiha[1]));
                            v.setCoordenadaY(Double.parseDouble(dadosLiha[2]));
                            
                            listaVertices.add(v);
                        }
                        
                        //monta lista de arestas
                        while ((linha = br.readLine()) != null) {
                            
                            dadosLiha = linha.split(" ");
                            ArestaModel a = new ArestaModel(listaVertices.get(Integer.parseInt(dadosLiha[0])), listaVertices.get(Integer.parseInt(dadosLiha[1])));
                            listaArestas.add(a);
                        }
                        
                        //busca todas as arestas do vertice
                        for (VerticeModel v  : listaVertices) {
                        
                            List<ArestaModel> listaArestasVertice = new ArrayList<ArestaModel>();
                            
                            for (ArestaModel a  : listaArestas) {
                                if(a.getOrigem().getDescricao().equals(v.getDescricao()))
                                    listaArestasVertice.add(a);
                            }
                            
                            if(listaArestasVertice.size() > 0)
                                v.setArestas(listaArestasVertice);
                        }

                        // catch do BufferedReader
                } catch (FileNotFoundException e) {
                        System.out.println("Nao encontrou o arquivo");
                        e.printStackTrace();
                }
                // catch do readLine
                catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
                //Retornando os vertices
                return listaVertices;
        }
    
    
}
