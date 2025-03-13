package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Basket;

import java.util.List;
import java.util.Optional;

public interface IBasketService {
    List<Basket> getAllBaskets();
    Optional<Basket> getBasketById(Long id);
    Basket saveBasket(Basket basket);
    Basket updateBasket(Long id, Basket basketDetails);
    void deleteBasket(Long id);
    Basket addProductToBasket(Long basketId, Long productId);
    Basket updateProductQuantityInBasket(Long basketId, Long productId, int newQuantity);
    Basket removeProductFromBasket(Long basketId, Long productId);
    Basket clearBasket(Long basketId);
}