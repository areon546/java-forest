package forest.domain;

import forest.collections.Resource;

public class Material {
    private int quantity=0;
    private Resource name;


    public Material(Resource name, int quantity) {
        this.quantity = quantity;
        this.name = name;
    }

    /**
     * Adjusts quantity by amount specified.
     * @param n Determines how much to increase or decrease the quantity by.
     * @return A boolean is returned telling the success of the operation. False means no change has been made.
     */
    public boolean adjustQuantity(int n)  {
        if (this.quantity+n>=0) {
            this.quantity += n;
            return true;
        }
        return false;
    }

    public Resource getResource() {
        return name;
    }

    public String getName() {
        return name.name();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + "," + quantity;
    }
}