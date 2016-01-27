package chop.impl;

import chop.BinarySearch;
import static chop.Constants.KEY_NOT_FOUND;


import static chop.Utils.*;

/**
 * Created by alexandriann on 19/01/16.
 */
public class BinarySearchIterative implements BinarySearch
{
    public int indexInArray(int element, int[] array) {
        int minIndex = 0;
        int maxIndex = array.length - 1;

        while (minIndex <= maxIndex) {
            int index = midPoint(minIndex, maxIndex);
            if (array[index] == element) {
                return index;
            }

            if (array[index] < element) {
                minIndex = index + 1;
            } else {
                maxIndex = index - 1;
            }
        }
        return KEY_NOT_FOUND;
    }
}
