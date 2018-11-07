import java.util.Arrays;

public class NearByElement {

    private int[][] givenArray = {{2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323},
            {1, 3, 5, 7},
            {321, 320, 32, 3, 41241, -11, -12, -13, -66, -688},
    };

    private int minimumLeftIndex;
    private int maximumRightIndex;
    private int[] resultArray;


    //Getters
    public int[][] getGivenArray() {
        return givenArray;
    }

    public int getMinimumLeftIndex() {
        return minimumLeftIndex;
    }

    public int getMaximumRightIndex() {
        return maximumRightIndex;
    }

    public int[] getResultArray() {
        return resultArray;
    }



    //Setters
    public void setMinimumLeftIndex(int minimumLeftIndex) {
        this.minimumLeftIndex = minimumLeftIndex;
    }

    public void setMaximumRightIndex(int maximumRightIndex) {
        this.maximumRightIndex = maximumRightIndex;
    }

    public void setEmptyResultArray(int[] resultArray) {
        this.resultArray = resultArray;
    }

    public void editResultArrayByIndex (int index, int value) {
        resultArray[index] = value;
    }


    //Other used methods
    public int[] getXthRowOfArray(int x) {
        return getGivenArray()[x];
    }

    public void calcMinIndex(int y, int range) {
        if (range >= y) {
            setMinimumLeftIndex(0);
        } else {
            setMinimumLeftIndex(y - range);
        }
    }

    public void calcMaxIndex(int x, int y, int range) {
        if (y + range >= getXthRowOfArray(x).length) {
            setMaximumRightIndex(getXthRowOfArray(x).length - 1);
        } else {
            setMaximumRightIndex(y + range);
        }
    }


    public void createEmptyResultArray(int minIndex, int maxIndex) {
        int resultArrayLength = maxIndex - minIndex;
        int[] emptyResultArray = new int[resultArrayLength];
        setEmptyResultArray(emptyResultArray);
    }

    public void fillResultArrayWithInts(int x, int y) {




        int indexCopiedFromGivenArray = getMinimumLeftIndex();
        for (int indexInResultArray = 0; indexInResultArray < getResultArray().length; indexInResultArray ++){
            if (indexCopiedFromGivenArray == y){
                indexCopiedFromGivenArray++;
                indexInResultArray--;
                continue;
            }
            editResultArrayByIndex(indexInResultArray, getXthRowOfArray(x)[indexCopiedFromGivenArray]);
            indexCopiedFromGivenArray++;
        }
        System.out.println("RESULT IS : " + Arrays.toString(getResultArray()) + "\n");
    }



    public void nearby(int x, int y, int range) {
        if (range >= 0) {
            System.out.println("Array is : " + Arrays.deepToString(getGivenArray()));
//            System.out.println("Selected row is : " + Arrays.toString(getXthRowOfArray(x)));
//            System.out.printf("X : %s,\nY : %s,\nRange : %s,\n", x, y, range);
            calcMinIndex(y, range);
            calcMaxIndex(x, y, range);
            createEmptyResultArray(getMinimumLeftIndex(), getMaximumRightIndex());
            fillResultArrayWithInts( x, y );
        } else {
            System.out.println("ERROR: range can't be negative integer. Must be >= 0");
        }
    }
}

