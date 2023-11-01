
package com.example.prueba_mercado_libre.Domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paging {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("primary_results")
    @Expose
    private Integer primaryResults;
    @SerializedName("offset")
    @Expose
    private Integer offset;
    @SerializedName("limit")
    @Expose
    private Integer limit;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPrimaryResults() {
        return primaryResults;
    }

    public void setPrimaryResults(Integer primaryResults) {
        this.primaryResults = primaryResults;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

}
