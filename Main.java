import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] cnm = sc.nextLine().split(" ");
        int C = Integer.parseInt(cnm[0]);
        int N = Integer.parseInt(cnm[1]);
        int M = Integer.parseInt(cnm[2]);
        int[] startPos = new int[N];
        int[] schedule = new int[M];

        for (int i = 0; i < N; i++){
            startPos[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < M; i++){
            schedule[i] = Integer.parseInt(sc.nextLine());
        }

        int lastDay = schedule[M-1];
        int[][] cowDB = new int[lastDay+1][C+1];

        for (int i = 0; i < N; i++){
            cowDB[0][startPos[i]]++;
        }

        for (int i = 0; i < lastDay; i++){
            for (int j = 1; j < C + 1; j++){
                if (j * 2 > C){
                    cowDB[i+1][j] += cowDB[i][j]*2;
                }else{
                    cowDB[i+1][j*2] += cowDB[i][j];
                }
            }
        }

        for (int day : schedule){
            int sum = 0;

            for (int i = 1; i < C+1; i++){
                sum += cowDB[day][i];
            }

            System.out.println(sum);
        }
    }
}
