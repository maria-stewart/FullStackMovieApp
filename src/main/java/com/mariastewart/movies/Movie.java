package com.mariastewart.movies;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data //takes care of all the getters and setters
@AllArgsConstructor
@NoArgsConstructor //constructors that takes no parameters
public class Movie {
    @Id //This will treat the ObjectId as a unique property in the database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres; //there can be multiple genres per one movie
    private List<String> backdrops; //will be used ih front end app
    @DocumentReference
    //cause database to only store the id's of the review-reviews will be in a separate collection-manual reference relationship
    private List<Review> reviewIds;

}
