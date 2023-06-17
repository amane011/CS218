package Assignment5.Challenge;
    import java.util.*;
    
    public class Swan {
    
        static int[] dx = {-1, 0, 1, 0};
        static int[] dy = {0, 1, 0, -1};
        static int r, c, x[] = new int[2], y[] = new int[2];
        static char[][] map;
        static int[][] water;
        static boolean[][] visit;
        static LinkedList<int[]> swan = new LinkedList<>();
        static LinkedList<int[]> waterQ = new LinkedList<>();
        static LinkedList<int[]> nextQ = new LinkedList<>();
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            r = sc.nextInt();
            c = sc.nextInt();
            map = new char[r][c];
            water = new int[r][c];
            visit = new boolean[r][c];
            int count=0;
    
            int idx = 0;
            for (int i = 0; i < r; i++) {
                map[i] = sc.next().toCharArray();
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == 'L') {
                        x[idx] = i;
                        y[idx] = j;
                        idx++;
                    }
                    if (map[i][j] != 'X') {
                        waterQ.add(new int[] {i, j});
                    }
                }
            }
            count++;
            melt();
            swan.add(new int[] {x[0], y[0]});
            visit[x[0]][y[0]] = true;
            int day = 0;
            while (true) {
                while (!swan.isEmpty()) {
                    int[] cur = swan.poll();
                    if (cur[0] == x[1] && cur[1] == y[1]) {
                        System.out.println(day);
                        return;
                    }
                    count++;
                    for (int i = 0; i < 4; i++) {
                        int nx = cur[0] + dx[i];
                        int ny = cur[1] + dy[i];
                        if (nx < 0 || ny < 0 || nx >= r || ny >= c || visit[nx][ny]) {
                            continue;
                        }
                        if (water[nx][ny] <= day) {
                            visit[nx][ny] = true;
                            swan.add(new int[] {nx, ny});
                        } else {
                            nextQ.add(new int[] {nx, ny});
                        }
                    }
                }
                swan = nextQ;
                nextQ = new LinkedList<>();
                day++;
            }
        }
    
        static void melt() {
            while (!waterQ.isEmpty()) {
                int[] cur = waterQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == '.') continue;
                    map[nx][ny] = '.';
                    water[nx][ny] = water[cur[0]][cur[1]] + 1;
                    waterQ.add(new int[] {nx, ny});
                }
            }
        }
    }
