// ObserverPatternExample.java

import java.util.*;
interface Observer {
    void update(String stockName, double price);
}

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public StockMarket(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        System.out.println("\nStock Price Updated: " + stockPrice);
        notifyObservers();
    }
}

// Concrete Observer - Mobile App
class MobileApp implements Observer {

    private String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App [" + userName +
                "] -> " + stockName +
                " Price: Rs." + price);
    }
}

// Concrete Observer - Web App
class WebApp implements Observer {

    private String userName;

    public WebApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("Web App [" + userName +
                "] -> " + stockName +
                " Price: Rs." + price);
    }
}

// Main Class
public class Exe7ObserverPatternExample {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket("TCS");

        Observer mobileUser = new MobileApp("Rithika");
        Observer webUser = new WebApp("Admin");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        stockMarket.setStockPrice(3500.50);
        stockMarket.setStockPrice(3600.75);

        stockMarket.deregisterObserver(webUser);

        stockMarket.setStockPrice(3700.00);
    }
}