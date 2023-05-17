package xyz.barreiro.usc.daw.models;

import java.util.Objects;

public final class CD {
    private final Integer id;
    private final String name;
    private final String artist;
    private final String country;
    private final Double price;

    public CD(Integer id, String name, String artist, String country, Double price) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.country = country;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getCountry() {
        return country;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CD cd = (CD) o;
        return Objects.equals(id, cd.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
