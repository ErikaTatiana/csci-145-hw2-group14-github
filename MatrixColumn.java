public class MatrixColumn {
    private ValueNode first;
    private MatrixColumn next;


    public ValueNode getFirst() {
        return first;
    }

    public MatrixColumn getNext() {
        return next;
    }

    public void setNext(MatrixColumn next) {
        this.next = next;
    }

    public void insert(ValueNode value) {
        if(first == null){
            this.first = value;
        } //empty column
        else if((value.getRow() < first.getRow())){
            value.setNextRow(first);
            this.first = value;
        } //node row is larger than first entry
        else{
            ValueNode current = first;
            ValueNode currentNext;

            while (current != null){
                currentNext = current.getNextRow();

                if (currentNext == null) {
                    current.setNextRow(value);
                    break;
                } //node goes at end of list
                else if(value.getRow() < currentNext.getRow()){
                    current.setNextRow(value);
                    value.setNextRow(currentNext);
                    break;
                } //node goes in between currentNode and currentNodeNext

                current = currentNext;
            }
        }
    }

    public int get(int position) {
        ValueNode current = first;
        while(current.getRow() <= position){
            if(current.getRow() == position){
                return current.getValue();
            }
            current = current.getNextRow();
        }
        return 0;
    }

}


