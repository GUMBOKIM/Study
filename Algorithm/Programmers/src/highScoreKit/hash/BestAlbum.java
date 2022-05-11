package highScoreKit.hash;


import java.util.Arrays;
import java.util.HashMap;


class Music {
    int count = 0;

    int order_max = -1;
    int play_max = -1;

    int order_min = -1;
    int play_min = -1;

    Music() {
    }

    Music(int order, int count) {
        this.order_max = order;
        this.play_max = count;
    }

    void push(int order, int play) {
        this.count += play;
        if (this.play_max < play) {
            this.play_min = this.play_max;
            this.order_min = this.order_max;
            this.play_max = play;
            this.order_max = order;
        } else if (this.play_max == play) {
            this.play_min = play;
            this.order_min = order;
        } else {
            if (play_min < play) {
                this.play_min = play;
                this.order_min = order;
            }
        }
    }

}

public class BestAlbum {

    static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Music> hashMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (hashMap.containsKey(genre)) {
                hashMap.get(genre).push(i, play);
            } else {
                hashMap.put(genre, new Music(i, play));
            }
        }

        Music max = new Music();
        Music min = new Music();

        for (Music music : hashMap.values()) {
            if (max.count < music.count) {
                min = max;
                max = music;
            } else {
                if (min.count < music.count) {
                    min = music;
                }
            }
        }


        return new int[]{max.order_max, max.order_min, min.order_max, min.order_min};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));

    }
}
