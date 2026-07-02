import java.util.*;

public class Exe6LibraryManagement {

    static int linearSearch(String books[], String key) {

        for(int i=0;i<books.length;i++) {
            if(books[i].equalsIgnoreCase(key))
                return i;
        }
        return -1;
    }

    static int binarySearch(String books[], String key) {

        int low=0, high=books.length-1;

        while(low<=high) {

            int mid=(low+high)/2;

            int result = books[mid].compareToIgnoreCase(key);

            if(result==0)
                return mid;
            else if(result<0)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {

        String books[]={"C","Java","Python","SQL"};

        Arrays.sort(books);

        System.out.println(linearSearch(books,"Python"));
        System.out.println(binarySearch(books,"Python"));
    }
}