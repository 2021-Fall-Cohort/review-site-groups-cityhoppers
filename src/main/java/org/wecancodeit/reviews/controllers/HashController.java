package org.wecancodeit.reviews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wecancodeit.reviews.model.CityReview;
import org.wecancodeit.reviews.model.HashPage;
import org.wecancodeit.reviews.repos.CityRepo;
import org.wecancodeit.reviews.repos.HashRepo;
import org.wecancodeit.reviews.repos.RegionsRepo;

import java.util.Optional;


@Controller
public class HashController {
    private CityRepo cityRepo;
    private HashRepo hashRepo;
    private RegionsRepo regionsRepo;

    public HashController(CityRepo cityRepo, HashRepo hashRepo, RegionsRepo regionsRepo) {
        this.cityRepo = cityRepo;
        this.hashRepo = hashRepo;
        this.regionsRepo = regionsRepo;
    }

    @RequestMapping("/Hashtags")
    public String getHashPage(Model hashModel) {
        hashModel.addAttribute("Hashtags", hashRepo.findAll());
        return "Hashtags";
    }
    @RequestMapping("/SubHashPage/{id}")
    public String getSubHashPage(Model subHashModel, @PathVariable Long id) {
        subHashModel.addAttribute("SubHashPage", hashRepo.findById(id).get());
        return "SubHash";
    }

    @PostMapping("/addHash")

    public String addHash(@RequestParam long cityID, @RequestParam String name, @RequestParam String description, @RequestParam String imgUrl) {
//    Technically we add the hashtag underneath a city review. We call CityReview object, create a variable "review1",
//    and get the city ID it correlates to. This is the hidden field on the form
        CityReview review1 = cityRepo.findById(cityID).get();
//    Next we call the HashPage object and create a variable "hash1" this is the name and description input of the form
        HashPage hash1;
//    We create a variable for the Optional that we pass the HashPage through. Tell it to find what the user gave us "hash1"
        Optional<HashPage> hashOpt = hashRepo.findByName(name);
//    If the optional is empty take the "hash1" variable and add it to our hash repo and save "hash1"
        if (hashOpt.isEmpty()) {
            hash1 = new HashPage(name, description, imgUrl);
            hashRepo.save(hash1);
//    If the system finds "hash1" get it
        } else {
            hash1 = hashOpt.get();
        }
//    This is what people forget. Once we have the hashtag (or add it to the repo) we have to associate it with the city
//    We call back the review and correct ID we found. Add the hashtag and SAVE IT BACK to the city repo.
        review1.addHashTag(hash1);
        cityRepo.save(review1);
//    Finally after we add the hash to the city review OR find the hash, return us back to the correct city review page
//    We added a list that shows all the hashtags associated with the city reviews. This will include whatever is added.
        return "redirect:/CityReview/" + cityID;
        }


}
