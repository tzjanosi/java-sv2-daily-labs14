package day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {
    MovieService movieService;

    @BeforeEach
    void init() {
        movieService = new MovieService();

        Movie m1 = new Movie("Mielött befejezi a denevér a röptét", 95,new ArrayList<>(Arrays.asList("Scherer Péter","Nagy-Kálózy Eszter","Rudolf Péter","Eperjes Károly","Klaus Maria Brandauer","Cserhalmi György")));
        Movie m2 = new Movie("Pad a parkban",90,new ArrayList<>(Arrays.asList("Bánsági Ildikó","Mucsi Zoltán","Szőke Andrés","Badár Sándor","Cserhalmi György")));
        Movie m3 = new Movie("Köszi a csokit", 96,new ArrayList<>(Arrays.asList("Andorai Péter","Pap Vera","Eperjes Károly","Szirtes Ági","Gáspár Sándor")));
        Movie m4 = new Movie("Ház a sziklák alatt", 101,new ArrayList<>(Arrays.asList("Görbe János","Psota Irén","Szirtes Ádám")));
        Movie m5 = new Movie("Egészséges erotika", 89,new ArrayList<>(Arrays.asList("Rajhona Ádám","Koltai Róbert","Scherer Péter","Szirtes Ádám")));


        movieService.addMovie(m1);
        movieService.addMovie(m2);
        movieService.addMovie(m3);
        movieService.addMovie(m4);
        movieService.addMovie(m5);

    }

    @Test
    void filterToActorTest(){
        List<Movie> result = movieService.getMoviesWithThisActor("Scherer Péter");
        assertEquals(2,result.size());
        result = movieService.getMoviesWithThisActor("Johny Deep");
        assertEquals(0,result.size());
        result = movieService.getMoviesWithThisActor("Klaus Maria Brandauer");
        assertEquals(1,result.size());
        result = movieService.getMoviesWithThisActor("Szirtes Ádám");
        assertEquals(2,result.size());
    }

    @Test
    void maxLengthTest(){
        assertEquals(101,movieService.getLengthOfLongestMovie());
    }
}