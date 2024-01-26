package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42579
 */
class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (map.containsKey(genre)) {
                map.put(genre, play + map.get(genre));
                songMap.get(genre).add(new Song(i, play));
            } else {
                map.put(genre, play);
                List<Song> songs = new ArrayList<>();
                songs.add(new Song(i, play));
                songMap.put(genre, songs);
            }
        }

        List<Entry<String, Integer>> sortedGenres = new ArrayList<>();
        for (Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            sortedGenres.add(stringIntegerEntry);
        }
        Collections.sort(sortedGenres, (o1, o2) -> o2.getValue() - o1.getValue());
        for (Entry<String, Integer> sortedGenre : sortedGenres) {
            List<Song> songs = songMap.get(sortedGenre.getKey());
            Collections.sort(songs, (o1, o2) -> o2.play - o1.play);
            for (int i = 0; i < songs.size(); i++) {
                answer.add(songs.get(i).index);
                if (i == 1) {
                    break;
                }
            }
        }
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static class Song {
        int index;
        int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}
