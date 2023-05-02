package dev.pranjal.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;//for associating the review with the movie
    //template is also a way to talk to the DB//can be used to insert data in db using query without using repository
    public Review createReview(String reviewBody, String imdbId){//here we ll first look for the movie with tyhe given imdbid then
        //then we will create a new review associate the review with the found movie
        Review review = reviewRepository.insert(new Review(reviewBody));//creating new review

        reviewRepository.insert(review);//inserting in DB
        mongoTemplate.update(Movie.class)//updatinf the array of review ids
                .matching(Criteria.where("imdbId").is(imdbId))//updating the imdb id in the db which we got from the user
                .apply(new Update().push("reviewIds").value(review));
        .first();//to make sure we are getting single movie and we are updating that
        return review

    }
}
