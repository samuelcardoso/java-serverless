package puc.sample.serverless;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String director;
    private String title;
    private int movieyear;
    private String genre;
    private int rating;

    public Movie() {
    }

    public Movie(String title, String director, String genre, int rating, int movieyear) {
        this.director = director;
        this.title = title;
        this.movieyear = movieyear;
        this.genre = genre;
        this.rating = rating;
    }

    public Movie(String director, String title, int movieyear) {
        this.director = director;
        this.title = title;
        this.movieyear = movieyear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMovieYear() {
        return movieyear;
    }

    public void setMovieYear(int movieYear) {
        this.movieyear = movieyear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}