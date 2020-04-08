/*
* Paulie Jo Gonzalez
* Lab-w11
*
 */
public class newSorting {
    public void newSorting(int[] A, int size) {
        if(A.length <= size)//base case
            quickSort(A);//call on quickSort
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

    private void quickSort(int[] A) {//will call on second quickSort method
        quickSort(A,0,A.length-1);//starts at 0 and ends at last element
    }//end quickSort

    private void quickSort(int[] A, int start, int end) {//recursive quickSort method
        int index = partition(A,start,end);//
        if(start < index - 1)//left half of partitioned array
            quickSort(A,start,index-1);
        if(end > index)//right half of partitioned array
            quickSort(A,index,end);
    }//end quickSort

    private int partition(int[] A, int l, int r) {//will partition from left to right
        int pivot = A[l];//pivot is first element

        while(l <= r) {
            while(A[l] < pivot)//loop to find elements < pivot
                l++;//track the index for left side
            while(A[r] > pivot)//loop to find elements > pivot
                r--;//track the index for right side
            if(l <= r) {//considers new indices just found
                //swap the values
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                l++;
                r--;
            }
        }
        return l;//starting index of all values >= pivot
    }//end partition

    private void mergeSortedHalves(int[] A, int[] LH, int[] RH) {
        int i = 0;//index for LH
        int j = 0;//index for RH
        int index = 0;//index for A
        while(index < A.length) {//length of A
            if(i < LH.length) {//if i is in bounds
                if(j < RH.length) {//if j is in bounds
                    if(LH[i] < RH[j]) {
                        A[index] = LH[i];
                        index++;
                        i++;
                    }
                    else {
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

    private void populate(int[] A, int[] LH, int[] RH) {
        for(int i = 0; i < LH.length; i++)//loop to fill LH
            LH[i] = A[i];

        int index = A.length/2;
        for(int j = 0; j < RH.length; j++,index++)//loop to fill RH
            RH[j] = A[index];
    }//end populate


}//end class
