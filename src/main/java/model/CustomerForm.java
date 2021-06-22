package model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

public class CustomerForm implements Validator {
    private Long id;
    private String firstName;
    private String lastName;
    private MultipartFile img;
    private Province province;
    @Column(unique = true)
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerForm(String firstName, String lastName, MultipartFile img, Province province, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
        this.province = province;
        this.phoneNumber = phoneNumber;
    }

    public CustomerForm(Long id, String firstName, String lastName, MultipartFile img, Province province) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
        this.province = province;
    }

    public CustomerForm(String firstName, String lastName, MultipartFile img, Province province) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
        this.province = province;

    }

    public CustomerForm() {
    }

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

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerForm customerForm = (CustomerForm) target;
        String phoneNumber = customerForm.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","phoneNumber.empty");
        if(phoneNumber.length()>11 || phoneNumber.length()<10){
            errors.rejectValue("phoneNumber","phoneNumber.length");
        }
        if(!phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber","phoneNumber.startsWith");
        }
        if(!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber","phoneNumber.matches");
        }
    }
}
