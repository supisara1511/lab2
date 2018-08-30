public class OX {
    int scoreX,scoreO,scoreD;
    int count;
    char currentPlayer;
    char[][] table = new char[3][3];

    public OX(){
        scoreX = 0;
        scoreO = 0;
        scoreD = 0;
        count = 0;
        currentPlayer = 'X';
        for (int i = 0; i < table.length ; i++) {
            for (int j = 0; j < table.length ; j++) {
                table[i][j] = '-';
            }
        }
    }

    public boolean put(int col,int row){
        if((col < 3 && col >= 0) && (row < 3 && row >= 0)){
            if (table[row][col] == '-'){
                table[row][col] = currentPlayer;
                count++;
                return true;
            }
        }
        return false;

    }

    public int getCount(){
        return count;
    }


    public boolean isDraw(){
        if(count < 9){
            return false;
        }
        scoreD++;
        return true;
    }

//    public void setTable(int col,int row){
//        table[col][row] = currentPlayer;
//    }



    public String getTableToString(){
        String tableString = "  0 1 2";

        for (int i = 0; i <  table.length; i++) {
            tableString += "\n";
            tableString += i;
            for (int j = 0; j <  table.length; j++) {
                tableString +=  " " + table[i][j];
            }

        }
        return tableString;
    }



    public char getCurrentPlayer()
    {
        return currentPlayer;
    }

    public void swcitchPlayer(){
        if(currentPlayer == 'X'){
            currentPlayer = 'O';
        }else{
            currentPlayer = 'X';
        }
    }

    public int getScoreX(){
        return scoreX;
    }

    public int getScoreO(){
        return scoreO;
    }

    public int getScoreD() {
        return scoreD;
    }

    public boolean checkWin(int col,int row){
        if(checkWinCol(col) ||
                checkWinRow(row) ||
                checkWinDiago(col,row)){

            if(currentPlayer == 'X'){
                scoreX++;
            }else{
                scoreO++;
            }




            return true;
        }
        return false;
    }

    public boolean checkWinRow(int row){
        boolean status = false;
        for (int i = 0; i < table.length; i++) {
            if(currentPlayer != table[row][i]){
                status = false;
                break;
            }else{
                status = true;
            }
        }

        return status;
    }

    public boolean checkWinCol(int col){
        boolean status = false;
        for (int i = 0; i < table.length; i++) {
            if(currentPlayer != table[i][col]){
                status = false;
                break;
            }else{
                status = true;
            }
        }

        return status;
    }

    public boolean checkWinDiago(int col,int row){
        boolean status = false;

        for (int i = 0; i < table.length; i++) {
            if(currentPlayer != table[i][i]){
                status = false;
                break;
            }else{
                status = true;
            }
        }
        if(status == true){
            return status;
        }else{
            for (int i = 0; i < table.length; i++) {
                if(currentPlayer != table[i][2-i]){
                    status = false;
                    break;
                }else{
                    status = true;
                }
            }
        }

        return status;


    }

    public void resetTable(){
        for (int i = 0; i < table.length ; i++) {
            for (int j = 0; j < table.length ; j++) {
                table[i][j] = '-';
            }
        }
        count = 0;
        currentPlayer = 'X';

    }


}




