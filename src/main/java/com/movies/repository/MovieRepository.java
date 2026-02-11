package com.movies.repository;

import com.movies.entity.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private static final List<Movie> movies = new ArrayList<>();

    public static Movie add(Movie movie) {
        movies.add(movie);
        return movie;
    }

    public static Movie getById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Movie> getAll() {
        return movies;
    }
}
