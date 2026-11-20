import shared.Greeter;

void main() {
    String[] names = {"Anna", "Bernd", "Carla"};
    for (String name : names) {
        IO.println(Greeter.greet(name));
    }
}
