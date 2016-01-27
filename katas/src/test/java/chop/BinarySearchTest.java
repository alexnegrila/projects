package chop;

import chop.impl.BinarySearchDeferred;
import chop.impl.BinarySearchIterative;
import chop.impl.BinarySearchRecursive;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by alexandriann on 19/01/16.
 */
public class BinarySearchTest
{

    BinarySearch binarySearch;

    @Test
    public void iterative()
    {
        binarySearch = new BinarySearchIterative();
        shouldFindInArray();
        shouldNotFindInArray();
    }

    @Test
    public void recursive()
    {
        binarySearch = new BinarySearchRecursive();
        shouldFindInArray();
        shouldNotFindInArray();
    }

    @Test
    public void deferred()
    {
        binarySearch = new BinarySearchDeferred();
        shouldFindInArray();
        shouldNotFindInArray();
    }

    public void shouldFindInArray()
    {
        Assert.assertTrue(binarySearch.indexInArray(1, new int[]{1}) == 0);

        Assert.assertTrue(binarySearch.indexInArray(1, new int[]{1, 3, 5}) == 0);
        Assert.assertTrue(binarySearch.indexInArray(3, new int[]{1, 3, 5}) == 1);
        Assert.assertTrue(binarySearch.indexInArray(5, new int[]{1, 3, 5}) == 2);

        Assert.assertTrue(binarySearch.indexInArray(1, new int[]{1, 3, 5, 7}) == 0);
        Assert.assertTrue(binarySearch.indexInArray(3, new int[]{1, 3, 5, 7}) == 1);
        Assert.assertTrue(binarySearch.indexInArray(5, new int[]{1, 3, 5, 7}) == 2);
        Assert.assertTrue(binarySearch.indexInArray(7, new int[]{1, 3, 5, 7}) == 3);

    }

    public void shouldNotFindInArray()
    {
        Assert.assertTrue(binarySearch.indexInArray(1, new int[]{}) == -1);
        Assert.assertTrue(binarySearch.indexInArray(1, new int[]{3}) == -1);

        Assert.assertTrue(binarySearch.indexInArray(0, new int[]{1, 3, 5}) == -1);
        Assert.assertTrue(binarySearch.indexInArray(2, new int[]{1, 3, 5}) == -1);
        Assert.assertTrue(binarySearch.indexInArray(4, new int[]{1, 3, 5}) == -1);
        Assert.assertTrue(binarySearch.indexInArray(6, new int[]{1, 3, 5}) == -1);

        Assert.assertTrue(binarySearch.indexInArray(0, new int[]{1, 3, 5, 7}) == -1);
        Assert.assertTrue(binarySearch.indexInArray(2, new int[]{1, 3, 5, 7}) == -1);
        Assert.assertTrue(binarySearch.indexInArray(4, new int[]{1, 3, 5, 7}) == -1);
        Assert.assertTrue(binarySearch.indexInArray(6, new int[]{1, 3, 5, 7}) == -1);

    }

}
