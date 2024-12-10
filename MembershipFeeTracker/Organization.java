public class Organization {
    private String name;
    private double membershipFee;

    public Organization(String name, double membershipFee) {
        this.name = name;
        this.membershipFee = membershipFee;
    }

    // Getter Functions
    public String getName() {
        return name;
    }

    public double getMembershipFee() {
        return membershipFee;
    }

    // Setter Functions
    public void setName(String name) {
        this.name = name;
    }

    public void setMembershipFee(double membershipFee) {
        this.membershipFee = membershipFee;
    }


}
