
package com.example.prueba_mercado_libre.Domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("thumbnail_id")
    @Expose
    private String thumbnailId;
    @SerializedName("catalog_product_id")
    @Expose
    private String catalogProductId;
    @SerializedName("listing_type_id")
    @Expose
    private String listingTypeId;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("buying_mode")
    @Expose
    private String buyingMode;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("domain_id")
    @Expose
    private String domainId;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("order_backend")
    @Expose
    private Integer orderBackend;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("original_price")
    @Expose
    private Integer originalPrice;
    @SerializedName("sale_price")
    @Expose
    private Object salePrice;
    @SerializedName("sold_quantity")
    @Expose
    private Integer soldQuantity;
    @SerializedName("available_quantity")
    @Expose
    private Integer availableQuantity;
    @SerializedName("official_store_id")
    @Expose
    private Object officialStoreId;
    @SerializedName("use_thumbnail_id")
    @Expose
    private Boolean useThumbnailId;
    @SerializedName("accepts_mercadopago")
    @Expose
    private Boolean acceptsMercadopago;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getThumbnailId() {
        return thumbnailId;
    }

    public void setThumbnailId(String thumbnailId) {
        this.thumbnailId = thumbnailId;
    }

    public String getCatalogProductId() {
        return catalogProductId;
    }

    public void setCatalogProductId(String catalogProductId) {
        this.catalogProductId = catalogProductId;
    }

    public String getListingTypeId() {
        return listingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getBuyingMode() {
        return buyingMode;
    }

    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getOrderBackend() {
        return orderBackend;
    }

    public void setOrderBackend(Integer orderBackend) {
        this.orderBackend = orderBackend;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Object getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Object salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Integer soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Object getOfficialStoreId() {
        return officialStoreId;
    }

    public void setOfficialStoreId(Object officialStoreId) {
        this.officialStoreId = officialStoreId;
    }

    public Boolean getUseThumbnailId() {
        return useThumbnailId;
    }

    public void setUseThumbnailId(Boolean useThumbnailId) {
        this.useThumbnailId = useThumbnailId;
    }

    public Boolean getAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    public void setAcceptsMercadopago(Boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
    }

}
