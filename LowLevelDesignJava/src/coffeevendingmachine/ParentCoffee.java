package coffeevendingmachine;

public class ParentCoffee {

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public int getNumOfCups() {
        return numOfCups;
    }

    public void setNumOfCups(int numOfCups) {
        this.numOfCups = numOfCups;
    }

    double price;

    String recipe;

    int numOfCups;


}
