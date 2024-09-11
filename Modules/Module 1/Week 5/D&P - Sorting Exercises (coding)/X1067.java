public void bubbleSort(E[] elems)
{
  for (int i = 0; i < elems.length - 1; i++) {
    for (int j = 1; j < elems.length - i; j++) {
      if (elems[j].compareTo(elems[j-1]) < 0) {
        // swap elements at j-1 and j
        E temp = elems[j];
        elems[j] = elems[j-1];
        elems[j-1] = temp;
      }
    }
  }
}
