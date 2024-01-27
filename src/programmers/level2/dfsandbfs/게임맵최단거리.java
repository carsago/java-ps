package programmers.level2.dfsandbfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int solution(int[][] maps) {
        int xMax = maps.length;
        int yMax = maps[0].length;
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0, 0, 1));
        boolean[][] clean = new boolean[xMax][yMax];
        clean[0][0] = true;

        while (!queue.isEmpty()) {
            Info info = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = info.x + dx[i];
                int y = info.y + dy[i];


                if (x >= xMax || y >= yMax || x < 0 || y < 0) {
                    continue;
                }

                if (clean[x][y]) {
                    continue;
                }

                if (maps[x][y] == 0) {
                    clean[x][y] = true;
                    continue;
                }

                if (x == xMax - 1 && y == yMax - 1) {
                    return info.length + 1;
                }

                clean[x][y] = true;
                queue.add(new Info(x, y, info.length + 1));
            }
        }

        return -1;
    }

    static class Info {
        int x;
        int y;
        int length;

        public Info(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }
    }
}
