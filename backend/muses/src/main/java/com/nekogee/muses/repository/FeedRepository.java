package com.nekogee.muses.repository;

import com.nekogee.muses.entity.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository<Feed, Integer> {


    List<Feed> findFeedsByUid(long uid);


}
