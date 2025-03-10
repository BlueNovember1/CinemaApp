package com.example.backend.model.cinema;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

// Zapobiega problemem z cyklicznymi odwołanami (nieskończona pętla)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity(name = "screenings")
public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Relacja wiele do jednego z Movie
    // Kazdy seans jest powiązany z filmem
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    // Relacja wiele do jednego z CinemaHall
    // Kazdy seans odbywa się w jendej sali kinowej
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id", referencedColumnName = "id")
    private CinemaHall cinemaHall;
    // Relacja jeden do wielu
    // Kazdy seans moze miec wiele biletów
    @OneToMany(mappedBy = "screening")
    private Set<Ticket> tickets;

    private LocalDateTime dateOfBeginning;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public LocalDateTime getDateOfBeginning() {
        return dateOfBeginning;
    }

    public void setDateOfBeginning(LocalDateTime dateOfBeginning) {
        this.dateOfBeginning = dateOfBeginning;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
