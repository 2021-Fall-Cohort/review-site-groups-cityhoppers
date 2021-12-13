package org.wecancodeit.reviews.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class HashPage {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String description;
    private String imgUrl;

    @ManyToMany(mappedBy = "hashPages")
    private Collection<CityReview> cityReviews;

    public HashPage(String name, String description, String imgUrl) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public HashPage() {
     //zero arg constructor
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Collection<CityReview> getCityReviews() {
        return cityReviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashPage hashPage = (HashPage) o;
        return id == hashPage.id && Objects.equals(name, hashPage.name) && Objects.equals(description, hashPage.description) && Objects.equals(cityReviews, hashPage.cityReviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
