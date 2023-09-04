package Lv1.크레인_인형뽑기_게임;

import java.util.Stack;

public class P64061 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int[] arr : board) {
            for (int i : arr) {
                System.out.print(i + " ");

            }
            System.out.println();
        }

        for (int m : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][m - 1] != 0) {
                    if (stack.peek() == board[j][m - 1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][m - 1]);
                    }
                    board[j][m - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P64061 T = new P64061();
        System.out.println(T.solution(
            new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

}
