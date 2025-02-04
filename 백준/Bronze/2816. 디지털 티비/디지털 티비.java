import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> channelList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            channelList.add(br.readLine().trim());
        }

        StringBuilder sb = new StringBuilder();
        int pointer = 0;

        // find KBS1
        while (!(channelList.get(pointer).equals("KBS1"))) {
            sb.append("1");
            pointer++;
        }

        // make KBS1 the first order
        for (int i = 0; i < pointer; i++) {
            sb.append("4");
        }
        String tmp = channelList.get(pointer);
        channelList.remove(pointer);
        channelList.add(0, tmp);
        pointer = 0;

        // find KBS2
        while (!(channelList.get(pointer).equals("KBS2"))) {
            sb.append("1");
            pointer++;
        }

        // make KBS1 the first order
        for (int i = 1; i < pointer; i++) {
            sb.append("4");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
}