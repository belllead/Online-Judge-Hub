import java.util.*;

class Solution {
    
    static int[][] map;
    static List<Integer> ans;
    static boolean[][] visited;
    static int R, C;
    static int[] dr = {-1, 1, 0, 0}, dc = {0, 0, -1, 1};
    
    public int[] solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        ans = new ArrayList<>();
        visited = new boolean[R][C];
        map = new int[R][C];
        
        for (int r=0; r<R; r++) {
            String row = maps[r];
            for (int c=0; c<C; c++) {
                if (row.charAt(c) == 'X')
                    map[r][c] = 0;
                else
                    map[r][c] = row.charAt(c) - '0';
            }
        }
        
        // for (int i=0; i<R; i++) { 
        //     for (int j=0; j<C; j++) {
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        
        for (int r=0; r<R; r++) { 
            for (int c=0; c<C; c++) {
                if (!visited[r][c] && map[r][c] != 0)
                    bfs(r, c);
            }
        }
        
        Collections.sort(ans);
        
        // System.out.println(ans);
        
        if (ans.size() == 0) return new int[] {-1};
        
        int[] answer = new int[ans.size()];
        
        for (int i=0; i<ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    static void bfs(int r, int c) {
        int food = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            
            food += map[cur[0]][cur[1]];
            
            for (int d=0; d<4; d++) {
                int tr = cur[0] + dr[d];
                int tc = cur[1] + dc[d];
                
                if (tr >= 0 && tr < R && tc >= 0 && tc < C && !visited[tr][tc] && map[tr][tc] != 0) {
                    q.offer(new int[] {tr, tc});
                    visited[tr][tc] = true;
                }
            }
        }
        ans.add(food);
    }
}