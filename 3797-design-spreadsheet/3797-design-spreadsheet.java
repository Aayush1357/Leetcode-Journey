class Spreadsheet {

    private int[][] grid;
    
    public Spreadsheet(int rows) {
        grid = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] x = parseCell(cell);
        int  i = x[0];
        int j = x[1];
        grid[i][j] = value;
    }
    
    public void resetCell(String cell) {
        int[] x = parseCell(cell);
        int  i = x[0];
        int j = x[1];
        grid[i][j] = 0;
        
    }
    
    public int getValue(String formula) {
        String[] parts = formula.substring(1).split("\\+");
        return part(parts[0]) + part(parts[1]);
    }

    public int[] parseCell(String cell){
        int i = cell.charAt(0) - 'A';
        int j = Integer.parseInt(cell.substring(1)) - 1;

        return new int[]{j , i};
    }

    public int part(String part){
        if (Character.isDigit(part.charAt(0))) {
            return Integer.parseInt(part);
        } else {
            int[] xaldrovine = parseCell(part);
            return grid[xaldrovine[0]][xaldrovine[1]];
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */