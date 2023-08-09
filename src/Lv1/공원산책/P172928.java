package Lv1.공원산책;

public class P172928 {

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        // E W S N
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        char[] dir = {'E', 'W', 'S', 'N'};
        char[][] board = new char[park.length][];
        int x = 0, y = 0;
        for(int i = 0; i < park.length; i++){
            board[i] = park[i].toCharArray();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'S'){
                    x = i;
                    y = j;
                }
            }
        }

        for(String s : routes) {
            char cmd = s.charAt(0);
            int dis = s.charAt(2) - '0';
            boolean flag = true;
            int nx = 0, ny = 0;
            for(int i = 0; i < 4; i++) {
                if(cmd == dir[i]) {
                    nx = x;
                    ny = y;
                    for(int j = 0; j < dis; j++) {
                        nx = nx + dx[i];
                        ny = ny + dy[i];
                        if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] == 'X') {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag == false) continue;
            x = nx;
            y = ny;
        }


        return answer = new int[]{x, y};
    }

    public static void main(String[] args) {

    }

}
