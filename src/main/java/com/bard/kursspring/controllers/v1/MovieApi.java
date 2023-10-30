package com.bard.kursspring.controllers.v1;


import com.bard.kursspring.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieApi {


    private List<Movie> movieList;

    public MovieApi() {
        this.movieList = new ArrayList<>();
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {

        return new ResponseEntity<>(movieList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@Validated @RequestBody Movie newMovie) {
        if (newMovie == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.movieList.add(newMovie);

        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);

    }
}
