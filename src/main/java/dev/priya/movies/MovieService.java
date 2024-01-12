package dev.priya.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    //we will write db access methods here
    //reference of repository
    @Autowired
    //this will let the framework know to instantiate the below class
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
    return movieRepository.findAll();
    };//this findall is defined in movierepo class
    public  Optional<Movie> singleMovie(String imdbId){
        return movieRepository.findMovieByImdbId(imdbId);
        }//optional means that if the id is not found then it may return null

    }
}
