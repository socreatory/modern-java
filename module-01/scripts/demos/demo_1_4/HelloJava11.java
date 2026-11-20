import shared.Greeter;

public class Hello {
    public static void main(String[] args) {
        String[] names = {"Anna", "Bernd", "Carla"};
        for (String name : names) {
            System.out.println(Greeter.greet(name));
        }
    }
}
