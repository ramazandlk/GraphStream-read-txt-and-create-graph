/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yazlab23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class Yazlab23 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String line;

        String[] dugum = null;
        String[] kenar = null;
        String kapasite = null;

        int sayac = 0;
        int say = 0;

        Graph graph = new MultiGraph("Tutorial 1");

        graph.addAttribute("ui.stylesheet", "node { size: 50px; fill-color: yellow, orange; fill-mode: gradient-horizontal; }");

        FileReader fileReader = new FileReader("C:\\Users\\RamazanDulek\\Desktop\\NetBeansProjects\\yazlab23\\source.txt");

        BufferedReader br = new BufferedReader(fileReader);

        while ((line = br.readLine()) != null) {

            if (sayac == 0) {
                dugum = line.split("-");
            }
            sayac++;
            line = br.readLine();
            if (sayac == 1) {

                kenar = line.split(",");

                for (int i = 0; i < kenar.length; i++) {
                    kapasite = kenar[i].substring(3, 5);
                    for (Node node : graph) {
                        node.addAttribute("ui.label", node.getId());

                    }
                    System.out.println(kapasite);
                }
            }

        }
        for (int a = 0; a < dugum.length; a++) {

            graph.addNode(dugum[a]);

        }

        for (int j = 0; j < kenar.length; j++) {

            graph.addEdge(kenar[j], kenar[j].substring(0, 1), kenar[j].substring(1, 2));//HARİKAYIMM

        }
        for (Node node : graph) {
            node.addAttribute("ui.label", node.getId());

        }
        br.close();

        graph.display();
    }
}
