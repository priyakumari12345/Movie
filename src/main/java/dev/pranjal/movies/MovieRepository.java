package dev.pranjal.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//repository are of type interface\
// it is the data access layer of the api
//it does the job talking to the database and getting the database back
//we have the list of movies in the database
//
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //data we will be dealing with movie, object id
    Optional<Movie> findMovieByImdbId(String imdbId);
}
