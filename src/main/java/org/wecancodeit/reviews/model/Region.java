package org.wecancodeit.reviews.model;


import org.wecancodeit.reviews.model.CityReview;


import java.util.Collection;



public class Region {
    private String regionName;
    private String regionDescription;


    public Region(String regionName, String regionDescription, Collection<CityReview> cityReviews) {
        this.regionName = regionName;
        this.regionDescription = regionDescription;

    }

    public String getRegionName() {
        return regionName;
    }

    public String getRegionDescription() {
        return regionDescription;
    }


}