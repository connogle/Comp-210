package assn02;

import java.util.Scanner;

import java.text.DecimalFormat;

// import java.util.LinkedList;
public class JavaWarmUp {
    static Scanner grabber = new Scanner(System.in).useDelimiter("\n");
    public static void main(String[] args) {
        short arrLen = amtItems();
        ElectronicProduct[] products = new ElectronicProduct[arrLen];
        addItems(products, arrLen);
        printReport(products);
    }
    static short amtItems() {
        System.out.println("How many items would you like to add?");
        return grabber.nextShort();
    }
    static void addItems(ElectronicProduct[] products, short arrLen) {
        System.out.println("Enter item information following the guidelines.");
        System.out.println("MM/DD/YY HH:MM Category Fee Quantity Time Cost");
        for (int i = 0; i < arrLen; i++) {
            products[i] = new ElectronicProduct();
            String[] item = grabber.next().split(" ");
            products[i].create(item);
        }
    }
    /* static String[] findCategories(ElectronicProduct[] products) {
        LinkedList<String> categoryLL = new LinkedList<>();
        for (ElectronicProduct product : products) {
            if (!categoryLL.contains(product._category)) {
                categoryLL.add(product._category);
            }
        }
        String categories = categoryLL.toString().replace("[", "").replace("]","").replace(" ","");
        return categories.split(",", 0);
    } */
    static ElectronicProduct lowestFee(ElectronicProduct[] products) {
        ElectronicProduct lowProduct = products[0];
        for (int i = 1; i < products.length; i++) {
            if (products[i]._fee < lowProduct._fee) {
                lowProduct = products[i];
            }
        }
        return lowProduct;
    }
    static ElectronicProduct highestFee(ElectronicProduct[] products) {
        ElectronicProduct highProduct = products[0];
        for (int i = 1; i < products.length; i++) {
            if (products[i]._fee > highProduct._fee) {
                highProduct = products[i];
            }
        }
        return highProduct;
    }
    static void printHighestLowest(ElectronicProduct product) {
        System.out.println("\tWhen: "+product._dayOfCreation+" "+product._timeMade);
        System.out.println("\tCategory: "+product._category);
        System.out.println("\tPrice: "+product._fee);
    }
    static void printCategoryStats(ElectronicProduct[] products, String[] categories) {
        DecimalFormat df = new DecimalFormat("0.00");
        for (String category : categories) {
            int totalQuantity = 0;
            float avgAssemblingFee = 0;
            float avgNetProfit = 0;
            for (ElectronicProduct product : products) {
                if (product._category.equals(category)) {
                    totalQuantity += product._quantity;
                    avgAssemblingFee += product._fee*product._quantity;
                    avgNetProfit+= ((product._fee * product._quantity) - (product._cost + (product._time * 16)));
                }
            }
            System.out.println("Statistic of "+category);
            System.out.println("\tQuantity: "+totalQuantity);
            System.out.println("\tAverage Assembling fee: "+df.format(Math.round(((avgAssemblingFee / totalQuantity ))* 100.0)/100.0));
            System.out.println("\tAverage Net Profit: "+df.format(Math.round(((avgNetProfit / totalQuantity)) * 100.0)/100.0));
        }
    }
    static void printReport(ElectronicProduct[] products) {
        System.out.println("Highest per unit assembling fee:");
        printHighestLowest(highestFee(products));
        System.out.println("Lowest per unit assembling fee:");
        printHighestLowest(lowestFee(products));
        String[] categories = {"phone","laptop","smart_watch"};
        printCategoryStats(products, categories);
    }
}