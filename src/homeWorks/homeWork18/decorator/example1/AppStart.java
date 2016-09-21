package homeWorks.homeWork18.decorator.example1;

/**
 * Created by Master on 09.09.2016.
 */
public class AppStart {
    public static void main(String[] args) {

        Purchasable simplePurchasable = new SimplePurchaseAgent();

        Product product = new Product(100.0);

        System.out.println("Simple purchase agent buy product " +
                (product.getPrice() - simplePurchasable.purchase(product)) + " dollars.");

        Purchasable goodPurchasable = new GoodPurchasingAgent(simplePurchasable);

        System.out.println("Good purchase agent buy product " +
                (product.getPrice() - goodPurchasable.purchase(product)) + " dollars.");
    }
}
