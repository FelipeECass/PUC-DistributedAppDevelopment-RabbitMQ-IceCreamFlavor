package ice_cream_parlor.Announcement;

public enum ExchangeNames {
    Announcement("announcement");
    
    private final String v_name;

    ExchangeNames(String p_nome) {
        v_name = p_nome;
    }

    @Override
    public String toString() {
        return v_name;
    }
}
