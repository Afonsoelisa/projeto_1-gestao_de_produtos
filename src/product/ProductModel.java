package product;

public class ProductModel {
    private final String barCode;
    private String name;
    private Integer priceInCents;
    private Integer stock;

    public ProductModel(String barCode, String name, Integer priceInCents, Integer stock) {
        this.barCode = barCode;
        this.name = name;
        this.priceInCents = priceInCents;
        this.stock = stock;
    }

    public String getBarCode() {
        return barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(Integer priceInCents) {
        this.priceInCents = priceInCents;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return String.format("Produto: %s | Código: %s | Preço (centavos): %d | Estoque: %d",
                name, barCode, priceInCents, stock);
    }
}
