/*
 * Paulie Jo Gonzalez
 * Lab-w11
 * newSorting tester:
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class newSortingTester {
    /*
     * newSorting() method:
     * This test case tests the basic functionality of the newSorting method under normal circumstances.
     * PASSED
     */
    @Test
    public void testNewSorting1() {
        newSorting ns = new newSorting();
        int[] sort = {3,2,7,5,1,9,4};
        int[] exp = {1,2,3,4,5,7,9};
        ns.newSorting(sort,4);//size is about half the array size
        assertArrayEquals(exp,sort);
    }
    /*
     * newSorting(sort,2) method:
     * This test case aims to test what happens if the given array is already sorted.
     * PASSED
     */
    @Test
    public void testNewSorting2() {
        newSorting ns = new newSorting();
        int[] sort = {1,2,3,4};
        int[] exp = {1,2,3,4};
        ns.newSorting(sort,2);
        assertArrayEquals(exp,sort);
    }
    /*
     * newSorting(sort,) method:
     * This test case aims to stress the newSorting method given a reversely sorted array.
     * PASSED
     */
    @Test
    public void testNewSorting3() {
        newSorting ns = new newSorting();
        int[] sort = {5,4,3,2,1};
        int[] exp = {1,2,3,4,5};
        ns.newSorting(sort,3);
        assertArrayEquals(exp,sort);

    }
    /*
     * newSorting() method:
     * This test case is to check that the method works correctly if the size
     * parameter is >= the size of the array.
     * PASSED
     */
    @Test
    public void testNewSorting4() {
        newSorting ns = new newSorting();
        int[] sort = {6,3,8,0,2,5};
        int[] exp = {0,2,3,5,6,8};
        ns.newSorting(sort,7);//size >= sort.length
        assertArrayEquals(exp,sort);

    }
    /*
     * newSorting() method:
     * This test case aims to stress the method with a size parameter of 0.
     * FAILED. (stack overflow will occur since the array is never split into size zero sub-arrays)
     */
    @Test
    public void testNewSorting5() {
        newSorting ns = new newSorting();
        int[] sort = {6,3,8,0,2,5};
        int[] exp = {0,2,3,5,6,8};
        ns.newSorting(sort,0);//zero will cause a StackOverflowError
        assertArrayEquals(exp,sort);
    }
    /*
     * newSorting() method:
     * This test case aims to stress the method with an input array that contains duplicates.
     * PASSED
     */
    @Test
    public void testNewSorting6() {
        newSorting ns = new newSorting();
        int[] sort = {4,4,4,4,4,4,4,4,4,4,1};
        int[] exp = {1,4,4,4,4,4,4,4,4,4,4};
        ns.newSorting(sort,5);//size is about half of the array size
        assertArrayEquals(exp,sort);
    }
    /*
     * newSorting() method:
     * This test case aims to stress the method with an input array that contains duplicates
     * and negative values, plus a small sorting size parameter.
     * PASSED
     */
    @Test
    public void testNewSorting7() {
        newSorting ns = new newSorting();
        int[] sort = {3,2,7,5,1,9,4,0,10,22,-3,6,5};
        int[] exp = {-3,0,1,2,3,4,5,5,6,7,9,10,22};
        ns.newSorting(sort,2);//breaks the array down into small sub-arrays
        assertArrayEquals(exp,sort);
    }
}//end tester class
