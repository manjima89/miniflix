package com.movies.controller;

import com.movies.entity.Movie;
import com.movies.repository.MovieRepository;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {

        if (movie.getId() == null ||
            movie.getTitle() == null || movie.getTitle().isBlank() ||
            movie.getRating() < 0 || movie.getRating() > 10) {

            return ResponseEntity.badRequest()
                    .body("Invalid movie data");
        }

        return new ResponseEntity<>(
                MovieRepository.add(movie),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovie(@PathVariable Long id) {

        Movie movie = MovieRepository.getById(id);

        if (movie == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Movie not found");
        }

        return ResponseEntity.ok(movie);
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return MovieRepository.getAll();
    }
}
