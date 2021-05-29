public class SparseMatrix {
    private int totalRows;
    private int totalColumns;
    private MatrixRow firstRow;
    private MatrixColumn firstColumn;


    public SparseMatrix(int rows, int columns) {
        this.totalRows = rows;
        this.totalColumns = columns;

        initSizeRows();
        initSizeColumns();
    }

    public void initSizeRows(){
        this.firstRow = new MatrixRow();
        MatrixRow tempPointer = firstRow;

        for(int i = 1; i <= totalRows; i++){
            tempPointer.setNext(new MatrixRow());
            tempPointer = tempPointer.getNext();
        }
    }

    public void initSizeColumns(){
        this.firstColumn = new MatrixColumn();
        MatrixColumn tempPointer = firstColumn;

        for(int i = 1; i <= totalColumns; i++){
            tempPointer.setNext(new MatrixColumn());
            tempPointer = tempPointer.getNext();
        }
    }

    public void insert(int row, int column, int value) {
        ValueNode newNode = new ValueNode(row,column,value);

        MatrixRow matrixRow = getRow(row);
        matrixRow.insert(newNode);

        MatrixColumn matrixColumn = getColumn(column);
        matrixColumn.insert(newNode);
    }

    public MatrixRow getRow(int position) {
        MatrixRow tempPointer = firstRow;

        for(int i = 1; i <= totalRows; i++){
            if(i == position){
                return tempPointer;
            }
            tempPointer = tempPointer.getNext();
        }

        return null;
    }

    public MatrixColumn getColumn(int position) {
        MatrixColumn tempPointer = firstColumn;

        for(int i = 1; i <= totalColumns; i++){
            if(i == position){
                return tempPointer;
            }
            tempPointer = tempPointer.getNext();
        }

        return null;
    }

    public int getValue(int row, int column) {
        MatrixRow matrixRow = getRow(row);
        ValueNode current = matrixRow.getFirst();

        while(current != null){
            if(column == current.getColumn()){
                return current.getValue();
            }
            current = current.getNextColumn();
        }
        return 0;
    }

    public void print() {
        for(int i = 1; i <= totalRows; i++){
            for(int j = 1; j <= totalColumns; j++){
                System.out.printf("%4d"+" ",getValue(i,j));
            }
            System.out.println();
        }
        System.out.println();

    }

    public SparseMatrix transpose() {
        SparseMatrix transposeMatrix = new SparseMatrix(totalColumns,totalRows);

        for(int i = 1; i <= transposeMatrix.totalRows; i++){
            for(int j = 1; j <= transposeMatrix.totalColumns; j++){
                transposeMatrix.insert(i,j,getValue(j,i));
            }
        }
        return transposeMatrix;
    }

    public SparseMatrix product(SparseMatrix other) {
        SparseMatrix productMatrix = new SparseMatrix(totalRows,other.totalColumns);

        for(int i = 1; i <= totalRows; i++){
            for(int j = 1; j <= other.totalColumns; j++){
                int sum = 0;
                for(int k = 1; k <= totalColumns; k++){
                    sum += (getValue(i,k) * (other.getValue(k,j)));
                }
                productMatrix.insert(i,j,sum);
            }
        }

        return productMatrix;
    }
}

