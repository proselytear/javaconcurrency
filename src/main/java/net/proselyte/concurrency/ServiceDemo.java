package net.proselyte.concurrency;

public class ServiceDemo {
    public static void main(String[] args) {
        Service service = new Service();

        service.readData();
        service.showGreetingMessage();
        service.calculateFactorial(50);
        service.calculateSum(100);
        service.finishProgram();
    }
}
