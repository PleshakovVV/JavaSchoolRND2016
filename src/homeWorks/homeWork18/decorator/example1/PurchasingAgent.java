package homeWorks.homeWork18.decorator.example1;

/**
 * Created by Master on 09.09.2016.
 */
abstract public class PurchasingAgent implements Purchasable {
    Purchasable purchasable;

    public PurchasingAgent(Purchasable purchasable) {
        this.purchasable = purchasable;
    }

    @Override
    public double purchase(Product product) {
        return purchasable.purchase(product);
    }
}
