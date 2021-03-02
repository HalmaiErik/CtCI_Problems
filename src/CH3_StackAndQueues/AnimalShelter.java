package CH3_StackAndQueues;

import java.util.LinkedList;

public class AnimalShelter {
    private LinkedList<Animal> dogs;
    private LinkedList<Animal> cats;
    private int order;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
    }

    public void enqueue(String name, String type) {
        order++;

        if (type.equals("dog")) {
            Dog dog = new Dog(name, order);
            dogs.add(dog);
        }
        else if (type.equals("cat")) {
            Cat cat = new Cat(name, order);
            cats.add(cat);
        }
        else {
            throw new UnsupportedOperationException();
        }
    }

    public Animal dequeueAny() {
        if (dogs.getFirst().order < cats.getFirst().order) {
            Animal dog = dogs.getFirst();
            dogs.removeFirst();
            return dog;
        }
        else {
            Animal cat = cats.getFirst();
            cats.removeFirst();
            return cat;
        }
    }

    public Animal dequeueDog() {
        Animal dog = dogs.getFirst();
        dogs.removeFirst();
        return dog;
    }

    public Animal dequeueCat() {
        Animal cat = cats.getFirst();
        cats.removeFirst();
        return cat;
    }

    abstract class Animal {
        int order;
        String name;

        public Animal(String name, int order) {
            this.name = name;
            this.order = order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }

    class Dog extends Animal {
        public Dog(String name, int order) {
            super(name, order);
        }
    }

    class Cat extends Animal {
        public Cat(String name, int order) {
            super(name, order);
        }
    }

    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue("Max", "dog");
        shelter.enqueue("Billy", "cat");
        shelter.enqueue("Lulu", "dog");
        shelter.enqueue("Catto", "cat");

        Animal animal1 = shelter.dequeueAny();
        System.out.println(animal1.name);

        Animal animal2 = shelter.dequeueAny();
        System.out.println(animal2.name);
    }
}
