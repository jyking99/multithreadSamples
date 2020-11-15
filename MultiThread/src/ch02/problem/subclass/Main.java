package ch02.problem.subclass;

public class Main {
    public static void main(String[] args) {
        Person alice = new ModPerson("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }
}
