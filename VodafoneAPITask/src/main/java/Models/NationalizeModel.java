package Models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NationalizeModel {
    @SerializedName("country")
    @Expose
    private List<Countries> countries;

    @SerializedName("name")
    @Expose
    private String name;

    public List<Countries> getCountries(){
        return countries;
    }
    public String getName(){
        return name;
    }
}
