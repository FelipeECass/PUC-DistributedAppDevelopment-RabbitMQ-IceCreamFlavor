package ice_cream_parlor.Orders;

public enum QueueNames {
    Orders("orders");
    
    private final String v_name;

    QueueNames(String p_nome) {
        v_name = p_nome;
    }

    @Override
    public String toString() {
        return v_name;
    }
}
