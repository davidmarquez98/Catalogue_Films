package mx.com.gm.films.business;

import mx.com.gm.films.exceptions.DataAccessEx;
import mx.com.gm.films.exceptions.DataWrittingEx;
import mx.com.gm.films.data.*;
import java.util.List;
import mx.com.gm.films.domain.Film;

public class FilmCatalogueImpl implements IFilmCatalogue{

    private final IDataAcces data;
    
    public FilmCatalogueImpl(){
        this.data = new DataAccesImpl();
    }
    
    @Override
    public void addFilm(String filmName) {
        Film film = new Film(filmName);
        boolean append = false;
        try {
            append = data.exists(SOURCE_NAME);
            data.writes(film,SOURCE_NAME,append);
        } catch (DataAccessEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        int index = 1;
        try {
            List<Film> films = data.listar(SOURCE_NAME);
            if(!films.isEmpty())
            {
                System.out.println("        FILMS");
                System.out.println("--------------------------");
                for(Film film:films){
                    System.out.println(+ index + ". " + film + "\n");
                    index++;
                }
            }
            else{
                System.out.println("ERROR: There isn´t any film.\n");
            }
        } catch (DataWrittingEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void searchFilm(String search) {
        try {
            String text = data.searchs(SOURCE_NAME, search);
            if(text != null)
            {
                System.out.println(text);
            }
            else{
                System.out.println("ERROR: Wrong film add.\n");
            }
        } catch (DataWrittingEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void startFilmCatalogue() {
        try {
            if(!data.exists(SOURCE_NAME)){
                data.creates(SOURCE_NAME);
                System.out.println("FILMS´S CATALOGUE STARTED.\n");
            }
            else{
                System.out.println("ERROR: FILM´S CATALOGUE EXIST.\n");
            }
        } catch (DataAccessEx ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void restartFilmCatalogue() {
        try {
            if(data.exists(SOURCE_NAME)){
                data.deletes(SOURCE_NAME);
                data.creates(SOURCE_NAME);
                System.out.println("FILMS´S CATALOGUE RESTARTED.\n");
            }
            else{
                System.out.println("ERROR: FILM´S CATALOGUE UNEXIST.\n");
            }
        } catch (DataAccessEx ex) {
            ex.printStackTrace();
        }
    }
    
}
