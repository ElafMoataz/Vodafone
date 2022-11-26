package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Countries {
    @SerializedName("country_id")
    @Expose
    private String country_id;
    @SerializedName("probability")
    @Expose
    private float probability;

    public String getCountry_id(){
        return country_id;
    }

    public float getProbability(){
        return probability;
    }
}
