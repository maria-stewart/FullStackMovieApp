package com.mariastewart.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.aggregation.SelectionOperators.First.first;

@Service
public class ReviewService {

    //insert review into the database
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate; //template used to form a dynamic query to do the job inside the database w/out using repo


    //associate review with one of the movies
    public Review createReview(String reviewBody, String imdbId) {
        //create new review in database
        //Repository works at the intermediate layer between the service class and the database
        Review review = reviewRepository.insert(new Review(reviewBody)); //when calling insert it will return the data just put inside the databased


        //update the movie associated with that review
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review; //return review that was just created

    }
}
