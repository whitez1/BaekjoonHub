import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int x = -1;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(st.hasMoreTokens()) x = Integer.parseInt(st.nextToken());
            if(command.equals("add")) {
                set.add(x);
            } else if(command.equals("remove")) {
                set.remove(x);
            } else if(command.equals("check")) {
                int answer = set.contains(x) ? 1 : 0;
                sb.append(answer+"\n");
            } else if(command.equals("toggle")) {
                if(set.contains(x)) set.remove(x);
                else set.add(x);
            } else if(command.equals("all")) {
                set.clear();
                for(int j=1; j<=20; j++) set.add(j);
            } else {
                set.clear();
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}