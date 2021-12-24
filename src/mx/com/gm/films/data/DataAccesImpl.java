package mx.com.gm.films.data;

import mx.com.gm.films.exceptions.DataAccessEx;
import mx.com.gm.films.exceptions.DataReadingEx;
import mx.com.gm.films.exceptions.DataWrittingEx;
import java.io.*;
import java.util.*;
import mx.com.gm.films.domain.Film;

public class DataAccesImpl implements IDataAcces{

    public DataAccesImpl(){
        
    }
    
    @Override
    public boolean exists(String fileName) { 
        File fileMade = new File(fileName);
        return fileMade.exists();
    }

    @Override
    public List<Film> listar(String fileName) throws DataWrittingEx{
        File fileMade = new File(fileName);
        List<Film> films = new ArrayList<>();
        try {
            var reading = new BufferedReader(new FileReader(fileMade));
            String line = reading.readLine();
            while(line != null){
                films.add(new Film(line));
                line = reading.readLine();
            }
            reading.close();
        } catch (FileNotFoundException ex) {
            throw new DataWrittingEx("Excepction : " + ex.getMessage());
        } catch (IOException ex) {
            throw new DataWrittingEx("Excepction: " + ex.getMessage());
        }
       return films;
    }

    @Override
    public void writes(Film film, String fileName, boolean append) throws DataReadingEx{
        File fileMade = new File(fileName);
        try {
            var exit = new PrintWriter(new FileWriter(fileMade,append));
            exit.println(film.toString());
            System.out.println("The film was add into the list: " + film.getNombre());
            exit.close();
        } catch (IOException ex) {
            throw new DataReadingEx("Excepcion al escribir peliculas: " + ex.getMessage());
        }
    }

    @Override
        public String searchs(String fileName, String search) throws DataWrittingEx{
        File fileMade = new File(fileName);
        String result = null;
        try {
            var reading = new BufferedReader(new FileReader(fileMade));
            String line = reading.readLine();
            int index = 1;
            while(line != null){
                if(search.equalsIgnoreCase(line)){
                    result = "Pelicula: " + line + ", encontrada en el indice: " + index;
                    break;
                }
                index++;
                line = reading.readLine();
            }
            reading.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new DataWrittingEx("Excepction: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataWrittingEx("Excepction: " + ex.getMessage());
        }
        return result;
    }

    @Override
    public void creates(String fileName) throws DataAccessEx{
        File fileMade = new File(fileName);
        try {
                var exit = new PrintWriter(fileMade);
                exit.close();   
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new DataAccessEx("Excepction: " + ex.getMessage());
            
        }     
    }

    @Override
    public void deletes(String fileName) {
        File fileMade = new File(fileName);
        if(fileMade.exists()){
            fileMade.delete();
        }
        else{
            System.out.println("NO EXISTE ARCHIVO INGRESADO.");
        }
    }
}
