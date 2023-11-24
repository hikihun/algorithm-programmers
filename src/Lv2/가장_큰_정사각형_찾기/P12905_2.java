package Lv2.가장_큰_정사각형_찾기;

public class P12905_2 {
    public int solution(int [][]board) {
        int answer = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] map = new int[row + 1][col + 1];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                map[i + 1][j + 1] = board[i][j];
            }
        }
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(map[i][j] != 0){
                    map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j -1]), map[i - 1][j - 1]) + 1;
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }

        return answer * answer;
    }
    public static void main(String[] args) {
        P12905_2 T = new P12905_2();
        System.out.println(T.solution(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }

}
