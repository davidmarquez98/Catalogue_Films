package mx.com.gm.films.data;

import mx.com.gm.films.exceptions.DataAccessEx;
import mx.com.gm.films.exceptions.DataReadingEx;
import mx.com.gm.films.exceptions.DataWrittingEx;
import java.util.List;
import mx.com.gm.films.domain.Film;

public interface IDataAcces {
    boolean exists(String nameFile) throws DataAccessEx;
    
    List<Film> listar(String nameFile) throws DataWrittingEx;
    
    void writes(Film film,String nameFile,boolean append) throws DataReadingEx;
    
    String searchs(String nombreArchivo,String buscar) throws DataWrittingEx;
    
    void creates(String nameFile) throws DataAccessEx;
    
    void deletes(String nameFile) throws DataAccessEx;
}
