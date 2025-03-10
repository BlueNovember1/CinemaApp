package com.example.backend.controller;

import com.example.backend.model.cinema.Movie;
import com.example.backend.service.MovieService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "https://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;
    // wstrzykuje instancje
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    // Żądanie GET, zwraca film po danym id
    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getById(id);
    }
    // Pobranie każdego wszytkich filmów
    @GetMapping("")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
