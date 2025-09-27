package dragon.forest;

/*
The Forset class represents a digital forest the Explorer visits through their days.

They [C]ollect Herbs here, [F]ight Creatures, and [T]alk with people they meet in the forest.
The forest is ever shifting. Upon sleeping it resets.
*/

public class Forest {
    static void enterForest() {
        Map map = new Map();
        System.out.println(map.Look());
        map.goEast();
        System.out.println(map.Look());
    }

} // END forest
