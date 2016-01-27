package chop.impl;

import chop.BinarySearch;

import static chop.Constants.KEY_NOT_FOUND;

import static chop.Utils.midPoint;

/**
 * Created by alexandriann on 26/01/16.
 */
public class BinarySearchRecursive implements BinarySearch
{

    public int indexInArray(int element, int[] array)
    {
        int minIndex = 0;
        int maxIndex = array.length - 1;

        return recursiveSearch(element, array, minIndex, maxIndex);
    }

    private int recursiveSearch(int element, int[] array, int minIndex, int maxIndex)
    {
        if (minIndex > maxIndex)
        {
            return KEY_NOT_FOUND;
        }

        int index = midPoint(minIndex, maxIndex);
        if (array[index] == element)
        {
            return index;
        }

        if (array[index] < element)
        {
            return recursiveSearch(element, array, index + 1, maxIndex);
        }
        else
        {
            return recursiveSearch(element, array, minIndex, index - 1);
        }


    }
}
