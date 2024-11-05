package com.brianprojects.DataStrucImp;

public class MergeSort {
  public void sort(int[] array) { //[1,2,3,4 ,5, 6]
    if (array.length < 2)
      return;

    var middle = array.length / 2; //4/2 = 2 [middle]

    int[] left = new int[middle];
    for (var i = 0; i < middle; i++)
      left[i] = array[i]; //[1 , 2, 3] // [1,2]

    int[] right = new int[array.length - middle];
    for (var i = middle; i < array.length; i++)
      right[i - middle] = array[i]; //[4, 5, 6] //[3]

    sort(left);
    sort(right);

    merge(left, right, array);
  }

  private void merge(int[] left, int[] right, int[] result) {
    int i = 0, j = 0, k = 0;

    while (i < left.length && j < right.length) {
      if (left[i] <= right[j])
        result[k++] = left[i++];
      else
        result[k++] = right[j++];
    }

    while (i < left.length)
      result[k++] = left[i++];

    while (j < right.length)
      result[k++] = right[j++];
  }
}
