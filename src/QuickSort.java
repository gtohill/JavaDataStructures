class QuickSort{
    private int[] array;

    public QuickSort(int[] array) {
        this.array = array;
        quicksort(array, 0, array.length-1);
    }

    public void quicksort(int array[], int left, int right) {
        if(left >= right) {
            return;
        }

        int midpt = (left+right)/2;
        int pivot = array[midpt];
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index-1);
        quicksort(array, index, right);

    }

    public int partition(int[] array, int left, int right, int pivot) {

        while(left <= right) {

            while(array[left] < pivot) {
                left++;
            }

            while(array[right] > pivot) {
                right--;
            }

            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

    }


    public void printString(){
        for(int item : this.array){
            System.out.print(item);
        }
    }

    // TEST HARNESS
    public static void main(String[] args){
        int[] arr = {9, 2, 5, 4, 6, 8, 1};
        QuickSort sort = new QuickSort(arr);
        sort.printString();
    }

}