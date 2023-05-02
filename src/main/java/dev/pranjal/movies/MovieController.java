package dev.pranjal.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private MovieService MovieService;
     @GetMapping
    public ResponseEntity<List<Movie>> getallMovies(){// this is gettimg a request from the user
        return new ResponseEntity<List<Movie>>(MovieService.allMovies(), HttpStatus.OK);// tyhis is returning a response to the user
//HttpStatus.OK this means 200 response code check on terminal/we want rest api to return proper status codes
        //.all movies //get all movies from the db and return req on tha page with ok status
         @GetMapping("/{imdbId}")//trying to search movie by id
                public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
            return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK));
         }
    }
}
