package org.wecancodeit.reviews.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class CityReview {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String slogan;
    private Long population;
    //@Column(length=1000) for string lengths
    @Lob
    private String review;
    private String imgUrl;

    @ManyToMany
    private Collection<HashPage> hashPages;

    @ManyToOne
    private Region region;

    @ElementCollection
    private Collection<String> comments;

    public CityReview(String name, String slogan, Long population, String review, String imgUrl, Region region, HashPage...hashPages) {
        this.name = name;
        this.slogan = slogan;
        this.population = population;
        this.review = review;
        this.imgUrl = imgUrl;
        this.hashPages = Arrays.asList(hashPages);
        this.region = region;
        this.comments = new ArrayList<>();
    }

    public CityReview(){
        //zerg arg constructor
    }

    public Collection<String> getComments() {
        return comments;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlogan() {
        return slogan;
    }

    public Long getPopulation() {
        return population;
    }

    public String getReview() {
        return review;
    }

    public Collection<HashPage> getHashPages() {
        return hashPages;
    }

    public Region getRegion() {
        return region;
    }

    public void addHashTag(HashPage hashpage){
        hashPages.add(hashpage);
    }

    public void addComment(String comment) {
        comments.add(comment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityReview that = (CityReview) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(slogan, that.slogan) && Objects.equals(population, that.population) && Objects.equals(review, that.review) && Objects.equals(hashPages, that.hashPages) && Objects.equals(region, that.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, slogan, population, review, region);
    }
}
