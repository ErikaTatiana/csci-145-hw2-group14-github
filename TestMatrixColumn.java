package com.company;

public class TestMatrixColumn {
    public static void main(String[] args) {
        TestMatrixRow test = new TestMatrixRow();

        test.testInsertToEmpty();
        test.testInsertToEnd();
        test.testInsertBeforeFirst();
        test.testInsertBeforeLast();
    }

    public void testInsertToEmpty() {
        MatrixRow columnHead = new MatrixRow();
        ValueNode v1 = new ValueNode(3,1, 13);

        columnHead.insert(v1);

        System.out.print("Insert to empty test(3): ");

        ValueNode current = columnHead.getFirst();
        printLoop(current);
    }

    public void testInsertToEnd() {
        MatrixRow columnHead = new MatrixRow();
        ValueNode v1 = new ValueNode(3, 1, 13);
        ValueNode v2 = new ValueNode(5, 1, 45);
        ValueNode v3 = new ValueNode(8, 1, 18);

        columnHead.insert(v1);
        columnHead.insert(v2);
        columnHead.insert(v3);

        System.out.print("Insert to end test (3,5,8): ");

        ValueNode current = columnHead.getFirst();
        printLoop(current);
    }

    public void testInsertBeforeFirst() {
        MatrixRow columnHead = new MatrixRow();
        ValueNode v1 = new ValueNode(3, 1, 13);
        ValueNode v2 = new ValueNode(2, 1, 22);

        columnHead.insert(v1);
        columnHead.insert(v2);

        System.out.print("Insert before first(3,2): ");

        ValueNode current = columnHead.getFirst();
        printLoop(current);
    }

    public void testInsertBeforeLast() {
        MatrixRow columnHead = new MatrixRow();
        ValueNode v1 = new ValueNode(3, 1, 33);
        ValueNode v3 = new ValueNode(5, 1, 555);
        ValueNode v5 = new ValueNode(6, 1, 66);
        ValueNode v4 = new ValueNode(7, 1, 77);
        ValueNode v2 = new ValueNode(8, 1, 888);

        columnHead.insert(v1);
        columnHead.insert(v2);
        columnHead.insert(v3);
        columnHead.insert(v4);
        columnHead.insert(v5);

        System.out.print("Insert before last(3,8,5,7,6): ");
        ValueNode current = columnHead.getFirst();
        printLoop(current);


        System.out.print("get position test: ");

        for(int i = 1; i<=8; i++){
            System.out.print(columnHead.get(i)+" ");
        }

    }

    public void printLoop(ValueNode current){
        while(current != null){
            System.out.print(current.getRow()+";"+current.getRow()+"  ");
            current = current.getNextRow();
        }
        System.out.println();
    }
}

