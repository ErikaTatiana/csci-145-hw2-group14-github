public class Homework2 {
    public void run() {
        MatrixReader matrixA = new MatrixReader();
        MatrixReader matrixB = new MatrixReader();

        SparseMatrix sparseMatrixA = matrixA.read("matrixA.txt");
        SparseMatrix sparseMatrixB = matrixB.read("matrixB.txt");


        System.out.println("Matrix A: ");
        sparseMatrixA.print();
        System.out.println("Matrix B: ");
        sparseMatrixB.print();


        System.out.println("Matrix A transpose: ");
        sparseMatrixA.transpose().print();
        System.out.println("Matrix B transpose: ");
        sparseMatrixB.transpose().print();


        System.out.println("Matrix A x Matrix B: ");
        sparseMatrixA.product(sparseMatrixB).print();

    }
}

