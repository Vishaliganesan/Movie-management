package com.example.demo.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie mv)
    {
        return this.movieService.addMovie(mv);
    }

    @GetMapping("/getMovie")
    public List<Movie> getMovie()
    {
        return this.movieService.getAllMovie();
    }

    @GetMapping("/getMovie/{id}")
    public Movie getMovieById(@PathVariable Long id)
    {
        return this.movieService.getMovieById(id);
    }

    @PutMapping("/updateMovie/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie)
    {
        return this.movieService.updateMovie(id, updatedMovie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public void deleteMovie(@PathVariable Long id)
    {
        this.movieService.deleteMovie(id);
    }
}
