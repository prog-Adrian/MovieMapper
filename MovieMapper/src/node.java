
public class node<KeyType, ValueType>{
    KeyType key;
    ValueType val;

    public node(KeyType key, ValueType value){
        this.key = key;
        this.val = value;
    }

    public KeyType getKey(){
        return this.key;
    }
    public ValueType getVal(){
        return this.val;
    }
    @Override
    public int hashCode(){
        return Math.abs(this.key.hashCode());
    }

    @Override
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj instanceof node){
            if(this.hashCode() == obj.hashCode()){
                return true;
            }
        }
        return false;
    }
}
