package problems.undefined.favoritegenres;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void name() {

        Map<String, List<String>> answer = new HashMap<>();
        answer.put("David", Arrays.asList("Rock", "Techno"));
        answer.put("Emma", Arrays.asList("Pop"));

        Map<String, List<String>> userSongs = new HashMap<>();
        userSongs.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userSongs.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> songGenres = new HashMap<>();
        songGenres.put("Rock", Arrays.asList("song1", "song3"));
        songGenres.put("Dubstep", Arrays.asList("song7"));
        songGenres.put("Techno", Arrays.asList("song2", "song4"));
        songGenres.put("Pop", Arrays.asList("song5", "song6"));
        songGenres.put("Jazz", Arrays.asList("song8", "song9"));

        assertEquals(answer, new Solution().favoriteGenres(userSongs, songGenres));
    }
}