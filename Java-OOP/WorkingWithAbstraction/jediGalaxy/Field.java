package WorkingWithAbstraction.jediGalaxy;

public class Field {
    private final long[][] starsField;

    public Field(int rows, int cols) {
        this.starsField = new long[rows][cols];
        populateGalaxy(rows, cols);
    }

    public void populateGalaxy(int rows, int cols) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                starsField[i][j] = value++;
            }
        }
    }

    public boolean isInBounds(int row, int col){
        return row >= 0 && col >= 0 && row < starsField.length && col < starsField[row].length;
    }

    public long getValue(int row, int col){
        return this.starsField[row][col];
    }

    public void setValue(int row, int col, int newValue){
        starsField[row][col] = newValue;
    }

    public int getColLength(){
        return starsField[1].length;
    }
}
