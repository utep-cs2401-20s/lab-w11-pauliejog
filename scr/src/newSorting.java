/*
* Paulie Jo Gonzalez
* Lab-w11
* newSorting problem:
 */
public class newSorting {
    /*
    * newSorting: recursive method that calls on quickSort and mergeSortedHalves method to sort an array depending
    * on a size parameter
     */
    public void newSorting(int[] A, int size) {
        if(A.length <= size) {//base case
            quickSort(A);//call on quickSort
        }
        else {//recursive call
            int mid = A.length/2;//split array in half
            int[] LH = new int[mid];//left half of A
            int[] RH = new int[A.length - mid];//right half of A
            populate(A,LH,RH);//populate LH and RH
            newSorting(RH,size);//recursive call for right half
            newSorting(LH,size);//recursive call for left half
            mergeSortedHalves(A,LH,RH);//merge sorted right and sorted left halves
        }//end else
    }//end newSorting
    /*
     * mergeSortedHalves: method to merge the sorted halves together back into the given array (A)
     */
    private void mergeSortedHalves(int[] A, int[] LH, int[] RH) {
        int i = 0;//index for LH
        int j = 0;//index for RH
        int index = 0;//index for A
        while(index < A.length) {//length of A
            if(i < LH.length) {//if i is in bounds
                if(j < RH.length) {//if j is in bounds
                    if(LH[i] < RH[j]) {//swap
                        A[index] = LH[i];
                        index++;
                        i++;
                    }
                    else {//swap
                        A[index] = RH[j];
                        index++;
                        j++;
                    }
                }
                else {//j is oob
                    A[index] = LH[i];
                    index++;
                    i++;
                }
            }
            else if(j < RH.length) {//i is oob
                A[index] = RH[j];
                index++;
                j++;
            }
        }
    }//end mergeSortedHalves
    /*
    * quickSort: first quickSort method that takes an array and calls on the second quickSort method
     */
    private void quickSort(int[] A) {//will call on second quickSort method
        quickSort(A,0,A.length-1);//starts at 0 and ends at last element
    }//end quickSort
    /*
    * quickSort: recursive method to sort an array
     */
    private void quickSort(int[] A, int start, int end) {//recursive quickSort method
        int index = partition(A, start, end);//index of pivot after partitioning
        if(index-1 > start)//left side of partitioned array
            quickSort(A, start, index-1);
        if(index+1 < end)//right side of partitioned array
            quickSort(A, index+1, end);

    }//end quickSort
    /*
    * partition: helper method to partition the array during quickSort
     */
    private int partition(int[] A, int l, int r) {
        int pivot = A[l];//pivot is first element
        int less = l+1;//index of elements less than pivot
        int temp;//temp value to swap elements
        while(less <= r) {
            while(less < A.length && A[less] < pivot)//loop to find elements < pivot
                less++;//track the index for left side
            while(A[r] > pivot)//loop to find elements > pivot
                r--;//track the index for right side
            if(less <= r) {//considers new indices just found
                //swap the values
                temp = A[less];
                A[less] = A[r];
                A[r] = temp;
                less++;
                r--;
            }
        }
        //once less > r swap the pivot value with A[r] and return r
        temp = A[r];
        A[r] = A[l];
        A[l] = temp;

        return r;//new index of pivot
    }//end partition
    /*
    * populate: method to fill the left half and right half arrays
     */
    private void populate(int[] A, int[] LH, int[] RH) {
        for(int i = 0; i < LH.length; i++)//loop to fill LH
            LH[i] = A[i];

        int index = A.length/2;//starting at second half of A
        for(int j = 0; j < RH.length; j++,index++)//loop to fill RH
            RH[j] = A[index];
    }//end populate
}//end class

