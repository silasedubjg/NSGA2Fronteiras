/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cefronteira;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class CEfronteira {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<solucaoCandidata> solucoes = new ArrayList<solucaoCandidata>();
        ArrayList<solucaoCandidata> primeirafront = new ArrayList<solucaoCandidata>();

        solucaoCandidata A = new solucaoCandidata(1, 5, "A");
        solucaoCandidata B = new solucaoCandidata(2, 3, "B");
        solucaoCandidata C = new solucaoCandidata(4, 1, "C");
        solucaoCandidata D = new solucaoCandidata(3, 4, "D");
        solucaoCandidata E = new solucaoCandidata(4, 3, "E");
        solucaoCandidata F = new solucaoCandidata(5, 5, "F");

        System.out.println("");

        solucoes.add(A);
        solucoes.add(B);
        solucoes.add(C);
        solucoes.add(D);
        solucoes.add(E);
        solucoes.add(F);

        for (int i = 0; i < solucoes.size(); i++) {

            solucoes.get(i).rank = 0;
            solucoes.get(i).np = 0;

            for (int j = 0; j < solucoes.size(); j++) {

                if (i != j) {

                    if (solucoes.get(j).f1 >= solucoes.get(i).f1 && solucoes.get(j).f2 >= solucoes.get(i).f2) {

//                       System.out.print(solucoes.get(i).Nome);
//                       System.out.print(" ");
//                       System.out.print(solucoes.get(j).Nome);
//                       System.out.println("");
                        solucoes.get(i).Sp.add(solucoes.get(j));

                    } else if (solucoes.get(j).f1 <= solucoes.get(i).f1 && solucoes.get(j).f2 <= solucoes.get(i).f2) {

                        solucoes.get(i).np = solucoes.get(i).np + 1;
                    }
                }
            }

            if (solucoes.get(i).np == 0) {
                solucoes.get(i).rank = 1;
                primeirafront.add(solucoes.get(i));
            }

        }

        System.out.println("Primeira Fronteira");
        for (int i = 0; i < primeirafront.size(); i++) {

            System.out.print(primeirafront.get(i).Nome + "   ");
        }

        System.out.println("");

//        dominancia da primeira fronteira e rank 
//        for (int i = 0; i < primeirafront.size(); i++) {
//            
//           System.out.println(solucoes.get(i).rank);
//           System.out.println(solucoes.get(i).np);
//            System.out.println("aqui");
//            for (int j = 0; j < solucoes.get(i).Sp.size(); j++) {
//                
//                System.out.print(solucoes.get(i).Sp.get(j));
//            }
//            
//            System.out.println("");
//            
//        }
        ArrayList<ArrayList<solucaoCandidata>> fronteiras = new ArrayList<>();
        fronteiras.add(primeirafront);

        int i = 1;

        while (!primeirafront.isEmpty()) {

            ArrayList<solucaoCandidata> Q = new ArrayList<solucaoCandidata>();

            for (int j = 0; j < primeirafront.size(); j++) {

                for (int k = 0; k < primeirafront.get(j).Sp.size(); k++) {

                    primeirafront.get(j).Sp.get(k).np = primeirafront.get(j).Sp.get(k).np - 1;

                    if (primeirafront.get(j).Sp.get(k).np == 0) {
                        primeirafront.get(j).Sp.get(k).rank = i + 1;
                        Q.add(primeirafront.get(j).Sp.get(k));
                    }

                }
            }

            fronteiras.add(Q);
            System.out.println("fronteira n: " + (i + 1));
            for (int j = 0; j < Q.size(); j++) {

                System.out.print(Q.get(j).Nome + "  ");

            }
            System.out.println("");
            i = i + 1;
            primeirafront = Q;
        }
    }
}