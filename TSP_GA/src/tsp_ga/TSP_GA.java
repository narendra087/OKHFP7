/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp_ga;

 import java.io.File;
 import java.io.FileNotFoundException;
 import java.util.Scanner;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import java.util.ArrayList;

/**
 *
 * @author umarr
 */
public class TSP_GA {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String fileName = "D:\\ITS\\SI\\sem7\\OKH\\FP\\datasets\\hiddeninstance1.csv";
        //untuk data bisa small1, small2, medium1, medium2, big1, big2, hiddeninstance1, hiddeninstance2
        
        File file = new File(fileName); // TODO: read about File Names
        try {
            Scanner inputStream = new Scanner(file);
            //buat array
            int isi=inputStream.nextInt();
            City a[]=new City[isi];
            //get size array
            int  index=0;
            while (inputStream.hasNext()){
                String b=inputStream.next();
                String array1[]= b.split(",");
                

                a[index]=new City(index, Integer.parseInt(array1[0]),Integer.parseInt(array1[1]));
                TourManager.addCity(a[index]);
                index++;
            /*    String data = inputStream.next();
                System.out.println(data); */
            //masukin data ke array
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Create and add our cities
       /* City city = new City(60, 200);
        TourManager.addCity(city);
        City city2 = new City(180, 200);
        TourManager.addCity(city2);
        City city3 = new City(80, 180);
        TourManager.addCity(city3);
        City city4 = new City(140, 180);
        TourManager.addCity(city4);
        City city5 = new City(20, 160);
        TourManager.addCity(city5);
        City city6 = new City(100, 160);
        TourManager.addCity(city6);
        City city7 = new City(200, 160);
        TourManager.addCity(city7);
        City city8 = new City(140, 140);
        TourManager.addCity(city8);
        City city9 = new City(40, 120);
        TourManager.addCity(city9);
        City city10 = new City(100, 120);
        TourManager.addCity(city10);
        City city11 = new City(180, 100);
        TourManager.addCity(city11);
        City city12 = new City(60, 80);
        TourManager.addCity(city12);
        City city13 = new City(120, 80);
        TourManager.addCity(city13);
        City city14 = new City(180, 60);
        TourManager.addCity(city14);
        City city15 = new City(20, 40);
        TourManager.addCity(city15);
        City city16 = new City(100, 40);
        TourManager.addCity(city16);
        City city17 = new City(200, 40);
        TourManager.addCity(city17);
        City city18 = new City(20, 20);
        TourManager.addCity(city18);
        City city19 = new City(60, 20);
        TourManager.addCity(city19);
        City city20 = new City(160, 20);
        TourManager.addCity(city20);
        */
       
        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        int Generation = 50;
        for (int i = 0; i < Generation; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println("Running Time: " + time + " Milisecond");
    }
}
