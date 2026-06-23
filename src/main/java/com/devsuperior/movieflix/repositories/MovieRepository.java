package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projections.MovieProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT obj.id as id, obj.title as title, obj.subTitle as subTitle, obj.year as year, obj.imgUrl as imgUrl FROM Movie obj ORDER BY obj.title")
    Page<MovieProjection> searchAllMovies(Pageable pageable);

    @Query("SELECT obj.id as id, obj.title as title, obj.subTitle as subTitle, obj.year as year, obj.imgUrl as imgUrl FROM Movie obj WHERE obj.genre.id = :genreId ORDER BY obj.title")
    Page<MovieProjection> searchAllMoviesByGenre(@Param("genreId") Long genreId, Pageable pageable);
}
