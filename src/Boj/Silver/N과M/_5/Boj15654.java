package Boj.Silver.N과M._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15654 {
    static int[] num,arr;
    static boolean visit[];
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str= br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        num= new int[N];
        arr=new int[M];
        visit=new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {

        if(M==depth) {
            for(int i:arr)
                sb.append(i+" ");
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++) {
            if(!visit[i]) {
                visit[i]=true;
                arr[depth]=num[i];
                dfs(depth+1);
                visit[i]=false;
            }

        }
    }
}
