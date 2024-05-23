package com.micoservice.billingservice.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name="fullBill", types=Bill.class)
public interface BillProjection {
    public Long getId();
    public Date getBillingDate();
    public Long getCustomerID();
    public Collection<ProductItem> getProductItem();

}
