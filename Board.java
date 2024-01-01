package connectfour;

public class Board{

    private String[][] boarddata = new String[6][7];
    private String[] token = {"R", "B"};
    private int i;
    private int j;

    public String[][] setBoard() {
        
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 7; j++) {
                boarddata[i][j] = "-";
            }
        }
        return boarddata;
    }

    public String[][] getBoard() {
        return boarddata;
    }

    public void setLoad(String[][] boardin) {
        boarddata = boardin;
    }

    public String[] getToken() {
        return token;
    }
    

    
/* this is a do-nothing method that was put here only so 
you could have an example of junit testing.  Once you have other
methods in the Board class and other tests you should delete
this method and this comment */
    public int returnSomething(){
        return 1;
    }

}