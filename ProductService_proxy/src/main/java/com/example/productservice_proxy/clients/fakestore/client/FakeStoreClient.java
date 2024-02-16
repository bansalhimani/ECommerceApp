package com.example.productservice_proxy.clients.fakestore.client;

import com.example.productservice_proxy.clients.fakestore.dto.FakeStoreProductDto;
import com.example.productservice_proxy.models.Categories;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public <T> ResponseEntity<T> patchForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l = restTemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreProductDto[].class);
        return Arrays.asList(l.getBody());
    }

    public FakeStoreProductDto getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, productId).getBody();
    }

    public FakeStoreProductDto addNewProduct(FakeStoreProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.postForEntity("https://fakestoreapi.com/products", productDto, FakeStoreProductDto.class).getBody();
    }

    public FakeStoreProductDto updateProduct(Long id,FakeStoreProductDto productDto) {
        return patchForEntity(HttpMethod.PATCH,"https://fakestoreapi.com/products/{id}", productDto, FakeStoreProductDto.class, id).getBody();
    }

    public void deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.delete("https://fakestoreapi.com/products/{id}", id);
    }

    public List<String> getAllCategories() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<List> categoryList = restTemplate.getForEntity("https://fakestoreapi.com/products/categories", List.class);
        return (categoryList.getBody());
    }

    public List<FakeStoreProductDto> getAllProductsInSingleCategory(String category){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> l = restTemplate.getForEntity("https://fakestoreapi.com/products/category/{category}", FakeStoreProductDto[].class,category);
        return Arrays.asList(l.getBody());
    }
}
