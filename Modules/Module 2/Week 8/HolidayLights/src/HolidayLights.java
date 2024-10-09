/**
 * TODO Write a one-sentence summary of your class here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 *
 * @author TODO Your Name
 * @version Sep 25, 2024
 */

class node<E> {
    E data;
    node<E> next;

    public node(E d, node<E> n) {
        this.data = d;
        this.next = n;
    }

    public E getData() {
        return data;
    }

    public void setData(E d) {
        data = d;
    }

    public node<E> getNext() {
        return next;
    }

    public void setNext(node<E> n) {
        next = n;
    }
}

class LightChain {
    /**
     * The reference to the beginning light node of this chain
     */
    node<String> headOfLightString;

    /**
     * Construcor
     */
    public LightChain() {
        // TODO Create a linked list of holiday lights as a chain of lights,
        // using the following colors: Red, Green, Blue, Yellow, and White. 
        // This will initialize the reference variable, headOfLightString
        // with the chain of lights: Red,Green,Blue,Yellow, White
        headOfLightString = new node<String>("Red",
                new node<String>("Green",
                        new node<String>("Blue",
                                new node<String>("Yellow",
                                        new node<String>("White", null)))));

    }

    private node<String> getHeadOfLightString() {
        return headOfLightString;
    }

    /**
     * Traverse the light chain
     */
    public void travereLightChain() {
        // TODO Traverse the chain of lights and print out
        // the color of each light in order.
        node<String> current = headOfLightString;
        while (current != null) {
            System.out.print(current.getData());
            current = current.getNext();
            if (current != null)
                System.out.print("->");
        }
        System.out.println();
    }

    /**
     * Insert the newColor between the before and the after.
     * 
     * @param newColor the color to be inserted
     * @param before   the color before the to-be-inserted color
     * @param after    the color after the to-be-inserted color
     */
    public void insert(String newColor, String before, String after) {
        // TODO Add a new light (Orange) between the Blue and Yellow lights. 
        // Please update the linked list and traverse it again to confirm the insertion.
        node<String> current = headOfLightString;
        node<String> nodeBefore;
        node<String> nodeAfter;
        while (current != null) {
            if (current.getData() == before) {
                nodeBefore = current;
                nodeAfter = nodeBefore.getNext();
                nodeBefore.setNext(new node<String>(newColor, nodeAfter));
                return;
            } else {
                current = current.getNext();
            }
        }
    }

    /**
     * Remove the given color
     * 
     * @param aColor the to-be-removed color
     */
    public void remove(String aColor) {
        // TODO Remove the Green light from the chain.
        // Please update the linked list and traverse it to confirm the deletion.
        node<String> current = headOfLightString;
        node<String> next = headOfLightString.getNext();
        while (current != null) {
            if (next.getData().equalsIgnoreCase(aColor)) {
                current.setNext(next.getNext());
                return;
            } else {
                current = current.getNext();
                next = current.getNext();
            }
        }
    }

    /**
     * Replace the given aColor with the given toAnotherColor.
     * 
     * @param aColor         the color to be replaced.
     * @param toAnotherColor the color that will be replaced.
     */
    public void replace(String aColor, String toAnotherColor) {
        // TODO Replace the Orange light with a Purple light.
        // Please update the linked list and traverse it to confirm the replacement.
        node<String> next = headOfLightString;
        while (next != null) {
            if (next.getData() == aColor) {
                node<String> after = next.getNext();
                next = new node<String>(toAnotherColor, after);
                return;
            } else {
                next = next.getNext();
            }
        }
    }

    public LightChain join(LightChain anotherPiece) {
        node<String> cur = headOfLightString;
        while (cur.getNext() != null)
            cur = cur.getNext();
        cur.setNext(anotherPiece.getHeadOfLightString());
        return this;
    }
}

public class HolidayLights {
    final static int REPEATS_OF_LIGHT_STRINGS = 1;

    public static void main(String argv[]) {
        // Task 1: Creating the Light Chains and link them.
        LightChain stringOfLights = new LightChain();

        for (int i = 1; i < REPEATS_OF_LIGHT_STRINGS; i++) {
            LightChain another = new LightChain();
            stringOfLights = stringOfLights.join(another);
        }
        // Task 2 Traversing the Light Chains.
        System.out.println("After the task 1 (Creating the Light Chains), we have");
        stringOfLights.travereLightChain();

        // Task 3: Inserting a New Light.
        stringOfLights.insert("Orange", "Blue", "Yellow");

        System.out.println("After the Task 3 (Inserting a New Light), we have");
        stringOfLights.travereLightChain();

        // Task 4: Removing a Light.
        stringOfLights.remove("Green");

        System.out.println("After the task 4 (Removing a Light), we have");
        stringOfLights.travereLightChain();

        // Task 5: Replacing a Light.
        stringOfLights.replace("Orange", "Purple");

        System.out.println("After the task 5 (Replacing a Light), we have");
        stringOfLights.travereLightChain();
    }
}

/*
 * 
 * // Task 1: Creating the Light Chains
 * ArrayList<LightChain> lightChains = new ArrayList<>();
 * for (int i = 0; i < REPEATS_OF_LIGHT_STRINGS; i++)
 * lightChains.add(new LightChain());
 * 
 * // Task 2: Traversing the Light Chains
 * System.out.println("After the task 1 (Creating the Light Chains), we have");
 * for (LightChain chain: lightChains)
 * chain.travereLightChain();
 * 
 * // Task 3: Inserting a New Light
 * for (LightChain chain: lightChains)
 * chain.insert("Orange", "Blue", "Yellow");
 * 
 * System.out.println("After the Task 3 (Inserting a New Light), we have");
 * for (LightChain chain: lightChains)
 * chain.travereLightChain();
 * 
 * // Task 4: Removing a Light
 * for (LightChain chain: lightChains)
 * chain.remove("Green");
 * 
 * System.out.println("After the task 4 (Removing a Light), we have");
 * for (LightChain chain: lightChains)
 * chain.travereLightChain();
 * 
 * // Task 5: Replacing a Light
 * for (LightChain chain: lightChains)
 * chain.replace("Orange", "Purple");
 * 
 * System.out.println("After the task 5 (Replacing a Light), we have");
 * for (LightChain chain: lightChains)
 * chain.travereLightChain();
 */