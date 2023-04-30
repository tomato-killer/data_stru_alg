public class MazeBack {

    int[][] map = new int[8][8];

    public MazeBack() {


        for (int i = 0; i < 8; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][7] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;
        map[2][4] = 1;
        map[1][4] = 1;
        map[4][4] = 1;
        map[5][4] = 1;
        map[6][4] = 1;
        map[4][5] = 1;

    }


    public void printMap(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j<7)
                    System.out.print(map[i][j] + " , ");
                else
                    System.out.println(map[i][j]);
            }
        }
    }

    public boolean findWay(int i, int j, int last_i, int last_j) {
        map[i][j] = 2;
        if (i == 6 && j == 6){
            System.out.println("i=={"+i+"}_______j=={"+j+"}");
            return true;
        }

        if (map[i + 1][j] == 0 && (i + 1 != last_i || j != last_j) && findWay(i+1, j, i, j)){
            System.out.println("i=={"+i+"}_______j=={"+j+"}");
            return true;
        } else if (map[i][j+1] == 0 && (i != last_i || j+1 != last_j) && findWay(i, j+1, i, j)){
            System.out.println("i=={"+i+"}_______j=={"+j+"}");
            return true;
        } else if (map[i-1][j] == 0 && (i-1 != last_i || j != last_j) && findWay((i-1), j, i, j)){
            System.out.println("i=={"+i+"}_______j=={"+j+"}");
            return true;
        } else if (map[i][j-1] == 0 && (i != last_i || j-1 != last_j) && findWay(i, j-1, i, j)){
            System.out.println("i=={"+i+"}_______j=={"+j+"}");
            return true;
        } else {
            map[i][j] = 3;
            return false;
        }
    }

    public static void main(String[] args) {
        MazeBack back = new MazeBack();
        back.printMap();
        System.out.println(back.findWay(1,1, 1, 1));
        back.printMap();
    }
}