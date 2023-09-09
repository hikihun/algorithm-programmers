package DFS;

public class Ex1 {

    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
//            System.out.println(n + " ");
            DFS(n - 1);
            System.out.println(n + " ");
        }
    }

    public static void main(String[] args) {
        Ex1 T = new Ex1();
        T.DFS(5);

    }

}
