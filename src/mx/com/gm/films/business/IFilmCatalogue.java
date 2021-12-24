package mx.com.gm.films.business;

public interface IFilmCatalogue {
    
    String SOURCE_NAME = "Films.txt";
    
    void addFilm(String filmName);
    
    void listarPeliculas();
    
    void searchFilm(String search);
    
    void startFilmCatalogue();
    
    void restartFilmCatalogue();
}
