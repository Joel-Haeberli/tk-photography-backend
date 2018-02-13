package ch.joelhaeberli.tkpbackend.domain.order;

public enum OrderForm {

    FILE {
        @Override
        public String toString() {
            return "FILE";
        }
    }

    , FRAMED {
        @Override
        public String toString() {
            return "FRAMED";
        }
    }
}
