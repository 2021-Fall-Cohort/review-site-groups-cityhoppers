package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.model.CityReview;
import org.wecancodeit.reviews.model.HashPage;
import org.wecancodeit.reviews.model.Region;
import org.wecancodeit.reviews.repos.CityRepo;
import org.wecancodeit.reviews.repos.HashRepo;
import org.wecancodeit.reviews.repos.RegionsRepo;

import java.util.Optional;

@Controller
public class CityController {
    private CityRepo cityRepo;
    private HashRepo hashRepo;
    private RegionsRepo regionsRepo;

    public CityController(CityRepo cityRepo, HashRepo hashRepo, RegionsRepo regionsRepo) {
        this.cityRepo = cityRepo;
        this.hashRepo = hashRepo;
        this.regionsRepo = regionsRepo;
    }

    @RequestMapping("/")
    public String getHomePage(Model introModel) {
        return "reviewHome";
    }

    @RequestMapping("/CityReviewList")
    public String getCityReviews(Model cityModel) {
        cityModel.addAttribute("CityReviewList", cityRepo.findAll());
        return "CityReviewList";
    }

    @RequestMapping("/Regions")
    public String getRegions(Model regionModel) {
        regionModel.addAttribute("Regions", regionsRepo.findAll());
        return "Regions";
    }

    @RequestMapping("/SubRegion/{id}")
    public String getSubRegion(Model subRegionModel, @PathVariable Long id) {
        subRegionModel.addAttribute("SubRegion", regionsRepo.findById(id).get());
        return "SubRegion";
    }

    @RequestMapping("/CityReview/{id}")
    public String getSubCityReview(Model subCityReviewModel, @PathVariable Long id) {
        subCityReviewModel.addAttribute("CityReview", cityRepo.findById(id).get());
        return "CityReview";
    }

    @RequestMapping("/writeCityReview")
    public String writeReview(Model subCityReviewModel) {
        //"regions" is a key value pairing
    subCityReviewModel.addAttribute("Regions" , regionsRepo.findAll());
        return "writeCityReview";
    }

    @PostMapping("/addComment")
    public String addComment(@RequestParam long cityID, @RequestParam String cname) {
        CityReview review1 = cityRepo.findById(cityID).get();
        String comment1 = cname;
        review1.addComment(comment1);
        cityRepo.save(review1);
        return "redirect:/CityReview/" + cityID;
    }

    @PostMapping("/addCityReview")
    public String addCityReview(@RequestParam String name, @RequestParam String slogan, @RequestParam Long population, @RequestParam String review, @RequestParam String imgUrl, @RequestParam String region) {

        Optional<CityReview> review2 = cityRepo.findByName(name);
        Region myRegion = regionsRepo.findByRegionNameIgnoreCase(region).get();

        if (review2.isPresent()) {
            return "redirect:/CityReview/" + review2.get().getId();
        } else {
            CityReview userReview = new CityReview(name, slogan, population, review, imgUrl, myRegion);
            cityRepo.save(userReview);
            return "redirect:/CityReview/" + userReview.getId();
        }
    }
}