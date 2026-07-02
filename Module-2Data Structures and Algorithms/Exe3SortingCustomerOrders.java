class Order {
    int orderId;
    double totalPrice;

    Order(int orderId, double totalPrice) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
    }
}

public class Exe3SortingCustomerOrders {

    static void bubbleSort(Order arr[]) {

        for(int i=0;i<arr.length-1;i++) {
            for(int j=0;j<arr.length-i-1;j++) {

                if(arr[j].totalPrice > arr[j+1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    static void display(Order arr[]) {
        for(Order o:arr)
            System.out.println(o.orderId+" "+o.totalPrice);
    }

    public static void main(String[] args) {

        Order orders[] = {
                new Order(1,5000),
                new Order(2,2000),
                new Order(3,8000)
        };

        bubbleSort(orders);
        display(orders);
    }
}