import productmgmtapp.ProductMgmtApp;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ProductMgmtApp[] products = {
                new ProductMgmtApp(3128874119L, "Banana", "2023-01-24", 124, 0.55),
                new ProductMgmtApp(2927458265L, "Apple", "2022-12-09", 18, 1.09),
                new ProductMgmtApp(9189927460L, "Carrot", "2023-03-31", 89, 2.99)
        };


        Arrays.sort(products, Comparator.comparing(ProductMgmtApp::getName));

        printProducts(products);
    }

    public static void printProducts(ProductMgmtApp[] products) {

        System.out.println("Printed in JSON Format:");
        System.out.println("[");
        for (ProductMgmtApp product : products) {
            System.out.print("\t{");
            System.out.print("productId\": " + product.getProductId() + ",");
            System.out.print("name\": \"" + product.getName() + "\",");
            System.out.print("dateSupplied\": \"" + product.getDateSupplied() + "\",");
            System.out.print("quantityInStock\": " + product.getQuantityInStock() + ",");
            System.out.print("unitPrice\": \"" + product.formattedUnitPrice() + "\"");
            System.out.println("},");
        }
        System.out.println("]");


        System.out.println("\nPrinted in XML Format");
        System.out.println("\n<?xml version=1.0>");
        System.out.println("<products>");
        for (ProductMgmtApp product : products) {
            System.out.println("\t<product>");
            System.out.println("\t\t<productId>" + product.getProductId() + "</productId>");
            System.out.println("\t\t<name>" + product.getName() + "</name>");
            System.out.println("\t\t<dateSupplied>" + product.getDateSupplied() + "</dateSupplied>");
            System.out.println("\t\t<quantityInStock>" + product.getQuantityInStock() + "</quantityInStock>");
            System.out.println("\t\t<unitPrice>" + product.formattedUnitPrice() + "</unitPrice>");
            System.out.println("\t</product>");
        }
        System.out.println("</products>");

        System.out.println("\nPrinted in Comma-Separated Value(CVS) Format");

        for (ProductMgmtApp product : products) {
            System.out.println(product.getProductId() + "," + product.getName() + "," + product.getDateSupplied() +
                    "," + product.getQuantityInStock() + "," + product.formattedUnitPrice());
        }
    }
}