package d_datastructure.dto;

public class School implements Comparable<School>{
    private String name;
    private String address;
    private String level;

    public School(String name, String address, String level) {
        this.name = name;
        this.address = address;
        this.level = level;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    
    @Override
    public String toString() {
        return "School [name=" + name + ", address=" + address + ", level=" + level + "]";
    }

    @Override
    public int compareTo(School o) {
        // return this.name.compareTo(o.name); // name 타입인 String이 compareTo를 구현하고 있음
        int rslt = this.level.compareTo(o.level);
        if (rslt == 0){ // level이 동일하면 내림차순
            return o.name.compareTo(this.name);
        } else {
            return rslt; // level로 오름차순
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((level == null) ? 0 : level.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // 주소가 동일하면 true
        if (this == obj)
            return true;
        // 비교대상이 null이면 false
        if (obj == null)
            return false;
        // 클래스 타입이 다르면 false
        if (getClass() != obj.getClass())
            return false;

        // School로 Obj를 다운캐스팅 해주기
        School other = (School) obj;
        
        // 각 필드값을 전부 사용해서 객체 비교
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (level == null) {
            if (other.level != null)
                return false;
        } else if (!level.equals(other.level))
            return false;
        return true;
    }

    
    
}
