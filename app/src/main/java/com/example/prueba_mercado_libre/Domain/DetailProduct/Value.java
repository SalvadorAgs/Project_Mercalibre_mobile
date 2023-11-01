
package com.example.prueba_mercado_libre.Domain.DetailProduct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("struct")
    @Expose
    private Struct struct;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Struct getStruct() {
        return struct;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
    }

}
