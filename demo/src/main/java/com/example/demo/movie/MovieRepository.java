package com.example.demo.movie;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


    @Repository
    public  interface MovieRepository extends JpaRepository<Movie ,Long>
    {

    }
