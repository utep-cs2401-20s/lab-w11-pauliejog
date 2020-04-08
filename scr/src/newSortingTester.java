import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

public class newSortingTester {
    /*
     * newSorting() method:
     * PASSED
     */
    @Test
    public void testNewSorting1() {
        newSorting ns = new newSorting();
        int[] sort = {3,2,7,5,1,9,4};
        int[] exp = {1,2,3,4,5,7,9};
        ns.newSorting(sort,3);
        assertArrayEquals(exp,sort);
    }
    /*
     * newSorting() method:
     *
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
     * newSorting() method:
     *
     */
    @Test
    public void testNewSorting3() {

    }
    /*
     * newSorting() method:
     *
     */
    @Test
    public void testNewSorting4() {

    }
    /*
     * newSorting() method:
     *
     */
    @Test
    public void testNewSorting5() {

    }


}
