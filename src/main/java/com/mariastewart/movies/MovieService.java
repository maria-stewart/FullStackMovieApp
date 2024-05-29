package com.mariastewart.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Class uses the Repository class and talks to the database to get the list of the movies
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    //database access methods
    @Autowired //lets the framework know to substantiate the below class for us-initialize for us
    private MovieRepository movieRepository; //reference of the repo
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    //method to search a movie by its imdbId
    public Optional<Movie> singleMovie(String imdbId) {
     //note that this may not find a movie thus we need to tell it that it can return null if the movie is not found
        return movieRepository.findMovieByImdbId(imdbId);

    }
}
