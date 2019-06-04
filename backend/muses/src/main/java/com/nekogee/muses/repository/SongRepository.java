package com.nekogee.muses.repository;

import com.nekogee.muses.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Integer> {

    Song findSongById(long id);

    List<Song> findSongsByAlbumId(long aid);

    List<Song> findSongsByUserIdsContaining(long uid);
}
