package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

interface AnimeRepository extends JpaRepository<Anime, Long> {

}