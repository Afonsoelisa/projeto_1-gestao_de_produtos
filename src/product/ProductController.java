package product;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;

import java.util.ArrayList;

public class ProductController {
    private final ArrayList<ProductModel> products = new ArrayList<>();

    public String create(ProductModel payload) {
        if (payload.getPriceInCents() <= 0) {
            throw new NegativePriceException("O preço do produto precisa ser um número positivo.");
        }

        // Verifica se já existe produto com o mesmo nome
        for (ProductModel product : products) {
            if (product.getName().equalsIgnoreCase(payload.getName())) {
                throw new IllegalArgumentException("Já existe um produto com esse nome.");
            }
        }

        products.add(payload);
        return "Produto '" + payload.getName() + "' adicionado.";
    }

    public ArrayList<ProductModel> read() {
        return products;
    }

    public int retrievePrice(String barCode) {
        for (ProductModel product : products) {
            if (product.getBarCode().equals(barCode)) {
                return product.getPriceInCents();
            }
        }
        throw new NotFoundException("Product with barCode '" + barCode + "' not found.");
    }
}
