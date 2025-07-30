package product;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;

public class Main {
    public static void main(String[] args) {
        ProductController controller = new ProductController();

        try {
            ProductModel p1 = new ProductModel("001", "Notebook", 250000, 10);
            ProductModel p2 = new ProductModel("002", "Teclado", 15000, 50);
            ProductModel p3 = new ProductModel("003", "Mouse", -5000, 30); // Deve lançar exceção

            System.out.println(controller.create(p1));
            System.out.println(controller.create(p2));
            System.out.println(controller.create(p3));
        } catch (NegativePriceException | IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }

        // Listar produtos
        for (ProductModel product : controller.read()) {
            System.out.println(product);
        }

        // Buscar preço por código de barras
        try {
            int price = controller.retrievePrice("002");
            System.out.println("Preço do produto com código 002: " + price + " centavos");
        } catch (NotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        // Buscar código inexistente
        try {
            controller.retrievePrice("999");
        } catch (NotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
