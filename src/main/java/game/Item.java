package game;

public class Item {


    private String UniqueID;
    private String TypeBUilding;
    private String Description;


    public Item(String uniqueID, String typeBUilding, String description) {
        UniqueID = uniqueID;
        TypeBUilding = typeBUilding;
        Description = description;
    }

    public Item() {

    }

    public String getUniqueID() {
        return UniqueID;
    }

    public void setUniqueID(String uniqueID) {
        UniqueID = uniqueID;
    }

    public String getTypeBUilding() {
        return TypeBUilding;
    }

    public void setTypeBUilding(String typeBUilding) {
        TypeBUilding = typeBUilding;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "UniqueID='" + UniqueID + '\'' +
                ", TypeBUilding='" + TypeBUilding + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}

