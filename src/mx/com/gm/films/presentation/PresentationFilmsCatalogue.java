package mx.com.gm.films.presentation;

import mx.com.gm.films.business.*;
import java.util.Scanner;

public class PresentationFilmsCatalogue {
    public static void main(String[] args) {
        int option = 0;
        String filmName;
        IFilmCatalogue catalogue = new FilmCatalogueImpl();
        var scanner = new Scanner(System.in);
       
        do{
            System.out.println("           MENU\n"
                            +".................................\n"
                            +"1. Options catalogue´film´s menu.\n"
                            +"2. Add film\n"
                            +"3. Show films\n"
                            +"4. Search film\n"
                            +"0. Exit\n"
                            + "Choose an option\n");
            option = Integer.parseInt(scanner.nextLine());
                switch(option){
                    case 1:
                        do{
                        System.out.println("1. Start film´s catalogue.\n"
                                          +"2. Restart film´s catalogue.\n"
                                          +"3. Exit.\n"
                                          +"Choose an option\n");
                        option = Integer.parseInt(scanner.nextLine());
                            switch(option){
                                case 1:
                                    catalogue.startFilmCatalogue();
                                    break;
                                case 2:
                                    catalogue.restartFilmCatalogue();
                                    break;
                                case 3:
                                    System.out.println("Out from catalogue´film´s menu.\n");
                                    break;
                                default:
                                    System.out.println("ERROR: Wrong option.\n");
                                    break;
                            }
                        }while(option != 3);
                        
                        break;
                    case 2:
                        System.out.println("Write your film´s name: ");
                        filmName = scanner.nextLine();                               
                        catalogue.addFilm(filmName);
                        break;
                    case 3:
                        catalogue.listarPeliculas();
                        break;
                    case 4:
                        System.out.println("Write your film´s name: ");
                        filmName = scanner.nextLine();
                        catalogue.searchFilm(filmName);
                        break;
                    case 0:
                        System.out.println("GOODBYE!");
                        break;
                    default:
                        System.out.println("ERROR: Wrong option.");
                }
        }while(option != 0);

    }
}
