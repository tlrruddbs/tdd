package com.example.orderservice.product;

class ProductAdapter implements ProductPort {

    private final ProductRepository productRepostiroy;


    ProductAdapter(final ProductRepository productRepostiroy) {
        this.productRepostiroy = productRepostiroy;
    }

    @Override
    public void save(Product product) {
        productRepostiroy.save(product);
    }


}
