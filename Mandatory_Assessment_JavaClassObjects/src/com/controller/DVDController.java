package com.controller;

import java.awt.Desktop;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.model.DVD;
import com.view.DVDView;

public class DVDController {

    static ArrayList<DVD> dvds = new ArrayList<>();

    static String FILE = "dvdLibrary.txt";
    public static void main(String args[]) {

        try {
            loadDvds();
        } catch (Exception e) {
            System.out.println("File not loaded");
        }

        DVDView view = new DVDView();

        while(view.using) {
            view.homepage();
        }

        list();
        save();

    }

    public static void display(DVD dvd) {
        System.out.println("Title: " + dvd.getTitle());
        System.out.println("Release Date: " + dvd.getReleaseDate());
        System.out.println("MPAA: " + dvd.getMpAArating());
        System.out.println("Director: " + dvd.getDirectorName());
        System.out.println("Studio: " + dvd.getStudioName());
        System.out.println("User Review: " + dvd.getUserRating());
    }

    public static void list() {

        for (DVD dvd : dvds) {
            System.out.println(dvd.getTitle());
        }
    }

    public static DVD search(String title) {
        for (DVD dvd : dvds) {
            if (title.equalsIgnoreCase(dvd.getTitle())) {
                return dvd;
            }
        }

        return null;
    }

    public static void addDVD(String title, int date, String mpaa, String director, String studio, String userRating) {
        if (!dupCheck(title)) {
            DVD dvd = new DVD(title, date, mpaa, director, studio, userRating);
            dvds.add(dvd);
            save();
        } else {
            System.out.println("Film already in list");
        }
    }

    public static void removeDVD(DVD dvd) {
        System.out.println("Deleting " + dvd.getTitle());
        dvds.remove(dvd);
    }

    public static void editDVD(DVD dvd, String title, String date, String mpaa, String director, String studio, String userRating) {

        if (!title.equals("")) {
            dvd.setTitle(title);
        }

        if (!date.equals("")) {
            dvd.setReleaseDate(Integer.parseInt(date));
        }

        if (!mpaa.equals("")) {
            dvd.setMpAArating(mpaa);
        }

        if (!director.equals("")) {
            dvd.setDirectorName(director);
        }

        if (!studio.equals("")) {
            dvd.setStudioName(studio);
        }

        if (!userRating.equals("")) {
            dvd.setUserRating(userRating);
        }
        save();
    }

    public static void loadDvds() throws FileNotFoundException {
        System.out.println("Loading from " + FILE);
        File txt = new File(FILE);

        Scanner loader = new Scanner(txt);
        
        

        ArrayList<DVD> dvdss = new ArrayList<>();

        while (loader.hasNextLine()) {
            String line = loader.nextLine();

            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            String title = lineScanner.next();
            int date = lineScanner.nextInt();
            String mpaa = lineScanner.next();
            String director = lineScanner.next();
            String studio = lineScanner.next();
            try {
                String userRating = lineScanner.next();
                DVD dvd = new DVD(title, date, mpaa, director, studio, userRating);
                dvdss.add(dvd);
                
            } catch(Exception e) {
                DVD dvd = new DVD(title, date, mpaa, director, studio);
                dvdss.add(dvd);
            }
           
        }

        dvds = dvdss;
        Desktop desktop = Desktop.getDesktop();
        if(txt.exists())
			try {
				desktop.open(txt);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        

    }

    public static void save() {
        System.out.println("Saving...");
        try {
            FileWriter writer = new FileWriter(FILE);

            for (DVD dvd : dvds) {
                String inputDvd = dvd.getTitle() + "," + Integer.toString(dvd.getReleaseDate()) + "," +
                        dvd.getMpAArating() + "," + dvd.getDirectorName() + "," +
                        dvd.getStudioName() + "," + dvd.getUserRating();
                writer.write(inputDvd);
                writer.write("\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("File not saved");
        }
    }

    public static boolean dupCheck(String title) {

        for (DVD dvd : dvds) {
            if (dvd.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }

        return false;
    }

    public static void setFile(String path) {
        FILE = path;
    }
    public static void exit() {
        System.exit(0);
    }

}