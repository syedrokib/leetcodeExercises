package problems.undefined.favoritegenres;

import java.util.*;

public class Solution {

    public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {

        Map<String, String> songsToGenre = new HashMap<>();

        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song : songs) songsToGenre.put(song, genre);
        }

        Map<String, Map<String, Integer>> userGenresCount = new HashMap<>();

        for (String user : userMap.keySet()) {

//            if (!userGenresCount.containsKey(user)) userGenresCount.put(user, new HashMap<>());
            List<String> songs = userMap.get(user);

            for (String song : songs) {
                String genre = songsToGenre.get(song);
                int count = userGenresCount.get(user).getOrDefault(genre, 0) + 1;
                userGenresCount.get(user).put(genre, count);
            }
        }

        Map<String, List<String>> results = new HashMap<>();

        for (String user : userGenresCount.keySet()) {

            if (!results.containsKey(user)) results.put(user, new ArrayList<>());
            Map<String, Integer> genreCount = userGenresCount.get(user);

            int max = 0;
            List<String> favouriteGenres = new ArrayList<>();

            for (String genre : genreCount.keySet()) {

                int count = genreCount.get(genre);

                if (favouriteGenres.size() == 0) {
                    favouriteGenres.add(genre);
                    max = count;

                } else {
                    if (count == max) favouriteGenres.add(genre);
                    if (count > max) {
                        max = count;
                        favouriteGenres.clear();
                        favouriteGenres.add(genre);
                    }
                }
            }
            results.put(user, favouriteGenres);
        }

        return results;
    }
}
