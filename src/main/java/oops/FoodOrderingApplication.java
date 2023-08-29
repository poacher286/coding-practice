package oops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FoodOrderingApplication {

    public static void main(String[] args) {

        int[] a = new int[] {1, 2, 3, 4, 5};
        ArrayList<String> b = new ArrayList<>(){{
            add("Hello");
            add("bye");
        }};

        List<Item> veg = new ArrayList<>() {{
            add(new Item("Paneer tikka", 120.00f));
            add(new Item("Cashew pulao", 150.00f));
            add(new Item("Veg fried rice", 130.00f));
            add(new Item("Gobi 65", 100.00f));
            add(new Item("Veg. thali", 140.00f));
        }};

//        List<Item> veg = new ArrayList<>();
//        Item paneerTikka = new Item("Paneer tikka", 120.00f);
//        Item cashewPulao = new Item("Cashew pulao", 150.00f);
//        Item vegFriedRice = new Item("Veg fried rice", 130.00f);
//        Item gobi65 = new Item("Gobi 65", 100.00f);
//        Item vegThali = new Item("Veg. thali", 140.00f);
//
//        veg.add(paneerTikka);
//        veg.add(cashewPulao);
//        veg.add(vegFriedRice);
//        veg.add(gobi65);
//        veg.add(vegThali);

        List<Item> nonVeg = new ArrayList<>();
        Item chickenBiryani = new Item("Chicken briyani", 200.00f);
        Item fishCurry = new Item("Fish curry", 150.00f);
        Item chicken65 = new Item("Chicken 65", 120.00f);
        Item muttonGravy = new Item("Mutton gravy", 220.00f);
        Item chickenFriedRice = new Item("Chicken fried rice", 180.00f);

        nonVeg.add(chickenBiryani);
        nonVeg.add(fishCurry);
        nonVeg.add(chicken65);
        nonVeg.add(muttonGravy);
        nonVeg.add(chickenFriedRice);

        boolean isDineIn = false;

        System.out.println("Hello Welcome to Numpy Ninja restaurant !");
        System.out.println("Please select the service offering from below list :");
        System.out.println("\t [1] Dine-In");
        System.out.println("\t [2] Take away");
        System.out.print("Please enter your option : ");
        Scanner input = new Scanner(System.in);
        int inputDineIn = input.nextInt();
        if (inputDineIn == 1) {
            isDineIn = true;
        }

        String otherCategory;
        float subtotal = 0.0f;

        do {
            System.out.println("Please select the category from the below list : ");
            System.out.println("\t [1] Vegetarian");
            System.out.println("\t [2] Non - vegetarian");

            System.out.print("Please enter the option ");
            int category = input.nextInt();
            if (category == 1) {
                subtotal = getSubtotal(veg, input, subtotal);

            } else {
                subtotal = getSubtotal(nonVeg, input, subtotal);
            }

            System.out.print("Would you like to order from other category ? [Y] or [N] ");
            otherCategory = input.next();

        } while (otherCategory.equals("Y"));

        float gst = subtotal * 0.06f;
        float dineIn_Parcel = isDineIn ? 30.00f : 10.00f;
        float totalBillAmount = subtotal + gst + dineIn_Parcel;
        float discountAmount = totalBillAmount > 1500 ? totalBillAmount * 0.15f
                : totalBillAmount > 1000 ? totalBillAmount * 0.10f
                : 0.00f;
        System.out.println("Total cost : " + subtotal);
        System.out.println("GST tax : " + gst);
        System.out.println("Parcel/Dine-in charge : " + dineIn_Parcel);
        System.out.println("Total bill amount : " + totalBillAmount);
        System.out.println("Discount : " + discountAmount);
        System.out.println("Net bill amount : " + (totalBillAmount - discountAmount));
        System.out.println("\n");
        System.out.println("Thank you ! Visit again !");

    }

    private static float getSubtotal(List<Item> items, Scanner input, float subtotal) {
        String moreDish;
        do {
            printMenu(items);

            System.out.print("Please enter the option : ");
            int itemNo = input.nextInt();
            System.out.print("Please enter number of " + items.get(itemNo - 1).getItem() + " you would like to order ");
            int quantity = input.nextInt();
            subtotal += items.get(itemNo - 1).getPrice() * quantity;

            System.out.print("Would you like to order one more dish ? [Y] or [N] ");
            moreDish = input.next();

        } while (moreDish.equals("Y"));
        return subtotal;
    }

    private static void printMenu(List<Item> items) {
        System.out.println("Below are the dishes available currently to order : ");
        for (int j = 0; j < items.size(); j++) {
            System.out.println(j + 1 + " " + items.get(j).getItem() + " - " + items.get(j).getPrice());
        }
    }
}

final class Item {
    private final String item;
    private final float price;

    public Item(String item, float price) {
        this.item = item;
        this.price = price;
    }

    public final String getItem() {
        return item;
    }

    public final float getPrice() {
        return price;
    }

}
