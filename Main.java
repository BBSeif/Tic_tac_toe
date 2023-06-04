import java.util.Arrays;
import java.util.Scanner;

public class Main {

        public static void show(char[][] gameMap) {

            System.out.println("---------");
            System.out.print("| ");
            System.out.print(gameMap[0][0]+" ");
            System.out.print(gameMap[0][1]+" ");
            System.out.print(gameMap[0][2]+" ");
            System.out.println("|");
            System.out.print("| ");
            System.out.print(gameMap[1][0]+" ");
            System.out.print(gameMap[1][1]+" ");
            System.out.print(gameMap[1][2]+" ");
            System.out.println("|");
            System.out.print("| ");
            System.out.print(gameMap[2][0]+" ");
            System.out.print(gameMap[2][1]+" ");
            System.out.print(gameMap[2][2]+" ");
            System.out.println("|");
            System.out.println("---------");
        }
        private static boolean xoro(char[][] gameMap){
            int count =0;
            for (int i = 0; i < gameMap.length ; i++) {
                for (int j = 0; j <gameMap[i].length ; j++) {
                    if (gameMap[i][j] == 'X' || gameMap[i][j] =='O'){
                        count++;
                    }
                }
            }
            return count % 2 == 0;
        }

        public static void check(char[][] str,int a,int b,int cX,int cO) {

            int[][] countIndexX = {{4, 4}, {4, 4}, {4, 4}, {4, 4}, {4, 4}};
            int[][] countIndexO = {{4, 4}, {4, 4}, {4, 4}, {4, 4}, {4, 4}};
            boolean winX = false;
            boolean winO = false;
            int[][][] ans = {{{0,0}, {0,1}, {0,2}}, {{1,0}, {1,1}, {1,2}}, {{2,0}, {2,1}, {2,2}}, {{0,0}, {1,0}, {2,0}}, {{0,1}, {1,1}, {2,1}}, {{0,2}, {1,2}, {2,2}}, {{0,0}, {1,1}, {2,2}}, {{0,2}, {1,1}, {2,0}}};
            if (str[a][b] == 'X') {
                countIndexX[cX][0] = a-1;
                countIndexX[cX][1] = b-1;
                cX++;
            } else if (str[a][b] == 'O') {
                countIndexO[cO][0] = a-1;
                countIndexO[cO][1] = b-1;
                cO++;
            }
            System.out.println(Arrays.deepToString(countIndexX));
            System.out.println(Arrays.deepToString(countIndexO));

//        for (int i = 0; i < ans.length; i++) {
//            for (int j = 0; j < ans[i].length; j++) {
//                int count = 0;
//                for (int k = 0; k < countIndexX.length; k++) {
//
//                    if (ans[i][0][0] == countIndexX[k][0] && ans[i][0][1] == countIndexX[k][1]) {
//                        count++;
//                    }
//                    if (ans[i][1][0] == countIndexX[k][0] && ans[i][1][1] == countIndexX[k][1]) {
//                        count++;
//                    }
//                    if (ans[i][2][0] == countIndexX[k][0] && ans[i][2][1] == countIndexX[k][1]) {
//                        count++;
//                    }
//                    if (count == 3) {
//                        winX = true;
//                    }
//                }
//            }
//        }
        }
        public static boolean checker (char[][] gameMap, boolean finish){
            int countO = 0;
            int countX = 0;
            int[] countIndexX = {9,9,9,9,9};
            int[] countIndexO = {9,9,9,9,9};
            boolean winX = false;
            boolean winO = false;
            int[][] ans ={ {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};


            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameMap[i][j] == 'X') {
                        countIndexX[countX] = i*3+j;
                        countX++;
                    } else if (gameMap[i][j] == 'O') {
                        countIndexO[countO] = i*3+j;
                        countO++;
                    }
                }

            }

            for (int i = 0; i < ans.length; i++) {
                int count = 0;
                for (int j = 0; j < countIndexX.length; j++) {

                    if (ans[i][0] == countIndexX[j]) {
                        count++;
                    }
                    if (ans[i][1] == countIndexX[j]) {
                        count++;
                    }
                    if (ans[i][2] == countIndexX[j]) {
                        count++;
                    }
                    if (count == 3){
                        winX = true;
                    }
                }
            }

            for (int i = 0; i < ans.length; i++) {
                int count = 0;
                for (int j = 0; j < countIndexO.length; j++) {

                    if (ans[i][0] == countIndexO[j]) {
                        count++;
                    }
                    if (ans[i][1] == countIndexO[j]) {
                        count++;
                    }
                    if (ans[i][2] == countIndexO[j]) {
                        count++;
                    }
                    if (count == 3){
                        winO = true;
                    }
                }
            }


            if ( winX ) {
                System.out.println("X wins");
                finish = false;
            } else if ( winO ) {
                System.out.println("O wins");
                finish = false;
            } else if (countX + countO > 8) {
                System.out.println("Draw");
                finish = false;
            }
            return finish;
        }


        public static char[][] valid (char[][] gameMap,boolean xTo) {
            Scanner sc = new Scanner(System.in);
            int x;
            int y;
            String varA = !sc.hasNextInt() ? sc.next() + "err" : sc.next();  //where is "err", just a marker
            String varB = !sc.hasNextInt() ? sc.next() + "err" : sc.next();  //where is "err", just a marker

            if (varA.contains("err") || varB.contains("err")) {
                System.out.println("You should enter numbers!");
                return gameMap;
            } else {
                x = Integer.parseInt(varA) - 1;
                y = Integer.parseInt(varB) - 1;
            }
            if ((x < 3 && x > -1) && (y < 3 && y > -1)) {
                if (gameMap[x][y] != 'X' && gameMap[x][y] != 'O') {
                    if (xoro(gameMap)) {
                        gameMap[x][y] = 'X';
                    } else {
                        gameMap[x][y] = 'O';

                    }
                }else{
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
            }
            return gameMap;
        }

        public static void main ( String[] args ) {


            char[][] gameMap = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

            boolean xTo=true;
            boolean finish = true;
            show(gameMap);
            while ( finish ) {

                valid(gameMap,xTo);
                show(gameMap);
                finish = checker(gameMap, finish);
            }
        }
}

