class Sort {
    public void bubbleSort(int a[]) {
        int i, j, temp, size;
        size = a.length;
        for (i=size-1; i>0; i--) {
            System.out.printf("\n버블정렬 %d 단계 :", size-1);
            for (j=0; j<i; j++) {
                if (a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
                System.out.printf("\n\t");
                for (int k=0; k<size; k++)
                    System.out.printf("%3d", a[k]);
            }
        }
    }

    private int sorted[] = new int [30];

    public void merge(int a[], int m, int middle, int n) {
        int size = a.length;
        int i, j, k, t;
        i = m;
        j = middle+1;
        k = m;
        while (i<=middle && j<=n) {
            if (a[i] <= a[j]) sorted[k] = a[i++];
            else sorted[k] = a[j++];
            k++;
        }
        if (i>middle) {
            for(t=j; t<=n; t++, k++)
                sorted[k] = a[t];
        }

        for (t=m; t<=n; t++)
            a[t] = sorted[t];
        System.out.printf("\n병합 정렬 >> ");
        for (t=0; t<size; t++)
            System.out.printf("%3d", a[t]);
    }

    public void mergeSort(int a[], int m, int n) {
        int middle;
        if (m<n) {
            middle = (m+n)/2;
            mergeSort(a, m, middle);
            mergeSort(a, middle+1, n);
            merge(a, m, middle, n);
        }
    }
}
public class Ex11_2 {
    public static void main(String[] args) {
        int a[] = {20, 15, 30, 5, 25, 70, 40, 55, 10, 35};
        int size = a.length;
        Sort S = new Sort();
        System.out.printf("\n정렬할 원소 : ");
        for (int i=0; i<a.length; i++)
            System.out.printf(" %d", a[i]);
        System.out.println();
        S.mergeSort(a, 0, size-1);
    }
}
