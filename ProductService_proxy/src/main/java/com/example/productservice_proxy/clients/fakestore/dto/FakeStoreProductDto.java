package com.example.productservice_proxy.clients.fakestore.dto;

import com.example.productservice_proxy.clients.IClientProductDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FakeStoreProductDto implements IClientProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String Image;
}
