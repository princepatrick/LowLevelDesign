package files;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Product, Integer> inventoryRecords;

    private VendingMachine vendingMachine;

    Inventory(VendingMachine theVendingMachine){
        inventoryRecords = new HashMap<>();
        vendingMachine = theVendingMachine;
    }

    public void addProductToInventory( Product product, int quantity ){
        System.out.println( "The product " + product.getName() + " of quantity " + quantity + " is added into the inventory" );
        if( !inventoryRecords.isEmpty() && inventoryRecords.containsKey(product) ){
            inventoryRecords.put( product, inventoryRecords.get(product) + quantity );
        } else {
            inventoryRecords.put( product, quantity );
        }
    }

    public void buyProduct( Product product ){
        if( inventoryRecords.containsKey(product) ){
            inventoryRecords.put( product, inventoryRecords.get(product) - 1 );

            System.out.println("Removing one product from quantity and proceeding to payment section");

            vendingMachine.setMachineState(vendingMachine.getReadyToReceiveCashAndDispenseState());
            vendingMachine.setSelectedProduct(product);

        } else {
            System.out.println("No products found!!");
        }
    }

    public void removeProduct( Product product ){
        if( inventoryRecords.containsKey(product) ){
            inventoryRecords.remove(product);
        } else {
            System.out.println("No products found!!");
        }
    }

    public int getNumberOfProductsAvailable( Product product ){
        return inventoryRecords.getOrDefault(product, 0);
    }

    public boolean isProductAvailable( Product product ){
        return inventoryRecords.containsKey(product);
    }

    public void displayAvailableProducts(){

            for( Map.Entry<Product, Integer> set : inventoryRecords.entrySet() ){
                System.out.println( "The product is " + set.getKey().getName()
                        + " and the number of products available is " + set.getValue() );
            }

    }

}
