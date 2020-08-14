class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        BurgerStore burgerStore = new BurgerStore();

        Burger chineseBurger = burgerStore.orderBurger("Chinese");
        Burger americanBurger = burgerStore.orderBurger("American");
        Burger russianBurger = burgerStore.orderBurger("Russian");
    }
}

abstract class BurgerFactory {

    abstract Burger createBurger(String type);

    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are not able to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName());
        burger.putBun();
        burger.putCutlet();
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println("Done a " + burger.getName() + "\n");
        return burger;
    }
}

class BurgerStore extends BurgerFactory {
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case "Chinese":
                return new ChineseBurger("Chinese Burger");
            case "American":
                return new AmericanBurger("American Burger");
            case "Russian":
                return new RussianBurger("Russian Burger");
            default:
                return null;
        }
    }
}

abstract class Burger {
    private final String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting cutlet");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

class ChineseBurger extends Burger {
    public ChineseBurger(String name) {
        super(name);
    }
}

class AmericanBurger extends Burger {
    public AmericanBurger(String name) {
        super(name);
    }
}

class RussianBurger extends Burger {
    public RussianBurger(String name) {
        super(name);
    }
}
