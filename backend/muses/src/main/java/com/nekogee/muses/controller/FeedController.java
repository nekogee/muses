package com.nekogee.muses.controller;


import com.nekogee.muses.entity.Feed;
import com.nekogee.muses.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {

    @Autowired
    FeedRepository feedRepository;

    //@GetMapping(value = "/api/feed")

    @PostMapping(value = "/api/{uid}/status")
    public Feed postStatus(@RequestParam("uid") long uid,
                           @RequestParam("aid") long aid,
                           @RequestParam("des") String description) {
        //TODO
        Feed feed = new Feed(uid, aid,0,  description);
        return feedRepository.saveAndFlush(feed);
    }


}
