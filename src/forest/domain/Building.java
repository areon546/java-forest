package forest.domain;

import forest.collections.Materials;
import forest.collections.Resource;

public class Building {
    private Materials buildingMaterials;
    private String name;

    public Building(String name, Materials requires) {
        this.name=name;
        this.buildingMaterials=requires;
    }

    public boolean isFinished() {
        if (!hasMaterials()) {
            return true;
        }

        for (Resource name : buildingMaterials.keySet()) {
            Material m = buildingMaterials.get(name);
            if (m.getQuantity()!=0) {
                return false;
            }
        }
        return true;
    }

    public int addMaterial(Resource name, int quantity) {
        if (!hasMaterials()) {
            return 0;
        }

        Material m = buildingMaterials.get(name);
        m.adjustQuantity(quantity);
        return m.getQuantity();
    }

    private boolean hasMaterials() {
        return buildingMaterials!=null;
    }


    public String getName() {
        return name;
    }

    public String materialString() {
        if (!hasMaterials()) {
            return "No materials needed. ";
        }


        String s = "{";

        for (Resource name : buildingMaterials.keySet()) {
            Material m = buildingMaterials.get(name);
            s += m.toString() + ",";
        }


        return s + "}";
    }
}
