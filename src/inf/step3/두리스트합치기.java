package inf.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두리스트합치기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int sizeOfN = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] N = new int[sizeOfN];

        for (int i = 0; i < sizeOfN; i++) {
            N[i] = Integer.parseInt(st.nextToken());
        }

        int sizeOfM = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] M = new int[sizeOfM];

        for (int i = 0; i < sizeOfM; i++) {
            M[i] = Integer.parseInt(st.nextToken());
        }

        int indexOfN = 0;
        int indexOfM = 0;

        while (indexOfN < sizeOfN && indexOfM < sizeOfM) {
            if (N[indexOfN] > M[indexOfM]) {
                System.out.print(M[indexOfM]+" ");
                indexOfM++;
                continue;
            }

            if (N[indexOfN] < M[indexOfM]) {
                System.out.print(N[indexOfN] +" ");
                indexOfN++;
                continue;
            }

            System.out.print(M[indexOfM]+" ");
            System.out.print(N[indexOfN]+" ");
            indexOfN++;
            indexOfM++;
        }

        if (indexOfN == sizeOfN) {
            for (int i = indexOfM; i < sizeOfM; i++) {
                System.out.print(M[i]+" ");
            }
        } else {
            for (int i = indexOfN; i < sizeOfN; i++) {
                System.out.print(N[i]+" ");
            }
        }
    }
}
