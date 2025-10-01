package forest.collections;

import forest.collections.Materials;
import forest.collections.Resource;
import forest.collections.TownBuilding;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Buildings class contains a Map of all buildings to the materials required to complete all.
 */
public class Buildings implements AskableCollection {
    private static Map<TownBuilding, Materials> map = new TreeMap<>();

    public Buildings() {map = new TreeMap<>();}

    /**
     * Adds a building to the Buildings collection.
     * @param tb
     * @param required
     */
    public void addBuilding(TownBuilding tb, Materials required) {
        map.put(tb, required);
    }

    /**
     * Retreives the materials needed to construct a building.
     * @param key
     * @return
     */
    public Materials get(TownBuilding key) {
        return map.get(key);
    }

    /**
     * Adds a specified resource to a building to get it closer to being finished.
     * @param building
     * @param r
     * @param quantity
     * @return
     */
    public int add(TownBuilding building, Resource r, int quantity) {
        return map.get(building).addMaterial(r, quantity).get(r).getQuantity();
    }

    /**
     * Returns an array of building labels.
     * @return
     */
    public Character[] getLabels() {
        TownBuilding[] towns = map.keySet().toArray(new TownBuilding[0]);
        Character[] inputs = new Character[towns.length];

        for (int i=0; i< towns.length; i++) {
            inputs[i]=towns[i].getInput();
        }

        return inputs;
    }

    /**
     * Returns an array of building names.
     * @return
     */
    public String[] getNames() {
        Set<TownBuilding> buildings = map.keySet();
        String[] names = new String[buildings.size()];
        int i=0;

        for (TownBuilding building : buildings) {
            names[i]=building.getName();
            i++;
        }

        return names;
    }

    /**
     * Searches through the Map and returns the building with the given label.
     * @param b
     * @return
     */
    public TownBuilding getBuildingByLabel(char b) {
        for (TownBuilding tb : map.keySet()) {
            if (tb.getInput()==b) {
                return tb;
            }
        }

        return null;
    }

    /**
     * List of all buildings in the town.
     * @return
     */
    @Override
    public String toString() {
        String s = "";

        for (TownBuilding b : map.keySet()) {
            s += "\n"+b.getName();
        }

        return s;
    }
}