public class Queen8 {

    int[] chessboard = new int[8];
    int count = 0;

    public void printArr(){
        for (int i = 0; i < 8; i++) {
            if (i<7)
                System.out.print(chessboard[i] + " , ");
            else
                System.out.println(chessboard[i]);
        }
        count +=1;
    }

    public void check(int n){
        if (n == 8){
            printArr();
            return;
        }

        for (int i = 0; i < 8; i++) {
            chessboard[n] = i;
            if (legal(n))
                check(n+1);
        }

    }



    public boolean legal(int n){
        for (int i = 0; i < n; i++) {
            if (chessboard[i] == chessboard[n] || Math.abs(i-n) == Math.abs(chessboard[i] - chessboard[n]))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(queen8.count);
    }

}
