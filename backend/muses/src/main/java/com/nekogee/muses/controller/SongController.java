package com.nekogee.muses.controller;

import com.nekogee.muses.entity.Song;
import com.nekogee.muses.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    @Autowired
    public SongRepository songRepository;

    @GetMapping(value = "/api/{sid}")
    public Song getSong(@PathVariable("sid") long sid) {
        return songRepository.findSongById(sid);
    }

    //The front-end upload the song to the COS server and then post the url to this api
    @PostMapping(value = "/api/song")
    public Song postSong(@RequestParam("title") String title,
                         @RequestParam("songPath") String songPath,
                         @RequestParam("coverPath") String coverPath,
                         @RequestParam("uids") String uids){
        //TODO: make sure all uids exist
        Song song = new Song(title, songPath, coverPath, uids);
        song.setState(new Byte("0"));
        return songRepository.saveAndFlush(song);
    }

}
