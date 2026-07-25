class ChessGame { 
 
    char[][] board = { 
        {'r','n','b','q','k','b','n','r'}, 
        {'p','p','p','p','p','p','p','p'}, 
        {'.','.','.','.','.','.','.','.'}, 
        {'.','.','.','.','.','.','.','.'}, 
        {'.','.','.','.','.','.','.','.'}, 
        {'.','.','.','.','.','.','.','.'}, 
        {'P','P','P','P','P','P','P','P'}, 
        {'R','N','B','Q','K','B','N','R'} 
    }; 
 
    void displayBoard() { 
        for (int i = 0; i < 8; i++) { 
            System.out.print((8 - i) + " "); 
            for (int j = 0; j < 8; j++) { 
                System.out.print(board[i][j] + " "); 
            } 
            System.out.println(); 
        } 
        System.out.println("  a b c d e f g h"); 
    } 
 
    void movePawn() { 
        board[6][4] = '.';   // e2 empty 
        board[4][4] = 'P';   // e4 
        System.out.println("\nPawn moved from e2 to e4\n"); 
    } 
 
    public static void main(String[] args) { 
        ChessGame game = new ChessGame(); 
 
        System.out.println("=== Chess Game Using OOP ==="); 
        System.out.println("\nInitial Board:"); 
        game.displayBoard(); 
 
        game.movePawn(); 
 
        System.out.println("Board After Move:"); 
        game.displayBoard(); 
    } 
}
