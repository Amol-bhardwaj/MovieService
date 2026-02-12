package com.AmyConnects.MovieService.Controller;

import com.AmyConnects.MovieService.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/{movieName}")
    public ResponseEntity<String> searchMovie(
            @PathVariable String movieName,
            @RequestParam String token) {

        String response = movieService.searchMovie(movieName, token);

        return ResponseEntity.ok(response);
    }
}
