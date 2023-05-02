package dev.pranjal.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
// this will let framework know this class represnets
//each document in the movie collection
public class Movie {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @id
    //this movie module would be used to pull some data from the database
//    this will let the framework know that this prop should be treated as
//    a unique indetfier for each movie in the database
    private String id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;

    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference
    private List<Review> reviewIds;
//    all reviews against a movie will be added here
}
