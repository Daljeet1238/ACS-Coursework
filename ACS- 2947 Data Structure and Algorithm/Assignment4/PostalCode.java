/**
 * Daljeet Singh 3169763
 * ACS- 2947- 002
 * Assignment - 4
 */

public class PostalCode implements Comparable<PostalCode>{
    private String code;
    private String area;
    private String province;
    private double latitude;
    private double longitude;

    public PostalCode(String code, String area, String province, double latitude, double longitude) {
        this.code = code;
        this.area = area;
        this.province = province;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getCode() { 
        return code; 
    }

    public String getArea() { 
        return area; 
    }

    public String getProvince() {
        return province; 
    }

    public double getLatitude() { 
        return latitude; 
    }

    public double getLongitude() { 
        return longitude; 
    }

    @Override
    public int compareTo(PostalCode o){
        return this.code.compareTo(o.code);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Code: " + code + " ");
        sb.append("Area: " + area + " ");
        sb.append("Province: " + province + " ");
        sb.append("Latitude: " + latitude + " ");
        sb.append("Longitude: " + longitude);

        return sb.toString();
    }
}
