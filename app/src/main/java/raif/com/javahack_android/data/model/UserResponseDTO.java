package raif.com.javahack_android.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponseDTO {

    @Expose
    @SerializedName("id")
    public Long id;

    @Expose
    @SerializedName("firstName")
    public String firstName;

    @Expose
    @SerializedName("lastName")
    public String lastName;


    private Long inn;
    private Long okved;
    private String post;
    private String full_with_opf;
    private String short_with_opf;
    private String adress;

    private List<UserResponseDTO> recomProducers;
    private List<UserResponseDTO> recomConsumers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getOkved() {
        return okved;
    }

    public void setOkved(Long okved) {
        this.okved = okved;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getFull_with_opf() {
        return full_with_opf;
    }

    public void setFull_with_opf(String full_with_opf) {
        this.full_with_opf = full_with_opf;
    }

    public String getShort_with_opf() {
        return short_with_opf;
    }

    public void setShort_with_opf(String short_with_opf) {
        this.short_with_opf = short_with_opf;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<UserResponseDTO> getRecomProducers() {
        return recomProducers;
    }

    public void setRecomProducers(List<UserResponseDTO> recomProducers) {
        this.recomProducers = recomProducers;
    }

    public List<UserResponseDTO> getRecomConsumers() {
        return recomConsumers;
    }

    public void setRecomConsumers(List<UserResponseDTO> recomConsumers) {
        this.recomConsumers = recomConsumers;
    }
}
