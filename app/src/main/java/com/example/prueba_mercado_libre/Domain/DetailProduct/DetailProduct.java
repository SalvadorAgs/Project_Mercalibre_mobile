
package com.example.prueba_mercado_libre.Domain.DetailProduct;


import com.example.prueba_mercado_libre.Domain.DetailProduct.Body;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailProduct {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("body")
    @Expose
    private Body body;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

}
