package org.wecancodeit.reviews.model;


import org.wecancodeit.reviews.model.CityReview;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;


@Entity
public class Region {
    @Id
    @GeneratedValue
    private long id;
    private String regionName;
    private String regionDescription;
    private String imgUrl;

    @OneToMany(mappedBy = "region")
    private Collection<CityReview> cityReviews;

    public Region(String regionName, String regionDescription, String imgUrl) {

        this.regionName = regionName;
        this.regionDescription = regionDescription;
        this.imgUrl = imgUrl;
    }

    public Region(){
        //zero argument constructor
    }

    public long getId() {
        return id;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getRegionDescription() {
        return regionDescription;
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
        Region region = (Region) o;
        return id == region.id && Objects.equals(regionName, region.regionName) && Objects.equals(regionDescription, region.regionDescription) && Objects.equals(cityReviews, region.cityReviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, regionName, regionDescription);
    }
}
