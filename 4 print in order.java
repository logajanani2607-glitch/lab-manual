import java.util.concurrent.CountDownLatch;

class Foo {

    private CountDownLatch firstDone;
    private CountDownLatch secondDone;

    public Foo() {
        firstDone = new CountDownLatch(1);
        secondDone = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) {

        // printFirst.run() outputs "first".
        printFirst.run();

        // Allow second() to proceed
        firstDone.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // Wait until first() finishes
        firstDone.await();

        // printSecond.run() outputs "second".
        printSecond.run();

        // Allow third() to proceed
        secondDone.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // Wait until second() finishes
        secondDone.await();

        // printThird.run() outputs "third".
        printThird.run();
    }
}
