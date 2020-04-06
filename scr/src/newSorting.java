public class newSorting {
    void newSorting(int[] A, int size) {
        if(A.length <= size)
            quickSort(A);
        else {
            int mid = A.length/2;
            int[] LH = new int[mid];
            int[] RH = new int[A.length - mid];
            populate(A,LH,RH);
            newSorting(RH,size);
            newSorting(LH,size);
            mergeSortedHalves(A,LH,RH);
        }

    }//end newSorting

    void quickSort(int[] A) {

    }//end quickSort

    void mergeSortedHalves(int[] A, int[] LH, int[] RH) {
        int i = 0;//index for LH
        int j = 0;//index for RH
        int index = 0;//index for A
        while(index < A.length) {
            if(LH[i] < RH[j]) {
                if(i < LH.length)
                    A[index] = LH[i];
                index++;
                i++;
            }
            else {
                if(j < RH.length)
                    A[index] = RH[j];
                index++;
                j++;

            }

        }
    }//end mergeSortedHalves

    void populate(int[] A, int[] LH, int[] RH) {
        for(int i = 0; i < LH.length; i++)
            LH[i] = A[i];

        int index = A.length;
        for(int j = 0; j < RH.length; j++,index++)
            RH[j] = A[index];
    }//end populate


}//end class
