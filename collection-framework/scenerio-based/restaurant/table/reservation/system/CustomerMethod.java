package restaurant.table.reservation.system;

class TableAlreadyReservedException extends RuntimeException {
    
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}
