import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button,styled } from '@mui/material';

export default function Movie() {
  const paperStyle = { padding: '50px 20px', width: 600, margin: '20px auto' };
  const [id, setId] = useState('');
  const [name, setName] = useState('');
  const [movies, setMovies] = useState([]);

  const handleClick = (e) => {
    e.preventDefault();
    const movie = { id, name };
    console.log(movie);

    fetch("http://localhost:8080/movie/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(movie),
    })
      .then(() => {
        console.log("New Movie Added");
      })
      .catch((error) => {
        console.error("Error adding movie:", error);
      });
  };

  useEffect(() => {
    fetch("http://localhost:8080/movie/getMovie")
      .then((res) => res.json())
      .then((result) => setMovies(result));
  }, []);

  return (
    <Container>
      <h1 style={{ color: 'blue' }}>
        <u>Add Movie</u>
      </h1>
      <Paper elevation={3} style={paperStyle}>
        <Box
          component="form"
          sx={{
            '& > :not(style)': { m: 1 },
          }}
          noValidate
          autoComplete="off"
        >
          <TextField
            id="standard-basic"
            label="Movie Id"
            variant="standard"
            fullWidth
            value={id}
            onChange={(e) => setId(e.target.value)}
          />
          <TextField
            id="standard-basic"
            label="Movie Name"
            variant="standard"
            fullWidth
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <Button variant="contained" disableElevation onClick={handleClick}>
            Submit
          </Button>
        </Box>
      </Paper>
      <h1>Movies</h1>
      {movies.map((movie) => (
        <Paper
          elevation={3}
          style={{ margin: "10px", padding: "15px", textAlign: "left" }}
          key={movie.id}
        >
          Id: {movie.id}
          <br />
          Name: {movie.name}
          <br />
          Lan: {movie.lan}
        </Paper>
      ))}
    </Container>
  );
}
