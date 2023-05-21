package com.view;

import java.util.Scanner;

import com.controller.DVDController;
import com.model.DVD;

public class DVDView extends DVDController{
	
	public static boolean using = true;
	static String FILE_PATH = "dvdLibrary.txt";
	
    public static void homepage() {

        System.out.println("---------------------------------------------");
        System.out.println("Please choose one of the following and enter the corresponding number:");
        System.out.println("1. Add DVD"); 	
        System.out.println("2. List DVD");
        System.out.println("3. Search DVD");
        System.out.println("4. Save File");
        System.out.println("5. Load File");
        System.out.println("6. Exit");
        System.out.println("---------------------------------------------");

        Scanner in = new Scanner(System.in);

        int choice = in.nextInt();

        switch(choice) {
            case 1:
                addMovie();
                break;
            case 2:
                listMovie();
                break;
            case 3:
                searchMovie();
                break;
            case 4:
                saveFile();
                break;
            case 5:
                loadFile();
                break;
            case 6:
                quit();
                break;
            default:
                homepage();
        }
        
        
    }
    
    public static void addMovie() {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the movie's title:");
        String title = in.nextLine();
        System.out.println("Enter the movie's release date (ddmmyyyy):");
        int date = Integer.parseInt(in.nextLine());
        System.out.println("Enter the movie's MPAA rating:");
        String mpaa = in.nextLine();
        System.out.println("Enter the movie's director:");
        String director = in.nextLine();
        System.out.println("Enter the movie's studio:");
        String studio = in.nextLine();
        System.out.println("Enter your review:");
        String userRating = in.nextLine();
        addDVD(title, date, mpaa, director, studio, userRating);
        displayMovie(search(title));
    }
    
    public static void removeMovie(DVD dvd) {

        removeDVD(dvd);
        homepage();
    }
    
    public static void editMovie(DVD dvd) {

        Scanner in  = new Scanner(System.in);
        System.out.println("Enter Title or leave blank to skip");
        String title = in.nextLine();

        System.out.println("Enter Release Date or leave blank to skip");
        String date = in.nextLine();

        System.out.println("Enter MPAA or leave blank to skip");
        String mpaa = in.nextLine();

        System.out.println("Enter Director or leave blank to skip");
        String director = in.nextLine();

        System.out.println("Enter Studio or leave blank to skip");
        String studio = in.nextLine();

        System.out.println("Enter Review or leave blank to skip");
        String userRating = in.nextLine();

        editDVD(dvd, title, date, mpaa, director, studio, userRating);
        displayMovie(dvd);
    }
    
    public static void listMovie() {

        System.out.println("Here are all movie titles...");
        list();
        homepage();
    }
    
    public static void searchMovie() {

        System.out.println("Enter the movie's title");
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        System.out.println(title);
        DVD dvd = new DVD();
        try {
            dvd = search(title);
            displayMovie(dvd);
        } catch (Exception e) {
            System.out.println("Could not find movie");
            homepage();
        }

        System.out.println("---------------------------------------------");
        homepage();
    }
    
    
    public static void displayMovie(DVD dvd) {
    	System.out.println("---------------------------------------------");
        display(dvd);

        Scanner in = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("Would you like to edit or delete this movie?");
        System.out.println("1. Edit");
        System.out.println("2. Delete");
        System.out.println("3. Return to menu");
        System.out.println("---------------------------------");

        int choice = in.nextInt();
        switch(choice) {
            case 1:
                editMovie(dvd);
                break;
            case 2:
                removeMovie(dvd);
                break;
            case 3:
                homepage();

        }

    }
    
    public static void loadFile() {
        try {
            loadDvds();
        } catch(Exception e) {
            System.out.println("File not found");
        }
        homepage();
    }

    public static void saveFile() {
        save();
        homepage();
    }
    
    public static void quit() {
        System.out.println("Goodbye!");
        exit();
    }
    

}
