package ch.joelhaeberli.tkpbackend.domain.order;

public enum OrderStatus {

    OPEN {
        @Override
        public String toString() {
            return "OPEN";
        }
    }

    , MAIL_SENT {
        @Override
        public String toString() {
            return "MAIL_SENT";
        }
    }

    , PAID {
        @Override
        public String toString() {
            return "PAID";
        }
    }

    , ORDER_SENT {
        @Override
        public String toString() {
            return "ORDER_SENT";
        }
    }
}
