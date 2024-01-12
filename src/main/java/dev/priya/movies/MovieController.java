package dev.priya.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
// there are multiple layers in rest api in which one of the layer
//is this controller
//this is a restapi controller in which we will write API
 @RestController//
@RequestMapping("api.v1/movies")//not mapping it to localhost 8080
 // any request on the above address will be handled by the above controller
 //url would be  localhost:8080/api/v1/movies
public class MovieController {
     //reference to movie service class--down
     @Autowired
    private MovieService movieService;
    //we will write db access methods here
    //reference of repository
    @Autowired
    //this will let the framework know to instantiate the below class
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        return movieRepository.findAll();}
    //this findall is defined in movierepo class
        public  Optional<Movie> singleMovie(String imdbId){
            return movieRepository.findMovieByImdbId(imdbId);
        }//optional means that if the id is not found then it may return null

 }

