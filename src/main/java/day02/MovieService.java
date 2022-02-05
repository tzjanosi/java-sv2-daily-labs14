package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {
    private List<Movie> movies=new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public List<Movie> getMoviesWithThisActor(String actor){
        return movies.stream()
                .filter(movie->(movie.getActors().stream().anyMatch(a->a.equals(actor))))
                .toList();
    }

    public int getLengthOfLongestMovie(){
        return movies.stream()
                .sorted(Comparator.comparing(movie->movie.getLength(),Comparator.reverseOrder()))
                .map(movie->movie.getLength())
                .findFirst().get();
    }

}
