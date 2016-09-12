package homeWork18.decorator.example1;

/**
 * Created by Master on 09.09.2016.
 */
public class GoodPurchasingAgent extends PurchasingAgent {

    public GoodPurchasingAgent(Purchasable purchasable) {
        super(purchasable);
    }

    public double makeDiscount(Product product) {
        return 0.1 * product.getPrice();
    }

    @Override
    public double purchase(Product product) {
        return super.purchase(product) + makeDiscount(product);
    }
}
