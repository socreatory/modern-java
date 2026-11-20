void main() {
    String[] names = {"Anna", "Bernd", "Carla"};
    for (String name : names) {
        IO.println(greet(name));
    }
}

private String greet(String name) {
    return "Hallo, " + name + "!";
}
