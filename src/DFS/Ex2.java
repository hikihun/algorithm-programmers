package DFS;

public class Ex2 {

    // 이진 트리의 깊이우선 탐색
    //       1
    //   2       3
    //4    5   6    7
    // 전위 순회 : 1 2 4 5 3 6 7
    public void DFS(int v) {
        if (v > 7) {
            return;
        } else {
            System.out.print(v + " "); // 전위 순회
            DFS(v * 2);
//            System.out.print(v + " "); // 중위 순회
            DFS(v * 2 + 1);
//            System.out.print(v + " "); // 후위 순회
        }
    }

    public static void main(String[] args) {
        Ex2 T = new Ex2();
        T.DFS(1);
    }

}
