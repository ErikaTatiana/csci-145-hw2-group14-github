package com.company;

public class TestMatrixRow {
    public static void main(String[] args) {
        TestMatrixRow test = new TestMatrixRow();

        test.testInsertToEmpty();
        test.testInsertToEnd();
        test.testInsertBeforeFirst();
        test.testInsertBeforeLast();
    }

    public void testInsertToEmpty() {
        MatrixRow rowHead = new MatrixRow();
        ValueNode v1 = new ValueNode(1, 3, 13);

        rowHead.insert(v1);

        System.out.print("Insert to empty test(3): ");

        ValueNode current = rowHead.getFirst();
        printLoop(current);
    }

    public void testInsertToEnd() {
        MatrixRow rowHead = new MatrixRow();
        ValueNode v1 = new ValueNode(1, 3, 13);
        ValueNode v2 = new ValueNode(1, 5, 45);
        ValueNode v3 = new ValueNode(1, 8, 18);

        rowHead.insert(v1);
        rowHead.insert(v2);
        rowHead.insert(v3);

        System.out.print("Insert to end test (3,5,8): ");

        ValueNode current = rowHead.getFirst();
        printLoop(current);
    }

    public void testInsertBeforeFirst() {
        MatrixRow rowHead = new MatrixRow();
        ValueNode v1 = new ValueNode(1, 3, 13);
        ValueNode v2 = new ValueNode(1, 2, 22);

        rowHead.insert(v1);
        rowHead.insert(v2);

        System.out.print("Insert before first(3,2): ");

        ValueNode current = rowHead.getFirst();
        printLoop(current);
    }

    public void testInsertBeforeLast() {
        MatrixRow rowHead = new MatrixRow();
        ValueNode v1 = new ValueNode(1, 3, 20);
        ValueNode v3 = new ValueNode(1, 5, 2);
        ValueNode v5 = new ValueNode(1, 6, 13);
        ValueNode v4 = new ValueNode(1, 7, 77);
        ValueNode v2 = new ValueNode(1, 8, 88888);

        rowHead.insert(v1);
        rowHead.insert(v2);
        rowHead.insert(v3);
        rowHead.insert(v4);
        rowHead.insert(v5);

        System.out.print("Insert before last(3,8,5,7,6): ");
        ValueNode current = rowHead.getFirst();
        printLoop(current);


        System.out.print("get position test: ");

        for(int i = 1; i<=8; i++){
            System.out.print(rowHead.get(i)+" ");
        }

    }

    public void printLoop(ValueNode current){
        while(current != null){
            System.out.print(current.getColumn()+";"+current.getValue()+"  ");
            current = current.getNextColumn();
        }
        System.out.println();
    }
}

