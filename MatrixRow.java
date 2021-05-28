package com.company;

public class MatrixRow {
    private ValueNode first;
    private MatrixRow next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixRow getNext() {
        return next;
    }

    public void setNext(MatrixRow next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        if(first == null){
            value.setNextColumn(first);
            this.first = value;
        } //empty row
        else if((value.getColumn() < first.getColumn())){
            value.setNextColumn(first);
            this.first = value;
        } //node column is larger than first entry
        else{
            ValueNode current = first;
            ValueNode currentNext;

            while (current != null){
                currentNext = current.getNextColumn();

                if (currentNext == null) {
                    current.setNextColumn(value);
                    break;
                } //node goes at end of list
                else if(value.getColumn() < currentNext.getColumn()){
                    current.setNextColumn(value);
                    value.setNextColumn(currentNext);
                    break;
                } //node goes in between currentNode and currentNodeNext

                current = currentNext;
            }
        }
    }

    public int get(int position) {
        ValueNode current = first;
        while(current.getColumn() <= position){
            if(current.getColumn() == position){
                return current.getValue();
            }
            current = current.getNextColumn();
        }
        return 0;
    }

}
