import animal.Animal;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Animal[] animals = {
                new Dog("Leo", 2, "mops"),
                new Cat("Felix", 5, "white")};
        for (Animal animal : animals) {
            Class<?> clazz = animal.getClass();
            Field[] fields = clazz.getDeclaredFields();
            System.out.println("Animal: " + clazz.getSimpleName());
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.getName() + ": " + field.get(animal));
            }
        }
    }
}