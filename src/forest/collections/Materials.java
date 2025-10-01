package forest.collections;

import forest.domain.Material;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 * A collection of materials.
 */
public class Materials implements AskableCollection {
    private Map<Resource, Material> map;

    public Materials() {
        map = new TreeMap<>();
    }

    public Materials addMaterial(Resource name, int quant) {
        map.put(name, new Material(name, quant));
        return this;
    }

    public void put(Resource r, int quantity) {
        map.put(r, new Material(r, quantity));
    }

    public Material get(Resource r) {
        boolean exists = map.containsKey(r);
        if (!exists) {
            put(r, 0);
        }

        return map.get(r);
    }

    public Set<Resource> keySet() {
        return this.map.keySet();
    }

    /**
     * This function returns an array of strings containing the values of the Key's names
     */
    public String[] getNames() {
        String[] mats = new String[map.size()];
        int i=0;
        for (Resource r : map.keySet()) {
            mats[i] = map.get(r).getName();
            i++;
        }

        return mats;
    }

    /**
     * This function creates an array of alphabetical characters, limited to 10. A->J
     * Characters [N] and [P] are reserved for `next` and `previous` if it turns out that sufficient numbers are needed.
     */
    public Character[] getLabels() {
        String labels = "abcdefghij".toUpperCase();
        Character[] chars = new Character[map.size()];

        for (int i = 0; i< map.size(); i++) {
            chars[i]=labels.charAt(i);
        }

        return chars;
    }
}
