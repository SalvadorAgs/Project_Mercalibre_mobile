
package com.example.prueba_mercado_libre.Domain;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListProducts {

    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("country_default_time_zone")
    @Expose
    private String countryDefaultTimeZone;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("paging")
    @Expose
    private Paging paging;
    @SerializedName("results")
    @Expose
    private List<Result> results;
    @SerializedName("metadata")
    @Expose
    private Metadata metadata;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCountryDefaultTimeZone() {
        return countryDefaultTimeZone;
    }

    public void setCountryDefaultTimeZone(String countryDefaultTimeZone) {
        this.countryDefaultTimeZone = countryDefaultTimeZone;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

}
