package com.example.demo.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

  @Autowired
  MovieRepository movieRepository;

  public Movie addMovie(Movie mv) {
    return movieRepository.save(mv);
  }

  public List<Movie> getAllMovie()
  {
    return movieRepository.findAll();
  }

  public Movie getMovieById(Long id)
  {
    return movieRepository.findById(id).orElse(null);
  }

  public Movie updateMovie(Long id, Movie updatedMovie)
  {
    Movie existingMovie = movieRepository.findById(id).orElse(null);
    if (existingMovie != null) {
      existingMovie.setId(updatedMovie.getId());
      existingMovie.setName(updatedMovie.getName());
      return movieRepository.save(existingMovie);
    }
    return null;
  }

  public void deleteMovie(Long id)
  {
    movieRepository.deleteById(id);
  }
}
