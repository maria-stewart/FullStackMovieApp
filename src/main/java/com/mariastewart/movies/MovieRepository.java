package com.mariastewart.movies;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//talks to the database to get the data back
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    //method to search for the imdbId
    Optional<Movie> findMovieByImdbId(String imdbId);
}
