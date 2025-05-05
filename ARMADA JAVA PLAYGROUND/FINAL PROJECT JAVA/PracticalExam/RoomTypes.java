package PracticalExam;

class SingleRoom extends Room {
    public SingleRoom(double price) {
        super("Single Room", price);
    }

    @Override
    public String getDescription() {
        return "A Single Room is ideal for one person. It includes a single bed and basic amenities.";
    }
}

class DoubleRoom extends Room {
    public DoubleRoom(double price) {
        super("Double Room", price);
    }

    @Override
    public String getDescription() {
        return "A Double Room is perfect for two people. It includes a double bed and additional amenities.";
    }
}

class Suite extends Room {
    public Suite(double price) {
        super("Suite", price);
    }

    @Override
    public String getDescription() {
        return "A Suite is a luxurious option with premium facilities, ideal for families or business travelers.";
    }
}