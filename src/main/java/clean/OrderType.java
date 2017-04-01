package clean;

public enum OrderType {
    PREMIUM {
        @Override
        public String getDelivery() {
            return "premium";
        }
    },
    NORMAL {
        @Override
        public String getDelivery() {
            return "normal";
        }
    };

    public abstract String getDelivery();
}
