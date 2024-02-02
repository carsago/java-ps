package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        String[] strings = {".D.R", "....", ".G..", "...D"};
        System.out.println(solution(strings));
    }

    public static int solution(String[] board) {
        char[][] map = new char[board[0].length()][board.length];
        int[] startIdx = new int[2];
        boolean[][] clean = new boolean[board[0].length()][board.length];
        for (int i = 0; i < board.length; i++) {
            String value = board[i];
            for (int j = 0; j < value.length(); j++) {
                char c = value.charAt(j);
                map[j][i] = c;
                if (c == 'R') {
                    startIdx[0] = j;
                    startIdx[1] = i;
                }
            }
        }

        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(startIdx[0], startIdx[1], 0));
        clean[startIdx[0]][startIdx[1]] = true;
        while (!queue.isEmpty()) {
            Location location = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = location.x + dx[i];
                int y = location.y + dy[i];

                while (!(x < 0) && !(x > board[0].length() - 1) &&
                        !(y < 0) && !(y > board.length - 1)) {
                    if (map[x][y] == 'D') {
                        break;
                    }

                    x += dx[i];
                    y += dy[i];
                }

                x -= dx[i];
                y -= dy[i];

                if (map[x][y] == 'G') {
                    return location.count + 1;
                }


                if (clean[x][y]) {
                    continue;
                }

                queue.add(new Location(x, y, location.count + 1));
                clean[x][y] = true;
            }
        }

        return -1;
    }

    static class Location {
        int x;
        int y;
        int count;

        public Location(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
