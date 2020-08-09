package sda.spring.library.model;

public enum Genre {
    SF("SF"),
    COMEDY("Comedy"),
    DRAMA("Drama"),
    MISTERY("Mistery"),
    HORROR("Horror");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return getGenre();
    }
}
