package PracticalExam;

public class Customer {
    private String name;
    private String email;
    private String membershipStatus;

    public Customer(String name, String email, String membershipStatus) {
        this.name = name;
        this.email = email;
        this.membershipStatus = membershipStatus;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }


    // public void setName(String name) {
    //     this.name = name;
    // }

    // public void setEmail(String email) {
    //     this.email = email;
    // }

    // public void setMembershipStatus(String membershipStatus) {
    //     this.membershipStatus = membershipStatus;
    // }

    
}
